package com.example.mati.holamundo3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final Button volverBtn= (Button)findViewById(R.id.miVolver);
        final MediaPlayer audio2 = MediaPlayer.create(this,R.raw.shutdown);
        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo=miBundleRecoger.getString("TEXTO");
        volverBtn.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                Bundle vueltaBundle=new Bundle();
                String mensajeDevuelto= "Devuelvo a Principal " + completarSaludo;
                vueltaBundle.putString("DEVUELTO", mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK, vueltaIntent);
                audio2.start();
                finish();

            }

        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart Actividad2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume Actividad2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause Actividad2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop Actividad2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart Actividad2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy Actividad2", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
