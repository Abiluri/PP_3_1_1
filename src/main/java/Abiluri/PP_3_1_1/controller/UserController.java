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

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getUsers(ModelMap model) {
        List<User> users = userServiceImpl.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping
    public String createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        userServiceImpl.insertUser(name, email, password);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email,
                             @RequestParam String password) {
        userServiceImpl.updateUser(id, name, email, password);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam String email) {
        userServiceImpl.deleteUser(email);
        return "redirect:/users";
    }
}