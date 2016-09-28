package com.example.mati.checkbox2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chkBoxLeer;
    CheckBox chkBoxMusica;
    CheckBox chkBoxDeporte;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUISetup();
    }
    public void initialUISetup (){
        chkBoxDeporte = (CheckBox) findViewById(R.id.chkBoxDeporte);
        chkBoxLeer = (CheckBox) findViewById(R.id.chkBoxLeer);
        chkBoxMusica = (CheckBox) findViewById(R.id.chkBoxMusica);
        txtHobby = (TextView) findViewById(R.id.txtHobby);
        chkBoxMusica.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxLeer.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxDeporte.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
    }
    public void showTextNotification(String msgToDisplay){
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            if (isChecked){
                if (buttonView==chkBoxDeporte){
                    showTextNotification("Deporte");
                }
                if (buttonView==chkBoxLeer){
                    showTextNotification("Leer");
                }
                if (buttonView==chkBoxMusica){
                    showTextNotification("Musica");
                }
            }
        }

    }
}

