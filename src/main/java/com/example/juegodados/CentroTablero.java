package com.example.juegodados;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CentroTablero extends VBox {
    private DadoUI dado1, dado2, dado3;
    private Button lanzar;
    private Juego3Dados juego;
    private HBox contenedorDados;
    private Label rondas;
    public CentroTablero(Juego3Dados juego){}
//Centro del tablero contendra un boton(lanzar) y 3 dadosUI
    public CentroTablero() {
        rondas = new Label();
        rondas.setText("Rondas = 0");
        contenedorDados = new HBox();
        contenedorDados.setSpacing(5);
        dado1 = new DadoUI(1);
        dado2 = new DadoUI(2);
        dado3 = new DadoUI(3);
        contenedorDados.getChildren().addAll(dado1, dado2, dado3);
        lanzar = new Button("Lanzar");

        this.getChildren().addAll(rondas, contenedorDados, lanzar);
        this.setSpacing(5);

    }
    public void setDados(int[] valores){
        dado1.actualizarDadoUI(valores[0]);
        dado2.actualizarDadoUI(valores[1]);
        dado3.actualizarDadoUI(valores[2]);

    }

    public void actualizarRonda(int rondas){
        this.rondas.setText("Rondas = " + rondas);
    }

    public Button getBotonLanzar() {
        return lanzar;
    }
}
