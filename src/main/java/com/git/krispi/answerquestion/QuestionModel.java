package com.git.krispi.answerquestion;

public class QuestionModel {
    private String Question;
    private AnswerModel[] answer;

    public QuestionModel(String question, AnswerModel[] answer) {
        Question = question;
        this.answer = answer;

    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public AnswerModel[] getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerModel[] answer) {
        this.answer = answer;
    }


}
