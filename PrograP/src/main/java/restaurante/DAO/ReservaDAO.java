
package restaurante.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.bean.Cliente;
import restaurante.bean.Reserva;
import restaurante.conexion.Conexion;

public class ReservaDAO {
     public static ArrayList<Reserva> listar(){
      
        Reserva re;
        Cliente c;
    
        ArrayList<Reserva> reservas= new ArrayList<>();
        
        String sql="SELECT a.* , c.nombre , c.numero FROM reserva a, cliente c WHERE c.idcliente = a.idcliente";
       
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            while(rs.next()){
                re = new Reserva();
                c = new Cliente();
                re.setIdreserva(rs.getInt("idreserva"));
                re.setNpersonas(rs.getInt("npersonas"));
                re.setFecha(rs.getString("fecha"));
                re.setHora(rs.getString("hora"));
                re.setIdcliente(rs.getInt("idcliente"));
                c.setNombre(rs.getString("nombre"));
                c.setNumero(rs.getInt("numero"));
                re.setNum(c.getNumero());
                re.setNombre(c.getNombre());
                //agregar objetos empleado al arreglo
                
                reservas.add(re);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservas;
    }
     
     
     
          public static void insertar(Reserva re){
         
         String sql = "insert into reserva(npersonas,fecha,hora,idcliente)values(?,?,?,?)";
         
       
         Connection cn=Conexion.abrir();
         
        try {
          
            PreparedStatement ps = cn.prepareStatement(sql);
          
            ps.setInt(1, re.getNpersonas());
            ps.setString(2, re.getFecha());
            ps.setString(3, re.getHora());
            ps.setInt(4, re.getIdcliente());
            
            
            ps.executeUpdate();
           
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
          
          
      public static void modificar(Reserva re){
        
         String sql = "update reserva set npersonas = ? ,fecha = ? , hora = ?, idcliente = ? WHERE idreserva = ?";
      
         Connection cn=Conexion.abrir();
          
        try {
 
            PreparedStatement ps = cn.prepareStatement(sql);
 
         
            ps.setInt(1, re.getNpersonas());
            ps.setString(2, re.getFecha());
            ps.setString(3, re.getHora());
            ps.setInt(4, re.getIdcliente());
            ps.setInt(5, re.getIdreserva());
           
           
            
            //EJECUTAR(INSERT,UPDAT,DELETE)
            ps.executeUpdate();
            //CERRAR OBJETOS
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
      
      
      
      
       public static void eliminar(int codigo){
         String sql = "delete FROM  reserva WHERE idreserva = ?";
         
         
         Connection cn=Conexion.abrir();
         
        try {
            
            PreparedStatement ps = cn.prepareStatement(sql);
         
            ps.setInt(1, codigo);
          
            ps.executeUpdate();
          
            cn.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }     
          
          
     
       
        public static ArrayList<Reserva> listarPedidosFecha(String fecha1, String fecha2) {
        //variable empleado
        Reserva re;
        Cliente c;
        ArrayList<Reserva> reservas= new ArrayList<>();
        //INSTRUCCION SQL
        String sql="SELECT a.* , c.nombre , c.numero FROM reserva a, cliente c WHERE fecha BETWEEN ? AND ? AND c.idcliente = a.idcliente ";
       
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //agregar valor al parametro ?

              stm.setString(1, fecha1);
              stm.setString(2, fecha2 );
                    
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            while(rs.next()){
                re = new Reserva();
                c = new Cliente();
                re.setIdreserva(rs.getInt("idreserva"));
                re.setNpersonas(rs.getInt("npersonas"));
                re.setFecha(rs.getString("fecha"));
                re.setHora(rs.getString("hora"));
                re.setIdcliente(rs.getInt("idcliente"));
                c.setNombre(rs.getString("nombre"));
                c.setNumero(rs.getInt("numero"));
                re.setNum(c.getNumero());
                re.setNombre(c.getNombre());
                
                reservas.add(re);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservas;
     }
        
        
        
     public static ArrayList<Reserva> listarReservaFechaHoy() {
        
        Reserva re;
        Cliente c;
        ArrayList<Reserva> reservas= new ArrayList<>();
        
        String sql="SELECT a.* , c.nombre , c.numero FROM reserva a, cliente c WHERE fecha = CURDATE() AND c.idcliente = a.idcliente";
       
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //agregar valor al parametro ?

                    
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            while(rs.next()){
                re = new Reserva();
                c = new Cliente();
                re.setIdreserva(rs.getInt("idreserva"));
                re.setNpersonas(rs.getInt("npersonas"));
                re.setFecha(rs.getString("fecha"));
                re.setHora(rs.getString("hora"));
                re.setIdcliente(rs.getInt("idcliente"));
                c.setNombre(rs.getString("nombre"));
                c.setNumero(rs.getInt("numero"));
                re.setNum(c.getNumero());
                re.setNombre(c.getNombre());
                
                reservas.add(re);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservas;
     }
}
