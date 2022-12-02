
package restaurante.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.bean.Archivo;
import restaurante.bean.Cliente;
import restaurante.conexion.Conexion;

public class ArchivoDAO {
    public static Archivo buscarPedidoMax(){
        
       Archivo ar=null;

        String sql="SELECT MAX(idarchivo) AS idarchivo FROM archivo";

        Connection cn = Conexion.abrir();
        try {

            PreparedStatement stm = cn.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
 
            if(rs.next()){
                ar = new Archivo();
                ar.setIdarchivo(rs.getInt("idarchivo"));
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    
    
    
    public static void AgregarArchivo(Archivo ar){
        
        Connection cn = Conexion.abrir();
       
       try {
  
            CallableStatement cst= cn.prepareCall("{call archivoinsertar(?,?,?)}"); 
          
                cst.setString(1 ,ar.getFecha());
                cst.setDouble(2 ,ar.getTotal());
                cst.setInt(3 ,ar.getIdcliente());
              
                cst.executeUpdate();
            cn.close();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      
    
    
    public static ArrayList<Archivo> listar(){
      
        Archivo ar;
        Cliente c;
    
        ArrayList<Archivo> archivos= new ArrayList<>();
        
        String sql="SELECT a.* , c.nombre FROM archivo a, cliente c WHERE a.idcliente = c.idcliente ";
       
        Connection cn = Conexion.abrir();
        try {

            PreparedStatement stm = cn.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                ar = new Archivo();
                c = new Cliente();
                ar.setIdarchivo(rs.getInt("idarchivo"));
                ar.setFecha(rs.getString("fecha"));
                ar.setTotal(rs.getInt("total"));
                c.setNombre(rs.getString("nombre")); 
                ar.setNombre(c.getNombre());           
                archivos.add(ar);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return archivos;
    }
    
    
    
     
        public static ArrayList<Archivo> listarPedidosFecha(String fecha1, String fecha2) {
        Archivo ar;
        Cliente c;
        ArrayList<Archivo> archivos= new ArrayList<>();
 
        String sql="SELECT a.* , c.nombre , c.numero FROM archivo a, cliente c WHERE fecha BETWEEN ? AND ? AND c.idcliente = a.idcliente ";
       
        Connection cn = Conexion.abrir();
        try {

            PreparedStatement stm = cn.prepareStatement(sql);

              stm.setString(1, fecha1);
              stm.setString(2, fecha2 );

            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                ar = new Archivo();
                c = new Cliente();
                ar.setIdarchivo(rs.getInt("idarchivo"));
                ar.setFecha(rs.getString("fecha"));
                ar.setTotal(rs.getInt("total"));
                c.setNombre(rs.getString("nombre")); 
                ar.setNombre(c.getNombre());  
                
                archivos.add(ar);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return archivos;
     }
        
        
        
     public static ArrayList<Archivo> listarReservaFechaHoy() {
        
        Archivo ar;
        Cliente c;
        ArrayList<Archivo> archivos= new ArrayList<>();
        
        String sql="SELECT a.* , c.nombre  FROM archivo a, cliente c WHERE fecha = CURDATE() AND c.idcliente = a.idcliente";
       
        Connection cn = Conexion.abrir();
        try {
         
            PreparedStatement stm = cn.prepareStatement(sql);
         
            ResultSet rs = stm.executeQuery();
     
            while(rs.next()){
                ar = new Archivo();
                c = new Cliente();
                ar.setIdarchivo(rs.getInt("idarchivo"));
                ar.setFecha(rs.getString("fecha"));
                ar.setTotal(rs.getInt("total"));
                c.setNombre(rs.getString("nombre")); 
                ar.setNombre(c.getNombre());  
                
                archivos.add(ar);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return archivos;
     }
}
