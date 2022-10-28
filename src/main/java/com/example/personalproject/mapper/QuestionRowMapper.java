package com.example.personalproject.mapper;

import com.example.personalproject.domain.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setQuestionID(rs.getInt("questionID"));
        question.setCategoryID(rs.getInt("categoryID"));
        question.setDescription(rs.getString("description"));
        question.setActive(rs.getBoolean("isActive"));

        return question;
    }
}
