package com.example.personalproject.controller;

import com.example.personalproject.domain.Category;
import com.example.personalproject.domain.Comment;
import com.example.personalproject.domain.Quiz;
import com.example.personalproject.domain.User;
import com.example.personalproject.service.CategoryService;
import com.example.personalproject.service.QuizService;
import com.example.personalproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private UserService userService;
    private QuizService quizService;
    private CategoryService categoryService;

    public HomeController(UserService userService, CategoryService categoryService, QuizService quizService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.quizService = quizService;
    }

    @GetMapping("/home")
    public String getHome(HttpServletRequest request, Model model) {
        // Category types for Quiz label
        List<Category> categories = categoryService.getAllCategories();
        Map<Integer, String> categoryName = new LinkedHashMap<>();
        for (Category c : categories) {
            categoryName.put(c.getCategoryID(), c.getName());
        }

        // User Quiz result
        User user = (User) request.getSession().getAttribute("user");
        List<Quiz> quizzes = quizService.getAllQuizByUser(user);

        // Add Attributes to Model
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("quizzes", quizzes);
        return "home";
    }

    @PostMapping("/home")
    public String chooseCategory(@RequestParam(name="categoryID") int categoryID, HttpSession session) {
        session.setAttribute("categoryID", categoryID);
        return "redirect:/quiz";
    }

    @GetMapping("/contactus")
    public String getContactus() {
        return "contactus";
    }

    @PostMapping("/contactus")
    public String createUserComment(@RequestParam(name="messageBody") String messageBody, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Comment comment = new Comment(user.getUserID(), messageBody);
        userService.createNewComment(comment);
        return "contactus";
    }

}
