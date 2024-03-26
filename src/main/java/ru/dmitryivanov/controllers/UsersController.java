package ru.dmitryivanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dmitryivanov.model.User;
import ru.dmitryivanov.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    private UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String carController(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(required = true) int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String updateUser(@RequestParam(required = true) int id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam(required = true) int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

}
