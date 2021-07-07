package P1S1E1;

public class CarreraCarretera extends ProductoCarrera {

        public CarreraCarretera(int nBicis, FactoriaAbstractaDeporte unaFact){
            super(nBicis, unaFact);
            super.setPorcentajeRetirada(10);
        }
        
        @Override
        public String toString(){
            return super.toString() + "\nTipo: Carretera\nPorcentaje de retirada: " + super.getPorcentajeRetirada() + "%";
        }
}