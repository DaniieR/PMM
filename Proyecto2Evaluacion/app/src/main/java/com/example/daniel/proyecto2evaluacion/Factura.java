package com.example.daniel.proyecto2evaluacion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Factura extends AppCompatActivity {

    private Skin skinM;
    private Intent intent;
    private String extra,usuario, pedido;
    private Double precioFinal;
    private Boolean azul, rojo;

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
        usuario = getIntent().getStringExtra("usuario");
        skinM = (Skin)intent.getSerializableExtra("producto");
        azul = intent.getBooleanExtra("pagoAzul",false);
        rojo = intent.getBooleanExtra("pagoRojo",false);

        //RELLENAMOS LOS TEXTVIEW
        String personaje = skinM.getPersonaje();
        Personaje.setText("PERSONAJE: "+personaje);

        String skin = skinM.getAspecto();
        Skin.setText("SKIN: "+skin);

        if (azul.booleanValue()==true){
            Pago.setText("AZUL");
        }
        if (rojo.booleanValue()==true){
            Pago.setText("ROJO");
        }

        extra = intent.getStringExtra("pago");
        Extra.setText("FORMA DE PAGO: "+extra);

        //CALCULAR EL PRECIO FINAL
        final Double precio = skinM.getPrecio();
        if (extra.equals("con transferencia")){
            precioFinal = precio + 5.00;
        } else{
            precioFinal = precio;
        }
        if (rojo.booleanValue()==true) {
            precioFinal = precioFinal + 1.50;
        }
        if (azul.booleanValue()==true) {
            precioFinal = precioFinal + 1.50;
        }
        Total.setText("EL PRECIO TOTAL ES: "+String.valueOf(precioFinal)+"€");

        //PONEMOS EL PEDIDO EN UN STRING PARA INSERTARLO EN LA TABLA
        pedido = personaje+" "+skin+" ,"+precioFinal+"€";

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.execSQL("INSERT INTO Pedidos (usuario, pedido) VALUES ('"+usuario+"', '"+pedido+"')");
                Toast.makeText(getApplicationContext(),"COMPRA REALIZADA",Toast.LENGTH_SHORT).show();
                intent = new Intent(Factura.this,Pedido.class);
                startActivity(intent);
            }
        });

        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Factura.this,Pedido.class);
                startActivity(intent);
            }
        });
    }
}
