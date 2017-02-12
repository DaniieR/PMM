package com.example.daniel.proyecto2evaluacion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pedido extends AppCompatActivity {
    Spinner miSpinner;
    Button miButton,mostrarHistorial;
    RadioGroup miRadio;
    RadioButton radiobutton1,radiobutton2;
    CheckBox azul, rojo;
    String seleccionado, usuario;
    boolean pagoAzul, pagoRojo;
    private Skin[]skins;
    Bundle bundle;
    Intent intent;
    public ArrayList<Skin> aspectos= new ArrayList<Skin>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        BDUsuarios cliBDh = new BDUsuarios(this, "BDUsuarios", null,1);
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();
        //Creamos los datos por defecto la primera vez que creamos la BD
        //cliBDh.crearProductosInicio();


        //DESCOMENTAR LA PRIMERA VEZ QUE SE INICIA LA APLICACION PARA QUE SE MUESTREN DATOS EN EL SPINNER
        /*bd.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES ('LeBlanc', 'Hija De Los Cuervos', '10.00')");
        bd.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES ('LeBlanc', 'Bosque Ancestral', '8.00')");
        bd.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES ('Ahri', 'Arcade', '12.00')");
        bd.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES ('Ahri', 'Raposa Ignea', '7.00')");
        bd.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES ('Lux', 'Elementalista', '20.00')");
        bd.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES ('Lux', 'Guardiana De Las Estrellas', '8.00')");*/

        //LLENAMOS EL SPINNER
        String[] campos = new String[]{"nombre","skin","precio"};
        Cursor c = bd.query("Skins",campos,null,null,null,null,null);
        skins=new Skin[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()){
            do {
                String nombre = c.getString(0);
                String skin = c.getString(1);
                Double precio = c.getDouble(2);

                skins[i]=new Skin(nombre,skin,precio);

                i++;
            }while (c.moveToNext());
        }

        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this);
        miSpinner = (Spinner) findViewById(R.id.spinner);
        miSpinner.setAdapter(adaptadorSpinner);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Personaje: "+ skins[position].getPersonaje()+", Aspecto: "+skins[position].getAspecto()+", precio: "+skins[position].getPrecio();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bd.close();

        //COGEMOS LOS DATOS
        miButton = (Button)findViewById(R.id.botonComprar);
        mostrarHistorial = (Button)findViewById(R.id.historial);
        miRadio = (RadioGroup)findViewById(R.id.rg);
        radiobutton1 = (RadioButton)findViewById(R.id.radiobutton1);
        radiobutton2 = (RadioButton)findViewById(R.id.radiobutton2);
        azul = (CheckBox)findViewById(R.id.azul);
        rojo = (CheckBox)findViewById(R.id.rojo);
        pagoAzul =false;
        pagoRojo =false;
        seleccionado="";
        usuario = getIntent().getStringExtra("usuario");

        mostrarHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                usuario = getIntent().getStringExtra("usuario");
                bundle.putSerializable("usuario",usuario);
                intent = new Intent(Pedido.this,Historial.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        miButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //PASAR DATOS DEL SPINNER
                bundle = new Bundle();
                Skin datos = new Skin(skins[miSpinner.getSelectedItemPosition()].getPersonaje(),
                        skins[miSpinner.getSelectedItemPosition()].getAspecto(),
                        skins[miSpinner.getSelectedItemPosition()].getPrecio());

                bundle.putSerializable("producto",datos);


                //COMPROBAMOS LA FORMA DE PAGO
                if (miRadio.getCheckedRadioButtonId()==R.id.radiobutton1){
                    bundle.putString("RadioGroup",radiobutton1.getText().toString());
                    seleccionado="con tarjeta de credito";
                    bundle.putString("pago",seleccionado);
                }else{
                    bundle.putString("RadioGroup",radiobutton2.getText().toString());
                    seleccionado="con transferencia";
                    bundle.putString("pago",seleccionado);
                }

                //COMPROBAMOS LOS CHROMAS QUE QUIERE
                if (azul.isChecked()){
                    pagoAzul =true;
                }
                bundle.putBoolean("pagoAzul", pagoAzul);
                bundle.putString("azul", azul.getText().toString());

                if (rojo.isChecked()){
                    pagoRojo =true;
                }
                bundle.putBoolean("pagoRojo", pagoRojo);
                bundle.putString("rojo", rojo.getText().toString());

                mostrarInformacion();

                bundle.putSerializable("usuario",usuario);
                intent = new Intent(Pedido.this,Factura.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    //INFORMACION DEL PEDIDO
    public void mostrarInformacion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pedido")
                .setMessage("El pedido es el siguiente:\n"+skins[miSpinner.getSelectedItemPosition()].getPersonaje()+" con la skin: "+skins[miSpinner.getSelectedItemPosition()].getAspecto()+" y lo quiere "+seleccionado)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    //INICIO Menu Acerca De
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logueado:
                UsuarioActual();
                return true;
            case R.id.Internet:
                intent = new Intent(Pedido.this,Internet.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void UsuarioActual(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("LOGUEADO COMO:")
                .setMessage("HOLA: "+usuario)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
    //FIN de Menu

    //INICIO DE ADAPTADOR SPINNER
    public class AdaptadorSpinner extends ArrayAdapter{
        Activity context;
        AdaptadorSpinner(Activity context){
            super(context,R.layout.activity_skin,skins);
            this.context=context;
        }
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }
        public View getView(int i, View convertView,ViewGroup parent){

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_skin,null);

            TextView personaje = (TextView)item.findViewById(R.id.personaje_skin);
            personaje.setText(skins[i].getPersonaje());

            TextView aspecto = (TextView)item.findViewById(R.id.aspecto_skin);
            aspecto.setText(skins[i].getAspecto());

            TextView precio = (TextView)item.findViewById(R.id.precio_skin);
            precio.setText(String.valueOf(skins[i].getPrecio()));

            return item;
        }
    }
    //FIN ADAPTADOR SPINNER
}


