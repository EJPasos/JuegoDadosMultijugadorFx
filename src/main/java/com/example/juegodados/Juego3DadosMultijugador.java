package com.example.juegodados;

import java.util.ArrayList;
import java.util.List;

public class Juego3DadosMultijugador {
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final DadoLogico dado1 = new DadoLogico();
    private final DadoLogico dado2 = new DadoLogico();
    private final DadoLogico dado3 = new DadoLogico();
    private int rondaActual = 0;
    private int jugadorActual = 0;
    public static final int RONDAS = 3;

    public Juego3DadosMultijugador(Jugador jugador1, Jugador jugador2, Jugador jugador3,Jugador jugador4) {

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
    }



    public void jugarTurno() {
        dado1.lanzar();
        dado2.lanzar();
        dado3.lanzar();

        int puntos = jugadores.get(jugadorActual).getPuntos() + dado1.getCaraActual() + dado2.getCaraActual() + dado3.getCaraActual();
        jugadores.get(jugadorActual).setPuntos(puntos);

        siguienteJugador();
    }

    public void siguienteJugador(){
        jugadorActual++;
        if(jugadorActual == jugadores.size()){
            jugadorActual = 0;
            rondaActual++;
        }
    }

    public int[] getDados() {
        return new int[] {dado1.getCaraActual(), dado2.getCaraActual(), dado3.getCaraActual()};
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public int getRondaActual() {
        return rondaActual + 1;
    }

    public Jugador getGanador() {
        Jugador ganador = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntos() > ganador.getPuntos()) {
                ganador = jugador;
            }
        }
        return ganador;
    }

    public boolean hayEmpate() {
        int maxPuntos = jugadores.get(0).getPuntos();
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntos() > maxPuntos) {
                maxPuntos = jugador.getPuntos();
            }
        }
        int contador = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntos() == maxPuntos) {
                contador++;
            }
        }
        return contador > 1;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public boolean partidaFinalizada() {
        return rondaActual >= RONDAS;
    }
}
