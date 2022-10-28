package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.QuizDetailDao;
import com.example.personalproject.domain.QuizDetail;
import com.example.personalproject.domain.User;
import com.example.personalproject.mapper.QuizDetailRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizDetailJDBC implements QuizDetailDao {
    JdbcTemplate jdbcTemplate;
    QuizDetailRowMapper quizDetailRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final List<User> users;

    static {
        users = new ArrayList<>();
    }
    public QuizDetailJDBC() {}
    @Autowired
    public QuizDetailJDBC(JdbcTemplate jdbcTemplate, QuizDetailRowMapper quizDetailRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.quizDetailRowMapper = quizDetailRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public List<QuizDetail> getQuizDetailsByQuiz(int quizID) {
        String query = "SELECT * FROM QuizDetail WHERE quizID = ? ORDER BY questionID";
        return jdbcTemplate.query(query,
                new Object[]{quizID},
                new int[] { Types.INTEGER },
                quizDetailRowMapper);
    }
    @Override
    public void createNewQuizDetail(QuizDetail quizDetail) {
        String query = "INSERT INTO QuizDetail (quizID, questionID, choiceID)" +
                "values (?, ?, ?)";
        jdbcTemplate.update(query, quizDetail.getQuizID(), quizDetail.getQuestionID(), quizDetail.getChoiceID());
    }
}
