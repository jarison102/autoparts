/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.VentaDAO;
import ModeloVO.VentaVO;
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
@WebServlet(name = "ControladorCambioV", urlPatterns = {"/ControladorCambioV"})
public class ControladorCambioV extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        VentaVO venVO = new VentaVO(id, action);
        VentaDAO venDAO = new VentaDAO(venVO);

        if (action.equals("Pendiente")) {
            if (venDAO.InactivarVenta(id)) {
                request.setAttribute("titleexito", "Venta Finalizada Correctamente");
                request.getRequestDispatcher("ListarVentas.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "La Venta no se pudo Finalizar Correctamente");
                request.getRequestDispatcher("ListarVentas.jsp").forward(request, response);
            }
        } else {
            if (venDAO.ActivarVenta(id)) {
                request.setAttribute("titleexito", "Venta Reactivada Correctamente");
                request.getRequestDispatcher("ListarVentas.jsp").forward(request, response);
            } else {
                request.setAttribute("titleexito", "La Venta no se pudo Reactivar Correctamente");
                request.getRequestDispatcher("ListarVentas.jsp").forward(request, response);
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
