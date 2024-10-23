package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/addUser")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam(value = "id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit-user";
    }


    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {

        userService.updateUser(user);
        return "redirect:/users";
    }
}


