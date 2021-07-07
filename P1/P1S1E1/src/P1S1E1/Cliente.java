package P1S1E1;

public class Cliente{
    static ProductoBicicleta bicicleta;
    static ProductoCarrera carrera;
    static FactoriaAbstractaDeporte factoria;
            
    public static void main(String[] args) {
        int numeroBicicletas = (int) (Math.random() * 10) + 11; //Numero de bicicletas
        
        factoria = new FactoriaCarretera();
        carrera = factoria.crearCarrera(numeroBicicletas);
        carrera.iniciarCarrera();
        
        factoria = new FactoriaMontania();
        carrera = factoria.crearCarrera(numeroBicicletas);
        carrera.iniciarCarrera();
        

    }
}