package com.nicolas.mastermindandroid;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.nicolas.mastermindandroid.mastermind;


public class mastermind extends AppCompatActivity {


    ControllerMastermind maPartie = new ControllerMastermind(5,4,10);
    int countX = 0;
    int countY = 9;
    private TableLayout tableLayoutProposition;
    int[] monTabDeProposition = new int[4];
    private TableLayout tableLayoutSoluce;
    private TextView maConsigne;
    private LinearLayout layoutDeChoix;
    Bundle extras;
    String pseudo;
    TextView monTextViewPseudo;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mastermind);

        try{
            extras = getIntent().getExtras();
            pseudo = extras.getString("pseudo");
            monTextViewPseudo = findViewById(R.id.textView8);
            monTextViewPseudo.setText(pseudo);
        }catch (Exception e){
            System.out.println("bug");
        }

        View myRectangleViewVert = findViewById(R.id.myRectangleViewVert); // ---> 0
        myRectangleViewVert.setBackgroundResource(R.drawable.cerclepropositionvert);

        View myRectangleViewRouge = findViewById(R.id.myRectangleViewRouge); //  ----> 1
        myRectangleViewRouge.setBackgroundResource(R.drawable.cerclepropositionrouge);

        View myRectangleViewBleu = findViewById(R.id.myRectangleViewBleu); // ---> 2
        myRectangleViewBleu.setBackgroundResource(R.drawable.cerclepropositionbleu);

        View myRectangleViewJaune = findViewById(R.id.myRectangleViewJaune); //  ----> 3
        myRectangleViewJaune.setBackgroundResource(R.drawable.cerclepropositionjaune);

        View myRectangleViewViolet = findViewById(R.id.myRectangleViewViolet);  // ----> 4
        myRectangleViewViolet.setBackgroundResource(R.drawable.cerclepropositionviolet);



        tableLayoutProposition = (TableLayout) findViewById(R.id.tableLayout);
        tableLayoutSoluce = (TableLayout) findViewById(R.id.soluceTableLayout);
        maConsigne = findViewById(R.id.textView7);


            myRectangleViewViolet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((TableRow) tableLayoutProposition.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionviolet);
                    monTabDeProposition[countX] = 4;
                    placementProposition();

                }

            });
            myRectangleViewJaune.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((TableRow) tableLayoutProposition.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionjaune);

                    monTabDeProposition[countX] = 3;
                    placementProposition();
                }

            });
            myRectangleViewBleu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((TableRow) tableLayoutProposition.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionbleu);

                    monTabDeProposition[countX] = 2;
                    placementProposition();
                }

            });
            myRectangleViewRouge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((TableRow) tableLayoutProposition.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionrouge);

                    monTabDeProposition[countX] = 1;
                    placementProposition();
                }

            });
            myRectangleViewVert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((TableRow) tableLayoutProposition.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionvert);

                    monTabDeProposition[countX] = 0;
                    placementProposition();
                }

            });

    }


    public void placementProposition (){
        countX ++;
        if (countX == 4){

            maPartie.SaisirProposition(monTabDeProposition, countY);
            maPartie.CalculBPMP(countY);
            int maProp[][] =  maPartie.getProposition();

            int BP = maProp[4][countY];
            int MP = maProp[5][countY];
            //int total_a_Placer = BP + MP;
            int positionMP = 0;

            // TEST //
            Log.d("montest", "BP = "+BP+"; MP = "+MP + " countY = "+countY);

            if (BP>0){
            for (int i = 0; i < BP; i++){
                Log.d("countY = ",  "countY = "+countY);
                ((TableRow)tableLayoutSoluce.getChildAt(countY)).getChildAt(positionMP).setBackgroundResource(R.drawable.cerclereponsevert);
                positionMP++;
            }}

            if(MP>0){
            for (int i = 0; i < MP; i++){
                ((TableRow)tableLayoutSoluce.getChildAt(countY)).getChildAt(positionMP).setBackgroundResource(R.drawable.cerclepropositionrouge);
                positionMP++;
            }}

            Log.d("gagne", "Gagne(-1 * (countY-10)) = "+maPartie.Gagne/*(-1 * (countY-10))*/(countY));


            //Correnspond à la fin de la partie


//                //Intent intent1 = new Intent(mastermind.this, mastermind.class);
//                //startActivity(intent1);

            if(BP == 4){
                maConsigne.setText(getString(R.string.felicitation));
                maConsigne.setTextSize(32);
                maConsigne.getLayoutParams().height = 100;
                maConsigne.getLayoutParams().width = 360;
                maConsigne.setBackgroundResource(R.drawable.bgresult);

                layoutDeChoix = findViewById(R.id.linearLayout2);
                ConstraintLayout layoutParent = findViewById(R.id.linearLayout);
                layoutParent.removeView(layoutDeChoix);


            }
            else if (BP <4 && countY == 0) {

                maConsigne.setText(getString(R.string.looser));
                maConsigne.setTextSize(32);
                maConsigne.getLayoutParams().height = 100;
                maConsigne.setBackgroundResource(R.drawable.bgloose);
                maConsigne.getLayoutParams().width = 360;

                layoutDeChoix = findViewById(R.id.linearLayout2);
                ConstraintLayout layoutParent = findViewById(R.id.linearLayout);
                layoutParent.removeView(layoutDeChoix);

            }

            countX = 0;
            countY --;
        }
    }

}
