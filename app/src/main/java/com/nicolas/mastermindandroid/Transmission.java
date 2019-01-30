package com.nicolas.mastermindandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;


import static android.content.Context.MODE_PRIVATE;

public class Transmission {

   private Context context;
    private Winner winner;
    private HighScore highScore;

    public HighScore getHighScore() {
        return highScore;
    }

    public void setHighScore(HighScore highScore) {
        this.highScore = highScore;
    }

    public Transmission(Context context) {
        this.context = context;
    }

    public Transmission(HighScore monHS, Winner mon_Wi, Context lecontext) {
        this.context = lecontext;
        this.winner = mon_Wi;
        this.highScore = monHS;
    }

    //-------------- ENREGISTREMENT DANS SHAREDPREFS DES 3 MEILLEURS SCORES-------------------//
    public void saveHighScore() {

        SharedPreferences monFichier = context.getSharedPreferences("Fichier_highScore", MODE_PRIVATE);
        SharedPreferences.Editor editor = monFichier.edit();

        for (int i = 0; i < 3; i++) { //--->on enregistre que 3 scores

                editor.putInt("score" + i, highScore.getListHighscore().get(i).getScore());
                editor.putString("nom" + i, highScore.getListHighscore().get(i).getPseudo());
                editor.putString("date" + i, highScore.getListHighscore().get(i).getDate());

                editor.apply();
        }
    }

    //---> recuperation du tableau + affichage dans l'Activity SCORE <---//
    public void readHighScore(Score score) {


        for (int i =0; i<3;  i++) {

            String monNom = highScore.getListHighscore().get(i).getPseudo();
            int monScore = highScore.getListHighscore().get(i).getScore();
            String maDate = highScore.getListHighscore().get(i).getDate();


            if (i == 0) {
                TextView pseudo1 = score.findViewById(R.id.pseudo1);
                pseudo1.setText(monNom);

                TextView score1 = score.findViewById(R.id.score1);
                score1.setText("" + monScore);

                TextView date1 = score.findViewById(R.id.date1);
                date1.setText(maDate);
            }
            if (i == 1) {

                TextView pseudo2 = score.findViewById(R.id.pseudo2);
                pseudo2.setText(monNom);

                TextView score2 = score.findViewById(R.id.score2);
                score2.setText("" + monScore);

                TextView date2 = score.findViewById(R.id.date2);
                date2.setText(maDate);
            }
            if (i == 2) {
                TextView pseudo3 = score.findViewById(R.id.pseudo3);
                pseudo3.setText(monNom);

                TextView score3 = score.findViewById(R.id.score3);
                score3.setText("" + monScore);

                TextView date3 = score.findViewById(R.id.date3);
                date3.setText(maDate);
            }
        }
    }

    public void remplissageTableau() {

        SharedPreferences monFichier = context.getSharedPreferences("Fichier_highScore", MODE_PRIVATE);
        System.out.println("lecture fichier : ");

        for (int i = 2 ; i >= 0; i--) {


            String monNom = monFichier.getString("nom" + i, "");
            int monScore = monFichier.getInt("score" + i, 0);
            String maDate = monFichier.getString("date" + i, "");

            Winner monWinner = new Winner(monScore,monNom,maDate);

            highScore.addElements(monWinner);
        }


    }
    public void deleteTab(){
        System.out.println("YALA");
        SharedPreferences monFichier = context.getSharedPreferences("Fichier_highScore", MODE_PRIVATE);
        monFichier.edit().clear().apply();
    }
}
