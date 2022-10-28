package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.QuizDao;
import com.example.personalproject.domain.Quiz;
import com.example.personalproject.domain.User;
import com.example.personalproject.mapper.QuizRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class QuizDaoJDBC implements QuizDao {
    JdbcTemplate jdbcTemplate;
    QuizRowMapper quizRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final List<Quiz> quizzes;
    static {
        quizzes = new ArrayList<>();
    }

    public QuizDaoJDBC() {}
    @Autowired
    public QuizDaoJDBC(JdbcTemplate jdbcTemplate, QuizRowMapper quizRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.quizRowMapper = quizRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        // FOR Interface but not implemented yet
        return null;
    }

    @Override
    public List<Quiz> getAllQuizByUser(User user) {
        String query = "SELECT * FROM Quiz WHERE userID = ? ORDER BY startTime DESC";

        List<Quiz> quizList = jdbcTemplate.query(query,
                new Object[]{ user.getUserID() },
                new int[] { Types.INTEGER },
                quizRowMapper);
        return quizList;
    }
    @Override
    public Quiz getQuizByStartTime(Quiz quiz) {
        String query = "SELECT * FROM Quiz WHERE startTime = ?";
        List<Quiz> quizzes = jdbcTemplate.query(query,
                new Object[]{quiz.getStartTime()},
                new int[] { Types.TIMESTAMP },
                quizRowMapper);
        return quizzes.stream().filter(
                a -> a.getUserID() == quiz.getUserID() &&
                        a.getCategoryID() == quiz.getCategoryID()
        ).findAny().get();
    }
    @Override
    public Quiz getQuizByID(int quizID) {
        String query = "SELECT * FROM Quiz WHERE quizID = ?";
        List<Quiz> quizList = jdbcTemplate.query(query,
                new Object[] {quizID},
                new int[] {Types.INTEGER},
                quizRowMapper);
        return quizList.stream().findAny().get();
    }
    @Override
    public void createNewQuiz(Quiz quiz) {
        String query = "INSERT INTO Quiz (userID, categoryID, startTime)" +
                "values (?, ?, ?)";
        jdbcTemplate.update(query, quiz.getUserID(), quiz.getCategoryID(), quiz.getStartTime());
    }
    @Override
    public void updateQuiz(Quiz quiz) {
        String query = "UPDATE Quiz SET endTime = ? WHERE quizID = ?";
        jdbcTemplate.update(query, quiz.getEndTime(), quiz.getQuizID());
    }

}
