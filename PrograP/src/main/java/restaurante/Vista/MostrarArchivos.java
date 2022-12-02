
package restaurante.Vista;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import restaurante.DAO.ArchivoDAO;
import restaurante.bean.Archivo;
import restaurante.conexion.Conexion;


public class MostrarArchivos extends javax.swing.JPanel {

    public MostrarArchivos() {
        initComponents();
        itemVerReservas();
    }

  
    
      void itemVerReservas(){     
         CBOBOLETAS.addItem("LISTAR POR FECHAS");
         CBOBOLETAS.addItem("LISTADO NORMAL");
         CBOBOLETAS.addItem("LISTADO DE BOLETAS DE HOY");
    }
    
     
     void listadoPorOpcion(){
         if(CBOBOLETAS.getSelectedIndex()==0){
             listarPedidosFecha();
         }
         if(CBOBOLETAS.getSelectedIndex()==1){
             listar();
         }
         if(CBOBOLETAS.getSelectedIndex()==2){
             listarHoy();
         }
     }
    
    void listar(){
       String c[]={"ID","NOMBRE","FECHA","TOTAL"};
        DefaultTableModel md = new DefaultTableModel(null , c);
       
        JTABLEARC.setModel(md);
      
        
        ArrayList<Archivo> lista=ArchivoDAO.listar();
        for(Archivo x : lista){
            md.addRow(new Object[]{x.getIdarchivo(),x.getNombre(),x.getFecha(),x.getTotal(),x.getFecha()});  
        }       
    }

    
    
    void listarPedidosFecha(){
         String c[]={"ID","NOMBRE","FECHA","TOTAL"};
         DefaultTableModel md = new DefaultTableModel(null , c);
       
        JTABLEARC.setModel(md);

        String fecha1=TXTFECHA1.getText();
        String fecha2=TXTFECHA2.getText();
        
        //agregar datos al modelo
        ArrayList<Archivo> lista = ArchivoDAO.listarPedidosFecha(fecha1 ,fecha2);
        for(Archivo x : lista){
            md.addRow(new Object[]{x.getIdarchivo(),x.getNombre(),x.getFecha(),x.getTotal(),x.getFecha()});  
        }   
    } 
    
    
    void listarHoy(){
       String c[]={"ID","NOMBRE","FECHA","TOTAL"};
         DefaultTableModel md = new DefaultTableModel(null , c);
       
        JTABLEARC.setModel(md);
      
        
        ArrayList<Archivo> lista=ArchivoDAO.listarReservaFechaHoy();
        for(Archivo x : lista){
            md.addRow(new Object[]{x.getIdarchivo(),x.getNombre(),x.getFecha(),x.getTotal(),x.getFecha()});  
        }       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLEARC = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TXTFECHA1 = new javax.swing.JTextField();
        TXTFECHA2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CBOBOLETAS = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTABLEARC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTABLEARC);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 530, 280));

        jButton1.setText("LISTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 130, 40));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione el metodo de listado:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 280, 30));
        jPanel1.add(TXTFECHA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, 30));
        jPanel1.add(TXTFECHA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 80, 30));

        jLabel2.setText("hasta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        CBOBOLETAS.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jPanel1.add(CBOBOLETAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 240, 30));

        jButton2.setText("GENERAR REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 180, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 890, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listadoPorOpcion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Connection cn = Conexion.abrir();
            JasperReport reporte= null;
            String path = "src\\main\\java\\restaurantReporte\\reporteArchivo.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint= JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view=new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
                    
            } catch (JRException ex) {
            Logger.getLogger(MostrarArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBOBOLETAS;
    private javax.swing.JTable JTABLEARC;
    private javax.swing.JTextField TXTFECHA1;
    private javax.swing.JTextField TXTFECHA2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
