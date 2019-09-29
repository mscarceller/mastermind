package com.mscarceller.mastermind;

import java.util.*;

class Mastermind {

    private static final JugadorAdivino jugadorAdivino  = new JugadorAdivino();
    private static final JugadorSecreto jugadorSecreto = new JugadorSecreto(jugadorAdivino);
    private static final Scanner entradaTexto = new Scanner(System.in);

    public static void main (String[] args){
       do {
            jugarPartida();
       }while(seguirJugando());
    }

    private static void jugarPartida(){
        System.out.println("----- MASTERMIND -----");
        jugadorAdivino.preparaTableroPropuestas();
        jugadorSecreto.prepapraCombincacionSecreta();
        do {
            jugadorAdivino.proponerCombinacion();
            jugadorSecreto.respondeAPropuesta();
            jugadorAdivino.escribirResultadosPropuestas();
        }
        while(!jugadorAdivino.esGanador() && !jugadorAdivino.esPerdedor());
    }

    private static boolean seguirJugando(){
        String respuestaNuevaPartida;
        do {
            System.out.print("¿Quieres echarte otra partida? (s/n)");
            respuestaNuevaPartida = entradaTexto.nextLine().toUpperCase();
        }
        while (!respuestaNuevaPartida.equals("S") && !respuestaNuevaPartida.equals("N"));
        return (respuestaNuevaPartida.equals("S"));
    }
}
