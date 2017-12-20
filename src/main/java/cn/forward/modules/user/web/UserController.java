package cn.forward.modules.user.web;

import cn.forward.modules.user.dao.UserDao;
import cn.forward.modules.user.entity.User;
import cn.forward.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Forward
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/User")
    public String list(User user, Model model) {

        List<User> userList = userDao.findAllUser();

        model.addAttribute("userList", userList);
        return "UserProfile";
    }
    @RequestMapping(value = "/")
    public String index( Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }
}