package com.example.personalproject.dao;

import com.example.personalproject.domain.Quiz;
import com.example.personalproject.domain.User;

import java.util.List;

public interface QuizDao {
    List<Quiz> getAllQuiz();
    List<Quiz> getAllQuizByUser(User user);
    Quiz getQuizByStartTime(Quiz quiz);
    Quiz getQuizByID(int quizID);
    void createNewQuiz(Quiz quiz);
    void updateQuiz(Quiz quiz);

}
