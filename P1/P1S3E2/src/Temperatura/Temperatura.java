package Temperatura;

import java.lang.Math;
import java.util.Observable;

public class Temperatura extends Observable{
    private float temperatura;
    private HebraTemperatura hebra;
    
    public Temperatura(){
    hebra = new HebraTemperatura(this);}
    
    public float getTemperatura(){
        return temperatura;
    }
    
    public void setTemperatura(float temp){
        
        temperatura = ((float) Math.round(temp*100)/100);
        
        //Cota superior e inferior
        if (temperatura > 60){
            temperatura = 60;
        }
        else if (temperatura < (-20)){
            temperatura = -20;
        }
        
        notificarTemperatura();
    }
    
    public void notificarTemperatura(){
        setChanged();
        notifyObservers(Float.valueOf(temperatura));
        setChanged();
        notifyObservers();
    }
    
    public void comenzarMedicion(){
        hebra.start();
    }
}
