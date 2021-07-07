package P1S4E1;

public class FiltroRepercutirRozamiento implements Filtro {
    private static final double ROZAMIENTO = 0.01;
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        
        return (revoluciones*(1-ROZAMIENTO));
    }
}