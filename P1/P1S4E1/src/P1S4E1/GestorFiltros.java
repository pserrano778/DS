package P1S4E1;

import java.util.ArrayList;
public class GestorFiltros {
    
    private CadenaFiltros cadenaFiltros;
    
    public GestorFiltros (){
        cadenaFiltros = new CadenaFiltros();
    }
    
    public void aniadeFiltro (Filtro filtro){
        cadenaFiltros.aniadeFiltro(filtro);
    }
    
    public void peticionFiltros(Salpicadero salpicadero){
        cadenaFiltros.ejecutar(salpicadero);
    }
}