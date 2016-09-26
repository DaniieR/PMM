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
        Intent miIntent = new Intent(MainActivity.this, EjercicioLayout.class);
        Bundle miBundle = new Bundle();
        startActivity(miIntent);
    }
}
