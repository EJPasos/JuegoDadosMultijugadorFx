package com.example.juegodados;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class JugadorUI extends VBox {
    private static final String COLOR_ACTIVO = "#99FF99";
    private static final String COLOR_INACTIVO = "#FF9933";
    private static final String ESTILO_BASE = "-fx-alignment: CENTER; -fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 1;";

    private Jugador jugador;
    private Label nombreJugador;
    private Label puntosJugador;

    public JugadorUI(Jugador jugador){
        this.jugador = jugador;
        nombreJugador = new Label();
        puntosJugador = new Label();
        actualizarInfo();
        this.setSpacing(5);
        this.setStyle(estiloConColor(COLOR_INACTIVO));

        nombreJugador.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        puntosJugador.setStyle("-fx-font-size: 24px; -fx-text-fill: #333;");

        this.getChildren().addAll(nombreJugador,puntosJugador);
    }

    public void addPuntos(int puntos){
        int suma = jugador.getPuntos() + puntos;
        jugador.setPuntos(suma);
        puntosJugador.setText("Puntos: "+jugador.getPuntos());
    }

    public void setColorActivo(boolean activo) {
        this.setStyle(estiloConColor(activo ? COLOR_ACTIVO : COLOR_INACTIVO));
    }

    private String estiloConColor(String colorFondo) {
        return ESTILO_BASE + " -fx-background-color: " + colorFondo + ";";
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
        actualizarInfo();
    }

    public Jugador getJugador() {
        return jugador;
    }

    private void actualizarInfo(){
        nombreJugador.setText("Jugador: \n"+jugador.getNombre());
        puntosJugador.setText(String.valueOf(jugador.getPuntos() + " Puntos"));
    }
}




