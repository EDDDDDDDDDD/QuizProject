package com.example.personalproject.dao;

import com.example.personalproject.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getAllQuestion();
    List<Question> getQuestionsByCategory(int categoryID, int quizSize);
    Question getQuestionByID(int questionID);
    void updateQuestion(Question question);
}
