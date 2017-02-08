package com.example.daniel.proyecto2evaluacion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Pedido extends AppCompatActivity {
    Spinner miSpinner;
    Button miButton;
    RadioGroup miRadio;
    RadioButton radiobutton1,radiobutton2;
    CheckBox credito,transferencia;
    private Skin[]skins;
    public ArrayList<Skin> aspectos= new ArrayList<Skin>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        BDUsuarios cliBDh = new BDUsuarios(this, "BDUsuarios", null,1);
        SQLiteDatabase bd = cliBDh.getWritableDatabase();
        //Creamos los datos por defecto la primera vez que creamos la BD
        cliBDh.crearProductosInicio();



       /* bd.execSQL("INSERT INTO Skin (personaje, aspecto, precio) VALUES ('LeBlanc', 'Hija De Los Cuervos', '10.00')");
        bd.execSQL("INSERT INTO Skin (personaje, aspecto, precio) VALUES ('LeBlanc', 'Bosque Ancestral', '8.00')");
        bd.execSQL("INSERT INTO Skin (personaje, aspecto, precio) VALUES ('Ahri', 'Arcade', '12.00')");
        bd.execSQL("INSERT INTO Skin (personaje, aspecto, precio) VALUES ('Ahri', 'Raposa Ignea', '7.00')");
        bd.execSQL("INSERT INTO Skin (personaje, aspecto, precio) VALUES ('Lux', 'Elementalista', '20.00')");
        bd.execSQL("INSERT INTO Skin (personaje, aspecto, precio) VALUES ('Lux', 'Guardiana De Las Estrellas', '8.00')");*/

        //LLENAMOS EL SPINNER
        String[] campos = new String[]{"personaje","aspecto","precio"};
        Cursor c = bd.query("Skin",campos,null,null,null,null,null);
        skins=new Skin[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()){
            do {
                String personaje = c.getString(0);
                String aspecto = c.getString(1);
                Double precio = c.getDouble(2);

                skins[i]=new Skin(personaje,aspecto,precio);

                i++;
            }while (c.moveToFirst());
        }
    }
}
