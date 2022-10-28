package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.QuizDao;
import com.example.personalproject.domain.Quiz;
import com.example.personalproject.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class QuizDaoHibernate implements QuizDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Quiz> getAllQuiz() {
        Session session = factory.getCurrentSession();
        TypedQuery<Quiz> query = session.createQuery(
                "SELECT q FROM Quiz q ORDER BY q.startTime DESC",
                Quiz.class
        );
        return query.getResultList();
    }

    @Override
    public List<Quiz> getAllQuizByUser(User user) {
        Session session = factory.getCurrentSession();
        TypedQuery<Quiz> query = session.createQuery(
                "SELECT q FROM Quiz q WHERE q.userID = :p1 ORDER BY q.startTime DESC",
                Quiz.class
        );
        query.setParameter("p1", user.getUserID());
        return query.getResultList();
    }

    @Override
    public Quiz getQuizByStartTime(Quiz quiz) {
        Session session = factory.getCurrentSession();
        TypedQuery<Quiz> query = session.createQuery(
                "SELECT q FROM Quiz q WHERE q.userID = :p1 AND q.startTime = :p2",
                Quiz.class
        );
        query.setParameter("p1", quiz.getUserID());
        query.setParameter("p2", quiz.getStartTime());
        return query.getSingleResult();
    }

    @Override
    public Quiz getQuizByID(int quizID) {
        Session session = factory.getCurrentSession();
        TypedQuery<Quiz> query = session.createQuery(
                "SELECT q FROM Quiz q WHERE q.quizID = :p1",
                Quiz.class
        );
        query.setParameter("p1", quizID);
        return query.getSingleResult();
    }

    @Override
    public void createNewQuiz(Quiz quiz) {
        Session session = factory.getCurrentSession();
        session.save(quiz);
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        Session session = factory.getCurrentSession();
        session.update(quiz);
    }
}
