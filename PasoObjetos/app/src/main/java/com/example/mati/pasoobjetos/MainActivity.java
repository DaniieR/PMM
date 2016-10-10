package com.example.mati.pasoobjetos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Nombre=(EditText)findViewById(R.id.nombre);
        final EditText Apellido=(EditText)findViewById(R.id.apellido);
        final EditText Edad=(EditText)findViewById(R.id.edad);
        final Button Aceptar=(Button)findViewById(R.id.Boton);

        Aceptar.setOnClickListener( new View.OnClickListener() {
            public void onClick (View v){
                String miNombre = Nombre.getText().toString();
                String miApellido = Apellido.getText().toString();
                int miEdad = Integer.parseInt(Edad.getText().toString());
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                Persona persona = new Persona(miNombre,miApellido,miEdad,R.drawable.imagen);
                miBundle.putSerializable("infoPersona",persona);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
        }
    }

