/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : contraseña.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */

package modelo;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
    String id;
    String password;
    String nombre;
    String apellidos;
    Date ultimo_acceso;
    int grupo;

    public Usuario(String id, String password, String nombre, String apellidos, Date ultimo_acceso, int grupo) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ultimo_acceso = ultimo_acceso;
        this.grupo = grupo;
    }

    public Usuario() {
        id = null;
        password = null;
        nombre = null;
        apellidos = null;
        ultimo_acceso = null;
        grupo = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
    
}
