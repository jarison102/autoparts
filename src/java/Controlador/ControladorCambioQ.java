/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.QuejaDAO;
import ModeloVO.QuejaVO;
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
@WebServlet(name = "ControladorCambioQ", urlPatterns = {"/ControladorCambioQ"})
public class ControladorCambioQ extends HttpServlet {

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
        
    
        String id_queja = request.getParameter("id_queja");
        String action = request.getParameter("action");
       QuejaVO queVO = new QuejaVO(id_queja, action);
        QuejaDAO queDAO = new QuejaDAO(queVO);

        if (action.equals("Pendiente")) {
            if (queDAO.InactivarQueja(id_queja)) {
                request.setAttribute("titleexito", "Queja Finalizada Correctamente");
                request.getRequestDispatcher("ListarQuejas.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "La Queja no se pudo Finalizar Correctamente");
                request.getRequestDispatcher("ListarQuejas.jsp").forward(request, response);
            }
        } else {
            if (queDAO.ActivarQueja(id_queja)) {
                request.setAttribute("titleexito", "Queja Activada Correctamente");
                request.getRequestDispatcher("ListarQuejas.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "La Queja no se pudo Activar Correctamente");
                request.getRequestDispatcher("ListarQuejas.jsp").forward(request, response);
            }
        
    }
    }

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
