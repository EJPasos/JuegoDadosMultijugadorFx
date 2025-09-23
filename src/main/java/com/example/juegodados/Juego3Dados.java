package com.example.juegodados;

public class Juego3Dados {
    private DadoLogico dado1, dado2, dado3;

    public Juego3Dados() {
        dado1 = new DadoLogico();
        dado2 = new DadoLogico();
        dado3 = new DadoLogico();
    }

    public void lanzar3Dados(){
        dado1.lanzar();
        dado2.lanzar();
        dado3.lanzar();

    }

    public boolean sonIguales() {
        return dado1.getCaraActual() == dado2.getCaraActual() && dado1.getCaraActual() == dado3.getCaraActual();
    }

    public int suma3Dados() {
        return dado1.getCaraActual() + dado2.getCaraActual() + dado3.getCaraActual();
    }

    public boolean gano() {
        return sonIguales() || (suma3Dados() > 14);
    }

    public void Jugar() {
        lanzar3Dados();
        System.out.println("Dados: " + dado1 + dado2 + dado3);
        System.out.println("La suma es igual a " + suma3Dados());
        System.out.println(sonIguales()? "Son iguales" : "No son iguales");
        System.out.println(gano()?" Has Ganado!" : "Perdiste");

    }

}
