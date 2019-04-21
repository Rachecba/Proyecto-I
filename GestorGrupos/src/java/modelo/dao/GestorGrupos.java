/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : GestorGrupos.java
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
import java.util.ArrayList;
import java.util.List;
import modelo.Grupo;
import modelo.Login;
import modelo.Usuario;

public class GestorGrupos implements Serializable{
    private static GestorGrupos instancia = null;
    
    //Base de datos
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/eif209_1901_p01?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARGRUPOS = "SELECT id, nombre, cupo, activo FROM eif209_1901_p01.grupo;";
    
    public GestorGrupos(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorGrupos obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorGrupos();
        
        return instancia;
    }
    
    public List<Grupo> gruposBD(){
        Login logged = GestorLogin.obtenerInstancia().getLogged();
        List<Grupo> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARGRUPOS);)
        {
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int cupo = rs.getInt("cupo");
                boolean activo = rs.getBoolean("activo");
                lista.add(new Grupo(id, nombre, cupo, null, activo));                
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public List<Grupo> listarGrupos(){
        List<Grupo> grupos = gruposBD();
        List<Usuario> estudiantes = GestorUsuarios.obtenerInstancia().listarEstudiantes();
        
        for(Grupo g : grupos){
            for(Usuario u : estudiantes){
                if(u.getGrupo() == g.getId())
                    g.agregarEstudiante(u);
            }
        }
        
        return grupos;
    }
    
    
    public String gruposHTML(){
        List<Grupo> grupos = listarGrupos();
        StringBuilder s = new StringBuilder();
        
        //Genero la tabla para cada Grupo. NOTA>> Considerar si cada tabla debe ir en un div. 
        
        for(Grupo g : grupos){ //Para cada grupo de la lista de grupos, genere el header de la tabla. Con el num de Grupo y el nombre
            s.append("<table>");
            s.append("<thead>");
            s.append("<tr>");
            s.append(String.format("<th id='id'>Grupo %s</th>", g.getId()));
            s.append("</tr>");
            s.append("<tr>");
            s.append(String.format("<th id='nombre'>%s</th>", g.getNombre()));
            s.append("</tr>");
            s.append("</thead>");
            s.append("<tbody>");
            
            if(g.getEstudiantes() != null){ //Si el grupo SI tiene estudiantes, genere las filas, con el nombre y apellidos de cada estudiante de ese grupo
                for(Usuario u : g.getEstudiantes()){
                        s.append("<tr class='filas'>");
                        s.append(String.format("<td>%s</td>", u.getApellidos()));
                        s.append(String.format("<td></td>", u.getNombre()));
                        s.append("</tr>");
                }
            }else{
                s.append("<tr></tr>"); //Si el grupo NO tiene estudiantes, genere una fila vacia.
            }
            
            s.append("</tbody>");
            
            s.append("</table");
        }
        
        return s.toString();
    }
}
