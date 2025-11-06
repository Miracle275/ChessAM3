package org.baltimorecityschools.chessam;

import androidx.annotation.NonNull;

public class Question {

    //Instance Variables
    private String qText;

    private boolean correctAns;



    //Constructors

    public Question(){
        qText = " ";

        correctAns = false;
    }

    public Question(String newqText, boolean newCorrectans){
        qText = newqText;

        correctAns = newCorrectans;
    }


    //Methods

    public String getqText() {
        return qText;
    }
    public boolean getcorrectAns() {
        return correctAns;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public void setCorrectAns(boolean correctAns) {
        this.correctAns = correctAns;
    }

    @NonNull
    @Override
    public String toString() {
        return qText + correctAns;
    }
}
