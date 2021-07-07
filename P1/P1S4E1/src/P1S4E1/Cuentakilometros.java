package P1S4E1;

public class Cuentakilometros extends javax.swing.JPanel {

    public Cuentakilometros() {
        initComponents();
        setVisible(true);
    }

    public void setReciente(String kmReciente){
        reciente.setText(kmReciente);
    }
    
    public void setTotal(String kmTotal){
        total.setText(kmTotal);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reciente = new javax.swing.JTextField();
        total = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentakilómetros"));

        reciente.setEditable(false);
        reciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reciente.setBorder(javax.swing.BorderFactory.createTitledBorder("Contador reciente"));
        reciente.setOpaque(false);

        total.setEditable(false);
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setBorder(javax.swing.BorderFactory.createTitledBorder("Contador total"));
        total.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reciente, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(reciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField reciente;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
