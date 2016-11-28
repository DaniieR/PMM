package com.example.mati.examencorregidopmm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    private Coche coche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView Modelo = (TextView)findViewById(R.id.modelo);
        final TextView PrecioHora = (TextView)findViewById(R.id.ph);
        final TextView Extras = (TextView)findViewById(R.id.extras);
        final TextView Seguro = (TextView)findViewById(R.id.seguro);
        final TextView tiempo = (TextView)findViewById(R.id.tiempo);
        final TextView costefinal = (TextView)findViewById(R.id.costefinal);
        final ImageView imagen = (ImageView)findViewById(R.id.imagen);
        final Button boton1 = (Button)findViewById(R.id.button);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        coche=(Coche) intent.getSerializableExtra("informacion");
        String modelo=coche.getModelo();
        if (modelo.compareTo("Megane")==0)
            modelo = "Megane Seat";
        if (modelo.compareTo("X-11")==0)
            modelo = "X-11 Ferrari";
        if (modelo.compareTo("Leon")==0)
            modelo = "Leon Seat";
        if (modelo.compareTo("Fiesta")==0)
            modelo = "Fiesta Ford";
        Modelo.setText("Modelo: "+modelo);
        imagen.setImageResource(coche.getImagen());
        PrecioHora.setText("El precio por hora es: "+String.valueOf(coche.getPrecio())+"€");
        Extras.setText("Extras: "+String.valueOf(bundle.getDouble("extras"))+"€");
        tiempo.setText("Tiempo: "+String.valueOf(bundle.getDouble("tiempo")));
        Seguro.setText("Seguro: "+bundle.getString("seguro"));
        costefinal.setText("Coste Total: "+String.valueOf(bundle.getDouble("precio"))+"€");
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miintent =new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miintent);

            }
        });
    }
}
