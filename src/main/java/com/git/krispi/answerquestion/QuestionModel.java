package com.git.krispi.answerquestion;

public class QuestionModel {
    private String Question;
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;
    private Answer answer4;

    public QuestionModel(String question, Answer answer1, Answer answer2, Answer answer3, Answer answer4) {
        Question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Answer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(Answer answer1) {
        this.answer1 = answer1;
    }

    public Answer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(Answer answer2) {
        this.answer2 = answer2;
    }

    public Answer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(Answer answer3) {
        this.answer3 = answer3;
    }

    public Answer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(Answer answer4) {
        this.answer4 = answer4;
    }

    private class Answer{
        boolean check;
        String Answer;

         private Answer(boolean check, String answer) {
            this.check = check;
            Answer = answer;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getAnswer() {
            return Answer;
        }

        public void setAnswer(String answer) {
            Answer = answer;
        }
    }
}
