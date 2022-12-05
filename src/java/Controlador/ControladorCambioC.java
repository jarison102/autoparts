/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.CompraDAO;
import ModeloVO.ComprasVO;
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
@WebServlet(name = "ControladorCambioC", urlPatterns = {"/ControladorCambioC"})
public class ControladorCambioC extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String action = request.getParameter("action");
        ComprasVO comVO = new ComprasVO(id, action);
        CompraDAO comDAO = new CompraDAO(comVO);

        if (action.equals("Pendiente")) {
            if (comDAO.InactivarCompra(id)) {
                request.setAttribute("titleexito", "Compra Finalizada Correctamente");
                request.getRequestDispatcher("ListarCompras.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "La compra no se pudo Finalizar Correctamente");
                request.getRequestDispatcher("ListarCompras.jsp").forward(request, response);
            }
        } else {
            if (comDAO.ActivarCompra(id)) {
                request.setAttribute("titleexito", "Compra Activada Correctamente");
                request.getRequestDispatcher("ListarCompras.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "La compra no se pudo Activar Correctamente");
                request.getRequestDispatcher("ListarCompras.jsp").forward(request, response);
            }
        }
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
