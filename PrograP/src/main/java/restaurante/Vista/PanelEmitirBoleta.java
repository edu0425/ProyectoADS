
package restaurante.Vista;

import com.mysql.cj.xdevapi.Client;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import restaurante.DAO.ArchivoDAO;
import restaurante.DAO.BoletaDAO;
import restaurante.DAO.ClienteDAO;
import restaurante.DAO.ElementoDAO;
import restaurante.bean.Archivo;
import restaurante.bean.Boleta;
import restaurante.bean.Cliente;
import restaurante.bean.Elemento;
import java.awt.*;
import java.awt.print.*;

public class PanelEmitirBoleta extends javax.swing.JPanel implements Printable {

    ArrayList<Boleta> bol= new ArrayList<>();
    ArrayList<Elemento> lista= new ArrayList<>();
    Boleta bo=new Boleta();
    Elemento el = new Elemento();
    Archivo ar = new Archivo();
    
    public PanelEmitirBoleta() {
        initComponents();
        itemVerElemento();
        numPedido();
        obtenerFecha();
    }
    
    
    void numPedido(){
        ar =  ArchivoDAO.buscarPedidoMax();
        TXTBOLETA.setText(String.valueOf(ar.getIdarchivo()+1));
    }
    
    
    void obtenerFecha(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        TXTFECHA.setText(timeStamp);
    }

    
    void seleccionarcomida(){
        switch(cbocomida.getSelectedIndex()){
           
            case 0: lblcomida.setIcon(new ImageIcon("src/main/java/img/menu_marino.jpg")); break;
            case 1: lblcomida.setIcon(new ImageIcon("src/main/java/img/menu_criollo.jpg"));;break;
            case 2: lblcomida.setIcon(new ImageIcon("src/main/java/img/leche_de_tigre.jpg"));break;
            case 3: lblcomida.setIcon(new ImageIcon("src/main/java/img/choritos.jpg"));  break;
            case 4: lblcomida.setIcon(new ImageIcon("src/main/java/img/ceviche.jpg"));break;
            case 5: lblcomida.setIcon(new ImageIcon("src/main/java/img/chicharron.jpg"));break;
            case 6: lblcomida.setIcon(new ImageIcon("src/main/java/img/mariscos.jpg"));break;
            case 7: lblcomida.setIcon(new ImageIcon("src/main/java/img/chupe2.jpg")); break;
            case 8: lblcomida.setIcon(new ImageIcon("src/main/java/img/jalea.jpg")) ; break;
            case 9: lblcomida.setIcon(new ImageIcon("src/main/java/img/tiradito.jpg")) ; break;
            case 10: lblcomida.setIcon(new ImageIcon("src/main/java/img/lomo2.jpg")) ; break;
            case 11: lblcomida.setIcon(new ImageIcon("src/main/java/img/bisteck.jpg")); break;
            case 12: lblcomida.setIcon(new ImageIcon("src/main/java/img/chaufa.jpg")) ; break;
            
        }            
    }
    
    void seleccionarbebida(){
         switch(cbobebida.getSelectedIndex()){
           
            case 0: lblbebida.setIcon(new ImageIcon("src/main/java/img/chicha.jpg")); break;
            case 1: lblbebida.setIcon(new ImageIcon("src/main/java/img/maracuya.jpg"));break;
            case 2: lblbebida.setIcon(new ImageIcon("src/main/java/img/limonada.jpg"));break;
            case 3: lblbebida.setIcon(new ImageIcon("src/main/java/img/gaseosa_1.5_.jpg"));break;
            case 4: lblbebida.setIcon(new ImageIcon("src/main/java/img/gaseosa_0.5_.jpg"));break;
            case 5: lblbebida.setIcon(new ImageIcon("src/main/java/img/pilsen.jpg"));break;
            case 6: lblbebida.setIcon(new ImageIcon("src/main/java/img/cusquena_2.jpg")) ; break;
        }
    }
    
    
    void itemVerElemento(){
         ArrayList<Elemento> lista=ElementoDAO.listar();
               for(Elemento x : lista){
                    if(x.getIdelemento() < 14 ){
                    cbocomida.addItem(x.getElemento());
                    }else{
                    cbobebida.addItem(x.getElemento());
                    }    
         }
      
    }
   
    
    
    int seleccionarElementoComida(){
        ArrayList<Elemento> lis = ElementoDAO.listarIDelemento();
        int v=0;    
        for (int i = 0 ; i <14 ; i++){
                if(cbocomida.getSelectedIndex()== i){           
                     v = lis.get(i).getIdelemento();
               
                }   
               
                
            } 
            return v;
        }
    
     int seleccionarElementoBebida(){
        ArrayList<Elemento> lis = ElementoDAO.listarIDelemento();
        int v=0;    
        for (int i = 0 ; i <20 ; i++){
                 if(cbobebida.getSelectedIndex()+ 13 ==i){
                     v = lis.get(i).getIdelemento();
                     System.out.println(v);
                }  
               
                
            } 
            return v;
     }
            

    
    void agregar(){
        
       
        int contadorTotal= 0;

        String col[]={"ID","NOMBRE","CANTIDAD","PRECIO","SUBTOTAL"};
        DefaultTableModel modeloTabla=new DefaultTableModel(null, col);
        //Asignar modelo a la tabla
        tablaboleta.setModel(modeloTabla);
       
      
        if( bol.size()>0){
            
            for (int i = 0; i < bol.size() ; i++) {
  
            Boleta bo = obtener(i); 
            modeloTabla.addRow(new Object[]{bo.getIdelemento(),bo.getNomelemento(),bo.getCantidad(),bo.getPrecio(),bo.getSubtotal()});  
                    contadorTotal=(int) (contadorTotal+bo.getSubtotal());
                    bo.setPrecioSuma(contadorTotal);
            }

        } 

        lblpreciototal.setText(String.valueOf(bo.getPrecioSuma()));
    }
    
    
    void AgregarComidaTabla(){
        
        Elemento li= ElementoDAO.ListarelementoID(seleccionarElementoComida());
 
        String eleme =  li.getElemento();
        int can = Integer.parseInt(txtcantidadco.getText());
        int precio = li.getPrecio();
 
        int preTo = can * precio;

        bo=new Boleta( seleccionarElementoComida(), eleme ,can, precio, preTo );
       
        adicionar(bo);
       agregar();
       txtcantidadco.setText("");
        
    }
    
    
     void AgregarBebidaTabla(){
        
        Elemento li= ElementoDAO.ListarelementoID(seleccionarElementoBebida());
 
        String eleme = li.getElemento();
        int can = Integer.parseInt(txtcantidadbe.getText());
        int precio = li.getPrecio();
 
        int preTo = can * precio;
        
        
        bo=new Boleta( seleccionarElementoBebida(), eleme ,can, precio, preTo );
       
        adicionar(bo);
        agregar();
        txtcantidadbe.setText("");
        
    }
     
     
    void eliminar(){
        
        int reg = tablaboleta.getSelectedRow();
        
        
        Double num = (Double) tablaboleta.getValueAt(reg,4);
        Double Total= Double.parseDouble(lblpreciototal.getText());
        eliminarPos(reg);

        String col[]={"ID","NOMBRE","CANTIDAD","PRECIO","SUBTOTAL"};
        DefaultTableModel modeloTabla=new DefaultTableModel(null, col);
        //Asignar modelo a la tabla
        tablaboleta.setModel(modeloTabla);
       
        //listar
        if( bol.size()>0){
            
            for (int i = 0; i < bol.size() ; i++) {
  
            Boleta bo = obtener(i); 
            modeloTabla.addRow(new Object[]{bo.getIdelemento(),bo.getNomelemento(),bo.getCantidad(),bo.getPrecio(),bo.getSubtotal()});            
            }
            Total = Total - num ;  
            bo.setPrecioFinal(Total);
        } 
        
        lblpreciototal.setText(String.valueOf(bo.getPrecioFinal()));
     
    } 
     
     
     public void eliminarPos(int pos) {
        bol.remove(pos);
    }
     
     void adicionar(Boleta x){
        bol.add(x);
    }
     
     Boleta obtener(int pos){

        return bol.get(pos);
    }
    
    
      void agregarPedidoBoleta(){
         
       for(int i = 0 ; i < tablaboleta.getRowCount() ; i++){
           bo.setIdelemento((int) tablaboleta.getValueAt(i,0));
           bo.setIdarchivo(Integer.parseInt(TXTBOLETA.getText()));
           bo.setCantidad((int) tablaboleta.getValueAt(i,2));
           bo.setPrecio((Double) tablaboleta.getValueAt(i,3));
           bo.setSubtotal((Double) tablaboleta.getValueAt(i,4));
           
          BoletaDAO.AgregarPedidoBoleta(bo);
 
       }  
 
     }
     
   void agregarPedidoArchivo(){
       String nombrecli = TXTNOMBRECLI.getText(); 
       int num = 0;
       Cliente cl = new Cliente(nombrecli,num);
       ClienteDAO.registrarNombre(cl);
       cl = ClienteDAO.buscarClienteNombre(nombrecli);
       ar = new Archivo( TXTFECHA.getText(), Double.parseDouble(lblpreciototal.getText()) , cl.getIdcliente() );
        ArchivoDAO.AgregarArchivo(ar);
   }
     
     
    void nuevoPedido(){  
       
        TXTNOMBRECLI.setText("");
        lblpreciototal.setText("");
        bol.clear();
        
        String col[]={"ID","NOMBRE","CANTIDAD","PRECIO","SUBTOTAL"};
        DefaultTableModel modeloTabla=new DefaultTableModel(null, col);
        tablaboleta.setModel(modeloTabla);
         for (int i = 0; i < bol.size() ; i++) {
            modeloTabla.addRow(new Object[]{bo.getIdelemento(),bo.getNomelemento(),bo.getCantidad(),bo.getPrecio(),bo.getSubtotal()});  
            }
        
        }  
     
     
     void mensaje(String msg){
        JOptionPane.showMessageDialog( this, msg);
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaboleta = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblpreciototal = new javax.swing.JLabel();
        TXTBOLETA = new javax.swing.JTextField();
        TXTNOMBRECLI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXTFECHA = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblcomida = new javax.swing.JLabel();
        lblbebida = new javax.swing.JLabel();
        cbocomida = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbobebida = new javax.swing.JComboBox<>();
        txtcantidadco = new javax.swing.JTextField();
        txtcantidadbe = new javax.swing.JTextField();
        BTNAGREGAR = new javax.swing.JButton();
        BTNAGREGAR1 = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        btnregboleta = new javax.swing.JButton();
        BTNELIMINAR1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaboleta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANTIDAD", "DESCRIPCION", "PRECIO UNITARIO", "PRECIO TOTAL"
            }
        ));
        tablaboleta.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tablaboleta);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 530, 130));

        jLabel14.setText("NOMBRE DE CLIENTE");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 30));

        jLabel15.setText("NUMERO DE BOLETA");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 130, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("RUC        10748917921");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 170, 30));

        jLabel1.setText("TOTAL");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));
        jPanel5.add(lblpreciototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 100, 20));
        jPanel5.add(TXTBOLETA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 90, -1));
        jPanel5.add(TXTNOMBRECLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 380, 30));

        jLabel2.setText("Fecha");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));
        jPanel5.add(TXTFECHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 90, -1));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 530, 320));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblcomida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 180));
        jPanel1.add(lblbebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 180));

        cbocomida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbocomidaItemStateChanged(evt);
            }
        });
        cbocomida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocomidaActionPerformed(evt);
            }
        });
        jPanel1.add(cbocomida, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 230, 40));

        jLabel3.setText("DIGITE LA CANTIDAD DE BEBIDAS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        jLabel4.setText("DIGITE LA CANTIDAD DEL PLATILLO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        cbobebida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobebidaItemStateChanged(evt);
            }
        });
        jPanel1.add(cbobebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 220, 40));
        jPanel1.add(txtcantidadco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 100, 30));
        jPanel1.add(txtcantidadbe, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 100, 30));

        BTNAGREGAR.setText("AÑADIR");
        BTNAGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAGREGARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNAGREGAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 100, 30));

        BTNAGREGAR1.setText("AÑADIR");
        BTNAGREGAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAGREGAR1ActionPerformed(evt);
            }
        });
        jPanel1.add(BTNAGREGAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 100, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 380));

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 100, 30));

        btnregboleta.setText("REGISTRAR BOLETA");
        btnregboleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregboletaActionPerformed(evt);
            }
        });
        add(btnregboleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 150, 40));

        BTNELIMINAR1.setText("QUITAR");
        BTNELIMINAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNELIMINAR1ActionPerformed(evt);
            }
        });
        add(BTNELIMINAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 100, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnregboletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregboletaActionPerformed
        agregarPedidoArchivo();
        agregarPedidoBoleta();
        numPedido();
        nuevoPedido();
    }//GEN-LAST:event_btnregboletaActionPerformed

    private void cbocomidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbocomidaItemStateChanged
       seleccionarcomida();
    }//GEN-LAST:event_cbocomidaItemStateChanged

    private void cbocomidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocomidaActionPerformed

    }//GEN-LAST:event_cbocomidaActionPerformed

    private void cbobebidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobebidaItemStateChanged
         seleccionarbebida();
    }//GEN-LAST:event_cbobebidaItemStateChanged

    private void BTNAGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAGREGARActionPerformed
          
           if(txtcantidadbe.getText() != null ){
               AgregarBebidaTabla();
            }
    }//GEN-LAST:event_BTNAGREGARActionPerformed

    private void BTNAGREGAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAGREGAR1ActionPerformed
         if(txtcantidadco.getText() != null){
             AgregarComidaTabla();;
         }
    }//GEN-LAST:event_BTNAGREGAR1ActionPerformed

    private void BTNELIMINAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNELIMINAR1ActionPerformed
        eliminar();
    }//GEN-LAST:event_BTNELIMINAR1ActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
    try{
        PrinterJob gap = PrinterJob.getPrinterJob();
        gap.setPrintable(this);
        boolean top = gap.printDialog();
        if(top)
        {
            gap.print();
        }
    }
    catch(PrinterException pex){
         mensaje("Error del programa");
    }   
    }//GEN-LAST:event_btnimprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAGREGAR;
    private javax.swing.JButton BTNAGREGAR1;
    private javax.swing.JButton BTNELIMINAR1;
    private javax.swing.JTextField TXTBOLETA;
    private javax.swing.JTextField TXTFECHA;
    private javax.swing.JTextField TXTNOMBRECLI;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnregboleta;
    private javax.swing.JComboBox<String> cbobebida;
    private javax.swing.JComboBox<String> cbocomida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbebida;
    private javax.swing.JLabel lblcomida;
    private javax.swing.JLabel lblpreciototal;
    private javax.swing.JTable tablaboleta;
    private javax.swing.JTextField txtcantidadbe;
    private javax.swing.JTextField txtcantidadco;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException {
    if(index>0)
    {
        return NO_SUCH_PAGE;
    }
    Graphics2D hub = (Graphics2D) graf;
    hub.translate(pagfor.getImageableX() + 30, pagfor.getImageableY() +30);
    hub.scale(1.0, 1.0);
    
    jPanel5.printAll(graf);
    return PAGE_EXISTS;
    }
}
