/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import JavaMail.ParametrosCorreo;
import ModeloDAO.QuejaDAO;
import ModeloVO.QuejaVO;
import Util.Fecha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorQuejas", urlPatterns = {"/Quejas"})
public class ControladorQuejas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Fecha fechasystem = new Fecha();
   private String host, puerto, usuarioCorreo, password;

    public void init() {
        ServletContext contex = getServletContext();
        host = contex.getInitParameter("host");
        puerto = contex.getInitParameter("puerto");
        usuarioCorreo = "autopartsatencioncliente@gmail.com";
        password = "zfuqmwunotbartwn";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id_queja = request.getParameter("textId");
        String id_usuario_fk = request.getParameter("textusu");
        String fecha_queja = request.getParameter("textFe");
        String correo = request.getParameter("textcor");
        String asunto = request.getParameter("textA");
        String detalle = request.getParameter("textD");
        String estado_queja = "Pendiente";
        String respuesta = request.getParameter("textR");
        String Copia ="Tu queja ha sido recibida, pronto te responderemos :)";
        String mensaje= "" + Copia;
        String Correo2 = "jsdiaz030@misena.edu.co";        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        QuejaVO qejVO = new QuejaVO(id_queja, id_usuario_fk,fechasystem.FechaBD(),asunto, detalle, estado_queja);
        QuejaDAO qejDAO = new QuejaDAO(qejVO);
        switch (opcion) {
            case 1: //Método 1: agregar registro
                if (qejDAO.agregarRegistro()) {
            try {
                ParametrosCorreo.envioCorreo(host,puerto, usuarioCorreo, password, Correo2,asunto,mensaje);
            } catch (MessagingException ex) {
                Logger.getLogger(ControladorQuejas.class.getName()).log(Level.SEVERE, null, ex);
            }
                    request.setAttribute("mensajeExito", "La queja se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "La queja no se registró correctamente");
                }
                request.getRequestDispatcher("registrarQueja.jsp").forward(request, response);//indica a donde queremos redireccionar y manejar peticiones http
                break;

            case 2: // Actualizar registro 
                if (qejDAO.actualizarRegistro()) {
                    request.setAttribute("mesajeExito", "La queja NO se actualizó correctamente ");
                } else {
                    request.setAttribute("mensajeError", "La queja no se actualizó");
                }
                request.getRequestDispatcher("consultarQueja.jsp").forward(request, response);
                break;

            case 3: //Consultar queja
                qejVO = qejDAO.consultarId(id_queja);
                if (qejVO != null) {
                    request.setAttribute("quejaConsultada", qejVO);
                    request.getRequestDispatcher("actualizarQueja.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "La queja No existe");
                    request.getRequestDispatcher("consultarQueja.jsp").forward(request, response);
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
