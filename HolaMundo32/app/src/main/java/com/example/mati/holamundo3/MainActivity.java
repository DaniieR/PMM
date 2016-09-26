package com.example.mati.holamundo3;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;
    TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final ImageButton miBoton= (ImageButton)findViewById(R.id.miBtn);
        elSaludo= (TextView)findViewById(R.id.miLbl);
        final MediaPlayer audio = MediaPlayer.create(this,R.raw.pentakill);

        //Si regreso de otra actividad
        if (savedInstanceState!=null){
            String mensajePasado=savedInstanceState.getString("TEXTO");
            elSaludo.setText(mensajePasado);

        }
        //Borrar el texto inicial del EditText
        miTexto.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b){
                if (b)  miTexto.setText("");

            }
        });

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
                audio.start();
                //elSaludo.setText(mensajePaso);
            }

        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart Actividad1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume Actividad1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause Actividad1", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop Actividad1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart Actividad1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy Actividad1", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    public void onActivityResult(int cod_resp, int cod_result,Intent intent){
        if (cod_result== RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }



}
