/*
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : GestorLogin.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo.dao;

import java.io.Serializable;
import java.util.List;
import modelo.Login;
import modelo.Usuario;

public class GestorLogin implements Serializable{
    private static GestorLogin instancia = null;
    public Login logged = null;
    boolean validado = false;
    
     public GestorLogin(){
      
    }
    
    public static GestorLogin obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorLogin();
        
        return instancia;
    }
    
    public boolean validateLogin(String username, String pass){
         List<Usuario> usuarios = GestorUsuarios.obtenerInstancia().listarEstudiantes();
        
        for(Usuario u : usuarios){
            if(u.getId().equals(username) && u.getPassword().equals(pass)){
                validado = true;
                logged = new Login(u.getId(), u.getPassword(), u.getUltimo_acceso());
                return validado;
            }
        }
        
        return validado;
    }
    
    public Login getLogged() {
        return logged;
    }

    public void setLogged(Login logged) {
        this.logged = logged;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
    
    
}

