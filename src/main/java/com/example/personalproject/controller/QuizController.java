package com.example.personalproject.controller;

import com.example.personalproject.domain.*;
import com.example.personalproject.service.QuizService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class QuizController {
    private QuizService quizService;
    public QuizController(QuizService quizService) { this.quizService = quizService; }

    @GetMapping("/quiz")
    public String getQuiz(HttpServletRequest request, HttpSession session, Model model) {
        int quizSize = 5;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int categoryID = (Integer) request.getSession().getAttribute("categoryID");
        User user = (User) request.getSession().getAttribute("user");

        List<Question> selectedQuestions = (List<Question>) quizService.getQuestionsByCategory(categoryID, quizSize);
        Map<Integer, List<Choice>> questionsChoice = new Hashtable<>();

        for (Question q: selectedQuestions) {
            List<Choice> choices = quizService.getChoicesByQuestion(q.getQuestionID());
            questionsChoice.put(q.getQuestionID(), choices);
        }

        model.addAttribute("selectedQuestions", selectedQuestions);
        model.addAttribute("questionsChoice", questionsChoice);

        String startTime = simpleDateFormat.format(date);
        Quiz quiz = new Quiz(user.getUserID(), categoryID, startTime);
        quizService.createNewQuiz(quiz);
        Quiz createdQuiz = quizService.getQuizByStartTime(quiz);

        session.setAttribute("quiz", createdQuiz);

        return "quiz";
    }

    @PostMapping("/quiz")
    public String postQuiz(@RequestParam Map<String, String> requestParam, HttpServletRequest request) {
        int correct = 0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QuizDetail quizDetail = null;

        String endTime = simpleDateFormat.format(date);
        Quiz createdQuiz = (Quiz) request.getSession().getAttribute("quiz");


        for (Map.Entry<String, String> entry : requestParam.entrySet()) {
            quizDetail = new QuizDetail(createdQuiz.getQuizID(),
                    Integer.parseInt(entry.getKey()),       // QuestionID
                    Integer.parseInt(entry.getValue()));    // ChoiceID
            quizService.createNewQuizDetail(quizDetail);

            int choiceID = Integer.parseInt(entry.getValue());
            Choice choice = quizService.getChoiceByID(choiceID);
            if (choice.isCorrect()) correct++;
        }

        createdQuiz.setEndTime(endTime);
        createdQuiz.setScore(correct);
        quizService.updateQuiz(createdQuiz);

        return "redirect:/result/" + quizDetail.getQuizID();
    }
}
