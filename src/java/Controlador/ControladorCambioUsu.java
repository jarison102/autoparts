/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author POWER
 */
@WebServlet(name = "ControladorCambioUsu", urlPatterns = {"/ControladorCambioUsu"})
public class ControladorCambioUsu extends HttpServlet {

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
    
      int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        UsuarioVO usuVO = new UsuarioVO(id, action);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        if (action.equals('0')) {
            if (usuDAO.InactivarUsuario(id)) {
                request.setAttribute("titleexito", "Usuario inactivado Correctamente ");
                request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "El usuario no se pudo Inactivar Correctamente");
                request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
            }
        } else {
            if (usuDAO.ActivarUsuario(id)) {
                request.setAttribute("titleexito", "Activo Correctamente");
                request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "El usuario no se pudo Activar Correctamente");
                request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
            }
        } 
    

    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    

    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
