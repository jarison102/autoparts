/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.VentaDAO;
import ModeloVO.VentasVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author No se que poner
 */
@WebServlet(name = "ControladorVentas", urlPatterns = {"/ControladorVen"})
public class ControladorVentas extends HttpServlet {

    String listar = "listarVenta.jsp";
    String add = "addVentas.jsp";
    String edit = "editVentas.jsp";
    VentasVO vensVO = new VentasVO();
    VentaDAO venDAO = new VentaDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;

        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String fecha_venta = request.getParameter("txtfechaVenta");
            String fecha_entrega = request.getParameter("txtfechaEntrega");
            String total_venta = request.getParameter("txttotalVenta");
            String id_persona_fk = request.getParameter("txtid_persna_fk");
            vensVO.setFecha_venta(fecha_venta);
            vensVO.setFecha_entrega(fecha_entrega);
            vensVO.setTotal_venta(total_venta);
            vensVO.setId_persona_fk(id_persona_fk);
            venDAO.add(vensVO);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id_venta", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String fecha_venta = request.getParameter("txtfechaVenta");
            String fecha_entrega = request.getParameter("txtfechaEntrega");
            String total_venta = request.getParameter("txttotalVenta");
            String id_persona_fk = request.getParameter("txtid_persna_fk");
            vensVO.setId(id);
            vensVO.setFecha_venta(fecha_venta);
            vensVO.setFecha_entrega(fecha_entrega);
            vensVO.setTotal_venta(total_venta);
            vensVO.setId_persona_fk(id_persona_fk);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            vensVO.setId(id);
            venDAO.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
