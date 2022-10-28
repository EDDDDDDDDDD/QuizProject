package com.example.personalproject.mapper;

import com.example.personalproject.domain.Choice;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ChoiceRowMapper implements RowMapper<Choice> {
    @Override
    public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Choice choice = new Choice();
        choice.setChoiceID(rs.getInt("choiceID"));
        choice.setQuestionID(rs.getInt("questionID"));
        choice.setDescription(rs.getString("description"));
        choice.setCorrect(rs.getBoolean("isCorrect"));

        return choice;
    }
}
