/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.CompraDAO;
import ModeloDAO.InventarioDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedorDAO;
import ModeloDAO.QuejaDAO;
import ModeloDAO.UsuarioDAO;
import ModeloDAO.VentaDAO;
import ModeloVO.ComprasVO;
import ModeloVO.InventarioVO;
import ModeloVO.ProductoVO;
import ModeloVO.ProveedorVO;
import ModeloVO.QuejaVO;
import ModeloVO.UsuarioVO;
import ModeloVO.VentasVO;
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
 * @author POWER
 */
@WebServlet(name = "Listar", urlPatterns = {"/Listar"})
public class Listar extends HttpServlet {

    UsuarioDAO usuDAO = new UsuarioDAO();
    QuejaDAO queDAO = new QuejaDAO();
    ProveedorDAO proDAO = new ProveedorDAO();
    VentaDAO venDAO = new VentaDAO();
    ProductoDAO  prodcDAO = new ProductoDAO();
    InventarioDAO inveDAO = new InventarioDAO();
    CompraDAO comDAO = new CompraDAO();
    
    List usuarios = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        usuarios = usuDAO.Listar();
        String variable = request.getParameter("variable");
        
        switch(variable){
           case "ListarVentas":
                List<VentasVO> ventas = venDAO.ListarVentas();
                request.setAttribute("ventas", ventas);
                request.getRequestDispatcher("Listares/ListarVentasPrueba.jsp").forward(request, response);
                break;
           case "ListarUsuarios":
                List<UsuarioVO> usuarios = usuDAO.Listar();
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("Listares/ListarUsuariosPrueba.jsp").forward(request, response);
                break;
           case "ListarQuejas":
                List<QuejaVO> quejas = queDAO.ListarQuejas();
                request.setAttribute("quejas", quejas);
                request.getRequestDispatcher("Listares/ListarQuejasPrueba.jsp").forward(request, response);
                break;
           case "ListarProveedores":
                List<ProveedorVO> proveedores = proDAO.ListarProveedores();
                request.setAttribute("proveedores", proveedores);
                request.getRequestDispatcher("Listares/ListarProveedoresPrueba.jsp").forward(request, response);
                break;
           case "ListarInventario":
                List<InventarioVO> inventarios = inveDAO.ListarInventario();
                request.setAttribute("inventarios", inventarios);
                request.getRequestDispatcher("Listares/ListarInventariosPrueba.jsp").forward(request, response);
                break;
           case"ListarProductos":
               List<ProductoVO> productos = prodcDAO.ListarProductos();
               request.setAttribute("pro", productos);
               request.getRequestDispatcher("Listares/ListarProducto2.jsp").forward(request, response);
               break;
           case"ListarVentas2":
               List<VentasVO> ventas2 = venDAO.ListarVentas();
               request.setAttribute("ven", ventas2);
               request.getRequestDispatcher("Listares/ListarVentas2Prueba.jsp").forward(request, response);
               break;
           case"ListarCompras":
               List<ComprasVO> Compras = comDAO.ListarCompras();
               request.setAttribute("Lc", Compras);
               request.getRequestDispatcher("ListarCompraPrueba.jsp").forward(request, response);
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
