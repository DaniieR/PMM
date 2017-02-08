package com.example.daniel.proyecto2evaluacion;

import java.io.Serializable;

public class Skin implements Serializable {

    private String personaje;
    private String aspecto;
    private double precio;

    public Skin(String personaje, String aspecto, double precio) {
        this.personaje = personaje;
        this.aspecto = aspecto;
        this.precio = precio;
    }

    public String getPersonaje() {return personaje;}

    public String getAspecto() {return aspecto;}

    public double getPrecio() {return precio;}

    public void setPersonaje(String personaje) {this.personaje = personaje;}

    public void setAspecto(String aspecto) {this.aspecto = aspecto;}

    public void setPrecio(double precio) {this.precio = precio;}

}