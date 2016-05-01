package com.maxenceb.calculateurbrevet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        Intent intent = getIntent();
        float[] notes = intent.getFloatArrayExtra("note");
        float total = 0;
        for(int i = 0; i < notes.length; i++){
            total = total + notes[i];
        }

        TextView pointsView = (TextView)findViewById(R.id.textView14);
        pointsView.setText(String.valueOf(total));
        TextView pointsRestants = (TextView)findViewById(R.id.textView17);
        String phrase;
        if(total >= 180){
            phrase = "Vous avez déja le brevet";
        }
        else {
            phrase = "Il vous faut " + ((180 - total) / 8) + " sur 20 à chaque épreuve pour avoir le brevet";
        }
        pointsRestants.setText(phrase);

        TextView assezBien = (TextView)findViewById(R.id.textView19);
        String phrase2;
        if((216-total)/8 > 20){
            phrase2 = "Vous ne pouvez pas avoir cette mention";
            findViewById(R.id.textView20).setVisibility(TextView.INVISIBLE);
        }
        else{
            phrase2 = String.valueOf((216 - total) / 8);
        }
        assezBien.setText(phrase2);

        TextView bien = (TextView)findViewById(R.id.textView22);
        String phrase3;
        if((252-total)/8 > 20){
            phrase3 = "Vous ne pouvez pas avoir cette mention";
            findViewById(R.id.textView23).setVisibility(TextView.INVISIBLE);
        }
        else{
            phrase3 = String.valueOf((252 - total) / 8);
        }
        bien.setText(phrase3);

        TextView tresBien = (TextView)findViewById(R.id.textView25);
        String phrase4;
        if((288-total)/8 > 20){
            phrase4 = "Vous ne pouvez pas avoir cette mention";
            findViewById(R.id.textView26).setVisibility(TextView.INVISIBLE);
        }
        else{
            phrase4 = String.valueOf((288 - total) / 8);
        }
        tresBien.setText(phrase4);






    }
}
