package com.example.mati.ejemploexamen;

import java.io.Serializable;

public class Destino implements Serializable {
    private String zona;
    private String continente;
    private int precio;

    public Destino(String zona, String continente, int precio) {
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }

    public String getZona() {return zona;}

    public String getContinente() {return continente;}

    public int getPrecio() {return precio;}
}
