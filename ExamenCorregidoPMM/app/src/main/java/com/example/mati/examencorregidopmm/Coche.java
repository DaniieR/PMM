package com.example.mati.examencorregidopmm;

/**
 * Created by mati on 28/11/16.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Coche implements Serializable {

    private String modelo;
    private String marca;
    private double precio;
    private int imagen;

    public Coche(String modelo, String marca, double precio ,int img) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = img;
    }

    public String getModelo() {return modelo;}

    public String getMarca() {return marca;}

    public double getPrecio() {return precio;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    public void setMarca(String marca) {this.marca = marca;}

    public void setPrecio(double precio) {this.precio = precio;}
    public int getImagen(){return imagen;}

}