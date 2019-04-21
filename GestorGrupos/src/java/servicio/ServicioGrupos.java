/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : ServicioGrupos.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Grupo;
import modelo.dao.GestorGrupos;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "ServicioGrupos", urlPatterns = {"/ServicioGrupos"})
public class ServicioGrupos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            List<Grupo> grupos = GestorGrupos.obtenerInstancia().listarGrupos();
            System.out.println(grupos);
            
            JSONObject obj = new JSONObject();
            JSONArray array = new JSONArray();  
            
            for(Grupo g : grupos){
                JSONObject pobj = new JSONObject();
                pobj.put("id", g.getId());
                pobj.put("nombre", g.getNombre());
                pobj.put("estudiantes", g.getEstudiantes());
                array.put(pobj);
            }
            
            
            obj.put("grupos", array);
            System.out.println(obj);
            out.print(obj);
        
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
