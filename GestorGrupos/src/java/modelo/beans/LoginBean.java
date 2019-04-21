/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : LoginBean.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo.beans;

import java.io.Serializable;
import modelo.dao.GestorLogin;

public class LoginBean implements Serializable{
    
    public LoginBean(){}
    
    public static String logged(){
        StringBuilder s = new StringBuilder();
        
        if(!GestorLogin.obtenerInstancia().isValidado()){
            
            s.append("<%");
            s.append("String redirectURL = \"index.jsp\";\n");
            s.append("response.sendRedirect(redirectURL);\n");
            s.append("%>");
        }
        
        return s.toString();
    }
}
