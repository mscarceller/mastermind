package com.mscarceller.mastermind;

import java.util.*;

public class CombinacionPropuesta {

    private final Scanner entradaTexto;
    private String propuestaIntroducida;
    private Resultado resultadoPropuesta;

    public CombinacionPropuesta(){
        entradaTexto = new Scanner(System.in);
        resultadoPropuesta = new Resultado();
        propuestaIntroducida = "";
    }

    public  void solicitaCombinacion(){
        boolean propuestaOK;
        do {
            System.out.print("Propón una combinación: ");
            propuestaIntroducida = entradaTexto.nextLine();
            propuestaOK = validaCombinacionPropuesta(propuestaIntroducida);
        } while (!propuestaOK);
    }

    public void escribeCombinacionYResultado(){
        System.out.print(propuestaIntroducida);
        resultadoPropuesta.escribeResultado();
    }

    private static boolean validaCombinacionPropuesta(String propuestaIntroducida) {
        if (propuestaIntroducida.length() != 4) {
            System.out.print("La longitud de la propuesta es incorrecta (4 caracteres)\n");
            return false;
        } else if (tieneColoresRepetidos(propuestaIntroducida)) {
            System.out.print("Ha introducido colores repetidos\n");
            return false;
        } else {
            for (int i = 0; i < propuestaIntroducida.length(); i++) {
                if (esColorInvalido(propuestaIntroducida.charAt(i))) {
                    System.out.print("Ha introducido colores inválidos, sólo pueden ser r, b, y, g, o, p\n");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean contieneColor(char color, int posicion){
        return (propuestaIntroducida.charAt(posicion) == color);
    }

    public boolean contieneColor(char color){
        for (int i = 0; i < 4; i++) {
            if (propuestaIntroducida.charAt(i) == color)
                return true;
        }
        return false;
    }

    private static boolean esColorInvalido(Character value) {
        List<ColorBola> coloresBola = new ArrayList<>(Arrays.asList(ColorBola.values()));
        for (ColorBola colorBola : coloresBola) {
            if (value.toString().equals(colorBola.toString())) {
                return false;
            }
        }
        return true;
    }

    private static boolean tieneColoresRepetidos(String propuestaIntroducida) {
        List<Character> coloresEnPropuesta = new ArrayList<>();
        for (int i = 0; i < propuestaIntroducida.length(); i++) {
            for (Character color : coloresEnPropuesta) {
                if (propuestaIntroducida.charAt(i) == color) {
                    return true;
                }
            }
            coloresEnPropuesta.add(propuestaIntroducida.charAt(i));
        }
        return false;
    }

    public void setResultado(Resultado resultado){
        resultadoPropuesta = resultado;
    }

    public boolean esGanadora(){
        return resultadoPropuesta.esGanador();
    }
}