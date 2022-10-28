package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.CommentDao;
import com.example.personalproject.domain.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoHibernate implements CommentDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public void createNewComment(Comment comment) {
        Session session = factory.getCurrentSession();
        session.save(comment);
    }
}
