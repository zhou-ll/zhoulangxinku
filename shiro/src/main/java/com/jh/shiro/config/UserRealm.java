package com.jh.shiro.config;

import com.jh.shiro.entity.DataResult;
import com.jh.shiro.entity.UserEntity;
import com.jh.shiro.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * 用户
 *
 * @author: jh
 * @date: 2020/3/10
 */
public class UserRealm extends AuthorizingRealm {

    private static final Log log = LogFactory.getLog(UserRealm.class);

    @Resource
    private UserService userService;

    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     * @author jh
     * @date 2020/3/10
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加资源的授权字符串
        //info.addStringPermission("userEntity:add");

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UserEntity userEntity = (UserEntity) subject.getPrincipal();
        int id = userEntity.getId();
        //到数据库查询当前用户权限
        DataResult dataResult;
        String autn;
        try {
            dataResult = userService.getAuth(id);
            autn = (String) dataResult.getData();
            info.addStringPermission(autn);
        } catch (Exception e) {
            log.fatal("授权失败");
        }

        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     * @author jh
     * @date 2020/3/10
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行认证逻辑");
        DataResult dataResult;
        UserEntity userEntity;
        /**
         * 编写shiro判断逻辑，判断用户名何密码
         */
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        dataResult = userService.getUserInfo(name);
        userEntity = (UserEntity) dataResult.getData();
        if (userEntity == null) {
            //用户名不存在，shiro会返回UnknowAccountException异常
            return null;
        }

        //2.判断密码
        return new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), "");
    }
}
