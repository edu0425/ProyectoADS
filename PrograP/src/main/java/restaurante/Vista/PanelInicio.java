
package restaurante.Vista;

import javax.swing.ImageIcon;

public class PanelInicio extends javax.swing.JPanel {
     
    public PanelInicio() {
        initComponents();
        diseño();
    }

    
    
    void diseño(){
        LBLFONDO.setIcon(new ImageIcon("src/main/java/img/fondoreal.png"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLFONDO = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 167, 54));
        setPreferredSize(new java.awt.Dimension(980, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(LBLFONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 410));

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 410));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLFONDO;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
