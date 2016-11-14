package com.example.mati.ejemploexamen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    int precio = 0;
    private Destino[] zona = new Destino[]{
            new Destino("Zona A","Asia y Oceania",30),
            new Destino("Zona B","America y Africa",20),
            new Destino("Zona C","Europa",10)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miSpinner = (Spinner)findViewById(R.id.spinner);
        final TextView miTexto = (TextView)findViewById(R.id.txt1);
        final RadioGroup miRadio = (RadioGroup)findViewById(R.id.rg);
        AdaptadorDestino adaptador = new AdaptadorDestino(this);
        miSpinner.setAdapter(adaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precio = zona[position].getPrecio();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        miTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTexto.setText("");
            }
        });
        miRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group,int checkedId){

            }
        });
    }
    public class AdaptadorDestino extends ArrayAdapter {
        Activity context;
        AdaptadorDestino(Activity context){
            super(context);
        }
    }

    public void Calculos (View clickedButton){
        Intent activityIntent = new Intent(this,Pantalla2.class);
        startActivity(activityIntent);
    }
    public void showToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
