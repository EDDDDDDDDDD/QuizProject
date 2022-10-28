package com.example.personalproject.controller;

import com.example.personalproject.domain.*;
import com.example.personalproject.service.CategoryService;
import com.example.personalproject.service.QuizService;
import com.example.personalproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ResultController {
    private QuizService quizService;
    private CategoryService categoryService;
    private UserService userService;

    public ResultController(QuizService quizService, UserService userService, CategoryService categoryService) {
        this.quizService = quizService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/result/{id}")
    public String getResult(@PathVariable int id, Model model) {
        Quiz takenQuiz = quizService.getQuizByID(id);
        User currentUser = userService.getUserByID(takenQuiz.getUserID());

        int quizID = takenQuiz.getQuizID();
        int categoryID = takenQuiz.getCategoryID();
        int score = takenQuiz.getScore();

        Map<String, String> quizAttributes = new LinkedHashMap<>();         // <Attribute Name, value>
        Map<Question, List<Choice>> questionsChoice = new LinkedHashMap<>();  // <Question content, Choices>
        List<Choice> selectedChoices = new ArrayList<>();                   // List of Selected choices

        List<QuizDetail> quizDetailList = quizService.getQuizDetailsByQuiz(quizID); // Details in Quiz
        Category category = categoryService.getCategoryByID(categoryID);            // Quiz Name

        for (QuizDetail detail: quizDetailList) {
            int questionID = detail.getQuestionID();
            int choiceID = detail.getChoiceID();

            Question question = quizService.getQuestionByID(questionID);
            Choice choose = quizService.getChoiceByID(choiceID);
            List<Choice> choices = quizService.getChoicesByQuestion(questionID);

            questionsChoice.put(question, choices);
            selectedChoices.add(choose);
        }

        String quizName = category.getName();
        String fullName = currentUser.getFirstName() + " " + currentUser.getLastName();
        String startTime = takenQuiz.getStartTime();
        String endTime = takenQuiz.getEndTime();
        quizAttributes.put("quizName", quizName);
        quizAttributes.put("fullName", fullName);
        quizAttributes.put("startTime", startTime);
        quizAttributes.put("endTime", endTime);
        quizAttributes.put("score", String.valueOf(score));

        model.addAttribute("quizAttributes", quizAttributes);
        model.addAttribute("questionsChoice", questionsChoice);
        model.addAttribute("selectedChoices", selectedChoices);

        if (currentUser.isAdmin()) {
            model.addAttribute("isAdmin", currentUser.isAdmin());
        }

        return "result";
    }
}
