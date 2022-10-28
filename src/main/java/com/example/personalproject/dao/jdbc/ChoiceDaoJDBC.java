package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.ChoiceDao;
import com.example.personalproject.domain.Choice;
import com.example.personalproject.mapper.ChoiceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class ChoiceDaoJDBC implements ChoiceDao {
    JdbcTemplate jdbcTemplate;
    ChoiceRowMapper choiceRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final List<Choice> choices;

    static {
        choices = new ArrayList<>();
    }
    public ChoiceDaoJDBC() {}

    @Autowired
    public ChoiceDaoJDBC(JdbcTemplate jdbcTemplate, ChoiceRowMapper choiceRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.choiceRowMapper = choiceRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public Choice getChoiceByID(int choiceID) {
        String query = "SELECT * FROM Choice WHERE choiceID = ?";
        List<Choice> choices = jdbcTemplate.query(query,
                new Object[]{choiceID},
                new int[] { Types.INTEGER },
                choiceRowMapper);
        return choices.stream().findFirst().get();
    }
    @Override
    public List<Choice> getChoicesByQuestion(int questionID) {
        String query = "SELECT * FROM Choice WHERE questionID = ?";
        List<Choice> choices = jdbcTemplate.query(
                query,
                new Object[]{questionID},
                new int[] { Types.INTEGER },
                choiceRowMapper);

        return choices;
    }
//    @Override
//    public Choice getCorrectChoiceByQuestion(int questionID) {
//        String query = "SELECT * FROM Choice WHERE questionID = ?";
//        List<Choice> choices = jdbcTemplate.query(query,
//                new Object[]{questionID},
//                new int[] { Types.INTEGER },
//                choiceRowMapper);
//        return choices.stream().filter(
//                a -> a.getIsCorrect() == true
//        ).findAny().get();
//    }
}
