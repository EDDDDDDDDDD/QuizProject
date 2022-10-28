package com.example.personalproject.dao;

import com.example.personalproject.domain.Feedback;

import java.util.List;

public interface FeedbackDao {
    List<Feedback> getAllFeedback();
    void createNewFeedback(Feedback feedback);
}
