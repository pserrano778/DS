package P1S4E1;

public class Cliente {
    public static void main(String args[]) {
        Salpicadero salpicadero = new Salpicadero();
        salpicadero.comenzarMedicionSalpicadero();
        
        GestorFiltros gestor = new GestorFiltros();
        gestor.aniadeFiltro(new FiltroCalcularVelocidad());
        gestor.aniadeFiltro(new FiltroRepercutirRozamiento());
        
        while(true){
            try {
                Thread.sleep(1000); //Duerme 1 segundo
            } catch (Exception e) {
                System.out.println(e);
            }
            gestor.peticionFiltros(salpicadero);
        }
    }
}