package com.example.mati.recopilatoriobotton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected Button boton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button) findViewById(R.id.boton1);

        boton1.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                startActivity(miIntent);
            }
        });
        /*boton2.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla3.class);
                Bundle miBundle = new Bundle();
                startActivity(miIntent);
            }
        });
        boton3.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla4.class);
                Bundle miBundle = new Bundle();
                startActivity(miIntent);
            }
        });*/
    }
    public void onClickBoton2(View clickedButton) {
        Intent miIntent = new Intent(MainActivity.this, Pantalla3.class);
        Bundle miBundle = new Bundle();
        startActivity(miIntent);
    }
    public void onClickBoton3(View clickedButton) {
        Intent miIntent = new Intent(MainActivity.this, Pantalla4.class);
        Bundle miBundle = new Bundle();
        startActivity(miIntent);
    }
    public void onClickBoton4(View clickedButton) {

    }
}
