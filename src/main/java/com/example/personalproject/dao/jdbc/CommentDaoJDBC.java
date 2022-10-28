package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.CommentDao;
import com.example.personalproject.domain.Comment;
import com.example.personalproject.mapper.CommentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class CommentDaoJDBC implements CommentDao {
    JdbcTemplate jdbcTemplate;
    CommentRowMapper commentRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final List<Comment> comments;
    static {
        comments = new ArrayList<>();
    }

    public CommentDaoJDBC() {}

    @Autowired
    public CommentDaoJDBC(JdbcTemplate jdbcTemplate, CommentRowMapper commentRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.commentRowMapper = commentRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public void createNewComment(Comment comment) {
        String query = "INSERT INTO Comment (userID, messageBody)" +
                "values (?, ?)";
        jdbcTemplate.update(query, comment.getUserID(), comment.getMessageBody());
    }
}
