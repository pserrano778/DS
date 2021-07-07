package P1S1E1;

public class FactoriaCarretera implements FactoriaAbstractaDeporte {

        @Override
	public BicicletaCarretera crearBicicleta() {
            BicicletaCarretera biciCarretera = new BicicletaCarretera();
            return biciCarretera;
	}

        @Override
	public CarreraCarretera crearCarrera(int nBicis) {
            CarreraCarretera carreraCarretera = new CarreraCarretera(nBicis, this);
            return carreraCarretera;
	}

}