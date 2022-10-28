package com.example.personalproject.mapper;

import com.example.personalproject.domain.QuizDetail;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizDetailRowMapper implements RowMapper<QuizDetail> {
    @Override
    public QuizDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizDetail quizDetail = new QuizDetail();
        quizDetail.setDetailID(rs.getInt("detailID"));
        quizDetail.setQuizID(rs.getInt("quizID"));
        quizDetail.setChoiceID(rs.getInt("choiceID"));
        quizDetail.setQuestionID(rs.getInt("questionID"));

        return quizDetail;
    }
}
