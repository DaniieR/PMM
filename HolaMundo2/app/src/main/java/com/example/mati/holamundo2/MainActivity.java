package com.example.mati.holamundo2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        protected EditText miTexto;
        protected Button miBoton;
        protected TextView elSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto= (EditText)findViewById(R.id.miTxt);
        miBoton= (Button)findViewById(R.id.miBtn);
        elSaludo= (TextView)findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mejor = miTexto.getText() + " BIENVENIDO A VALENCIA";
                elSaludo.setText(mejor);

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(miIntent);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

        //Toast.makeText(this, "Pulsado BOTON", Toast.LENGTH_SHORT).show();
        showToast("HOLA");
    }
    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
