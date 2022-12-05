/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import JavaMail.ParametrosCorreo;
import ModeloDAO.EmpleadoDAO;
import ModeloDAO.PersonaDAO;
import ModeloDAO.UsuarioDAO;
import ModeloDAO.VentaDAO;
import ModeloVO.PersonaVO;
import ModeloVO.UsuarioStrings;
import Util.Encritar;
import ModeloVO.UsuarioVO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author No se que poner
 */
@WebServlet(name = "ControladorUsuarios", urlPatterns = {"/ControladorUsuarios"})
public class ControladorUsuarios extends HttpServlet {

    private String host, puerto, usuarioCorreo, password;

    public void init() {
        ServletContext contex = getServletContext();
        host = contex.getInitParameter("host");
        puerto = contex.getInitParameter("puerto");
        usuarioCorreo = contex.getInitParameter("usuarioCorreo");
        password = contex.getInitParameter("password");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");

        String id_usuario = request.getParameter("id_usuario");
        String email = request.getParameter("textEmail");
        String clave_usuario = request.getParameter("textClave");
        boolean estado_usuario = Boolean.getBoolean("estado_usuario");
        String id_rol_fk = request.getParameter(request.getParameter("textIdRol"));
        //Variables para consultar  registrar y listar 
        String id = request.getParameter("id");
        String email_usu = request.getParameter("email");
        String clave_usu = request.getParameter("clave");
        String estado = request.getParameter("estado");
        String rol = request.getParameter("rol");
        UsuarioVO usuVO = null;
        VentaDAO venDAO = new VentaDAO();
        UsuarioDAO usuDAO = new UsuarioDAO();
        String Asunto = "hola";
        String Mensaje = "Bienvenidos";

        UsuarioStrings usu = new UsuarioStrings(id, email_usu, clave_usu, estado, rol);
        UsuarioDAO usuarioDAO = new UsuarioDAO(usu);
        EmpleadoDAO empDAO = new EmpleadoDAO(usu);
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        switch (opcion) {
            case 1:
                if (usuarioDAO.agregarRegistro()) {
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
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case 2: // Actualizar registro 

                if (usuarioDAO.actualizarRegistro()) {
                    request.setAttribute("mesajeExito", "El usuario se actualizó correctamente ");
                } else {
                    request.setAttribute("mensajeError", "El usuario  no se actualizó");
                }
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                break;

            case 3: //Consultar usuario
                usu = usuarioDAO.consultarId(id);
                if (usu != null) {
                    request.setAttribute("usuarioConsultado", usu);
                    request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "El usuario No existe");
                    request.getRequestDispatcher("consultarUsuario").forward(request, response);
                }
                break;

            case 4: //Inicio de sesion
                if (request.getParameter("textEmail").equals("") || request.getParameter("textClave").equals("")) {
                    request.setAttribute("tituloError", "Error en los datos ");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    usuVO = usuDAO.login(email, Encritar.getMD5(clave_usuario));
                    UsuarioVO usuVo = null;
                    UsuarioDAO usuDAo = new UsuarioDAO(usuVo);
                    usuVO = usuDAo.login(email, clave_usuario);
                    if (usuVO != null) {

                        PersonaDAO perDAO = new PersonaDAO();
                        PersonaVO perVO = perDAO.consultarId(String.valueOf(usuVO.getId_usuario()));

                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("PersonaVO", perVO);
                        sesion.setAttribute("UsuarioVO", usuVO);
                        sesion.setAttribute("email", email);
                        request.getRequestDispatcher("Menu.jsp").forward(request, response);

                    } else {
                        request.setAttribute("tituloError", "Error al iniciar sesion");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }

            case 5: //Registrar Empleado
                if (empDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", " Se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "NO se registro correctamente");
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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
