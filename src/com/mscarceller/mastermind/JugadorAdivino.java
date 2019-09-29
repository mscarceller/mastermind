package com.mscarceller.mastermind;
import java.util.List;
import java.util.ArrayList;

class JugadorAdivino {

    private int intentos = 0;
    private final List<CombinacionPropuesta> combinacionesPropuestas = new ArrayList<>();

    public void preparaTableroPropuestas(){
        intentos = 0;
        combinacionesPropuestas.clear();
    }

    public void escribirResultadosPropuestas(){
        for (CombinacionPropuesta combinacionPropuesta : combinacionesPropuestas) {
            combinacionPropuesta.escribeCombinacionYResultado();
        }
    }

    public void proponerCombinacion(){
        intentos++;
        combinacionesPropuestas.add(new CombinacionPropuesta());
        devolverUltimaPropuesta().solicitaCombinacion();
    }

    public CombinacionPropuesta devolverUltimaPropuesta(){
        return combinacionesPropuestas.get(intentos-1) ;
    }

    public void mostrarIntentos(){
        System.out.print(intentos + " intento(s)\n");
    }

    public boolean esGanador(){
        if (devolverUltimaPropuesta().esGanadora()){
            System.out.print("¡¡Has ganado!!\n");
            return true;
        }
        return false;
    }

    public boolean esPerdedor(){
        if (intentos == 10){
            System.out.print("¡¡Has perdido!!\n");
            return true;
        }
        return false;
    }
}
