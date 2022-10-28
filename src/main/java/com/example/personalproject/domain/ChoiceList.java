package com.example.personalproject.domain;

import java.util.List;

public class ChoiceList {
    private List<Choice> choices;

    public ChoiceList() {}
    public ChoiceList(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
