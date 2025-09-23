package com.example.juegodados;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Tablero extends BorderPane {
    private ArrayList<JugadorUI> jugadores = new ArrayList<>();
    private CentroTablero centroTablero;

    public Tablero(Jugador j1, Jugador j2, Jugador j3, Jugador j4) {
        jugadores.add(new JugadorUI(j1));
        jugadores.add(new JugadorUI(j2));
        jugadores.add(new JugadorUI(j3));
        jugadores.add(new JugadorUI(j4));
        centroTablero = new CentroTablero();
        this.setCenter(centroTablero);
        this.setTop(jugadores.get(0));
        this.setBottom(jugadores.get(2));
        this.setLeft(jugadores.get(1));
        this.setRight(jugadores.get(3));
    }

    public ArrayList<JugadorUI> getJugadores() {
    return jugadores;}


    public CentroTablero getCentroTablero() {
        return centroTablero;
    }


    public void setJugadorActual(int jugadorActual){
        for(JugadorUI jugador : jugadores){
            jugador.setColorActivo(false);
        }
        jugadores.get(jugadorActual).setColorActivo(true);
    }

    public void setPuntuaciones(ArrayList<Jugador> jugadores){
        for(int i =0; i < jugadores.size(); i++){
            this.jugadores.get(i).setJugador(jugadores.get(i));
        }
    }

}




