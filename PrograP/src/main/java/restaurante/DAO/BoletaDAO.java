
package restaurante.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.bean.Boleta;
import restaurante.conexion.Conexion;

public class BoletaDAO {
     public static void AgregarPedidoBoleta(Boleta bo){
        
        Connection cn = Conexion.abrir();
       
       try {
       
            CallableStatement cst= cn.prepareCall("{call boletainsertar(?,?,?,?,?)}"); 
          
                cst.setInt(1 ,bo.getCantidad());
                cst.setDouble(2 ,bo.getPrecio());
                cst.setDouble(3 ,bo.getSubtotal()); 
                cst.setInt(4 ,bo.getIdelemento());
                cst.setInt(5 ,bo.getIdarchivo());

          
                cst.executeUpdate();
            cn.close();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
