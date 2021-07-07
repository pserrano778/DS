package P1S4E1;

public class HebraSalpicadero extends Thread {
    
    private Salpicadero salpicadero;
    public HebraSalpicadero(Salpicadero salp){
        salpicadero = salp; 
    }
        
    @Override
    public void run(){
        salpicadero.actualizarSalpicadero();
        while(true){
            try {
                Thread.sleep(100); //Duerme 1 segundo
            } catch (Exception e) {
                System.out.println(e);
            }
            if(salpicadero.getEstadoMotor() == EstadoMotor.APAGADO && salpicadero.getVelocidadAngular() == 0){
                salpicadero.resetDistanciaRecorrida();
            }
            salpicadero.actualizarSalpicadero(); 
        }
    }
}