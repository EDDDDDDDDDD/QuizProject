package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.QuestionDao;
import com.example.personalproject.domain.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class QuestionDaoHibernate implements QuestionDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Question> getAllQuestion() {
        Session session = factory.getCurrentSession();
        TypedQuery<Question> query = session.createQuery(
                "FROM Question q",
                Question.class
        );
        return query.getResultList();
    }
    @Override
    public List<Question> getQuestionsByCategory(int categoryID, int quizSize) {
        Session session = factory.getCurrentSession();
        TypedQuery<Question> query = session.createQuery(
                "SELECT q FROM Question q WHERE q.categoryID = :p1 AND q.isActive = true ORDER BY RAND()",
                Question.class
        ).setMaxResults(quizSize);
        query.setParameter("p1", categoryID);
        return query.getResultList();
    }
    @Override
    public Question getQuestionByID(int questionID) {
        Session session = factory.getCurrentSession();
        TypedQuery<Question> query = session.createQuery(
                "SELECT q FROM Question q WHERE q.questionID = :p1",
                Question.class
        );
        query.setParameter("p1", questionID);
        return query.getSingleResult();
    }
    @Override
    public void updateQuestion(Question question) {
        Session session = factory.getCurrentSession();
        session.update(question);
    }
}
