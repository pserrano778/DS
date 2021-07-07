package Temperatura;

import java.util.ArrayList;

public class main {
    
    public static void main(String args[]) {
        ArrayList<Temperatura> temperaturasZonas = new ArrayList<Temperatura>();
        
        for (int i=0; i<7; i++){
            Temperatura temperatura = new Temperatura();
            temperaturasZonas.add(temperatura);
            temperaturasZonas.get(i).comenzarMedicion();
        }

        Mapa mapa = new Mapa(temperaturasZonas);
        
        for (int i=0; i<7; i++){
            
            temperaturasZonas.get(i).addObserver(mapa);
        }
    }
}
