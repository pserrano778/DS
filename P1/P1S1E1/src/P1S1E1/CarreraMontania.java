package P1S1E1;

public class CarreraMontania extends ProductoCarrera {

        public CarreraMontania(int nBicis, FactoriaAbstractaDeporte unaFact){
            super(nBicis, unaFact);
            super.setPorcentajeRetirada(20);
        }

        @Override
        public String toString(){
            return super.toString() + "\nTipo: Montania\nPorcentaje de retirada: " + super.getPorcentajeRetirada() + "%";
        }
}