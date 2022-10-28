package com.example.personalproject.controller;

import com.example.personalproject.domain.User;
import com.example.personalproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) { this.userService = userService; }

    @GetMapping("/")
    public String getDefault(Model model) {
        model.addAttribute("isCorrect", true);
        return "login";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request) {
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }
        return "redirect:/";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String userName, @RequestParam String password,
                            HttpServletRequest request, Model model) {

        Optional<User> possibleUser = userService.validateLogin(new User(userName, password));
        model.addAttribute("isCorrect", true);

        if (possibleUser.isPresent()) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("user", possibleUser.get());

            if (possibleUser.get().isAdmin()){
                newSession.setAttribute("isAdmin", true);
                return "redirect:/admin/home";
            }
            return "redirect:/home";
        }
        else{
            model.addAttribute("isCorrect", false);
            return "login";
        }
    }

}