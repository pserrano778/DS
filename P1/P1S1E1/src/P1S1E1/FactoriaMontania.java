package P1S1E1;

public class FactoriaMontania implements FactoriaAbstractaDeporte {

        @Override
	public BicicletaMontania crearBicicleta() {
            BicicletaMontania biciMontania = new BicicletaMontania();
		return biciMontania;
	}

	@Override
	public CarreraMontania crearCarrera(int nBicis) {
            CarreraMontania carreraMontania = new CarreraMontania(nBicis, this);
            return carreraMontania;
	}

}