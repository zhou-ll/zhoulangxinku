package springbootredis.com.shinyue.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springbootredis.com.shinyue.Service.UserService;
import springbootredis.com.shinyue.Bean.User;

/**
 * @PackageName: springbootredis.com.shinyue.Controller
 * @Description: author:周浪浪
 * @date:2019/10/23 17:56
 */
@RestController
public class Controller {
    @Autowired
    private UserService userService;

    @RequestMapping("/adduser")
    public int addUser(@RequestParam("name") String name, @RequestParam("age") String age) {
        return userService.addUser(name, age);
    }

    @RequestMapping("/findUser")
    public User findUser(@RequestParam("id") String id) {
        return userService.findById(id);
    }

    @RequestMapping("/updataById")
    public String updataById(@RequestParam("id") String id, @RequestParam("name") String name) {
        try {
            userService.updataById(id, name);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam("id") String id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }
}
