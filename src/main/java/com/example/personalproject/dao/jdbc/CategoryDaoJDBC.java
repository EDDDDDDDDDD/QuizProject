package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.CategoryDao;
import com.example.personalproject.domain.Category;
import com.example.personalproject.mapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoJDBC implements CategoryDao {
    JdbcTemplate jdbcTemplate;
    CategoryRowMapper categoryRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final List<Category> categories;
    static {
        categories = new ArrayList<>();
    }

    public CategoryDaoJDBC() {}

    @Autowired
    public CategoryDaoJDBC(JdbcTemplate jdbcTemplate, CategoryRowMapper categoryRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryRowMapper = categoryRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public List<Category> getAllCategories() {
        String query = "SELECT * FROM Category";
        List<Category> categories = jdbcTemplate.query(query, categoryRowMapper);
        return categories;
    }
    @Override
    public Category getCategoryByID(int categoryID) {
        String query = "SELECT * FROM Category WHERE categoryID = ?";
        List<Category> categories = jdbcTemplate.query(query,
                new Object[] { categoryID },
                new int[] { Types.INTEGER },
                categoryRowMapper);
        return categories.stream().findFirst().get();
    }
}
