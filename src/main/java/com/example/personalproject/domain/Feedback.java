package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackID;
    private String description;
    private int starRating;

    public Feedback() {}
    public Feedback(String description, int starRating) {
        this.description = description;
        this.starRating = starRating;
    }

    @Override
    public String toString() {
        return "Feedback {" +
                "feedbackID = " + this.feedbackID +
                ", description = '" + this.description + '\'' +
                ", starRating = '" + this.starRating + '\'' +
                '}';
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
}
