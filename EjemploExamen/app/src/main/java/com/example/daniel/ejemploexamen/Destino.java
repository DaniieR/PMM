package com.example.daniel.ejemploexamen;

import java.io.Serializable;

public class Destino implements Serializable {

    private String zona;
    private String continente;
    private double precio;

    public Destino(String zona, String continente, double precio) {
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }

    public String getZona() {return zona;}

    public String getContinente() {return continente;}

    public double getPrecio() {return precio;}

    public void setZona(String zona) {this.zona = zona;}

    public void setContinente(String continente) {this.continente = continente;}

    public void setPrecio(double precio) {this.precio = precio;}

}