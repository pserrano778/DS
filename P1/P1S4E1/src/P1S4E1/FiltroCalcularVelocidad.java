package P1S4E1;

public class FiltroCalcularVelocidad implements Filtro {
    private static final double MAXVELOCIDAD = 5000.0; //RPM
    private static final double incrementoVelocidad = 100.0;
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        
        double velocidad = revoluciones;
        
        if (estadoMotor == EstadoMotor.ACELERANDO){
            velocidad = velocidad + incrementoVelocidad;
            if (velocidad > MAXVELOCIDAD)
                velocidad = MAXVELOCIDAD;
        } else if (estadoMotor == EstadoMotor.FRENANDO){
            velocidad = velocidad - incrementoVelocidad;
            if (velocidad < 0)
                velocidad = 0;
        }
        
        return velocidad;
    }
}