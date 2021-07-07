package Temperatura;

import java.util.Observable;

public class HebraPantalla extends Thread{
    private PantallaTemperatura pantalla;
    private Observable observablePantalla;
    
    public HebraPantalla(PantallaTemperatura unaPantalla, Observable observable){
        pantalla = unaPantalla;
        observablePantalla = observable;
    }
    
    @Override
    public void run(){
        while(true){
            pantalla.update(observablePantalla, null);
        }
    }
}
