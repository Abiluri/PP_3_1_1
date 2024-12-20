package Abiluri.PP_3_1_1.controller;

import Abiluri.PP_3_1_1.model.User;
import Abiluri.PP_3_1_1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping
    public String create(User user) {
        userService.insertUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id, User user) {
        user.setId(id);
        userService.insertUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, ModelMap model) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}