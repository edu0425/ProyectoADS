
package restaurante.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.bean.Elemento;
import restaurante.conexion.Conexion;

public class ElementoDAO {
    
     public static ArrayList<Elemento> listar(){
        //variable empleado
        Elemento ele;
        //arreglo de objetos
        ArrayList<Elemento> elementos= new ArrayList<>();
        //INSTRUCCION SQL
        String sql="SELECT*FROM elemento";
        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            while(rs.next()){
                ele = new Elemento();
                ele.setIdelemento(rs.getInt("idelemento"));
                ele.setElemento(rs.getString("elemento"));
                ele.setPrecio(rs.getInt("precio"));

                elementos.add(ele);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elementos;
    }
     
     
     public static ArrayList<Elemento> listarIDelemento(){
        //variable empleado
        Elemento e;
        //arreglo de objetos
        ArrayList<Elemento> elementos= new ArrayList<>();
        //INSTRUCCION SQL
        String sql="SELECT idelemento FROM elemento";
        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            while(rs.next()){
                e = new Elemento();
                e.setIdelemento(rs.getInt("idelemento"));
                
                
                //agregar objetos empleado al arreglo
                
                elementos.add(e);
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elementos;
    }
    
     
     
     public static Elemento ListarelementoID(int codigo){
        //variable empleado
        Elemento el=null;
        //arreglo de objetos
        
        //INSTRUCCION SQL
        String sql="SELECT*FROM elemento WHERE idelemento=?";
        //conexion a la base de datos
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instruccion sql
            PreparedStatement stm = cn.prepareStatement(sql);
            //agregar valor al parametro ?
              stm.setInt(1 , codigo);
                    
            //ejecutar consulta y almacenar en un resultset
            ResultSet rs = stm.executeQuery();
            //leer resultSet y colocar datos en el objeto empleado
            if(rs.next()){
                el = new Elemento();
                el.setElemento(rs.getString("elemento"));
                el.setPrecio(rs.getInt("precio"));
              
 
             
            }
            
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return el;
    }
}
