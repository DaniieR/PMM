package com.example.mati.examencorregidopmm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    Button miBotton;
    TextView total;
    RadioGroup miRadio;
    EditText miTexto;
    RadioButton radioButton1,radioButton2;
    CheckBox Aire,Gps,RadioDVD;
    public Double precio = 0.0, Extras= 0.0, Tiempo=0.0;
    public String Decoracion="", Seguro="";
    public Coche[] coches = new Coche[]{
            new Coche("Megane", "Seat", 20,R.drawable.img1),
            new Coche("X-11", "Ferrari", 100,R.drawable.img2),
            new Coche("Leon", "Seat", 30,R.drawable.img3),
            new Coche("Fiesta", "Ford", 40,R.drawable.img4),
    };
    Coche coche;

    private static final int REQUEST_PANTALLA2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIAMOS ELEMENTOS

        miSpinner = (Spinner) findViewById(R.id.spinner);
        miBotton = (Button)findViewById(R.id.Calculos);
        miTexto = (EditText) findViewById(R.id.txt1);
        miRadio = (RadioGroup) findViewById(R.id.rg);
        radioButton1 = (RadioButton) findViewById(R.id.radiobutton1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobutton2);
        Aire = (CheckBox)findViewById(R.id.AireAcondicionado);
        Gps = (CheckBox)findViewById(R.id.gps);
        RadioDVD = (CheckBox)findViewById(R.id.RadioDVD);
        total = (TextView)findViewById(R.id.preciofinal);

        //SPINNER

        AdaptadorDestino adaptador = new AdaptadorDestino(this);
        miSpinner.setAdapter(adaptador);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precio = coches[position].getPrecio();
                coche = coches[position];
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
        Aire.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    precio = precio + 50;
                    Extras = Extras + 50;
                    if (Decoracion.isEmpty()){
                        Decoracion = "Aire Acondicionado";

                    }
                    else {
                        Decoracion = Decoracion +" y Aire Acondicionado";
                    }
                }
                else {
                    precio = precio - 50;
                    Extras = Extras - 50;
                }
            }
        });
        Gps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    precio = precio + 50;
                    Extras = Extras + 50;
                    if (Decoracion.isEmpty()){
                        Decoracion = "GPS";
                    }
                    else {
                        Decoracion = Decoracion +" y GPS";

                    }
                }
                else {
                    precio = precio - 50;
                    Extras = Extras - 50;
                }
            }
        });
        RadioDVD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    precio = precio + 50;
                    Extras = Extras + 50;
                    if (Decoracion.isEmpty()){
                        Decoracion = "Radio/DVD";
                    }
                    else {
                        Decoracion = Decoracion +" y Radio/DVD";

                    }
                }
                else {
                    precio = precio - 50;
                    Extras = Extras - 50;
                }
            }
        });
        //RADIOGROUPS
        miRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.radiobutton1:
                        Seguro = "Seguro Normal";
                        break;
                    case R.id.radiobutton2:
                        Seguro = "Seguro a todo riesgo";
                        precio = precio + (precio*0.2);
                        break;
                }
            }
        });

        miBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!miTexto.getText().toString().isEmpty()){
                    precio = precio * Double.parseDouble(miTexto.getText().toString());
                }
                total.setText("Precio: "+precio);
                Intent activityIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("informacion", coche);
                bundle.putDouble("extras",Extras);
                bundle.putDouble("tiempo",Double.parseDouble(miTexto.getText().toString()));
                bundle.putString("seguro",Seguro);
                bundle.putDouble("precio",precio);
                activityIntent.putExtras(bundle);
                startActivityForResult(activityIntent,REQUEST_PANTALLA2);
            }
        });
    }
    //ADAPTADOR SPINNER

    public class AdaptadorDestino extends ArrayAdapter {
        Activity context;

        AdaptadorDestino(Activity context) {
            super(context, R.layout.activity_coche, coches);
            this.context = context;

        }

        public View getView(int i, View convertView, ViewGroup parent) {

            View item = convertView;
            if (item == null) {

                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.activity_coche, null);
            }
            TextView Marca = (TextView) item.findViewById(R.id.marca);
            Marca.setText(coches[i].getMarca());

            TextView Modelo = (TextView) item.findViewById(R.id.modelo);
            Modelo.setText(coches[i].getModelo());

            TextView Precio = (TextView) item.findViewById(R.id.precio);
            Precio.setText(String.valueOf(coches[i].getPrecio()));

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setBackground(getDrawable(coches[i].getImagen()));

            return item;
        }
        public View getDropDownView(final int position, View convertview, ViewGroup parent) {
            View vistadesplegada = getView(position, convertview, parent);
            return vistadesplegada;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode==REQUEST_PANTALLA2){
                Bundle bundle1 = data.getExtras();
                String resultado = bundle1.getString("Reloj");
                Toast.makeText(this,resultado,Toast.LENGTH_SHORT).show();
            }
        }

    }
}
