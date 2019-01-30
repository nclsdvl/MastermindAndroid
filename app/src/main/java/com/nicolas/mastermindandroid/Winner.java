package com.nicolas.mastermindandroid;

import android.app.Activity;



public class Winner extends Activity implements Comparable<Winner>{
    Integer Score;
    String pseudo;
    String date;

    @Override
    public String toString() {
        return "Winner{" +
                "Score=" + Score +
                ", pseudo='" + pseudo + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    // --> creation de la comparaison de Winner
    @Override
    public int compareTo(Winner o) {
        if (o==null){
            return -1;
        }
        else return this.getScore() > o.getScore() ? -1 : this.getScore() < o.getScore() ? 1 : 0;

    }

    public Winner(Integer score, String pseudo, String date) {
        Score = score;
        this.pseudo = pseudo;
        this.date = date;

    }

    public Winner(String pseudo, String date) {
        this.pseudo = pseudo;
        this.date = date;
    }

    public Integer getScore() {
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



}
