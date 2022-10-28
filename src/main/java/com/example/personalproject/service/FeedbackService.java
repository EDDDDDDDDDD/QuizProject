package com.example.personalproject.service;

import com.example.personalproject.dao.FeedbackDao;
import com.example.personalproject.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackService {
    private FeedbackDao feedbackDao;

    @Autowired
    public FeedbackService(@Qualifier("feedbackDaoHibernate") FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }
    public List<Feedback> getAllFeedback() { return feedbackDao.getAllFeedback(); }
    public void createNewFeedback(Feedback feedback) {
        feedbackDao.createNewFeedback(feedback);
    }
}
