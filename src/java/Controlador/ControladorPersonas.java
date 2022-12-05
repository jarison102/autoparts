/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.PersonaDAO;
import ModeloVO.PersonaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author No se que poner
 */
@WebServlet(name = "ControladorPersonas", urlPatterns = {"/ControladorPersonas"})
public class ControladorPersonas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String id = request.getParameter("textId");
        String nombre = request.getParameter("textNombre");
        String apellido = request.getParameter("textApe");
        String tdoc = request.getParameter("textTdoc");
        String documento  = request.getParameter("textDocumento");
        String telefono = request.getParameter("textTelefono");
        String direccion  = request.getParameter("textDireccion");
        String id_usuario_fk = request.getParameter("textId_usuario");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        PersonaVO perVO = new PersonaVO (id, nombre, apellido, tdoc, documento, telefono, direccion, id_usuario_fk);
        PersonaDAO perDAO = new PersonaDAO (perVO);
        
       switch(opcion) {
            case 1:
                if(perDAO.agregarRegistro()){
                    request.setAttribute("mensajeExito", " Se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "NO se registro correctamente");
                }
                request.getRequestDispatcher("ControladorProductos?accion=carrito").forward(request, response);
                break;
                
            case 2 : // Actualizar registro 
                if(perDAO.actualizarRegistro())
                {
                    request.setAttribute("mesajeExito"," Se actualizó correctamente ");
                }
                else{
                    request.setAttribute("mensajeError","No se actualizó");
                }
                request.getRequestDispatcher("consultarPersona.jsp").forward(request, response);
                break;
            case 3 : //Consultar usuario
               perVO = perDAO.consultarId(id);
               if(perVO != null){
                   request.setAttribute("personaConsultada", perVO);
                   request.getRequestDispatcher("actualizarPersona.jsp").forward(request, response);
            
              }
                else{
                   request.setAttribute("mensajeError", "La personaNo existe");
                   request.getRequestDispatcher("consultarPersona").forward(request, response);
                }
               break; 
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
