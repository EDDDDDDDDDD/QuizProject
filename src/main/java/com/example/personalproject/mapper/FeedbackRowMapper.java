package com.example.personalproject.mapper;

import com.example.personalproject.domain.Feedback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FeedbackRowMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet rs,int rowNum) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setFeedbackID(rs.getInt("feedbackID"));
        feedback.setDescription(rs.getString("description"));
        feedback.setStarRating(rs.getInt("starRating"));

        return feedback;
    }
}
