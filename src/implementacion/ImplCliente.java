package implementacion;

import conexion.ConexionDB;
import entidades.Cliente;
import entidades.Persona;
import generator.Generator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplCliente {
    
    ConexionDB cx= new ConexionDB();
    ArrayList<Cliente> listaClientes= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;
    ImplPersona ip= new ImplPersona();
    Generator gn =new Generator();
    Persona ps = new Persona();
    public int  registrarCliente(Cliente c){
        
        int i=0;
       
            try {
            query=" insert into cliente (id,tipo, persona_id) "+
                  " values('"+gn.generatorId()+"','"+c.getTipo()+"','"+c.getPersona_id()+"') ";            
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            } catch (SQLException ex) {
                    System.out.println(""+ex.getMessage()); 
            }
              
            
           return i;
            
        }
           
       
    }
    

