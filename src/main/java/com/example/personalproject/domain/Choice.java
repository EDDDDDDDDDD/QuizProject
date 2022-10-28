package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int choiceID;
    private int questionID;
    private String description;
    private boolean isCorrect;

    public Choice() {}
    public Choice(int choiceID, int questionID, String description, boolean isCorrect) {
        this.choiceID = choiceID;
        this.questionID = questionID;
        this.description = description;
        this.isCorrect = isCorrect;
    }
    @Override
    public String toString() {
        return "Choice {" +
                "choiceID = " + this.choiceID +
                ", questionID = '" + this.questionID + '\'' +
                ", description = '" + this.description + '\'' +
                ", isCorrect = '" + this.isCorrect + '\'' +
                '}';
    }

    public int getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(int choiceID) {
        this.choiceID = choiceID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCorrect() { return isCorrect; }

    public void setCorrect(boolean correct) { isCorrect = correct; }
}
