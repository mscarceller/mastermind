package com.mscarceller.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class CombinacionSecreta {

    private final String stringCombinacionSecreta;

    public CombinacionSecreta() {
        int indiceAleatorio;
        StringBuilder constructorCombinacionSecreta = new StringBuilder(4);
        ColorBola colorAleatorio;
        Random random = new Random();
        List<ColorBola> coloresBola = new ArrayList<>(Arrays.asList(ColorBola.values()));
        for (int i = 0; i < 4; i++) {
            indiceAleatorio = random.nextInt(coloresBola.size());
            colorAleatorio  = coloresBola.get(indiceAleatorio);
            constructorCombinacionSecreta.append(colorAleatorio);
            coloresBola.remove(indiceAleatorio);
        }
        stringCombinacionSecreta =  constructorCombinacionSecreta.toString();
    }

    public void analizaPropuesta(CombinacionPropuesta combinacionPropuesta){
        Resultado resultado = new Resultado();
        for (int i = 0; i < 4; i++) {
            if (combinacionPropuesta.contieneColor(stringCombinacionSecreta.charAt(i),i)) {
                resultado.muertos++;
            }
            else if (combinacionPropuesta.contieneColor(stringCombinacionSecreta.charAt(i))) {
                resultado.heridos++;
            }
        }
        combinacionPropuesta.setResultado(resultado);
    }

    public void escribirCombinacionSecreta(){
        System.out.println("****");
    }
}
