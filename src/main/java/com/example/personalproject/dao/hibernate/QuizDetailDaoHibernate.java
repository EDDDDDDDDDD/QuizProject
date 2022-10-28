package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.QuizDetailDao;
import com.example.personalproject.domain.Category;
import com.example.personalproject.domain.QuizDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class QuizDetailDaoHibernate implements QuizDetailDao {
    @Autowired
    private SessionFactory factory;
    @Override
    public List<QuizDetail> getQuizDetailsByQuiz(int quizID) {
        Session session = factory.getCurrentSession();
        TypedQuery<QuizDetail> query = session.createQuery(
                "SELECT q FROM QuizDetail q WHERE q.quizID = :p1",
                QuizDetail.class
        );
        query.setParameter("p1", quizID);
        return query.getResultList();
    }

    @Override
    public void createNewQuizDetail(QuizDetail quizDetail) {
        Session session = factory.getCurrentSession();
        session.save(quizDetail);
    }
}
