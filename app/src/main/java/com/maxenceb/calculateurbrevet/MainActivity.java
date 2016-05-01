package com.maxenceb.calculateurbrevet;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void sendNotes(View view){

        EditText fr = (EditText)findViewById(R.id.editText);
        EditText ma = (EditText)findViewById(R.id.editText2);
        EditText an = (EditText)findViewById(R.id.editText3);
        EditText lv = (EditText)findViewById(R.id.editText4);
        EditText sv = (EditText)findViewById(R.id.editText5);

        EditText sc = (EditText)findViewById(R.id.editText6);
        EditText te = (EditText)findViewById(R.id.editText7);
        EditText mu = (EditText)findViewById(R.id.editText8);
        EditText ar = (EditText)findViewById(R.id.editText9);
        EditText ep = (EditText)findViewById(R.id.editText10);

        EditText listeNote[] = {fr,ma,an,lv,sv,sc,te,mu,ar,ep};
        float notes[] =  new float[listeNote.length];
        boolean vide = false;
        boolean grand = false;
        boolean point = false;
        for(int i=0; i < listeNote.length; i++){
            if(listeNote[i].getText().toString().equals(".")){
                point = true;
                break;
            }
            if(listeNote[i].getText().toString().matches("")){
                vide = true;
                break;
            }
            if(Float.parseFloat(listeNote[i].getText().toString()) > 20){
                grand = true;
                break;
            }


            notes[i] = Float.parseFloat(listeNote[i].getText().toString());
        }
        if (vide){
            Snackbar mySnack = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Vous ne devez pas laisser de cases vides", Snackbar.LENGTH_SHORT);
            mySnack.show();
        }
        else if(grand){
            Snackbar mySnack = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Vos notes ne peuvent pas dépasser 20", Snackbar.LENGTH_SHORT);
            mySnack.show();
        }
        else if(point){
            Snackbar mySnack = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Vous ne devez pas mettre de virgules seules", Snackbar.LENGTH_SHORT);
            mySnack.show();
        }
        else
        {
        Intent intent = new Intent(this, Resultats.class);
        intent.putExtra("note", notes);
        startActivity(intent);
        }
    }
}
