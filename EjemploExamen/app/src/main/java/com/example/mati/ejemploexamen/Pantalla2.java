package com.example.mati.ejemploexamen;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pantalla2);

        final TextView texto = (TextView)findViewById(R.id.infor);
        final Button boton1 = (Button)findViewById(R.id.button);

        Bundle mibundle = getIntent().getExtras();
        Destino destino=(Destino) mibundle.getSerializable("informacion");
        texto.setText("El envio es: "+destino.getZona()+", "+destino.getContinente()+", "+destino.getPrecio()+".");
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miintent =new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miintent);

            }
        });
    }
}
