/*
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : Login.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable{
    private String id;
    private String clave;
    private Date ultimo_acceso;
    
    public Login(){
        this.id = null;
        this.clave = null;
        this.ultimo_acceso = null;
    }
    
    public Login(String id, String clave, Date acceso){
        this.id = id;
        this.clave = clave;
        this.ultimo_acceso = acceso;
    }

    public String getId() {
        return id;
    }

    public String getClave() {
        return clave;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }
    
    
    
}
