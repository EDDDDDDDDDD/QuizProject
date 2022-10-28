package com.example.personalproject.mapper;

import com.example.personalproject.domain.Quiz;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizRowMapper implements RowMapper<Quiz> {
    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setQuizID(rs.getInt("quizID"));
        quiz.setUserID(rs.getInt("userID"));
        quiz.setCategoryID(rs.getInt("categoryID"));
        quiz.setStartTime(rs.getString("startTime"));
        quiz.setEndTime(rs.getString("endTime"));

        return quiz;
    }
}
