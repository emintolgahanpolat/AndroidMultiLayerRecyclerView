package com.emintolgahanpolat.recyclerviewinrecyclerview;

import java.util.List;

public class QuestionModel {
    private String id;
    private String question;
    private List<Object> answers;

    public QuestionModel(String id, String question, List<Object> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Object> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Object> answers) {
        this.answers = answers;
    }
}
