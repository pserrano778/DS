package Temperatura;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class Mapa extends javax.swing.JFrame implements Observer{
    private Interfaz interfazMedicion;
    private ArrayList<Temperatura> temperaturasZonas;
    public Mapa(ArrayList<Temperatura> temperaturas) {
        initComponents();
        temperaturasZonas = temperaturas;
        
        interfazMedicion = new Interfaz(temperaturasZonas.get(0), nombreZona1.getText());   
        setTitle("Mapa de Sinnoh");
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg){
        if (arg instanceof Float){
            int zona = -1;
            for (int i=0; i<temperaturasZonas.size() && zona==(-1); i++){          
                if (temperaturasZonas.get(i).equals(o)){
                    zona = i;
                }
            }

            if (zona==0){
                temperaturaZona1.setText(String.valueOf(arg) + " ºC");
            } else if(zona==1){
                temperaturaZona2.setText(String.valueOf(arg) + " ºC");
            } else if(zona==2){
                temperaturaZona3.setText(String.valueOf(arg) + " ºC");
            } else if(zona==3){
                temperaturaZona4.setText(String.valueOf(arg) + " ºC");
            } else if(zona==4){
                temperaturaZona5.setText(String.valueOf(arg) + " ºC");
            } else if(zona==5){
                temperaturaZona6.setText(String.valueOf(arg) + " ºC");
            } else if(zona==6){
                temperaturaZona7.setText(String.valueOf(arg) + " ºC");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zona1 = new javax.swing.JLabel();
        nombreZona1 = new javax.swing.JLabel();
        temperaturaZona1 = new javax.swing.JLabel();
        zona2 = new javax.swing.JLabel();
        nombreZona2 = new javax.swing.JLabel();
        temperaturaZona2 = new javax.swing.JLabel();
        zona3 = new javax.swing.JLabel();
        nombreZona3 = new javax.swing.JLabel();
        temperaturaZona3 = new javax.swing.JLabel();
        zona4 = new javax.swing.JLabel();
        nombreZona4 = new javax.swing.JLabel();
        temperaturaZona4 = new javax.swing.JLabel();
        zona5 = new javax.swing.JLabel();
        nombreZona5 = new javax.swing.JLabel();
        temperaturaZona5 = new javax.swing.JLabel();
        zona6 = new javax.swing.JLabel();
        nombreZona6 = new javax.swing.JLabel();
        temperaturaZona6 = new javax.swing.JLabel();
        zona7 = new javax.swing.JLabel();
        nombreZona7 = new javax.swing.JLabel();
        temperaturaZona7 = new javax.swing.JLabel();
        mapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 842));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        zona1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona1MouseClicked(evt);
            }
        });
        getContentPane().add(zona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 360, 240));

        nombreZona1.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona1.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona1.setText("Ciudad Puntaneva");
        nombreZona1.setOpaque(true);
        getContentPane().add(nombreZona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, 30));

        temperaturaZona1.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona1.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona1.setOpaque(true);
        getContentPane().add(temperaturaZona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 120, -1, 20));

        zona2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona2MouseClicked(evt);
            }
        });
        getContentPane().add(zona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 400, 290));

        nombreZona2.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona2.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona2.setText("Ciudad Jubileo");
        nombreZona2.setOpaque(true);
        getContentPane().add(nombreZona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 670, -1, 30));

        temperaturaZona2.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona2.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona2.setOpaque(true);
        getContentPane().add(temperaturaZona2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 700, -1, 20));

        zona3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona3MouseClicked(evt);
            }
        });
        getContentPane().add(zona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 320, 230));

        nombreZona3.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona3.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona3.setText("Ciudad Vetusta");
        nombreZona3.setOpaque(true);
        getContentPane().add(nombreZona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, 30));

        temperaturaZona3.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona3.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona3.setOpaque(true);
        getContentPane().add(temperaturaZona3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 430, -1, 20));

        zona4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona4MouseClicked(evt);
            }
        });
        getContentPane().add(zona4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 340, 280));

        nombreZona4.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona4.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreZona4.setText("Bahía Gresca");
        nombreZona4.setOpaque(true);
        getContentPane().add(nombreZona4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, -1, 30));

        temperaturaZona4.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona4.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona4.setOpaque(true);
        getContentPane().add(temperaturaZona4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, -1, 20));

        zona5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona5MouseClicked(evt);
            }
        });
        getContentPane().add(zona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 300, 300));

        nombreZona5.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona5.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona5.setText("Ciudad Pradera");
        nombreZona5.setOpaque(true);
        getContentPane().add(nombreZona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, -1, 30));

        temperaturaZona5.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona5.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona5.setOpaque(true);
        getContentPane().add(temperaturaZona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 590, -1, 20));

        zona6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona6MouseClicked(evt);
            }
        });
        getContentPane().add(zona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 320, 370));

        nombreZona6.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona6.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona6.setText("Ciudad Marina");
        nombreZona6.setOpaque(true);
        getContentPane().add(nombreZona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 510, -1, 30));

        temperaturaZona6.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona6.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona6.setOpaque(true);
        getContentPane().add(temperaturaZona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1062, 540, -1, 20));

        zona7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        zona7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zona7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zona7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zona7MouseClicked(evt);
            }
        });
        getContentPane().add(zona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 220, 110));

        nombreZona7.setBackground(new java.awt.Color(190, 190, 190));
        nombreZona7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nombreZona7.setForeground(new java.awt.Color(0, 0, 0));
        nombreZona7.setText("Pueblo Caelestis");
        nombreZona7.setOpaque(true);
        getContentPane().add(nombreZona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, 30));

        temperaturaZona7.setBackground(new java.awt.Color(190, 190, 190));
        temperaturaZona7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        temperaturaZona7.setForeground(new java.awt.Color(0, 0, 0));
        temperaturaZona7.setOpaque(true);
        getContentPane().add(temperaturaZona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 400, -1, 20));

        mapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Sinnoh.jpg"))); // NOI18N
        mapa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zona1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona1MouseClicked
        setZona(0, nombreZona1);
    }//GEN-LAST:event_zona1MouseClicked

    private void zona2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona2MouseClicked
        setZona(1, nombreZona2);
    }//GEN-LAST:event_zona2MouseClicked

    private void zona3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona3MouseClicked
        setZona(2, nombreZona3);
    }//GEN-LAST:event_zona3MouseClicked

    private void zona4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona4MouseClicked
        setZona(3, nombreZona4);
    }//GEN-LAST:event_zona4MouseClicked

    private void zona5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona5MouseClicked
        setZona(4, nombreZona5);
    }//GEN-LAST:event_zona5MouseClicked

    private void zona6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona6MouseClicked
        setZona(5, nombreZona6);
    }//GEN-LAST:event_zona6MouseClicked

    private void zona7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zona7MouseClicked
        setZona(6, nombreZona7);
    }//GEN-LAST:event_zona7MouseClicked
     
    private void setZona(int indice, javax.swing.JLabel nombreZona){
        if (!(interfazMedicion.comparaObjetoTemperatura(temperaturasZonas.get(indice)))){
            interfazMedicion.setVisible(false);
            interfazMedicion.dispose();
            interfazMedicion = new Interfaz(temperaturasZonas.get(indice), nombreZona.getText()); 
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel mapa;
    private javax.swing.JLabel nombreZona1;
    private javax.swing.JLabel nombreZona2;
    private javax.swing.JLabel nombreZona3;
    private javax.swing.JLabel nombreZona4;
    private javax.swing.JLabel nombreZona5;
    private javax.swing.JLabel nombreZona6;
    private javax.swing.JLabel nombreZona7;
    private javax.swing.JLabel temperaturaZona1;
    private javax.swing.JLabel temperaturaZona2;
    private javax.swing.JLabel temperaturaZona3;
    private javax.swing.JLabel temperaturaZona4;
    private javax.swing.JLabel temperaturaZona5;
    private javax.swing.JLabel temperaturaZona6;
    private javax.swing.JLabel temperaturaZona7;
    private javax.swing.JLabel zona1;
    private javax.swing.JLabel zona2;
    private javax.swing.JLabel zona3;
    private javax.swing.JLabel zona4;
    private javax.swing.JLabel zona5;
    private javax.swing.JLabel zona6;
    private javax.swing.JLabel zona7;
    // End of variables declaration//GEN-END:variables
}
