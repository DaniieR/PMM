package com.example.daniel.proyecto2evaluacion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText usuario = (EditText)findViewById(R.id.usuario);
        final EditText contraseña = (EditText)findViewById(R.id.contraseña1);
        final EditText confirmacion = (EditText)findViewById(R.id.contraseña2);

        Button BotonAceptar = (Button)findViewById(R.id.botonConfirmar);

        //Abrimos la base de datos en modo escritura
        BDUsuarios BDU = new BDUsuarios(this, "BDUsuarios", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        final SQLiteDatabase bd = BDU.getWritableDatabase();

        BotonAceptar.setOnClickListener(new View.OnClickListener() {
            String mensaje1 = "LAS CONTRASEÑAS NO COINCIDEN, PORFAVOR VUELVE A INTRODUCIRLAS";
            String mensaje = "REGISTRO COMPLETO";
            @Override
            public void onClick(View v) {
                if (contraseña.getText().toString().equals(confirmacion.getText().toString())){
                    ContentValues newValues = new ContentValues();
                    newValues.put("usuario",usuario.getText().toString());
                    newValues.put("contraseña",contraseña.getText().toString());
                    bd.insert("Usuarios",null,newValues);
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),mensaje1,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}