package com.nicolas.mastermindandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


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
    private EditText highScoreStorage;
    private String simpleFileName = "highScore.txt";
    private String monDossierScore = "highScore";
    Button quitter;
    Button rejouer;
    File monFile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

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

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sdf.format(c.getTime());

        Winner monJoueur = new Winner(calculScore(),pseudo, strDate);


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
//        this.getSharedPreferences("user_prefs",Context.MODE_PRIVATE);
        TextView essai = findViewById(R.id.textView13);
        essai.setText(Winner.monTabHighScore[2].getPseudo()+" "+ Winner.monTabHighScore[2].getDate()+ " " +Winner.monTabHighScore[2].getScore());

    }

    public int calculScore(){
        monScoreFinal = (Integer.parseInt(nbrTour)+2)*100 + ((120 - Integer.parseInt(time))*10);
        return monScoreFinal;
    }

}
