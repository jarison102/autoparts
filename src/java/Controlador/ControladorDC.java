/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DetalleCompraDAO;
import ModeloVO.DetalleCompraVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorDC", urlPatterns = {"/DC"})
public class ControladorDC extends HttpServlet {

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
        String id_detalle_compra = request.getParameter("textIddetalleC");
        String id_producto_fk = request.getParameter("textIdproducto");
        String id_compra_fk = request.getParameter("textIdcompra");
        String precio_compra= request.getParameter("textPreciocompra");
        String cantidad_compra= request.getParameter("textCantidad");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        DetalleCompraVO decVO = new DetalleCompraVO(id_detalle_compra, id_producto_fk, id_compra_fk,precio_compra, cantidad_compra);
        DetalleCompraDAO decDAO = new DetalleCompraDAO (decVO);
        
         switch(opcion) {
            case 1:
                if(decDAO.agregarRegistro()){
                    request.setAttribute("mensajeExito", "Se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarDC.jsp").forward(request, response);
                break;
                 case 2: //Método 2 Actualizar reg
                if (decDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeExito", "El de detalle se actualizo correctamente");
                }
                else
                {
                    request.setAttribute("mensajeError", "El detalle no se actualizocorrectamente");
                }
                request.getRequestDispatcher("consultarDC.jsp").forward(request, response);//indica a donde queremos redireccionar y manejar peticiones http
                break;
                 case 3: //Método 1: agregar registro
                decVO = decDAO.consultarId(id_detalle_compra);
                if (decVO !=null){
                    request.setAttribute("DetalleConsultado", decVO);
                    request.getRequestDispatcher("actualizarDC.jsp").forward(request, response);
                    
                }
                else{
                    request.setAttribute("mensajeError","El detalle  NO existe");
                    request.getRequestDispatcher("consultarDC.jsp").forward(request, response);
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
