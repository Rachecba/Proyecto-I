/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : ServicioSesion.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.GestorLogin;
import modelo.dao.GestorUsuarios;

@WebServlet(name = "ServicioSesion", urlPatterns = {"/ServicioSesion"})
public class ServicioSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setIntHeader("Refresh", 1);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        HttpSession session = request.getSession();
        
        if (!session.isNew()) {  //mientras no sea una nueva sesion
            Date hourAgo = new Date(System.currentTimeMillis() - 60 * 5 * 1000);
            Date accessed = new Date(session.getLastAccessedTime());
            
            if (accessed.before(hourAgo)) {
                session.invalidate(); //cierro sesion
                GestorLogin.obtenerInstancia().setValidado(false);
                GestorUsuarios.obtenerInstancia().updateSesion(dateFormat.format(date));
                response.sendRedirect("index.jsp"); //redirijo a login
            }else{
                GestorUsuarios.obtenerInstancia().updateSesion(dateFormat.format(date));
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
