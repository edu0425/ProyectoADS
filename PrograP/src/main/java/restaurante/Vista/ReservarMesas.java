
package restaurante.Vista;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import restaurante.DAO.ClienteDAO;
import restaurante.DAO.ReservaDAO;
import restaurante.bean.Cliente;
import restaurante.bean.Reserva;


public class ReservarMesas extends javax.swing.JPanel {

  
    public ReservarMesas() {
        initComponents();
        listar();
       
    }

    
    
     void listar(){
       String c[]={"ID","NOMBRE","N° PERSONAS","NUMERO","FECHA","HORA"};
        DefaultTableModel md = new DefaultTableModel(null , c);
        //asignar modelo a la tabla
        JTABLERESERVA.setModel(md);
        //capturar valro de el txt
        
        ArrayList<Reserva> lista=ReservaDAO.listar();
        for(Reserva x : lista){
            md.addRow(new Object[]{x.getIdreserva(),x.getNombre(),x.getNpersonas(),x.getNum(),x.getFecha(),x.getHora()});  
        }       
    }
     
     
    void seleccionar(){

       int reg = JTABLERESERVA.getSelectedRow();
       TXTID.setText(String.valueOf( JTABLERESERVA.getValueAt(reg,0)));  
       TXTNOMBRE.setText(String.valueOf(JTABLERESERVA.getValueAt(reg,1)));
       TXTNUMEROPER.setText(String.valueOf(JTABLERESERVA.getValueAt(reg,2)));
       TXTNUMCEL.setText(String.valueOf(JTABLERESERVA.getValueAt(reg,3)));
       TXTFECHA.setText(String.valueOf(JTABLERESERVA.getValueAt(reg,4)));
       TXTHORA.setText(String.valueOf(JTABLERESERVA.getValueAt(reg,5)));
       

    }
   
    
    void grabar(){

        //if( TXTN.getText().length()!=0 && TXTDES.getText().length()!=0 && TXTPRE.getText().length()!=0){
        
        
        String nombre = TXTNOMBRE.getText();
        int numero = Integer.parseInt(TXTNUMCEL.getText());
        
        Cliente c = new Cliente(nombre, numero);
        ClienteDAO.insertar(c);
        
        
        Cliente cli = ClienteDAO.buscarClienteNombre(nombre);     
        int idnombre = cli.getIdcliente();
        int npersonas = Integer.parseInt(TXTNUMEROPER.getText());
        String fecha =  TXTFECHA.getText();
        String hora = TXTHORA.getText();
        Reserva rese = new Reserva(npersonas, fecha, hora, idnombre);
        ReservaDAO.insertar(rese);
        listar();
        nuevo();
        
    }
    
    
    
    void modificar(){
        
       Cliente c = new Cliente();
       int reg = JTABLERESERVA.getSelectedRow();
       String nombreA = String.valueOf(JTABLERESERVA.getValueAt(reg,1));
       Cliente cli = ClienteDAO.buscarClienteNombre(nombreA);
       String nom = TXTNOMBRE.getText();
       int num = Integer.parseInt(TXTNUMCEL.getText());
       int idnombre = cli.getIdcliente();
       
       c.setNombre(nom);
       c.setNumero(num);
       c.setIdcliente(idnombre);
       
       ClienteDAO.modificar(c);
        
      
        int npersonas = Integer.parseInt(TXTNUMEROPER.getText());
        String fecha =  TXTFECHA.getText();
        String hora = TXTHORA.getText();
        
        Reserva re = new Reserva(npersonas, fecha, hora, idnombre);
        re.setIdreserva(Integer.parseInt(TXTID.getText()));
        ReservaDAO.modificar(re);
        listar();
        nuevo();
    }
    
    void eliminar(){
        ReservaDAO.eliminar(Integer.parseInt(TXTID.getText()));
        String nombre = TXTNOMBRE.getText();
        Cliente cli = ClienteDAO.buscarClienteNombre(nombre);
        int idnombre = cli.getIdcliente();
        ClienteDAO.eliminar(idnombre);
        listar();
        nuevo();
    }
    
    void instarFecha(){
    String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
    String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
    String fecha = (year + "-" + mes+ "-" + dia);
    TXTFECHA.setText(fecha);
    }
    
    void nuevo(){   
        TXTID.setText("");
        TXTNOMBRE.setText("");
        TXTNUMEROPER.setText("");
        TXTNUMCEL.setText("");
        TXTFECHA.setText("");
        TXTHORA.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TXTNOMBRE = new javax.swing.JTextField();
        TXTNUMEROPER = new javax.swing.JTextField();
        TXTNUMCEL = new javax.swing.JTextField();
        TXTFECHA = new javax.swing.JTextField();
        TXTHORA = new javax.swing.JTextField();
        BTNREGISTRAR = new javax.swing.JButton();
        BTNMODIFICAR = new javax.swing.JButton();
        BTNELIMINAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLERESERVA = new javax.swing.JTable();
        TXTID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jdt = new com.toedter.calendar.JDateChooser();
        btnGrabarFecha = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(TXTNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 170, 30));
        jPanel1.add(TXTNUMEROPER, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 50, 30));

        TXTNUMCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTNUMCELActionPerformed(evt);
            }
        });
        jPanel1.add(TXTNUMCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 120, 30));

        TXTFECHA.setEnabled(false);
        jPanel1.add(TXTFECHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 90, 30));
        jPanel1.add(TXTHORA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 70, 30));

        BTNREGISTRAR.setText("REGISTRAR");
        BTNREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREGISTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 100, 40));

        BTNMODIFICAR.setText("MODIFICAR");
        BTNMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMODIFICARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNMODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 100, 40));

        BTNELIMINAR.setText("ELIMINAR");
        BTNELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNELIMINARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 90, 40));

        JTABLERESERVA.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLERESERVA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLERESERVAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLERESERVA);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 590, 230));

        TXTID.setEnabled(false);
        jPanel1.add(TXTID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, 30));

        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 100, 40));

        jLabel12.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel12.setText("Hora");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel13.setText("Ingrese Datos del Usuario");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel14.setText("ID Reserva");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel15.setText("Nombre");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel16.setText("N° de Personas");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel17.setText("Numero de Celular");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel18.setText("Fecha");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdtMouseClicked(evt);
            }
        });
        jPanel1.add(jdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 120, 30));

        btnGrabarFecha.setText("GrabarFecha");
        btnGrabarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarFechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrabarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 940, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void TXTNUMCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTNUMCELActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTNUMCELActionPerformed

    private void JTABLERESERVAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLERESERVAMouseClicked
        seleccionar();
    }//GEN-LAST:event_JTABLERESERVAMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTNREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREGISTRARActionPerformed
         grabar();
    }//GEN-LAST:event_BTNREGISTRARActionPerformed

    private void BTNELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNELIMINARActionPerformed
        eliminar();
    }//GEN-LAST:event_BTNELIMINARActionPerformed

    private void BTNMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMODIFICARActionPerformed
        modificar();
    }//GEN-LAST:event_BTNMODIFICARActionPerformed

    private void jdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdtMouseClicked
    
    }//GEN-LAST:event_jdtMouseClicked

    private void btnGrabarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarFechaActionPerformed
     instarFecha();
    }//GEN-LAST:event_btnGrabarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNELIMINAR;
    private javax.swing.JButton BTNMODIFICAR;
    private javax.swing.JButton BTNREGISTRAR;
    private javax.swing.JTable JTABLERESERVA;
    private javax.swing.JTextField TXTFECHA;
    private javax.swing.JTextField TXTHORA;
    private javax.swing.JTextField TXTID;
    private javax.swing.JTextField TXTNOMBRE;
    private javax.swing.JTextField TXTNUMCEL;
    private javax.swing.JTextField TXTNUMEROPER;
    private javax.swing.JButton btnGrabarFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdt;
    // End of variables declaration//GEN-END:variables
}
