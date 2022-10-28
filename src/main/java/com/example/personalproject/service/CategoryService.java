package com.example.personalproject.service;

import com.example.personalproject.dao.CategoryDao;
import com.example.personalproject.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(@Qualifier("categoryDaoHibernate") CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getAllCategories() { return categoryDao.getAllCategories(); }
    public Category getCategoryByID(int categoryID) { return categoryDao.getCategoryByID(categoryID); }
}
