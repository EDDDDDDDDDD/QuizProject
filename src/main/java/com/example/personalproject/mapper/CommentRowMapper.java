package com.example.personalproject.mapper;

import com.example.personalproject.domain.Comment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentID(rs.getInt("commentID"));
        comment.setUserID(rs.getInt("userID"));
        comment.setMessageBody(rs.getString("messageBody"));
        return comment;
    }
}
