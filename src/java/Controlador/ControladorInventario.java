/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.InventarioDAO;
import ModeloVO.InventarioVO;
import Util.Fecha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "ControladorInventario", urlPatterns = {"/Inventario"})
public class ControladorInventario extends HttpServlet {

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
        String id_inventario = request.getParameter("textIdinventario");
        String informacion_inventario = request.getParameter("textInformacion");
        String fecha_inventario = request.getParameter("textFecha");
        String perdidas_productos = request.getParameter("textPerdidas");
        String id_producto_fk = request.getParameter("textProducto");
        String id_empleado_fk = request.getParameter("textEmpleado");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        Fecha fechasystem = new Fecha();
        InventarioVO invVO = new InventarioVO (id_inventario, informacion_inventario,fechasystem.FechaBD() , perdidas_productos, id_producto_fk, id_empleado_fk); 
        InventarioDAO invDAO = new InventarioDAO(invVO);
        
        switch(opcion) {
            case 1:
                if(invDAO.agregarRegistro()){
                    request.setAttribute("mensajeExito", "Se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarInventario.jsp").forward(request, response);
                break;
                
                
            case 2 : // Actualizar registro 
                if(invDAO.actualizarRegistro())
                {
                    request.setAttribute("mesajeExito","El inventario se actualizó correctamente ");
                }
                else{
                    request.setAttribute("mensajeError","El inventario no se actualizó");
                }
                request.getRequestDispatcher("registrarInventario.jsp").forward(request, response);
                break;
            case 3 : //Consultar usuario
                invVO = invDAO.consultarId(id_inventario);
                if(invVO != null){
                    request.setAttribute("inventarioConsultado", invVO);
                    request.getRequestDispatcher("listarInventario.jsp").forward(request, response);
            
                }
                else{
                    request.setAttribute("mensajeError", "El inventario No existe");
                    request.getRequestDispatcher("actualizarInventario.jsp").forward(request, response);
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
