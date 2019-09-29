package com.mscarceller.mastermind;

class Resultado {

    int muertos;
    int heridos;

    public Resultado(){
        muertos = 0;
        heridos = 0;
    }

    public void escribeResultado(){
        System.out.println(" --> " + muertos + " muertos y " + heridos + " heridos");
    }

    public boolean esGanador(){
        return (muertos == 4);
    }
}
