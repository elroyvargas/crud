package conexion;
import java.sql.*;
public class ConexionDB {
    
    Connection conexion= null;
    String userDB="";
    String password="";
    String url=""; 
    
    
    public Connection conectaMysql(){        
        try {
            userDB="root";
            url="jdbc:mysql://127.0.0.1:3306/poo-crud";
            conexion=DriverManager.getConnection(url,userDB,password);
            if(conexion!=null) System.out.println("Se establecio la conexion");
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return conexion;
    }
}
