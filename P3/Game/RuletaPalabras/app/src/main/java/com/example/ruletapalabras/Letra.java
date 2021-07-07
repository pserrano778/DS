package com.example.ruletapalabras;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Letra {
    private String letra;
    private Integer idXML;
    private Palabra palabra;
    private Estado estado;
    private ImageView imagen;

    Letra(String letra1, Palabra palabra1, Integer idXML1, Partida vista, Estado estado){
        letra = letra1;
        palabra = palabra1;
        idXML = idXML1;

        imagen = (ImageView) vista.findViewById(idXML);
        this.estado = estado;
    }

    String comprobarRespuesta(String respuesta){
        String cadena = "";

        if (palabra.getPalabra().equalsIgnoreCase(respuesta)){
            estado = Estado.CORRECTA;
            cadena = "\nCorrecto";
            //actualizar circulo
            imagen.setImageResource(R.drawable.circulo_verde);
        }else{
            estado = Estado.INCORRECTA;
            //actualizar circulo
            imagen.setImageResource(R.drawable.circulo_rojo);
            cadena = "Incorrecto. La palabra correcta era " + "\"" + palabra.getPalabra() + "\"";
        }

        return cadena;
    }

    String getLetra(){
        return letra;
    }

    Estado getEstado(){
        return estado;
    }

    Palabra getPalabra(){
        return palabra;
    }

    void setActual(Boolean actual){
        if (actual){
            imagen.setImageResource(R.drawable.circulo_azul_oscuro);
        }
        else{
            imagen.setImageResource(R.drawable.circulo);
        }
    }
}
