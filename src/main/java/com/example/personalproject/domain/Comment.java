package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;
    private int userID;
    private String messageBody;

    public Comment() {}
    public Comment(int userID, String messageBody) {
        this.userID = userID;
        this.messageBody = messageBody;
    }
    @Override
    public String toString() {
        return "Comment {" +
                "commentID = " + this.commentID +
                ", userID = '" + this.userID + '\'' +
                ", messageBody = '" + this.messageBody + '\'' +
                '}';
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
