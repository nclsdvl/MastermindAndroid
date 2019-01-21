package com.nicolas.mastermindandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class mastermind extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mastermind);

        View myRectangleViewVert = findViewById(R.id.myRectangleViewVert);
        myRectangleViewVert.setBackgroundColor(Color.argb(255,0,100,0));

        View myRectangleViewRouge = findViewById(R.id.myRectangleViewRouge);
        myRectangleViewRouge.setBackgroundColor(Color.argb(255,200,0,0));

        View myRectangleViewBleu = findViewById(R.id.myRectangleViewBleu);
        myRectangleViewBleu.setBackgroundColor(Color.argb(255,0,0,200));

        View myRectangleViewJaune = findViewById(R.id.myRectangleViewJaune);
        myRectangleViewJaune.setBackgroundColor(Color.argb(255,200,200,0));

        View myRectangleViewViolet = findViewById(R.id.myRectangleViewViolet);
        myRectangleViewViolet.setBackgroundColor(Color.argb(255,100,0,100));
    }

    // YourView.setBackgroundColor(Color.argb(255, 255, 255, 255));
}
