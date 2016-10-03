package com.example.mati.ejercicioslayout;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

public class EjercicioTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_table);
        final Button Rojo = (Button) findViewById(R.id.Boton1);
        final Button Amarillo = (Button) findViewById(R.id.Boton2);
        final Button Azul = (Button) findViewById(R.id.Boton3);
        final Button Limpiar = (Button) findViewById(R.id.BotonLimpiar);
        final Context context = this;
        final TableRow Fondo = (TableRow) findViewById(R.id.fondo);
    Rojo.setOnClickListener(new Button.OnClickListener(){
        public void onClick (View v){
            Fondo.setBackgroundColor(Color.RED);
        }
        });
        Amarillo.setOnClickListener(new Button.OnClickListener(){
            public void onClick (View v){
                Fondo.setBackgroundColor(Color.YELLOW);
            }
        });
        Azul.setOnClickListener(new Button.OnClickListener(){
            public void onClick (View v){
                Fondo.setBackgroundColor(Color.BLUE);
            }
        });
        Limpiar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //Fondo.setBackgroundColor(Color.WHITE);
                Fondo.setBackgroundColor(ContextCompat.getColor(context, R.color.background));
            }
        });
    }
}
