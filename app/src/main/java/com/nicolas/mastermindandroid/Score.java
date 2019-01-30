package com.nicolas.mastermindandroid;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;





public class Score extends AppCompatActivity{
    Bundle extras;
    String pseudo;
    String nbrTour;
    TextView monTextViewPseudo;
    TextView monTemps;
    TextView monScore;
    String time;
    int calculScoreTime;
    int monScoreFinal;
    Button quitter;
    Button rejouer;
    Context context;


    public Context getContext() {
        return context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
    this.context = getApplicationContext();
    //  -----------------RECUP DES INFORMATION DE LA PARTIE + AFFICHAGE----------------- //
        try{
            extras = getIntent().getExtras();
            pseudo = extras.getString("pseudo");
            time = extras.getString("time");
            nbrTour = extras.getString("nbrTour");
            monTextViewPseudo = findViewById(R.id.msgFelicitation);
            monTextViewPseudo.setText(getString(R.string.congrats)+" "+pseudo);
            calculScoreTime = Integer.parseInt(time);
            quitter = findViewById(R.id.Quitter);
            rejouer = findViewById(R.id.Rejouer);


        }catch (Exception e){
            System.out.println("bug");
        }

        monTemps = findViewById(R.id.textView11);
        monTemps.setText("vous avez réussit en "+calculScoreTime+" secondes");
        monScore = findViewById(R.id.textView12);
        monScore.setText("Votre score est de : "+calculScore());


        //--> recuperation de la date
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sdf.format(c.getTime());



        Winner monJoueur = new Winner(calculScore(),pseudo, strDate);

        HighScore HallOfFame = new HighScore();

        //

        Transmission monRec = new Transmission(HallOfFame,monJoueur,context);
        monRec.deleteTab();
        monRec.remplissageTableau();

        HighScore listHighScore = monRec.getHighScore();


        listHighScore.getListHighscore().add(monJoueur);

        Collections.sort(listHighScore.getListHighscore());

        monRec.setHighScore(listHighScore);


        monRec.saveHighScore();


        monRec.readHighScore(this);



        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(Score.this, MainActivity.class);
                startActivity(monIntent);
            }
        });

    }

    public int calculScore(){
        monScoreFinal = (Integer.parseInt(nbrTour)+2)*100 + ((120 - Integer.parseInt(time))*10);
        return monScoreFinal;
    }





}
