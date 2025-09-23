package com.example.juegodados;

public class Jugador {
    private String nombre;
    private  int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
