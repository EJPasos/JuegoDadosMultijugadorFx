package com.example.juegodados;

import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class DadoUI extends Label {
    private int valor;

    public DadoUI(int valor) {
        this.valor = valor;
        Font font = new Font("Arial", 100);

        this.setFont(font);
        actualizarLabel();
    }

    public void actualizarDadoUI(int valor) {
        this.valor = valor;
        actualizarLabel();

    }

    public void actualizarLabel() {
        int EMOJI_DADO = 9855;
        String emoji = new String(Character.toChars(EMOJI_DADO + valor));
        this.setText(emoji);
    }



}
