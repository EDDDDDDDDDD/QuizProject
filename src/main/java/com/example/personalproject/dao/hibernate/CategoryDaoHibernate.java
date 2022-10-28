package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.CategoryDao;
import com.example.personalproject.domain.Category;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryDaoHibernate implements CategoryDao {
    @Autowired
    private SessionFactory factory;
    public CategoryDaoHibernate() {}

    @Override
    public List<Category> getAllCategories() {
        Session session = factory.getCurrentSession();
        TypedQuery<Category> query = session.createQuery(
                "SELECT c FROM Category c",
                Category.class
        );

        return query.getResultList();
    }

    @Override
    public Category getCategoryByID(int categoryID) {
        Session session = factory.getCurrentSession();
        return session.get(Category.class, categoryID);
//        TypedQuery<Category> query = session.createQuery(
//                "SELECT c FROM Category c WHERE c.categoryID = :p1",
//                Category.class
//        );
//        query.setParameter("p1", categoryID);
//        return query.getSingleResult();
    }
}
