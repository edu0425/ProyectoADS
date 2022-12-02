
package restaurante.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static String url="jdbc:mysql://localhost/restaurante1";
    private static String usuario="root";
    private static String password="";
    private static Connection cn=null;
    
    public static Connection abrir(){
        try {
            //REGISTRAR DRIVER DEL MYSQL
            Class.forName("com.mysql.jdbc.Driver");
            //ABIRIR CONEXION
            cn = DriverManager.getConnection(url,usuario,password);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
}

