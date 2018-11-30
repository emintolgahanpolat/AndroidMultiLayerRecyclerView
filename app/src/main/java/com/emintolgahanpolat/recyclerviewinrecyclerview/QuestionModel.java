package com.emintolgahanpolat.recyclerviewinrecyclerview;

import java.util.List;

public class QuestionModel {
    private String id;
    private String question;
    private List<AnswerModel> answers;

    public QuestionModel(String id, String question, List<AnswerModel> answers) {
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

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }
}
