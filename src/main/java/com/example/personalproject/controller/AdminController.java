package com.example.personalproject.controller;

import com.example.personalproject.domain.*;
import com.example.personalproject.service.CategoryService;
import com.example.personalproject.service.FeedbackService;
import com.example.personalproject.service.QuizService;
import com.example.personalproject.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private QuizService quizService;
    private FeedbackService feedbackService;
    private CategoryService categoryService;

    public AdminController(UserService userService,
                           QuizService quizService,
                           FeedbackService feedbackService,
                           CategoryService categoryService) {
        this.userService = userService;
        this.quizService = quizService;
        this.feedbackService = feedbackService;
        this.categoryService = categoryService;
    }

    @GetMapping("/home")
    public String getUser(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);

        return "/admin";
    }
    @PostMapping("/home")
    public String postUser(@RequestParam int userID, Model model) {
        User user = userService.getUserByID(userID);
        user.setActive(!user.isActive());
        userService.updateUser(user);

        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);

        return "/admin";
    }
    @GetMapping("/quiz-history")
    public String getQuizHistory(HttpSession session, Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Quiz> allQuiz = quizService.getAllQuiz();
        List<User> allUser = userService.getAllUser();
        Map<Integer, String> userFullName = new LinkedHashMap<>();
        for (User user : allUser) {
            userFullName.put(user.getUserID(),
                    user.getFirstName() + " " + user.getLastName());
        }

        model.addAttribute("categories", categories);
        model.addAttribute("allQuiz", allQuiz);
        model.addAttribute("userFullName", userFullName);

        return "/quiz-history";
    }
    @GetMapping("/questions")
    public String getQuestions(Model model) {
        Map<Integer, String> categoryName = new LinkedHashMap<>();

        List<Question> questions = quizService.getAllQuestion();
        List<Category> categories = categoryService.getAllCategories();
        for (Category c : categories) {
            categoryName.put(c.getCategoryID(), c.getName());
        }

        model.addAttribute("allQuestions", questions);
        model.addAttribute("categoryName", categoryName);

        return "questions";
    }
    @GetMapping("question-update")
    public String getQuestionUpdate(@RequestParam int questionID, Model model) {
        Question question = quizService.getQuestionByID(questionID);
        model.addAttribute("question", question);

        return "question-update";
    }
    @PostMapping("question-update")
    public String updateQuestion(@ModelAttribute("updatedQuestion") Question question) {
        quizService.updateQuestion(question);

        return "redirect:/admin/questions";
    }
    @GetMapping("choice-update")
    public String getChoiceUpdate(@RequestParam int questionID, Model model) {
        Question question = quizService.getQuestionByID(questionID);
        List<Choice> choices = quizService.getChoicesByQuestion(questionID);
        ChoiceList choiceList = new ChoiceList();
        choiceList.setChoices(choices);
        model.addAttribute("question", question);
        model.addAttribute("updatedChoices", choiceList);
        return "choice-update";
    }
    @PostMapping(value = "choice-update")
    public String updateChoice(@ModelAttribute("updatedChoices") ChoiceList updatedChoices,
                               Model model) {
        for (Choice c : updatedChoices.getChoices()) {
            quizService.updateChoice(c);
        }
        return "redirect:/admin/questions";
    }
    @GetMapping("feedback-history")
    public String getAllFeedback(Model model) {
        List<Feedback> feedbacks = feedbackService.getAllFeedback();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-history";
    }
}
