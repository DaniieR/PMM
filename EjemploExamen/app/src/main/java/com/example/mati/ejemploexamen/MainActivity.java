package com.example.mati.ejemploexamen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    double precio = 0;
    public Destino[] zona = new Destino[]{
            new Destino("Zona A", "Asia y Oceania", 30),
            new Destino("Zona B", "America y Africa", 20),
            new Destino("Zona C", "Europa", 10)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miSpinner = (Spinner) findViewById(R.id.spinner);
        final TextView miTexto = (TextView) findViewById(R.id.txt1);
        final RadioGroup miRadio = (RadioGroup) findViewById(R.id.rg);
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
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
        //CALCULAR EL PESO DEL PAQUETE
        if(!miTexto.getText().toString().isEmpty()){
            if(Double.parseDouble(miTexto.getText().toString())>=6 && Double.parseDouble(miTexto.getText().toString())<=10){
                precio = precio + (Double.parseDouble(miTexto.getText().toString())*1.5);
            }
            if(Double.parseDouble(miTexto.getText().toString())>=6 && Double.parseDouble(miTexto.getText().toString())<=10){
                precio = precio + (Double.parseDouble(miTexto.getText().toString())*1.5);
            }
            if(Double.parseDouble(miTexto.getText().toString())>10){
                precio = precio + (Double.parseDouble(miTexto.getText().toString())*2);
            }
        }

    }

    public class AdaptadorDestino extends ArrayAdapter {
        Activity context;

        AdaptadorDestino(Activity context) {
            super(context, R.layout.activity_destino, zona);
            this.context = context;

        }

        public View getView(int i, View convertView, ViewGroup parent) {

            View item = convertView;
            if (item == null) {

                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.activity_destino, null);
            }
            TextView zone = (TextView) item.findViewById(R.id.zona);
            zone.setText(zona[i].getZona());

            TextView continent = (TextView) item.findViewById(R.id.continente);
            continent.setText(zona[i].getContinente());

            TextView price = (TextView) item.findViewById(R.id.precio);
            price.setText(String.valueOf(zona[i].getPrecio()));

            return item;
        }

        public View getDropDownView(final int position, View convertview, ViewGroup parent) {
            View vistadesplegada = getView(position, convertview, parent);
            return vistadesplegada;
        }
    }

    public void Calculos(View clickedButton) {
        Intent activityIntent = new Intent(this, Pantalla2.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("informacion",zona);
        activityIntent.putExtras(bundle);
        startActivity(activityIntent);

    }
}