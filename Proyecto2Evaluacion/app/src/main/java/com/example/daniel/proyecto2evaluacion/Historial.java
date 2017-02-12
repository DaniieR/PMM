package com.example.daniel.proyecto2evaluacion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    ListView listView;
    ArrayList<String> entradas = new ArrayList<String>();
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial2);

        listView = (ListView)findViewById(R.id.list);
        usuario = getIntent().getStringExtra("usuario");

        //Abrimos la base de datos en modo escritura
        BDUsuarios BDU = new BDUsuarios(this, "BDUsuarios", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        final SQLiteDatabase bd = BDU.getWritableDatabase();
        Bundle bundle = new Bundle();

        Cursor cursor = bd.rawQuery("SELECT usuario,pedido FROM Pedidos WHERE usuario='"+usuario+"'",null);
        if (cursor.moveToFirst()){
            do {
                String usu = cursor.getString(0);
                String pedido = cursor.getString(1);
                String usuped = "USUARIO: "+usu+", REALIZO EL PEDIDO: "+pedido;
                entradas.add(usuped);
            }
            while (cursor.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entradas);
        listView.setAdapter(adaptador);
    }
}
