package com.example.mati.shapedrawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mati on 7/11/16.
 */
public class VistaAMedida extends View {
    private ShapeDrawable miDrawable;
    public VistaAMedida(Context contexto){
        super(contexto);
    }
    public VistaAMedida(Context contexto, AttributeSet attrs) {
        super(contexto, attrs);
    }
    protected void onDraw (Canvas lienzo){
        int x=10,y=10;
        int ancho=300, alto=500;
        miDrawable = new ShapeDrawable(new OvalShape());
        miDrawable.getPaint().setColor(Color.BLUE);
        miDrawable.setBounds(x,y,x+ancho,y+alto);
        miDrawable.draw(lienzo);
        setBackgroundColor(Color.BLACK);
        Paint miPincel = new Paint();
        Paint punto = new Paint();
        Paint punto2 = new Paint();
        Paint punto3 = new Paint();
        Paint punto4 = new Paint();
        Paint puntoCentral = new Paint();
        Paint Linea = new Paint();
        Paint Ovalo = new Paint();
        Paint Arco = new Paint();

        miPincel.setColor(Color.MAGENTA);
        miPincel.setStrokeWidth(30);
        miPincel.setStyle(Paint.Style.STROKE);

        punto.setColor(Color.RED);
        punto.setStrokeWidth(100);
        punto.setStyle(Paint.Style.STROKE);

        punto2.setColor(Color.BLUE);
        punto2.setStrokeWidth(100);
        punto2.setStyle(Paint.Style.STROKE);

        punto3.setColor(Color.GREEN);
        punto3.setStrokeWidth(100);
        punto3.setStyle(Paint.Style.STROKE);

        punto4.setColor(Color.YELLOW);
        punto4.setStrokeWidth(100);
        punto4.setStyle(Paint.Style.STROKE);

        puntoCentral.setColor(Color.CYAN);
        puntoCentral.setStrokeWidth(30);
        puntoCentral.setStyle(Paint.Style.STROKE);

        Linea.setColor(Color.WHITE);
        Linea.setStrokeWidth(30);
        Linea.setStyle(Paint.Style.STROKE);

        Ovalo.setColor(Color.GRAY);
        Ovalo.setStrokeWidth(15);
        Ovalo.setStyle(Paint.Style.STROKE);

        Arco.setColor(Color.DKGRAY);
        Arco.setStrokeWidth(15);
        Arco.setStyle(Paint.Style.STROKE);
        RectF coordenadas = new RectF(300,1600,1100,2000);

        lienzo.drawCircle(700,700,350,miPincel);
        lienzo.drawPoint(300,300,punto);
        lienzo.drawPoint(1100,300,punto2);
        lienzo.drawPoint(300,1100,punto3);
        lienzo.drawPoint(1100,1100,punto4);
        lienzo.drawPoint(700,700,puntoCentral);
        lienzo.drawLine(300,1300,1100,1300,Linea);
        lienzo.drawOval(300,1400,1100,1500,Ovalo);
        lienzo.drawArc(coordenadas,180,180,false,Arco);
    }
}