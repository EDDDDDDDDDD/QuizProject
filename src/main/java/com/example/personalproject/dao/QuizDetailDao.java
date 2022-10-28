package com.example.personalproject.dao;

import com.example.personalproject.domain.QuizDetail;

import java.util.List;

public interface QuizDetailDao {
    List<QuizDetail> getQuizDetailsByQuiz(int quizID);
    void createNewQuizDetail(QuizDetail quizDetail);
}
