package com.git.krispi.answerquestion;

public class AnswerModel{
    boolean check;
    String Answer;

    AnswerModel(boolean check, String answer) {
        this.check = check;
        Answer = answer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getAnswerModel() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}