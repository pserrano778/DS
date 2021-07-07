package Temperatura;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GraficaTemperatura extends javax.swing.JPanel implements Observer{
    private ArrayList<Float> temperaturas;

    public GraficaTemperatura() {
        initComponents();
        temperaturas = new ArrayList<>(10); //Capacidad fijada a 10
        inicializaBarras();
        
        setVisible(true);
    }    
    
    @Override
    public void update(Observable o, Object arg) {
        
        if(temperaturas.size() < 10) //Si no hay 10 elementos
            temperaturas.add( (float) arg); //Se añaden
        else{
            temperaturas.remove(0); //se elimina el mas antiguo
            temperaturas.add((float) arg); //se añade el mas nuevo
        }           
        
        int tamanio = temperaturas.size();
        
        configuraBarra(barra1, temperaturas.get(tamanio-1));
        barra1.setVisible(true);
        jLabel1.setVisible(true);
        
        if(tamanio > 1){
            configuraBarra(barra2, temperaturas.get(tamanio-2));
            barra2.setVisible(true);
            jLabel2.setVisible(true);
            
            if(tamanio > 2){
                configuraBarra(barra3, temperaturas.get(tamanio-3));
                barra3.setVisible(true);
                jLabel3.setVisible(true);
                
            if(tamanio > 3){
                configuraBarra(barra4, temperaturas.get(tamanio-4));
                barra4.setVisible(true);
                jLabel4.setVisible(true);
            
            if(tamanio > 4){
                configuraBarra(barra5, temperaturas.get(tamanio-5));
                barra5.setVisible(true);
                jLabel5.setVisible(true);
            
            if(tamanio > 5){
                configuraBarra(barra6, temperaturas.get(tamanio-6));
                barra6.setVisible(true);
                jLabel6.setVisible(true);
            
            if(tamanio > 6){
                configuraBarra(barra7, temperaturas.get(tamanio-7));
                barra7.setVisible(true);
                jLabel7.setVisible(true);
            
            if(tamanio > 7){
                configuraBarra(barra8, temperaturas.get(tamanio-8));
                barra8.setVisible(true);
                jLabel8.setVisible(true);
        
            if(tamanio > 8){
                configuraBarra(barra9, temperaturas.get(tamanio-9));
                barra9.setVisible(true);
                jLabel9.setVisible(true);
        
            if(tamanio > 9){
                configuraBarra(barra10, temperaturas.get(tamanio-10));                  
                barra10.setVisible(true);
                jLabel10.setVisible(true);
            
            }}}}}}}}
        }
            
        
        repaint();
        revalidate();
        
    }
    
    private void configuraBarra(javax.swing.JProgressBar barra, float valor){
        barra.setString(Float.toString(valor));
        barra.setValue(Math.round(valor));
        barra.setStringPainted(true);
    }
    
    private void inicializaBarras(){
        barra1.setVisible(false);
        barra2.setVisible(false);
        barra3.setVisible(false);
        barra4.setVisible(false);
        barra5.setVisible(false);
        barra6.setVisible(false);
        barra7.setVisible(false);
        barra8.setVisible(false);
        barra9.setVisible(false);
        barra10.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra1 = new javax.swing.JProgressBar();
        barra3 = new javax.swing.JProgressBar();
        barra4 = new javax.swing.JProgressBar();
        barra5 = new javax.swing.JProgressBar();
        barra6 = new javax.swing.JProgressBar();
        barra7 = new javax.swing.JProgressBar();
        barra8 = new javax.swing.JProgressBar();
        barra9 = new javax.swing.JProgressBar();
        barra10 = new javax.swing.JProgressBar();
        barra2 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de temperaturas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        barra1.setForeground(new java.awt.Color(164, 199, 147));
        barra1.setMaximum(60);
        barra1.setMinimum(-20);
        barra1.setOrientation(1);
        barra1.setAutoscrolls(true);
        barra1.setBorderPainted(false);

        barra3.setForeground(new java.awt.Color(164, 199, 147));
        barra3.setMaximum(60);
        barra3.setMinimum(-20);
        barra3.setOrientation(1);
        barra3.setAutoscrolls(true);
        barra3.setBorderPainted(false);

        barra4.setForeground(new java.awt.Color(164, 199, 147));
        barra4.setMaximum(60);
        barra4.setMinimum(-20);
        barra4.setOrientation(1);
        barra4.setAutoscrolls(true);
        barra4.setBorderPainted(false);

        barra5.setForeground(new java.awt.Color(164, 199, 147));
        barra5.setMaximum(60);
        barra5.setMinimum(-20);
        barra5.setOrientation(1);
        barra5.setAutoscrolls(true);
        barra5.setBorderPainted(false);

        barra6.setForeground(new java.awt.Color(164, 199, 147));
        barra6.setMaximum(60);
        barra6.setMinimum(-20);
        barra6.setOrientation(1);
        barra6.setAutoscrolls(true);
        barra6.setBorderPainted(false);

        barra7.setForeground(new java.awt.Color(164, 199, 147));
        barra7.setMaximum(60);
        barra7.setMinimum(-20);
        barra7.setOrientation(1);
        barra7.setAutoscrolls(true);
        barra7.setBorderPainted(false);

        barra8.setForeground(new java.awt.Color(164, 199, 147));
        barra8.setMaximum(60);
        barra8.setMinimum(-20);
        barra8.setOrientation(1);
        barra8.setAutoscrolls(true);
        barra8.setBorderPainted(false);

        barra9.setForeground(new java.awt.Color(164, 199, 147));
        barra9.setMaximum(60);
        barra9.setMinimum(-20);
        barra9.setOrientation(1);
        barra9.setAutoscrolls(true);
        barra9.setBorderPainted(false);

        barra10.setForeground(new java.awt.Color(164, 199, 147));
        barra10.setMaximum(60);
        barra10.setMinimum(-20);
        barra10.setOrientation(1);
        barra10.setAutoscrolls(true);
        barra10.setBorderPainted(false);

        barra2.setForeground(new java.awt.Color(164, 199, 147));
        barra2.setMaximum(60);
        barra2.setMinimum(-20);
        barra2.setOrientation(1);
        barra2.setAutoscrolls(true);
        barra2.setBorderPainted(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actual");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("5s");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("10s");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("15s");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("20s");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("25s");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("30s");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("35s");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("40s");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("45s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(barra10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra8, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra7, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barra1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra1;
    private javax.swing.JProgressBar barra10;
    private javax.swing.JProgressBar barra2;
    private javax.swing.JProgressBar barra3;
    private javax.swing.JProgressBar barra4;
    private javax.swing.JProgressBar barra5;
    private javax.swing.JProgressBar barra6;
    private javax.swing.JProgressBar barra7;
    private javax.swing.JProgressBar barra8;
    private javax.swing.JProgressBar barra9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
