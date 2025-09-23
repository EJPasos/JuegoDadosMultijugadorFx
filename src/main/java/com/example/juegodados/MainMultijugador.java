package com.example.juegodados;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMultijugador extends Application {


    public void start(Stage primaryStage) {
        // Crear jugadores
        Jugador j1 = new Jugador("Ana");
        Jugador j2 = new Jugador("Luis");
        Jugador j3 = new Jugador("Marta");
        Jugador j4 = new Jugador("Juan");

        // Crear Tablero y lógica
        Tablero tablero = new Tablero(j1, j2, j3, j4);
        Juego3DadosMultijugador juego = new Juego3DadosMultijugador(j1, j2, j3, j4);


        tablero.setJugadorActual(juego.getJugadorActual());
        // Conectar botón lanzar
        tablero.getCentroTablero().getBotonLanzar().setOnAction(e -> {
            if (!juego.partidaFinalizada()) {
                juego.jugarTurno();
               tablero.getCentroTablero().setDados(juego.getDados());
                tablero.setJugadorActual(juego.getJugadorActual());
                tablero.setPuntuaciones(juego.getJugadores());
                tablero.getCentroTablero().actualizarRonda(juego.getRondaActual());
                if (juego.partidaFinalizada()) {
                    String mensaje;
                    if (!juego.hayEmpate()) {
                        mensaje = "¡Ganador: " + juego.getGanador().getNombre() + "!";
                    } else {
                        mensaje = "¡Empate, no hay ganador";
                    }
                    Alert alert = new Alert(AlertType.INFORMATION, mensaje);
                    alert.setHeaderText("Fin de la partida");
                    alert.showAndWait();
                }
            }
        });

        // Mostrar ventana
        Scene scene = new Scene(tablero, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Juego 3 Dados Multijugador");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
