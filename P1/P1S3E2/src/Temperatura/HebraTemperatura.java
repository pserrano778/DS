package Temperatura;

public class HebraTemperatura extends Thread{
    Temperatura temperatura;
    
    HebraTemperatura(Temperatura temperatura2){
        float temp = (float) (Math.random() * 40 - 5);
        temperatura = temperatura2;
        temperatura.setTemperatura(temp);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.sleep(5000); //Duerme 5 segundos
            } catch (Exception e) {
                System.out.println(e);
            }
                        
            float temp = (float) (Math.random() * 8 + temperatura.getTemperatura() - 4);
            temperatura.setTemperatura(temp);
        }
    }
}
