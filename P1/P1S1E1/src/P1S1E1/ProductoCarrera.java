package P1S1E1;

import java.util.ArrayList;

public abstract class ProductoCarrera {

        private int porcentajeRetirada;
	private static final int DURACION = 60;
        private ArrayList<ProductoBicicleta> bicisEnCarrera;

        public ProductoCarrera (int nBicis, FactoriaAbstractaDeporte unaFactoria){
            bicisEnCarrera = new ArrayList<>();

            for (int i=0; i<nBicis; i++){ //Creamos nBicis del tipo que indica la factoria usando esta
                ProductoBicicleta bici = unaFactoria.crearBicicleta();
                bici.setIdentificador(i+1); //Identificador
                bici.setSegundoRetirada(DURACION); //Duración de la carrera
                bicisEnCarrera.add(bici);
            }
        }
        
        public int getIDBicicleta(int num){
            return bicisEnCarrera.get(num).getID();
        }

        public int getPorcentajeRetirada() {
            return porcentajeRetirada;
	}
        
        protected void setPorcentajeRetirada(int nuevoPorcentaje) {
            porcentajeRetirada = nuevoPorcentaje;
	}
        
	public static int getDuracion() {
            return DURACION;
	}

        /***************************************************************/
        //Permite asignar a un numero de bicicletas, en funcion del porecntaje de retirada y elegidas de forma aleatoria,
        //el segundo donde se retiraran de la carrera (intervalo [1-59])
        //Devuelve las posiciones en el vector de bicisEnCarrera de las bicicletas que se reriraran antes de tiempo
        /***************************************************************/
        private ArrayList<Integer> RetiradaAntesDeTiempo(){
            
            int segundoRetirada = (int) (Math.random() * 58) + 1; //desde el segundo 1 hasta el 59
            ArrayList<Integer> bicisARetirar = new ArrayList<>();
            int numBicisARetirar = (int) Math.round((bicisEnCarrera.size()*porcentajeRetirada/100.0));
            
            for (int i=0; i<numBicisARetirar; i++){
                bicisARetirar.add(-1);
            }
            
            int retiradas = 0;
            while (retiradas < numBicisARetirar){ //Se obtienen las bicicletas que se retiraran antes de tiempo
                int numBici = (int) (Math.random() * bicisEnCarrera.size()); //Bici aleatoria
                boolean retirada = false;

                for (int i=0; i<retiradas && !retirada; i++){ //Comprobamos si la numBici ya se ha seleccionado
                    if (bicisARetirar.get(i) == numBici){ //Si se ha seleccionado se busca otra bici
                        retirada = true;
                    }
                }
                if (!retirada){ //Si no se ha seleccionado se añade y se incrementa el numero de bicis retiradas
                    bicisARetirar.set(retiradas, numBici);
                    retiradas++;
                }
            } 
            for (int i=0; i<bicisARetirar.size(); i++){ //Asignamos las bicicletas que se retirarán antes de terminar la carrera
                for (int j=0; j<bicisEnCarrera.size(); j++){
                    if (j == bicisARetirar.get(i)){
                        bicisEnCarrera.get(j).setSegundoRetirada(segundoRetirada);
                    }
                }
            }
            
            return bicisARetirar;
        }
        
        public void iniciarCarrera(){
            
            ArrayList<Integer> bicisARetirar = this.RetiradaAntesDeTiempo();
            
            /************************************************************/
            // Informacion sobre la carrera: tipo, participantes, etc
            /************************************************************/
            System.out.println(this);
            
            /************************************************************************************/
            // Informacion sobre las bicicletas que se retiran y en que segundo se van a retirar
            /************************************************************************************/
            System.out.println("Se van a retirar " + bicisARetirar.size() + " bicicletas en el segundo " +
                                bicisEnCarrera.get(bicisARetirar.get(0)).getSegundoRetirada());
            for (int i=0; i<bicisARetirar.size(); i++){
                System.out.println("Se retirara la bici: " + (bicisARetirar.get(i)+1 ));
            }
                     
            for (int i=0; i<bicisEnCarrera.size(); i++){ //Lanza todas las hebras (bicicletas)
                bicisEnCarrera.get(i).start();
            }
        }
     
        @Override
        public String toString(){
            return "Datos de la carrera:\nDuracion: " + this.DURACION + " segundos\nParticipantes:" + this.bicisEnCarrera.size();
        }
}