package Temperatura;

public class main {
    
    public static void main(String args[]) {
        Temperatura temperatura = new Temperatura();
        Interfaz interfaz = new Interfaz(temperatura);          
        
        temperatura.comenzarMedicion();
    }
}
