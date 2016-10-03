package com.example.mati.ejercicioslayout;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Ejerciciolayout extends AppCompatActivity {

    RadioGroup RadioGroup;
    TextView Fondo;
    RadioButton RadioButtonRed, RadioButtonWhite, RadioButtonBlue;
    Button BotonAplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejerciciolayout);
        final TextView Fondo = (TextView) findViewById(R.id.fondo);
        final RadioGroup RadioGroup = (RadioGroup) findViewById(R.id.radios);
        final RadioButton RadioButtonRed = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton RadioButtonWhite = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton RadioButtonBlue = (RadioButton) findViewById(R.id.radioButton3);
        final Button BotonAplicar = (Button) findViewById(R.id.BottonAplicar);
        final Button BotonBorrar = (Button) findViewById(R.id.BottonBorrar);
        final Context context = this;
        RadioGroup.clearCheck();
        BotonAplicar.setOnClickListener(new Button.OnClickListener(){
          public void onClick(View v){
              if (RadioGroup.getCheckedRadioButtonId()==R.id.radioButton)
                  Fondo.setBackgroundColor(Color.RED);
              if (RadioGroup.getCheckedRadioButtonId()==R.id.radioButton2)
                  Fondo.setBackgroundColor(Color.WHITE);
              if (RadioGroup.getCheckedRadioButtonId()==R.id.radioButton3)
                  Fondo.setBackgroundColor(Color.BLUE);
          }
        });
        BotonBorrar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                RadioGroup.clearCheck();
                //Fondo.setBackgroundColor(Color.WHITE);
                Fondo.setBackgroundColor(ContextCompat.getColor(context, R.color.background));
            }
        });


    }
}
