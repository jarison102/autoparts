/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import JavaMail.ParametrosCorreo;
import ModeloDAO.EmpleadoDAO;
import ModeloVO.UsuarioStrings;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author POWER
 */
@WebServlet(name = "ControladorEmpleados", urlPatterns = {"/ControladorEmpleados"})
public class ControladorEmpleados extends HttpServlet {

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

        //Variables para consultar  registrar y listar 
        String id = request.getParameter("id");
        String email_usu = "" + request.getParameter("email");
        // String clave_usu = "" + request.getParameter("clave");
        String estado = request.getParameter("estado");
        String rol = "" + request.getParameter("rol");
        String Asunto = "Bienvenid@ a la empresa";

        String cargo = "" + rol;
        switch (rol) {
            case "1":

                if (rol.equals("1")) {
                    cargo = "Gerente";
                }
                break;
            case "2":
                if (rol.equals("2")) {
                    cargo = "Cliente";
                }
                break;
            case "3":
                if (rol.equals("3")) {
                    cargo = "Almacenista";
                }
                break;
            case "4":
                if (rol.equals("4")){
                cargo = "Repartidor";
                }
                break;
            case "5":
                if (rol.equals("5")){
                cargo = "Atencion al cliente";
                }
                break;
            default:
              
        }
//       EmpleadoDAO empDAO = new EmpleadoDAO();

        GenerarClave generador = new GenerarClave();
        String contraGenerada = generador.crearPassword();
        UsuarioStrings usu = new UsuarioStrings(id, email_usu, contraGenerada, estado, rol);
        String Mensaje = "Su email es: " + email_usu + "\n" + " Su contraseña es: " + contraGenerada+ "\n" + "Y su cargo dentro de la empresa será: " + cargo;
        EmpleadoDAO empDAO = new EmpleadoDAO(usu);
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        switch (opcion) {
            case 1:
                if (empDAO.agregarRegistro()) {
                    try {
                        ParametrosCorreo.envioCorreo(host, puerto, usuarioCorreo, password, email_usu, Asunto, Mensaje);
                        request.setAttribute("mensajeExito", "El usuario Se registro correctamente");
                    } catch (MessagingException e) {
                        System.out.println("error = " + e);
                        request.setAttribute("mensajeError", "El usuario se registro pero ocurrio un error");
                    }

                } else {
                    request.setAttribute("mensajeError", "El usuario NO se registro correctamente");
                }
                request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
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
