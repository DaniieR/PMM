package com.example.mati.primerosdibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }
    class MiDibujo extends View{
        public MiDibujo(Context c){
            super(c);
        }
        protected void onDraw(Canvas lienzo){
            Paint miPincel = new Paint();
            miPincel.setColor(Color.BLUE);
            miPincel.setStrokeWidth(5);
            miPincel.setStyle(Paint.Style.STROKE);
            for (int i=0;i<500;i+=10)
            lienzo.drawCircle(600,600,100+i,miPincel);
            miPincel.setTextSize(60);
            lienzo.drawText("Mi Circulo",500,1300,miPincel);
        }
    }
}
