package com.example.personalproject.dao;

import com.example.personalproject.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCategories();
    Category getCategoryByID(int categoryID);
}
