/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : GestorUsuarios.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */

package modelo.dao;
    
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Login;
import modelo.Usuario;

public class GestorUsuarios implements Serializable{
    private static GestorUsuarios instancia = null;
    
    //BASES DE DATOS 
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/eif209_1901_p01?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARESTUDIANTES = "SELECT id, apellidos, nombre, clave, ultimo_acceso, grupo_id FROM eif209_1901_p01.estudiante";
    private static final String CMD_PASSWORD = "UPDATE eif209_1901_p01.estudiante SET clave = '%s' WHERE id = '%s';";
    private static final String CMD_SESION = "UPDATE eif209_1901_p01.estudiante SET ultimo_acceso = '%s' WHERE id = '%s';";
    public Connection conn;
    
    public GestorUsuarios(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }   
    
    public static GestorUsuarios obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorUsuarios();
        
        return instancia;
    }
    
    public List<Usuario> listarEstudiantes(){
        List<Usuario> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARESTUDIANTES);)
        {
            while(rs.next()){
                String id = rs.getString("id");
                String apellidos = rs.getString("apellidos");
                String nombre = rs.getString("nombre");
                String clave = rs.getString("clave");
                String ultimo_acceso = rs.getString("ultimo_acceso");
                int grupo = rs.getInt("grupo_id");
                
                lista.add(new Usuario(id, clave, nombre, apellidos, ultimo_acceso, grupo));
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public void cambiarPass(String nueva){
        Login logged = GestorLogin.obtenerInstancia().getLogged();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            stm.executeUpdate(String.format(CMD_PASSWORD, nueva, logged.getId()));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void updateSesion(String sesion){
        Login logged = GestorLogin.obtenerInstancia().getLogged();
        
         try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            stm.executeUpdate(String.format(CMD_SESION, sesion, logged.getId()));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
}
