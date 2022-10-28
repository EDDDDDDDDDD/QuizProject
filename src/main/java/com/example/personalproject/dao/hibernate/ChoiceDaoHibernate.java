package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.ChoiceDao;
import com.example.personalproject.domain.Choice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ChoiceDaoHibernate implements ChoiceDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public Choice getChoiceByID(int choiceID) {
        Session session = factory.getCurrentSession();
        TypedQuery<Choice> query = session.createQuery(
                "SELECT c FROM Choice c WHERE c.choiceID = :p1",
                Choice.class
        );
        query.setParameter("p1", choiceID);
        return query.getSingleResult();
    }

    @Override
    public List<Choice> getChoicesByQuestion(int questionID) {
        Session session = factory.getCurrentSession();
        TypedQuery<Choice> query = session.createQuery(
                "SELECT c FROM Choice c WHERE c.questionID = :p1",
                Choice.class
        );
        query.setParameter("p1", questionID);
        return query.getResultList();
    }
    @Override
    public void updateChoice(Choice choice) {
        Session session = factory.getCurrentSession();
        session.update(choice);
    }
}
