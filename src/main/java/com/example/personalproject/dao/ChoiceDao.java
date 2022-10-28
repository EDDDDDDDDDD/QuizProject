package com.example.personalproject.dao;

import com.example.personalproject.domain.Choice;

import java.util.List;

public interface ChoiceDao {
    Choice getChoiceByID(int choiceID);
    List<Choice> getChoicesByQuestion(int questionID);

    void updateChoice(Choice choice);
}
