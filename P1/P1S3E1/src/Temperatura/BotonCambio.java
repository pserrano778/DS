package Temperatura;

import java.util.Observable;
import java.util.Observer;

public class BotonCambio extends javax.swing.JPanel implements Observer{
    private Temperatura temperatura;
    
    public BotonCambio(Temperatura temp) {
        initComponents();
        temperatura = temp;
    }
    
    @Override
    public void update(Observable o, Object arg) {}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonTemp = new javax.swing.JButton();
        textTemp = new javax.swing.JTextField();

        botonTemp.setText("Modificar temperatura");
        botonTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTempActionPerformed(evt);
            }
        });

        textTemp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(botonTemp)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(textTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonTemp)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTempActionPerformed
        temperatura.setTemperatura(Float.parseFloat(textTemp.getText()));
    }//GEN-LAST:event_botonTempActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonTemp;
    private javax.swing.JTextField textTemp;
    // End of variables declaration//GEN-END:variables
}
