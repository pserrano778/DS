package P1S4E1;

import java.util.ArrayList;
public class CadenaFiltros {
    private ArrayList<Filtro> cadenaFiltros;
    public CadenaFiltros(){
        cadenaFiltros = new ArrayList<Filtro>();
    }
    
    public void aniadeFiltro(Filtro filtro){
        cadenaFiltros.add(filtro);
    }
    
    public void ejecutar(Salpicadero salpicadero){
        double rpm = salpicadero.getVelocidadAngular();
        for (int i=0; i<cadenaFiltros.size(); i++){
            rpm = cadenaFiltros.get(i).ejecutar(rpm, salpicadero.getEstadoMotor());
        }
        salpicadero.ejecutar(rpm, salpicadero.getEstadoMotor());
    }
}