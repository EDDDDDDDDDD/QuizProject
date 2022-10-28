package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuizDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailID;
    private int quizID;
    private int questionID;
    private int choiceID;

    public QuizDetail() {}
    public QuizDetail(int quizID, int questionID, int choiceID) {
        this.quizID = quizID;
        this.questionID = questionID;
        this.choiceID = choiceID;
    }
    public QuizDetail(int detailID, int quizID, int questionID, int choiceID) {
        this.detailID = detailID;
        this.quizID = quizID;
        this.questionID = questionID;
        this.choiceID = choiceID;
    }
    @Override
    public String toString() {
        return "QuizDetail {" +
                "detailID = " + this.detailID +
                ", quizID = '" + this.quizID + '\'' +
                ", questionID = '" + this.questionID + '\'' +
                ", choiceID = '" + this.choiceID + '\'' +
                '}';
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(int choiceID) {
        this.choiceID = choiceID;
    }
}
