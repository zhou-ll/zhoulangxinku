package com.jh.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jh.shiro.dao.UserDao;
import com.jh.shiro.entity.DataResult;
import com.jh.shiro.entity.UserEntity;
import com.jh.shiro.error.BussinessException;
import com.jh.shiro.error.EmBusinessError;
import com.jh.shiro.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户ServiceImpl
 *
 * @author jh
 * @date 2020/3/9
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);
    public static final String KEY_MD5 = "MD5";

    @Resource
    private UserDao userDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public UserEntity login(String name, String password) {

        return userDao.getUserInfo(name);
    }

    @Override
    public String loginValdate(String name) {
        //记录登录错误次数key
        String key = (String) UserEntity.getLoginCountFailKey(name);
        int num = 5;
        //登录错 误的次数
        if (!redisTemplate.hasKey(key)) {
            //如果不存在
            //是第-次登录失败次数为1赋值为1和设置失效期2分钟user: loginCount:fail:用户名进行赋值，同时设置失效期
            //注意: redisTemplate中在赋值时不能直接赋值并设置失效期( 会设置失败)
            redisTemplate.opsForValue().set(key, "1");
            //先赋值
            redisTemplate.expire(key, 2, TimeUnit.MINUTES);
            //再设置失效期2分钟
            return "登录失败，在2分钟内还允许输入错误 " + (num - 1) + " 次，";
        } else {//如果存在
            //查询登录失败次数的key结果
            long loginFailCount = Long.parseLong(redisTemplate.opsForValue().get(key).toString());
            if (loginFailCount < (num - 1)) {
                //代表如果当前登录失败次数<4意思:还有资格继续进行登录
                //user: loginCount:fail:+1登录次数+1
                redisTemplate.opsForValue().increment(key, 1);
                //对指定KEY 增加指定数据
                long seconds = redisTemplate.getExpire(key, TimeUnit.SECONDS);
                //返回的是秒
                return name + "登录失败， 在" + seconds + "秒内还允许输入错误" + (num - loginFailCount - 1) + "次";
            } else {
                //超过指定登录次数
                //限制登录KEY存在，同时设置限制登录时间锁定1小时。
                //限制登录KEY存在，同时设置限制登录时间锁定1小时。
                redisTemplate.opsForValue().set(UserEntity.getLoginTimeLockKey(name), "1");
                //我改成了限制5分钟
                redisTemplate.expire(UserEntity.getLoginTimeLockKey(name), 5, TimeUnit.MINUTES);
                return " 因登录失败次数超过限制" + num + "次，已对其限制登录5分钟";
            }
        }
    }


    @Override
    public Map<String, Object> loginUserLock(String name) {
        String key = UserEntity.getLoginTimeLockKey(name);
        Map<String, Object> map = new HashMap<String, Object>();
        if (redisTemplate.hasKey(key)) {
            //以分钟为单位进行返回
            long lockTime = redisTemplate.getExpire(key, TimeUnit.MINUTES);
            //如果存在
            map.put("flag", true);
            //还剩多长时间(小时单位锁定:给用户返回分钟)
            map.put("lockTime", lockTime);
        } else {
            map.put("flag", false);
        }
        return map;
    }

    @Override
    public DataResult saveRegister(UserEntity userEntity) {
        DataResult result = new DataResult();
        try {
            // 确定计算方法
            MessageDigest md51 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            // 加密字符串
            userEntity.setPassword(base64Encoder.encode(md51.digest(userEntity.getPassword().getBytes("utf-8"))));
            userDao.saveRegister(userEntity);
            result.setMessage("注册成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("增加成功");
            result.setSuccess(false);
        }

        return result;
    }

    @Override
    public boolean checkout(UserEntity userEntity) {
        // 验证MD5对于同一内容加密是否一致
        boolean t = false;
        try {
            //从数据库查询出加密后的密码 和传过来的密码进行对比
            UserEntity userEntity1 = userDao.getUserInfo(userEntity.getName());
            MessageDigest md51 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String str =base64Encoder.encode(md51.digest(userEntity.getPassword().getBytes("utf-8")));
            if (!StringUtils.equals(str, userEntity1.getPassword())) {
                t = false;
               // throw new BussinessException(EmBusinessError.USER_LOGIN_FAIL);
            } else {
                t = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * MD5加密   单向 （不能反向解密）
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public DataResult listUserInfo() {
        List<UserEntity> list;
        DataResult dataResult = new DataResult();
        int page = 1;
        int size = 100;
        try {
            PageHelper.startPage(page, size);
            list = userDao.listUserInfo();
            PageInfo pageInfo = new PageInfo(list);
            dataResult.setMessage("查询成功");
            dataResult.setSuccess(true);
            dataResult.setTotalcount((int) pageInfo.getTotal());
            dataResult.setResult(list);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return dataResult;
    }

    /**
     * 获取用户信息
     *
     * @param name 姓名
     * @return com.jh.shiro.entity.Result 结果集
     * @author jh
     * @date 2020/3/11
     */
    @Override
    public DataResult getUserInfo(String name) {
        DataResult dataResult = new DataResult();
        UserEntity userEntity;
        try {
            userEntity = userDao.getUserInfo(name);
            dataResult.setMessage("查询成功");
            dataResult.setSuccess(true);
            dataResult.setTotalcount(1);
            dataResult.setData(userEntity);
        } catch (Exception e) {
            LOG.fatal("查询错误{}" + e.getMessage());
        }
        return dataResult;
    }

    /**
     * 获取用户权限
     *
     * @param id 用户id
     * @return Result
     * @author jh
     * @date 2020/3/11
     */
    @Override
    public DataResult getAuth(Integer id) {
        String auth;
        DataResult dataResult = new DataResult();
        try {
            auth = userDao.getAuth(id);
            dataResult.setSuccess(true);
            dataResult.setMessage("");
            dataResult.setData(auth);
        } catch (Exception e) {
            LOG.fatal("查询错误{}" + e.getMessage());
        }
        return dataResult;
    }
}
