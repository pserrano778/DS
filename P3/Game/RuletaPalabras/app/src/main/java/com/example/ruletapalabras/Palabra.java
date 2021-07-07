package com.example.ruletapalabras;

public class Palabra {
    private String palabra, definicion;

    Palabra(String palabra1, String definicion1){
        palabra = palabra1;
        definicion = definicion1;
    }

    String getPalabra(){
        return palabra;
    }

    String getDefinicion(){
        return definicion;
    }
}
