package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizID;
    private int userID;
    private int categoryID;
    private String startTime;
    private String endTime;
    private Integer score;

    public Quiz() {}
    public Quiz(int userID, int categoryID, String startTime) {
        this.userID = userID;
        this.categoryID = categoryID;
        this.startTime = startTime;
    }
    public Quiz(int userID, int categoryID, String startTime, String endTime) {
        this.userID = userID;
        this.categoryID = categoryID;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public String toString() {
        return "Quiz {" +
                "quizID = " + this.quizID +
                ", userID = '" + this.userID + '\'' +
                ", categoryID = '" + this.categoryID + '\'' +
                ", startTime = '" + this.startTime + '\'' +
                ", endTime = '" + this.endTime + '\'' +
                '}';
    }

    public int getQuizID() {
        return quizID;
    }
    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }
}
