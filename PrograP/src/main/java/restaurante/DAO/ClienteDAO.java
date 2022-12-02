
package restaurante.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.bean.Cliente;
import restaurante.conexion.Conexion;

public class ClienteDAO {
     public static Cliente buscarClienteNombre(String nombre){
        //variable empleado
        Cliente cl=null;
        //arreglo de objetos
        
        //INSTRUCCION SQL
        String sql="SELECT*FROM cliente WHERE nombre=?";
        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //agregar valor al parametro ?
              stm.setString(1 , nombre);
                    
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            if(rs.next()){
                cl = new Cliente();
                cl.setIdcliente(rs.getInt("idcliente"));
               
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
    
    
     
     public static void insertar(Cliente cl){
        
         String sql = "insert into cliente(nombre,numero)values(?,?)";
         
         //CONEXION A LA BD
         Connection cn=Conexion.abrir();
         
        try {
           
            PreparedStatement ps = cn.prepareStatement(sql);
  
            ps.setString(1, cl.getNombre());
            ps.setInt(2, cl.getNumero());

            ps.executeUpdate();
   
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
     
         
      public static void modificar(Cliente cl){
        
         String sql = "update cliente set nombre = ? ,numero = ?  WHERE idcliente = ?";
      
         Connection cn=Conexion.abrir();
          
        try {
 
            PreparedStatement ps = cn.prepareStatement(sql);
 
         
            ps.setString(1, cl.getNombre());
            ps.setInt(2, cl.getNumero());
            ps.setInt(3, cl.getIdcliente());
           
           
            
            //EJECUTAR(INSERT,UPDAT,DELETE)
            ps.executeUpdate();
            //CERRAR OBJETOS
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
      
      
      
      
       public static void eliminar(int codigo){
         String sql = "delete FROM  cliente WHERE idcliente = ?";
         
         
         Connection cn=Conexion.abrir();
         
        try {
            
            PreparedStatement ps = cn.prepareStatement(sql);
         
            ps.setInt(1, codigo);
          
            ps.executeUpdate();
          
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }     
          
       public static void registrarNombre(Cliente cl){
        
         String sql = "insert into cliente(nombre)values(?)";
         
         //CONEXION A LA BD
         Connection cn=Conexion.abrir();
         
        try {
           
            PreparedStatement ps = cn.prepareStatement(sql);
  
            ps.setString(1, cl.getNombre());
  

            ps.executeUpdate();
   
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }      
     
}
