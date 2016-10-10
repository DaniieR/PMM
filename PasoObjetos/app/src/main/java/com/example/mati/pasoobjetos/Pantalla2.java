package com.example.mati.pasoobjetos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView Mensaje = (TextView) findViewById(R.id.Mensaje);
        final ImageView imagen = (ImageView)findViewById(R.id.imagen);
        Bundle miBundle = getIntent().getExtras();
        Persona persona = (Persona) miBundle.getSerializable("infoPersona");
        Mensaje.setText("Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido() + ", Edad: " + persona.getEdad());
        imagen.setImageResource(persona.getImagen());
    }

}
