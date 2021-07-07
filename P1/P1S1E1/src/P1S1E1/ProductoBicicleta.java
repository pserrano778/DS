package P1S1E1;

public abstract class ProductoBicicleta  extends Thread{

	private int identificador;
        private int segundoRetirada;

	public void setIdentificador(int id) {
		this.identificador = id;
	}
                
        public int getID(){
            return this.identificador;
        }
        
        public void setSegundoRetirada(int segundo) {
		this.segundoRetirada = segundo;
	}
                
        public int getSegundoRetirada() {
		return this.segundoRetirada;
	}

        @Override
        public String toString(){
            return "Bicicleta " + this.identificador;
        }

        @Override
        public void run(){
            for (int i=0; i<segundoRetirada; i++){
                System.out.println(this + " en el segundo " + i);
                    try {
                        this.sleep(1000); //Duerme 1 segundo
                    } catch (Exception e) {
                        System.out.println(e);
                    }
            }
            System.out.println(this+" se retira en el segundo " + segundoRetirada);
        }
}