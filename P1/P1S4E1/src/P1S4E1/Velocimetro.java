package P1S4E1;

public class Velocimetro extends javax.swing.JPanel {

    public Velocimetro() {
        initComponents();
        setVisible(true);
    }
    
    public void setVelocidad(String vel){
        velocidad.setText(vel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        velocidad = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Velocímetro"));

        velocidad.setEditable(false);
        velocidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        velocidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Km/h"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField velocidad;
    // End of variables declaration//GEN-END:variables
}
