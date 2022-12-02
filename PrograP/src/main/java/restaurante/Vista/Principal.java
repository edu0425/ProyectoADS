
package restaurante.Vista;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {
    //LLAMAR A LOS PANELES
     PanelEmitirBoleta panelemitir = new PanelEmitirBoleta();
     PanelInicio panelinicio = new PanelInicio();
     MostrarArchivos panelarchivos = new MostrarArchivos();
     ReservarMesas panelreserva = new ReservarMesas();
     MostrarReservas mostrarreserva= new MostrarReservas();
    
   JPanel panelsiguiente = new JPanel();
   JPanel panelactual = new JPanel();
    
    
    public Principal() {
        initComponents();
        diseño();
        this.inicio();
    }

    
    public void agregar(){
        addPanel(panelemitir);     
    }
    
     public void inicio(){
        addPanel(panelinicio);
      
    }
     
     public void archivo(){
        addPanel(panelarchivos);
      
    }
     
      public void reserva(){
        addPanel(panelreserva);
      
    }
      
       public void mostrarreserva(){
        addPanel(mostrarreserva);
      
    }
    
     public void setPanelSiguiente(JPanel panelsiguiente) {
        this.panelsiguiente  = panelsiguiente ;
    }

    public void setPanelActual(JPanel panelactual) {
        this.panelactual = panelactual;
    }
    
    public void addPanel(JPanel panel){
        this.setPanelSiguiente(panel);
        panelactual.setVisible(false);
        panelsiguiente.setVisible(true);
        PanelOperaciones.remove(panelactual);
        PanelOperaciones.add(panelsiguiente);
        
        PanelOperaciones.validate();
        this.setPanelActual(panel);
    }
    
     //IMAGENES DEL FRAME 
    void diseño(){
        LBLLOGO.setIcon(new ImageIcon("src/main/java/img/LOGO_1.png"));
        btninicio.setIcon(new ImageIcon("src/main/java/img/incio_oscuro.jpg"));
        btninicio.setRolloverIcon(new ImageIcon("src/main/java/img/inicio_claro.jpg"));
        
        BTNEMITIRBOLETA.setIcon(new ImageIcon("src/main/java/img/oscuro.jpg"));
        BTNEMITIRBOLETA.setRolloverIcon(new ImageIcon("src/main/java/img/claro.jpg"));
        
        BTNMOSTRARARCHIVOS.setIcon(new ImageIcon("src/main/java/img/mostrar.jpg"));
        BTNMOSTRARARCHIVOS.setRolloverIcon(new ImageIcon("src/main/java/img/mostrarc.jpg"));
        
        BTNRESERVARMESAS.setIcon(new ImageIcon("src/main/java/img/reserva.jpg"));
        BTNRESERVARMESAS.setRolloverIcon(new ImageIcon("src/main/java/img/reservac.jpg"));
        
        BTNMOSTRARRESERVAS.setIcon(new ImageIcon("src/main/java/img/mostrarmesa.jpg"));
        BTNMOSTRARRESERVAS.setRolloverIcon(new ImageIcon("src/main/java/img/mostrarmesac.jpg"));
        LOGO2.setIcon(new ImageIcon("src/main/java/img/logoenca.png"));
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelOperaciones = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        LBLLOGO = new javax.swing.JLabel();
        LOGO2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btninicio = new javax.swing.JButton();
        BTNEMITIRBOLETA = new javax.swing.JButton();
        BTNMOSTRARARCHIVOS = new javax.swing.JButton();
        BTNRESERVARMESAS = new javax.swing.JButton();
        BTNMOSTRARRESERVAS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelOperaciones.setBackground(new java.awt.Color(153, 255, 255));
        PanelOperaciones.setLayout(new java.awt.BorderLayout());
        getContentPane().add(PanelOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 980, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(LBLLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 250, 140));
        jPanel2.add(LOGO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 700, 120));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 120));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninicio.setSelected(true);
        btninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninicioActionPerformed(evt);
            }
        });
        jPanel1.add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 60));

        BTNEMITIRBOLETA.setBackground(new java.awt.Color(51, 51, 51));
        BTNEMITIRBOLETA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEMITIRBOLETAActionPerformed(evt);
            }
        });
        jPanel1.add(BTNEMITIRBOLETA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 170, 60));

        BTNMOSTRARARCHIVOS.setBackground(new java.awt.Color(51, 51, 51));
        BTNMOSTRARARCHIVOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMOSTRARARCHIVOSActionPerformed(evt);
            }
        });
        jPanel1.add(BTNMOSTRARARCHIVOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 170, 60));

        BTNRESERVARMESAS.setBackground(new java.awt.Color(51, 51, 51));
        BTNRESERVARMESAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRESERVARMESASActionPerformed(evt);
            }
        });
        jPanel1.add(BTNRESERVARMESAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 170, 60));

        BTNMOSTRARRESERVAS.setBackground(new java.awt.Color(51, 51, 51));
        BTNMOSTRARRESERVAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMOSTRARRESERVASActionPerformed(evt);
            }
        });
        jPanel1.add(BTNMOSTRARRESERVAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 170, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 980, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninicioActionPerformed
        inicio();
    }//GEN-LAST:event_btninicioActionPerformed

    private void BTNEMITIRBOLETAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEMITIRBOLETAActionPerformed
        agregar();

    }//GEN-LAST:event_BTNEMITIRBOLETAActionPerformed

    private void BTNMOSTRARRESERVASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMOSTRARRESERVASActionPerformed
        mostrarreserva();
    }//GEN-LAST:event_BTNMOSTRARRESERVASActionPerformed

    private void BTNMOSTRARARCHIVOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMOSTRARARCHIVOSActionPerformed
        archivo();
    }//GEN-LAST:event_BTNMOSTRARARCHIVOSActionPerformed

    private void BTNRESERVARMESASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRESERVARMESASActionPerformed
        reserva();
    }//GEN-LAST:event_BTNRESERVARMESASActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNEMITIRBOLETA;
    private javax.swing.JButton BTNMOSTRARARCHIVOS;
    private javax.swing.JButton BTNMOSTRARRESERVAS;
    private javax.swing.JButton BTNRESERVARMESAS;
    private javax.swing.JLabel LBLLOGO;
    private javax.swing.JLabel LOGO2;
    private javax.swing.JDesktopPane PanelOperaciones;
    private javax.swing.JButton btninicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
