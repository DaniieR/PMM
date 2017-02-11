package com.example.daniel.proyecto2evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        final TextView Personaje = (TextView)findViewById(R.id.personaje_factura);
        final TextView Skin = (TextView)findViewById(R.id.skin_factura);
        final TextView Extra = (TextView)findViewById(R.id.extra_factura);
        final TextView Pago = (TextView)findViewById(R.id.pago_factura);
        final TextView Total = (TextView)findViewById(R.id.total_factura);
        final Button aceptar = (Button)findViewById(R.id.botonSI);
        final Button rechazar = (Button)findViewById(R.id.botonNO);

        intent = getIntent();

        skinM = (Skin)intent.getSerializableExtra("producto");
        credito = intent.getBooleanExtra("pagoCredito",false);
        transferencia = intent.getBooleanExtra("pagoTransferencia",false);

        //RELLENAMOS LOS TEXTVIEW
        String personaje = skinM.getPersonaje();
        Personaje.setText("PERSONAJE: "+personaje);

        String skin = skinM.getAspecto();
        Skin.setText("SKIN: "+skin);

        if (credito.booleanValue()==true){
            Pago.setText("LA FORMA DE PAGO ES :");
        }
        if (transferencia.booleanValue()==true){
            Pago.setText("LA FORMA DE PAGO ES :");
        }

        extra = intent.getStringExtra("chromas");
        Extra.setText("CHROMAS: "+extra);

        Total.setText(precioFinal.toString());


    }
    public void total(){
        Double precio = skinM.getPrecio();

        //CALCULAMOS EL PRECIO SI ELIGE LA OPCION DE CON CHROMAS
        if (extra.equals("con chormas")){
            precioFinal = precio + 5.00;
        }

        //CALCULAMOS LAS TASAS POR PAGAR CON TRANSFERENCIA
        if (transferencia.booleanValue()==true){
            precioFinal = precioFinal + 1.50;
        }
    }
}
