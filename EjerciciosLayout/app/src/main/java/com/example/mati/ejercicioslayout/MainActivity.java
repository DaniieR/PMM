package com.example.mati.ejercicioslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void EjercicioLayout (View clicado){
        Intent miIntent = new Intent(MainActivity.this, Ejerciciolayout.class);
        Bundle miBundle = new Bundle();
        startActivity(miIntent);
    }
    public void EjercicioTable (View clicado){
        Intent miIntent = new Intent(MainActivity.this, EjercicioTable.class);
        Bundle miBundle = new Bundle();
        startActivity(miIntent);
    }
    public void EjercicioRelative (View clicado){
        Intent miIntent = new Intent(MainActivity.this, EjercicioRelative.class);
        Bundle miBundle = new Bundle();
        startActivity(miIntent);
    }
}
