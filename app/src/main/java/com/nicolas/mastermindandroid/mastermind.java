package com.nicolas.mastermindandroid;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;


public class mastermind extends AppCompatActivity {



    int countX = 0;
    int countY = 9;
    private TableLayout tableLayout;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mastermind);

        View myRectangleViewVert = findViewById(R.id.myRectangleViewVert);
        myRectangleViewVert.setBackgroundResource(R.drawable.cerclepropositionvert);

        View myRectangleViewRouge = findViewById(R.id.myRectangleViewRouge);
        myRectangleViewRouge.setBackgroundResource(R.drawable.cerclepropositionrouge);

        View myRectangleViewBleu = findViewById(R.id.myRectangleViewBleu);
        myRectangleViewBleu.setBackgroundResource(R.drawable.cerclepropositionbleu);

        View myRectangleViewJaune = findViewById(R.id.myRectangleViewJaune);
        myRectangleViewJaune.setBackgroundResource(R.drawable.cerclepropositionjaune);

        View myRectangleViewViolet = findViewById(R.id.myRectangleViewViolet);
        myRectangleViewViolet.setBackgroundResource(R.drawable.cerclepropositionviolet);

//
//        //monTab[0] = R.id.cercleVideProposition_10_4;
//
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
//

        /*
        for (int i=tableLayout.getChildCount() - 1 ; i > -1; i--){
            for(int y=0; y<4; y++){
                View monCercle = ((TableRow)tableLayout.getChildAt(i)).getChildAt(y);
                Log.d("AJOUT", monCercle.toString());
                monTab[i*4+y] = monCercle;
            }

        }
*/


       myRectangleViewViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TableRow)tableLayout.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionviolet);

                countX ++;
                if (countX == 4){
                    countX =0;
                    countY --;

                    //Correnspond à la fin de la partie
                    if (countY < 0) countY = 0;
                }
            }

        });
        myRectangleViewJaune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TableRow)tableLayout.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionjaune);

                countX ++;
                if (countX == 4){
                    countX =0;
                    countY --;

                    //Correnspond à la fin de la partie
                    if (countY < 0) countY = 0;
                }
            }

        });
        myRectangleViewBleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TableRow)tableLayout.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionbleu);

                countX ++;
                if (countX == 4){
                    countX =0;
                    countY --;

                    //Correnspond à la fin de la partie
                    if (countY < 0) countY = 0;
                }
            }

        });
        myRectangleViewRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TableRow)tableLayout.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionrouge);

                countX ++;
                if (countX == 4){
                    countX =0;
                    countY --;

                    //Correnspond à la fin de la partie
                    if (countY < 0) countY = 0;
                }
            }

        });
        myRectangleViewVert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TableRow)tableLayout.getChildAt(countY)).getChildAt(countX).setBackgroundResource(R.drawable.cerclepropositionvert);

                countX ++;
                if (countX == 4){
                    countX =0;
                    countY --;

                    //Correnspond à la fin de la partie
                    if (countY < 0) countY = 0;
                }
            }

        });

    }
}
