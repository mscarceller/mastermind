package com.mscarceller.mastermind;

class JugadorSecreto {

    private static CombinacionSecreta combinacionSecreta;
    private final JugadorAdivino jugadorAdivino;

    public JugadorSecreto(JugadorAdivino jugadorAdivinoAsociado){
        jugadorAdivino = jugadorAdivinoAsociado;
    }

    public void prepapraCombincacionSecreta(){
        combinacionSecreta = new CombinacionSecreta();
        escribirCombinacionSecreta();
    }

    public void respondeAPropuesta(){
        jugadorAdivino.mostrarIntentos();
        combinacionSecreta.escribirCombinacionSecreta();
        CombinacionPropuesta ultimaPropuesta = jugadorAdivino.devolverUltimaPropuesta();
        combinacionSecreta.analizaPropuesta(ultimaPropuesta);
    }

    private void escribirCombinacionSecreta(){
        combinacionSecreta.escribirCombinacionSecreta();
    }


}
