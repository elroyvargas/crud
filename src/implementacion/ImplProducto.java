/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionDB;
import entidades.Cliente;
import entidades.Persona;
import entidades.Producto;
import generator.Generator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ImplProducto {
    ConexionDB cx= new ConexionDB();
    Generator gn=new Generator();
    ArrayList<Persona> listaPersonas= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;
    
    
    
    
    
    public Persona  registrarProducto (Producto p){
        int i=0;
        Persona pe= new Persona();
        String id=gn.generatorId();
        try {
            query=" insert into persona (persona_id,persona_nombre,persona_ap_paterno,persona_ap_materno, persona_codigo, persona_sexo,persona_usuario, persona_password ) "+
                  " values('"+id+"','"+p.getNombre()+"','"+p.getMarca()+"','"+p.getModelo()+"','"+p.getStock()+"') ";
            
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            
            pe.setId(id);
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        }
        System.out.println(i);
        return pe;
    }
            
            
            
    
}
