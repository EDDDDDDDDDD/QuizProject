package com.example.personalproject.controller;

import com.example.personalproject.domain.User;
import com.example.personalproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class RegisterController {
    private UserService userService;

    public RegisterController(UserService userService) { this.userService = userService; }

    @GetMapping("/register")
    public String getRegister(HttpServletRequest request, Model model) {
        // Verify Login
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("isLogin", true);
        }
        else {
            model.addAttribute("isLogin", false);
        }

        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String userName, @RequestParam String password,
                               @RequestParam Optional<String> firstName, @RequestParam Optional<String> lastName,
                               @RequestParam Optional<String> email, @RequestParam Optional<String> address,
                               @RequestParam Optional<String> phoneNum, HttpServletRequest request, Model model) {
        User user = new User(userName, password, firstName.orElse(null),
                lastName.orElse(null), email.orElse(null),
                address.orElse(null), phoneNum.orElse(null));

        Optional<User> possibleUser = userService.validateLogin(user);

        if (!possibleUser.isPresent()) {
            userService.createNewUser(user);
            model.addAttribute("isNew", true);
            return "redirect:/";
        }
        else {
            model.addAttribute("isNew", false);
            return "register";
        }
    }

}
