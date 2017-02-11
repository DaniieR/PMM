package com.example.daniel.proyecto2evaluacion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    private Skin skinM;
    private Intent intent;
    private String extra;
    private Double precioFinal;
    private Boolean credito,transferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        BDUsuarios cliBDh = new BDUsuarios(this, "BDUsuarios", null,1);
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();

        final TextView Personaje = (TextView)findViewById(R.id.personaje_factura);
        final TextView Skin = (TextView)findViewById(R.id.skin_factura);
        final TextView Extra = (TextView)findViewById(R.id.extra_factura);
        final TextView Pago = (TextView)findViewById(R.id.pago_factura);
        final TextView Total = (TextView)findViewById(R.id.total_factura);
        final Button aceptar = (Button)findViewById(R.id.botonSI);
        final Button rechazar = (Button)findViewById(R.id.botonNO);

        intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        skinM = (Skin)intent.getSerializableExtra("producto");
        credito = intent.getBooleanExtra("pagoCredito",false);
        transferencia = intent.getBooleanExtra("pagoTransferencia",false);

        //RELLENAMOS LOS TEXTVIEW
        String personaje = skinM.getPersonaje();
        Personaje.setText("PERSONAJE: "+personaje);

        String skin = skinM.getAspecto();
        Skin.setText("SKIN: "+skin);

        if (credito.booleanValue()==true){
            Pago.setText("LA FORMA DE PAGO ES : POR TARJETA DE CREDITO");
        }
        if (transferencia.booleanValue()==true){
            Pago.setText("LA FORMA DE PAGO ES : POR TRANSFERENCIA");
        }

        extra = intent.getStringExtra("chromas");
        Extra.setText("CHROMAS: "+extra);

        //CALCULAR EL PRECIO FINAL
        Double precio = skinM.getPrecio();
        if (extra.equals("con chromas")){
            precioFinal = precio + 5.00;
        }
        if (transferencia.booleanValue()==true) {
            precioFinal = precioFinal + 1.50;
        }
        Total.setText("EL PRECIO TOTAL ES: "+String.valueOf(precioFinal)+"€");

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.execSQL("");
            }
        });
    }
}
