package com.example.personalproject.controller;

import com.example.personalproject.domain.Feedback;
import com.example.personalproject.domain.User;
import com.example.personalproject.service.FeedbackService;
import com.example.personalproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class FeedbackController {

    private UserService userService;
    private FeedbackService feedbackService;

    public FeedbackController(UserService userService, FeedbackService feedbackService) {
        this.userService = userService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback")
    public String getFeedback(HttpServletRequest request, Model model) {
        // Verify Login
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("isLogin", true);
        }
        else {
            model.addAttribute("isLogin", false);
        }
        return "feedback";
    }

    @PostMapping("/feedback")
    public String createNewFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.createNewFeedback(feedback);
        return "redirect:/home";
    }
}
