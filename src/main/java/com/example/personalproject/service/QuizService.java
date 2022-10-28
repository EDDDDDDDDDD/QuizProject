package com.example.personalproject.service;

import com.example.personalproject.dao.*;
import com.example.personalproject.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizService {
    private QuizDao quizDao;
    private ChoiceDao choiceDao;
    private QuestionDao questionDao;
    private QuizDetailDao quizDetailDao;

    @Autowired
    public QuizService(@Qualifier("quizDaoHibernate") QuizDao quizDao,
                       @Qualifier("questionDaoHibernate") QuestionDao questionDao,
                       @Qualifier("choiceDaoHibernate") ChoiceDao choiceDao,
                       @Qualifier("quizDetailDaoHibernate") QuizDetailDao quizDetailDao) {
        this.quizDao = quizDao;
        this.choiceDao = choiceDao;
        this.questionDao = questionDao;
        this.quizDetailDao = quizDetailDao;
    }
    // GET Quiz series
    public List<Quiz> getAllQuiz() { return quizDao.getAllQuiz(); }
    public Quiz getQuizByID(int quizID) { return quizDao.getQuizByID(quizID); }
    public Quiz getQuizByStartTime(Quiz quiz) { return quizDao.getQuizByStartTime(quiz); }
    public List<Quiz> getAllQuizByUser(User user) { return quizDao.getAllQuizByUser(user); }


    // GET Question series
    public List<Question> getAllQuestion() { return questionDao.getAllQuestion(); }
    public List<Question> getQuestionsByCategory(int categoryID, int quizSize) {
        return questionDao.getQuestionsByCategory(categoryID, quizSize);
    }
    public Question getQuestionByID(int questionID) { return questionDao.getQuestionByID(questionID); }


    // GET choice series
    public List<Choice> getChoicesByQuestion(int questionID) { return choiceDao.getChoicesByQuestion(questionID); }
//    public Choice getCorrectChoiceByQuestion(int questionID) { return choiceDaoJDBC.getCorrectChoiceByQuestion(questionID); }
    public Choice getChoiceByID(int choiceID) { return choiceDao.getChoiceByID(choiceID); }


    // GET Detail series
    public List<QuizDetail> getQuizDetailsByQuiz(int quizID) { return quizDetailDao.getQuizDetailsByQuiz(quizID); }

    // CREATE OR UPDATE
    public void createNewQuiz(Quiz quiz) { quizDao.createNewQuiz(quiz); }
    public void createNewQuizDetail(QuizDetail quizDetail) { quizDetailDao.createNewQuizDetail(quizDetail); }
    public void updateQuiz(Quiz quiz) { quizDao.updateQuiz(quiz); }
    public void updateQuestion(Question question) { questionDao.updateQuestion(question); }
    public void updateChoice(Choice choice) { choiceDao.updateChoice(choice); }
}
