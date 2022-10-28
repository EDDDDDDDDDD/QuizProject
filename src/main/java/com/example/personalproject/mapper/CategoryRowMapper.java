package com.example.personalproject.mapper;

import com.example.personalproject.domain.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow (ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setCategoryID(rs.getInt("categoryID"));
        category.setName(rs.getString("name"));

        return category;
    }
}
