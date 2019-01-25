package com.nicolas.mastermindandroid;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.Date;

public class Winner {
    int Score;
    String pseudo;
    String date;
    static  Winner[] monTabHighScore = new Winner[3];

    public Winner(int score, String pseudo, String date) {
        Score = score;
        this.pseudo = pseudo;
        this.date = date;
        pushWinner();


       Log.d("winner", "Winner1: "+monTabHighScore[2].getPseudo());

       if (monTabHighScore[1] != null){
            Log.d("winner", "Winner2: "+monTabHighScore[1].getPseudo());
        }
        else {
            Log.d("loose 1", "loose");
        }

        if (monTabHighScore[0] != null){
            Log.d("winner", "Winner3: "+monTabHighScore[0].getPseudo());
        }
        else {
            Log.d("loose 1", "loose");
        }

        tri();
    }
    public Winner(String pseudo, String date) {
        this.pseudo = pseudo;
        this.date = date;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private void pushWinner(){

        Log.d("Entree??", "je suis entre dans push: ");
        if(monTabHighScore[monTabHighScore.length-1] == null){
            monTabHighScore[monTabHighScore.length-1] = this;
        }
        else if (Score > monTabHighScore[monTabHighScore.length-1].getScore() ){
            monTabHighScore[monTabHighScore.length-1] = this;
        }
    }

    public void tri(){
        for (int i=monTabHighScore.length-1; i>0; i--){
            if (monTabHighScore[i] != null && monTabHighScore[i-1] != null) {

                if (monTabHighScore[i].getScore() > monTabHighScore[i - 1].getScore()) {
                    Winner monwinnerTemp = monTabHighScore[i];
                    monTabHighScore[i] = monTabHighScore[i - 1];
                    monTabHighScore[i - 1] = monwinnerTemp;
                }
            }
            else if (monTabHighScore[i-1] == null){
                monTabHighScore[i-1] = monTabHighScore[i];
                monTabHighScore[i] = null;
            }
        }
    }

}
