package P1S4E1;

import java.text.DecimalFormat;
import java.awt.event.*;

public class Salpicadero extends javax.swing.JFrame {

    private HebraSalpicadero hebra;
    private PanelBotones botones;
    private Velocimetro velocimetro;
    private Cuentakilometros cuentakilometros;
    private Cuentarrevoluciones cuentarrevoluciones;
    private double velocidadAngular;
    private double velocidadLineal;
    private double distanciaRecorrida;
    private double distanciaTotal;
    private EstadoMotor estadoMotor;
    private static final double RADIO = 0.15; 
    
    public Salpicadero() {
        distanciaRecorrida = 0.0;
        velocidadAngular = 0.0;
        velocidadLineal = 0.0;
        distanciaTotal = 0.0;
        estadoMotor = EstadoMotor.APAGADO;
        
        hebra = new HebraSalpicadero(this);
        velocimetro = new Velocimetro(); 
        cuentakilometros = new Cuentakilometros();
        cuentarrevoluciones = new Cuentarrevoluciones();
        botones = new PanelBotones(this);
        
        initComponents();
        panelBotones.add(botones);
        panelVelocimetro.add(velocimetro);
        panelCuentakilometros.add(cuentakilometros);
        panelCuentarrevoluciones.add(cuentarrevoluciones);
        setVisible(true);
        
        actualizarSalpicadero();

        this.addWindowListener (new WindowAdapter () {
            public void windowClosing (WindowEvent e ) {
                System.exit(0);
            }
        });
        
        setTitle("Salpicadero");
    }

    public void comenzarMedicionSalpicadero(){
        hebra.start();
    }
    
    public void setEstadoMotor(EstadoMotor estado){ 
        estadoMotor = estado;
    }
    
    public EstadoMotor getEstadoMotor(){
        return estadoMotor;
    }
    
    public double getVelocidadAngular(){
        return velocidadAngular;
    }
    
    public double getDistanciaRecorrida(){
        return distanciaRecorrida;
    }
    
    public void resetDistanciaRecorrida(){
        distanciaRecorrida = 0.0;
    }
    
    public void actualizarSalpicadero(){
        DecimalFormat df = new DecimalFormat("0.00");
        velocimetro.setVelocidad(df.format(velocidadLineal));
        cuentakilometros.setReciente(df.format(distanciaRecorrida));
        cuentakilometros.setTotal(df.format(distanciaTotal));
        cuentarrevoluciones.setRevoluciones(df.format(velocidadAngular));
    }
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        velocidadAngular = revoluciones; 
        velocidadLineal = 2*Math.PI*RADIO*velocidadAngular*(60.0/1000.0);
        
        double avance = velocidadLineal/3600.0;
        distanciaRecorrida = distanciaRecorrida + avance;
        distanciaTotal = distanciaTotal + avance;
        
        return velocidadLineal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        panelCuentarrevoluciones = new javax.swing.JPanel();
        panelCuentakilometros = new javax.swing.JPanel();
        panelVelocimetro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 84));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVelocimetro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelCuentakilometros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCuentarrevoluciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelVelocimetro, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCuentakilometros, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCuentarrevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCuentakilometros;
    private javax.swing.JPanel panelCuentarrevoluciones;
    private javax.swing.JPanel panelVelocimetro;
    // End of variables declaration//GEN-END:variables
}
