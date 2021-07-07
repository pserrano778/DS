package com.example.ruletapalabras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Ruleta {
    private ArrayList<Letra> letras;
    private ArrayList<Integer> posiciones;
    private int posicionActual;
    private final int FIN = 25;
    private int restantes;

    Ruleta(ArrayList<Letra> letrasTemp, Integer pos){
        posicionActual = pos;
        letras = letrasTemp;
        restantes = 0;
        posiciones = new ArrayList<>();
        for(int i = 0; i < FIN; i++){
            if(letras.get(i).getEstado() == Estado.SIN_RESPONDER) {
                restantes++;
                posiciones.add(i);
            }
        }
        letras.get(posiciones.get(posicionActual)).setActual(true);
    }

    Letra getLetraActual(){
        return letras.get(posiciones.get(posicionActual));
    }

    void siguienteLetra(){
        letras.get(posiciones.get(posicionActual)).setActual(false);
        int sig = (int) (Math.random() * (restantes - 1) + 1);
        posicionActual = (posicionActual + sig)%restantes;
        letras.get(posiciones.get(posicionActual)).setActual(true);
    }

    String comprobarRespuesta(String respuesta){
        String cadena = "";

        cadena = getLetraActual().comprobarRespuesta(respuesta);
        restantes--;

        posiciones.remove(posicionActual);
        if (posicionActual > restantes-1){
            posicionActual = 0;
        }
        if(restantes > 0)
            letras.get(posiciones.get(posicionActual)).setActual(true);

        return cadena;
    }

    Integer getRestantes(){
        return restantes;
    }

    ArrayList<Letra> getLetras(){
        return letras;
    }

    Integer getPosicionActual(){
        return posicionActual;
    }

    HashMap<String, Integer> getResumen(){
        HashMap<String, Integer> map = new HashMap<>();
        int aciertos = 0;
        int errores = 0;
        int sin_responder = 0;

        for (int i=0; i<letras.size(); i++){
            if (letras.get(i).getEstado() == Estado.CORRECTA){
                aciertos ++;
            } else if (letras.get(i).getEstado() == Estado.INCORRECTA){
                errores ++;
            } else{
                sin_responder ++;
            }
        }
        map.put("aciertos", aciertos);
        map.put("errores", errores);
        map.put("sin_responder", sin_responder);
        return map;
    }

}