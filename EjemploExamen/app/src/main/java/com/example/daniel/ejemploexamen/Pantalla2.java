package com.example.daniel.ejemploexamen;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Pantalla2 extends Activity {
    private Destino destino;
    private String Zona,Tarifa;
    private Double Peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla2);

        final TextView zona = (TextView)findViewById(R.id.zona);
        final TextView tarifa = (TextView)findViewById(R.id.tarifa);
        final TextView peso = (TextView)findViewById(R.id.peso);
        final TextView decoracion = (TextView)findViewById(R.id.decoracion);
        final TextView costefinal = (TextView)findViewById(R.id.costefinal);
        final Button boton1 = (Button)findViewById(R.id.button);
        Intent intent = getIntent();

        destino=(Destino) intent.getSerializableExtra("informacion");

        Zona = intent.getStringExtra("zona");
        if (Zona.compareTo("Zona A")==0)
            Zona = "A (Asia/Oceania)";
        if (Zona.compareTo("Zona B")==0)
            Zona = "B (América/Africa)";
        if (Zona.compareTo("Zona C")==0)
            Zona = "C (Europa)";
        zona.setText("Zona: "+Zona);

        Tarifa = intent.getStringExtra("tarifa");
        if (Tarifa.compareTo("Normal")==0)
            Tarifa="Normal";
        if (Tarifa.compareTo("Urgente")==0)
            Tarifa="Urgente";
        tarifa.setText("La tarifa es: "+Tarifa);

        Peso = intent.getDoubleExtra("peso",0);
        peso.setText("El peso es: "+Peso);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miintent =new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miintent);

            }
        });
    }
}