package P1S4E1;

import java.awt.Color;

public class PanelBotones extends javax.swing.JPanel {
    private Salpicadero salpicadero;

    public PanelBotones(Salpicadero salp) {
        salpicadero = salp;
        
        initComponents();
        acelerar.setText("Acelerar");
        acelerar.setEnabled(false);
        frenar.setText("Frenar");
        frenar.setEnabled(false);
        motor.setForeground(Color.GREEN);
        motor.setText("Encender");
        estadoActual.setForeground(Color.RED);
        estadoActual.setText("APAGADO");
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estadoActual = new javax.swing.JLabel();
        motor = new javax.swing.JToggleButton();
        acelerar = new javax.swing.JToggleButton();
        frenar = new javax.swing.JToggleButton();

        estadoActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        motor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                motorMouseClicked(evt);
            }
        });

        acelerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acelerarMouseClicked(evt);
            }
        });

        frenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frenarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(estadoActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(motor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frenar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(estadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(acelerar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(frenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(motor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    synchronized private void motorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_motorMouseClicked
        if(salpicadero.getEstadoMotor() == EstadoMotor.APAGADO){
            motor.setForeground(Color.RED);
            motor.setText("Apagar");
            acelerar.setEnabled(true);
            frenar.setEnabled(true);
            estadoActual.setText("ENCENDIDO");
            salpicadero.setEstadoMotor(EstadoMotor.ENCENDIDO);
        } else if (salpicadero.getEstadoMotor() == EstadoMotor.ENCENDIDO){
            acelerar.setEnabled(false);
            frenar.setEnabled(false);
            motor.setForeground(Color.GREEN);
            motor.setText("Encender");
            estadoActual.setText("APAGADO");
            salpicadero.setEstadoMotor(EstadoMotor.APAGADO);
        }
    }//GEN-LAST:event_motorMouseClicked

    synchronized private void acelerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acelerarMouseClicked
        if(salpicadero.getEstadoMotor() == EstadoMotor.ENCENDIDO){
            acelerar.setForeground(Color.RED);
            acelerar.setText("Soltar acelerador");
            estadoActual.setText("ACELERANDO");
            salpicadero.setEstadoMotor(EstadoMotor.ACELERANDO);
            frenar.setEnabled(false);
            motor.setEnabled(false);
        } else if (salpicadero.getEstadoMotor() == EstadoMotor.ACELERANDO){ 
            acelerar.setForeground(Color.BLACK);
            acelerar.setText("Acelerar");
            estadoActual.setText("ENCENDIDO");
            salpicadero.setEstadoMotor(EstadoMotor.ENCENDIDO);
            frenar.setEnabled(true);
            motor.setEnabled(true);
        }
    }//GEN-LAST:event_acelerarMouseClicked

    synchronized private void frenarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frenarMouseClicked
        if (salpicadero.getEstadoMotor() == EstadoMotor.ENCENDIDO){
            estadoActual.setText("FRENANDO");
            salpicadero.setEstadoMotor(EstadoMotor.FRENANDO);
            acelerar.setEnabled(false);
            motor.setEnabled(false);
            frenar.setText("Soltar freno");
        } else if (salpicadero.getEstadoMotor() == EstadoMotor.FRENANDO){
            estadoActual.setText("ENCENDIDO");
            salpicadero.setEstadoMotor(EstadoMotor.ENCENDIDO);
            acelerar.setEnabled(true);
            motor.setEnabled(true);
            frenar.setText("Frenar");
        }
    }//GEN-LAST:event_frenarMouseClicked
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton acelerar;
    private javax.swing.JLabel estadoActual;
    private javax.swing.JToggleButton frenar;
    private javax.swing.JToggleButton motor;
    // End of variables declaration//GEN-END:variables
}
