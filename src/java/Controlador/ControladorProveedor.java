/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ProveedorDAO;
import ModeloVO.ProveedorVO;
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
@WebServlet(name = "ControladorProveedor", urlPatterns = {"/Proveedor"})
public class ControladorProveedor extends HttpServlet {

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

        String id_proveedor = request.getParameter("textId");
        String nombre_proveedor = request.getParameter("textNombre");
        String telefono_proveedor = request.getParameter("textTelefono");
        String correo_proveedor = request.getParameter("textCorreo");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        ProveedorVO prvVO = new ProveedorVO(id_proveedor, nombre_proveedor, telefono_proveedor, correo_proveedor);
        ProveedorDAO prvDAO = new ProveedorDAO(prvVO);

        switch (opcion) {
            case 1:
                if (prvDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "Se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
                break;

                
                     
            case 2 : // Actualizar registro 
                if(prvDAO.actualizarRegistro())
                {
                    request.setAttribute("mesajeExito","El proveedor se actualizó correctamente ");
                }
                else{
                    request.setAttribute("mensajeError","El proveedor NO se actualizó");
                }
                request.getRequestDispatcher("consultarProveedor.jsp").forward(request, response);
                break;
                
            case 3 : //Consultar id 
                prvVO = prvDAO.consultarId(id_proveedor);
                if(prvVO != null){
                    request.setAttribute("proveedorConsultado", prvVO);
                    request.getRequestDispatcher("actualizarProveedor.jsp").forward(request, response);
            
                }
                else{
                    request.setAttribute("mensajeError", "El proveedor No existe");
                    request.getRequestDispatcher("consultarProveedor.jsp").forward(request, response);
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

