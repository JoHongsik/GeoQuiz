package com.example.geoquiz;

public class Question {
    private int mTextReId;
    private boolean mAnswerTrue;

    public Question(int ReID, boolean answerTrue){
        this.mTextReId = ReID;
        this.mAnswerTrue = answerTrue;
    }

    public int getID(){
        return this.mTextReId;
    }

    public void setID(int ReID){
        this.mTextReId = ReID;
    }

    public boolean getAnswer(){
        return this.mAnswerTrue;
    }

    public void setAnswer(boolean answerTrue){
        this.mAnswerTrue = answerTrue;
    }

}
