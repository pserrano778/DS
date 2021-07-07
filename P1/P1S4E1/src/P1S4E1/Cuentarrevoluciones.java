/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P1S4E1;

/**
 *
 * @author Pedro
 */
public class Cuentarrevoluciones extends javax.swing.JPanel {

    /**
     * Creates new form Cuentarrevoluciones
     */
    public Cuentarrevoluciones() {
        initComponents();
        setVisible(true);
    }

    public void setRevoluciones(String rpm){
        revoluciones.setText(rpm);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        revoluciones = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentarrevoluciones"));
        setPreferredSize(new java.awt.Dimension(610, 166));

        revoluciones.setEditable(false);
        revoluciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        revoluciones.setBorder(javax.swing.BorderFactory.createTitledBorder("RPM"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField revoluciones;
    // End of variables declaration//GEN-END:variables
}
