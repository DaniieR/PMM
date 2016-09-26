package com.example.mati.CombinacionLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    protected Button boton;
    protected TextView mitexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.boton1);
        mitexto=(TextView)findViewById(R.id.texto1);

        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mitexto.setText("Has pulsado el boton");
            }
        });
    }
}
