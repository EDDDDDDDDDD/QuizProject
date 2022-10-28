package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.QuestionDao;
import com.example.personalproject.domain.Question;
import com.example.personalproject.mapper.QuestionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class QuestionDaoJDBC implements QuestionDao {
    JdbcTemplate jdbcTemplate;
    QuestionRowMapper questionRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final List<Question> questions;
    static {
        questions = new ArrayList<>();
    }

    public QuestionDaoJDBC() {}

    @Autowired
    public QuestionDaoJDBC(JdbcTemplate jdbcTemplate, QuestionRowMapper questionRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionRowMapper = questionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Question> getQuestionsByCategory(int categoryID, int quizSize) {
        String query = "SELECT * FROM Question WHERE categoryID = ?";
        List<Question> pool = jdbcTemplate.query(query, new Object[]{categoryID}, new int[] { Types.INTEGER }, questionRowMapper);

        return pool;
    }
    public Question getQuestionByID(int questionID) {
        String query = "SELECT * FROM Question WHERE questionID = ?";
        List<Question> questions = jdbcTemplate.query(query,
                new Object[]{questionID},
                new int[] { Types.INTEGER },
                questionRowMapper);
        return questions.stream().findAny().get();
    }
}
