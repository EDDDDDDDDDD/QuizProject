package com.example.personalproject.dao.hibernate;


import com.example.personalproject.dao.FeedbackDao;
import com.example.personalproject.domain.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FeedbackDaoHibernate implements FeedbackDao {

    @Autowired
    private SessionFactory factory;
    @Override
    public List<Feedback> getAllFeedback() {
        Session session = factory.getCurrentSession();
        TypedQuery<Feedback> query = session.createQuery(
                "FROM Feedback f",
                Feedback.class
        );
        return query.getResultList();
    }
    @Override
    public void createNewFeedback(Feedback feedback) {
        Session session = factory.getCurrentSession();
        session.save(feedback);
    }
}
