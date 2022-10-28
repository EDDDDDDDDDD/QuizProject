package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.FeedbackDao;
import com.example.personalproject.domain.Feedback;
import com.example.personalproject.mapper.FeedbackRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public abstract class FeedbackDaoJDBC implements FeedbackDao {
    JdbcTemplate jdbcTemplate;
    FeedbackRowMapper feedbackRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final List<Feedback> feedbacks;
    static {
        feedbacks = new ArrayList<>();
    }
    public FeedbackDaoJDBC() {}

    @Autowired
    public FeedbackDaoJDBC(JdbcTemplate jdbcTemplate, FeedbackRowMapper feedbackRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.feedbackRowMapper = feedbackRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public void createNewFeedback(Feedback feedback) {
        String query = "INSERT INTO Feedback (description, starRating)" +
                "values (?, ?)";
        jdbcTemplate.update(query, feedback.getDescription(), feedback.getStarRating());
    }
}
