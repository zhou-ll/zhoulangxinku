package springbootredis.com.shinyue.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootredis.com.shinyue.Bean.User;
import springbootredis.com.shinyue.Dao.UserMapper;


/**
 * @PackageName: springbootredis.com.shinyue.Service
 * @Description: author:周浪浪
 * @date:2019/10/23 17:49
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User findById(String id) {
        return userMapper.findById(id);
    }

    public int addUser(String name, String age) {
        return userMapper.addUser(name, age);
    }

    public void updataById(String id, String name) {
        userMapper.updataById(id, name);
    }

    public void deleteById(String id) {
        userMapper.deleteById(id);
    }
}
