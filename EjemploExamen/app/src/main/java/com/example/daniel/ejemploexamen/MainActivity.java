package com.example.daniel.ejemploexamen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String Decoracion= "";
    Spinner miSpinner;
    private String Urgente,Zona,Continente;
    double precio = 0;
    double peso;
    TextView miTexto;
    RadioGroup miRadio;
    RadioButton radioButton1, radioButton2;
    CheckBox cajaregalo,tarjetadedicada;
    private Destino destino = new Destino(Zona,Continente,precio);
    public Destino[] zona = new Destino[]{
            new Destino("Zona A", "Asia y Oceania", 30),
            new Destino("Zona B", "America y Africa", 20),
            new Destino("Zona C", "Europa", 10)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIAMOS ELEMENTOS
        miSpinner = (Spinner) findViewById(R.id.spinner);
        miTexto = (TextView) findViewById(R.id.txt1);
        miRadio = (RadioGroup) findViewById(R.id.rg);
        radioButton1 = (RadioButton) findViewById(R.id.radiobutton1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobutton2);
        cajaregalo = (CheckBox)findViewById(R.id.cajaregalo);
        tarjetadedicada = (CheckBox)findViewById(R.id.tarjetadedicada);



        //SPINNER
        AdaptadorDestino adaptador = new AdaptadorDestino(this);
        miSpinner.setAdapter(adaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precio = zona[position].getPrecio();
                Zona = zona[position].getZona();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //TEXTVIEW
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

        //DATOS CHECKBOXS
        cajaregalo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (Decoracion.isEmpty()){
                        Decoracion = "Caja Regalo";
                    }
                    else {
                        Decoracion = Decoracion +" y Caja Regalo";
                    }
                }
            }
        });
        tarjetadedicada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (Decoracion.isEmpty()){
                        Decoracion = "Tarjeta Dedicada";
                    }
                    else {
                        Decoracion = Decoracion +" y Tarjeta Dedicada";
                    }
                }
            }
        });

        //CALCULAR EL PESO DEL PAQUETE
        if(!miTexto.getText().toString().isEmpty()){
            if(Double.parseDouble(miTexto.getText().toString())>=6 && Double.parseDouble(miTexto.getText().toString())<=10){
                precio = precio + (peso*1);
            }
            if(Double.parseDouble(miTexto.getText().toString())>=6 && Double.parseDouble(miTexto.getText().toString())<=10){
                precio = precio + (Double.parseDouble(miTexto.getText().toString())*1.5);
            }
            if(Double.parseDouble(miTexto.getText().toString())>10){
                precio = precio + (Double.parseDouble(miTexto.getText().toString())*2);
            }
        }

        //RADIOGROUPS
        miRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.radiobutton1:
                        Urgente = "Normal";
                        break;
                    case R.id.radiobutton2:
                        Urgente = "Urgente";
                }
            }
        });
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
            TextView Zona = (TextView) item.findViewById(R.id.zona);
            Zona.setText(zona[i].getZona());

            TextView Continente = (TextView) item.findViewById(R.id.continente);
            Continente.setText(zona[i].getContinente());

            TextView precio = (TextView) item.findViewById(R.id.precio);
            precio.setText(String.valueOf(zona[i].getPrecio()));

            return item;
        }

        public View getDropDownView(final int position, View convertview, ViewGroup parent) {
            View vistadesplegada = getView(position, convertview, parent);
            return vistadesplegada;
        }
    }

    public void Calculos(View clickedButton) {
        Intent activityIntent = new Intent(MainActivity.this, Pantalla2.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("informacion",destino);
        bundle.putString("zona",Zona);
        bundle.putString("tarifa",Urgente);
        bundle.putDouble("peso",Double.parseDouble(miTexto.getText().toString()));
        activityIntent.putExtras(bundle);
        startActivity(activityIntent);

    }
}