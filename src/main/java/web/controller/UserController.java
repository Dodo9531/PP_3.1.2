package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.services.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String users(@RequestParam(required = false, defaultValue = "0") int id, ModelMap model) {
        if (id == 0) {
            List<User> user = userService.getAllUsers();
            model.addAttribute("users", user);
            return "/index.html";
        } else {
            model.addAttribute("user", userService.getById(id));
            return "/userview.html";
        }
    }

    @GetMapping(value = "/users/add")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "/adduser.html";
    }

    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/delete")
    public String addUser(int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping(value = "users/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
