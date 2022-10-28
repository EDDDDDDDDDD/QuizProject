package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionID;
    private int categoryID;
    private String description;
    private boolean isActive;

    public Question() {
    }

    public Question(int questionID, int categoryID, String description, boolean isActive) {
        this.questionID = questionID;
        this.categoryID = categoryID;
        this.description = description;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Question {" +
                "questionID = " + this.questionID +
                ", categoryID = '" + this.categoryID + '\'' +
                ", description = '" + this.description + '\'' +
                ", isActive = '" + this.isActive + '\'' +
                '}';
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }
}
