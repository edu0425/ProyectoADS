
package restaurante.Vista;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import restaurante.DAO.ReservaDAO;
import restaurante.bean.Reserva;

public class MostrarReservas extends javax.swing.JPanel {

   
    public MostrarReservas() {
        initComponents();
        itemVerReservas();
    }
    
    void instarFecha1(){
    String dia = Integer.toString(jdt1.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jdt1.getCalendar().get(Calendar.MONTH) + 1);
    String year = Integer.toString(jdt1.getCalendar().get(Calendar.YEAR));
    String fecha = (year + "-" + mes+ "-" + dia);
    TXTFECHA1.setText(fecha);
    }
    
    void instarFecha2(){
    String dia = Integer.toString(jdt2.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jdt2.getCalendar().get(Calendar.MONTH) + 1);
    String year = Integer.toString(jdt2.getCalendar().get(Calendar.YEAR));
    String fecha = (year + "-" + mes+ "-" + dia);
    TXTFECHA2.setText(fecha);
    }
    
     void itemVerReservas(){     
         CBOLISTADO.addItem("LISTAR POR FECHAS");
         CBOLISTADO.addItem("LISTADO NORMAL");
         CBOLISTADO.addItem("LISTADO DE RESERVAS PARA HOY");
    }
    
     
     void listadoPorOpcion(){
         if(CBOLISTADO.getSelectedIndex()==0){
             listarPedidosFecha();
         }
         if(CBOLISTADO.getSelectedIndex()==1){
             listar();
         }
         if(CBOLISTADO.getSelectedIndex()==2){
             listarHoy();
         }
     }
    
    void listar(){
       String c[]={"ID","NOMBRE","N° PERSONAS","NUMERO","FECHA","HORA"};
        DefaultTableModel md = new DefaultTableModel(null , c);
       
        JTABLERESERVAS.setModel(md);
      
        
        ArrayList<Reserva> lista=ReservaDAO.listar();
        for(Reserva x : lista){
            md.addRow(new Object[]{x.getIdreserva(),x.getNombre(),x.getNpersonas(),x.getNum(),x.getFecha(),x.getHora()});  
        }       
    }

    
    
    void listarPedidosFecha(){
         String c[]={"ID","NOMBRE","N° PERSONAS","NUMERO","FECHA","HORA"};
        DefaultTableModel md = new DefaultTableModel(null , c);
     
        JTABLERESERVAS.setModel(md);
        instarFecha1();
        instarFecha2();
        
        String fecha1=TXTFECHA1.getText();
        String fecha2=TXTFECHA2.getText();
        
        //agregar datos al modelo
        ArrayList<Reserva> lista = ReservaDAO.listarPedidosFecha(fecha1 ,fecha2);
        for(Reserva x : lista){
            md.addRow(new Object[]{x.getIdreserva(),x.getNombre(),x.getNpersonas(),x.getNum(),x.getFecha(),x.getHora()});
         }
    } 
    
    
    void listarHoy(){
       String c[]={"ID","NOMBRE","N° PERSONAS","NUMERO","FECHA","HORA"};
        DefaultTableModel md = new DefaultTableModel(null , c);
       
        JTABLERESERVAS.setModel(md);
      
        
        ArrayList<Reserva> lista=ReservaDAO.listarReservaFechaHoy();
        for(Reserva x : lista){
            md.addRow(new Object[]{x.getIdreserva(),x.getNombre(),x.getNpersonas(),x.getNum(),x.getFecha(),x.getHora()});  
        }       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLERESERVAS = new javax.swing.JTable();
        BTNLISTAR = new javax.swing.JButton();
        TXTFECHA1 = new javax.swing.JTextField();
        TXTFECHA2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CBOLISTADO = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jdt2 = new com.toedter.calendar.JDateChooser();
        jdt1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTABLERESERVAS.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTABLERESERVAS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 530, 280));

        BTNLISTAR.setText("LISTAR");
        BTNLISTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNLISTARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNLISTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 130, 40));
        jPanel1.add(TXTFECHA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 20, 30));
        jPanel1.add(TXTFECHA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 20, 30));

        jLabel2.setText("hasta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        CBOLISTADO.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jPanel1.add(CBOLISTADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 220, 30));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel3.setText("Seleccione el metodo de listado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 280, 30));

        jdt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdt2MouseClicked(evt);
            }
        });
        jPanel1.add(jdt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 120, 30));

        jdt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdt1MouseClicked(evt);
            }
        });
        jPanel1.add(jdt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 890, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void BTNLISTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNLISTARActionPerformed
        
        
        listadoPorOpcion();
    }//GEN-LAST:event_BTNLISTARActionPerformed

    private void jdt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdt2MouseClicked

    }//GEN-LAST:event_jdt2MouseClicked

    private void jdt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdt1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jdt1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNLISTAR;
    private javax.swing.JComboBox<String> CBOLISTADO;
    private javax.swing.JTable JTABLERESERVAS;
    private javax.swing.JTextField TXTFECHA1;
    private javax.swing.JTextField TXTFECHA2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdt1;
    private com.toedter.calendar.JDateChooser jdt2;
    // End of variables declaration//GEN-END:variables
}
