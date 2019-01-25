package com.nicolas.mastermindandroid;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnJouer = findViewById(R.id.buttonJouer);

        btnJouer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                build.setTitle("Merci d'entrer un pseudo");
                final EditText monPseudo = new EditText(MainActivity.this);
                build.setView(monPseudo);

                build.setCancelable(false);
                build.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        pseudo = monPseudo.getText().toString();




                        if (!pseudo.isEmpty()) {
                            Intent intent1 = new Intent(MainActivity.this, mastermind.class);
                            intent1.putExtra("pseudo",pseudo);
                            startActivity(intent1);
                        }
                        else{

                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Veuillez entrer un pseudo",
                                    Toast.LENGTH_SHORT);

                            toast.show();
                        }
                    }
                });

                build.show();
            }
        });
    }
}
