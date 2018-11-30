package com.emintolgahanpolat.recyclerviewinrecyclerview;

import java.util.List;

public class AnswerModel {


    private boolean checked;
    private String answer;


    public AnswerModel(String answer,boolean checked) {
        this.checked = checked;
        this.answer = answer;
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
