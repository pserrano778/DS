package Temperatura;

import java.util.Observable;
import java.util.Observer;

public class PantallaTemperatura extends javax.swing.JPanel implements Observer {

    private Temperatura temperatura;
    private HebraPantalla hebra;
    
    public PantallaTemperatura(Temperatura temp) {
        initComponents();
        temperatura = temp;
        hebra = new HebraPantalla(this, temperatura);
        setVisible(true);
        repaint();
        revalidate();
    }    
    
    @Override
    public void update(Observable obj, Object arg){
        tempActual.setText(String.valueOf(temperatura.getTemperatura()));
        tempActual1.setText(String.valueOf((float) Math.round((temperatura.getTemperatura() * 9.0/5.0 + 32 )*100)/100));
        tempActual2.setText(String.valueOf((float) Math.round((temperatura.getTemperatura() + 273.15)*100)/100));
        repaint();
        revalidate();
    }
    
    public void iniciarHebraPantalla(){
        hebra.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTemperatura = new javax.swing.JLabel();
        tempActual = new javax.swing.JTextField();
        textTemperatura1 = new javax.swing.JLabel();
        tempActual1 = new javax.swing.JTextField();
        textTemperatura2 = new javax.swing.JLabel();
        tempActual2 = new javax.swing.JTextField();

        textTemperatura.setText("Temperatura actual (ºC): ");

        tempActual.setEditable(false);
        tempActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textTemperatura1.setText("Temperatura actual (ºF): ");

        tempActual1.setEditable(false);
        tempActual1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textTemperatura2.setText("Temperatura actual (K):  ");

        tempActual2.setEditable(false);
        tempActual2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textTemperatura)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textTemperatura1)
                                .addGap(20, 20, 20))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(textTemperatura2)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tempActual2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tempActual1)
                        .addComponent(tempActual, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTemperatura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempActual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTemperatura1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempActual2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTemperatura2))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField tempActual;
    private javax.swing.JTextField tempActual1;
    private javax.swing.JTextField tempActual2;
    private javax.swing.JLabel textTemperatura;
    private javax.swing.JLabel textTemperatura1;
    private javax.swing.JLabel textTemperatura2;
    // End of variables declaration//GEN-END:variables
}
