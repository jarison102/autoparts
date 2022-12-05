/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.CompraDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.QuejaDAO;
import ModeloDAO.VentaDAO;
import ModeloVO.CarritoVO;
import ModeloVO.PersonaVO;
import ModeloVO.ProductoVO;
import ModeloVO.UsuarioVO;
import ModeloVO.VentaVO;
import Util.Fecha;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author No se que poner
 */
@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {

    UsuarioVO u = new UsuarioVO();
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO proVO = new ProductoVO();
    int item = 0;
    int cantidad = 1;
    double subtotal = 0.0;
    double totalPagar = 0.0;

    List<CarritoVO> listaProductos = new ArrayList<>();
    List productos = new ArrayList();

    int idcompra;
    int idpago;
    double montopagar;
    int id_producto = 0;
    double descuento = 0.0;
    CarritoVO car = new CarritoVO();
    Fecha fechaSistem = new Fecha();
    PersonaVO perVO = new PersonaVO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        productos = pdao.Listar();
        String accion = request.getParameter("accion");
        switch (accion) {
            case "carrito":
                descuento = 0.0;
                totalPagar = 0.0;
                item = 0;
                subtotal = 0;
                request.setAttribute("Carrito", listaProductos);
                for (int i = 0; i < listaProductos.size(); i++) {
                    subtotal = subtotal + listaProductos.get(i).getSubTotal();
                    totalPagar = totalPagar + listaProductos.get(i).getSubTotal();
                    listaProductos.get(i).setItem(item + i + 1);
                    if (listaProductos.get(i).getItem() >= 10 || listaProductos.get(i).getCantidad() >= 10) {
                        descuento = (totalPagar * 0.05);
                        totalPagar = totalPagar - descuento;
                    }
                }
                request.setAttribute("subtotal", subtotal);
                request.setAttribute("descuento", descuento);
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                break;
            case "Comprar":
                agregarCarrito(request);
                request.getRequestDispatcher("ControladorProductos?accion=carrito").forward(request, response);
                break;
            case "AgregarCarrito":
                agregarCarrito(request);
                request.setAttribute("cont", listaProductos.size());
                request.getRequestDispatcher("ControladorProductos?accion=home").forward(request, response);
                break;
            case "deleteProducto":
                id_producto = Integer.parseInt(request.getParameter("id"));
                if (listaProductos != null) {
                    for (int j = 0; j < listaProductos.size(); j++) {
                        if (listaProductos.get(j).getIdProducto() == id_producto) {
                            listaProductos.remove(j);
                        }
                    }
                }
                break;
            case "updateCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int j = 0; j < listaProductos.size(); j++) {
                    if (listaProductos.get(j).getIdProducto() == idpro) {
                        listaProductos.get(j).setCantidad(cant);
                        double st = listaProductos.get(j).getPrecioCompra() * cant;
                        listaProductos.get(j).setSubTotal(st);
                    }
                }
                break;
            case "Nuevo":
                request.getRequestDispatcher("ControladorProductos?accion=home").forward(request, response);
                break;
            default:
                request.setAttribute("cont", listaProductos.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            case "Buscar":
                String nombre = request.getParameter("txtBuscar");
                response.getWriter().println(nombre);
                productos = pdao.buscar(nombre);
                request.setAttribute("cont", listaProductos.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "GenerarVenta":
                HttpSession sesion = request.getSession();
                UsuarioVO usuario = (UsuarioVO) sesion.getAttribute("UsuarioVO");

                if (usuario != null) {
                    PersonaVO per = new PersonaVO();
                    PersonaVO personaVo = (PersonaVO) sesion.getAttribute("PersonaVO");
//                System.out.println("Id del ususario" + personaVo.getId());
                    per.setId_persona(Integer.parseInt(personaVo.getId()));
                    VentaDAO venDAO = new VentaDAO();

                    VentaVO venVO = new VentaVO(fechaSistem.FechaBD(), fechaSistem.FechaBD(), totalPagar, descuento, per, listaProductos);
                    int res = venDAO.GenerarVenta(venVO);
                    if (res != 0 && totalPagar > 0) {
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("iniciarSesion", true);
                    request.setAttribute("mensajeIniciarSesion", "Debe iniciar sesion y Tener registradoss sus datos personales para poder comprar");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;

            case "MisCompras":
                // Obtener la sesion
                HttpSession sesion2 = request.getSession();
                // Asignar el vo de la persona que iniciar sesion
                PersonaVO personaVo2 = (PersonaVO) sesion2.getAttribute("PersonaVO");
//                int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

                CompraDAO compraDao = new CompraDAO();

                String idPersona = personaVo2.getId();
                System.out.println("idPersona = " + idPersona);

                if (!idPersona.equals("0")) {
                    List compra = compraDao.misCompras(Integer.parseInt(idPersona));
                    System.out.println("compra = " + compra);
//                    List compra = cdao.misCompras(u.getId_rol_fk());
                    request.setAttribute("myCompras", compra);
                    System.out.println("Entro");
                    request.getRequestDispatcher("vistas/compras.jsp").forward(request, response);
                } //                else if (listaProductos.size() > 0) {
                //                    request.getRequestDispatcher("ControladorProductos?accion=carrito").forward(request, response);
                //                }
                else {
                    System.out.println("Error, el id de la persona es: " + idPersona);
                    request.getRequestDispatcher("ControladorProductos?accion=home").forward(request, response);
                }
                break;

            case "MisQuejas":
                // Obtener la sesion
                HttpSession sesion3 = request.getSession();
                // Asignar el vo de la persona que iniciar sesion
                PersonaVO personaVo3 = (PersonaVO) sesion3.getAttribute("PersonaVO");
                QuejaDAO queDao = new QuejaDAO();
                String id_queja = personaVo3.getId();
                System.out.println("idqueja = " + id_queja);

                if (!id_queja.equals("0")) {
                    List queja = queDao.misQuejas(Integer.parseInt(id_queja));
                    System.out.println("queja = " + queja);
                    request.setAttribute("myQueja", queja);
                    System.out.println("Entro");
                    request.getRequestDispatcher("vistas/Misquejas.jsp").forward(request, response);
                } else {
                    System.out.println("Error, el id de la persona es: " + id_queja);
                    request.getRequestDispatcher("ControladorProductos?accion=home").forward(request, response);
                }
                break;

            case "NuevoProducto":
                List<ProductoVO> productoss = pdao.ListarProductos();
                request.setAttribute("productos", productoss);
                request.getRequestDispatcher("Listares/ListarProductoPrueba.jsp").forward(request, response);
                break;
            case "GuardarProducto":
                ArrayList<String> pro = new ArrayList<>();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File file = new File("C:/xampp/htdocs/carrito/PRODUCTOS/" + fileItem.getName());
                            fileItem.write(file);
                            proVO.setImagen("http://localhost/carrito/PRODUCTOS/" + fileItem.getName());
                        } else {
                            pro.add(fileItem.getString());
                        }
                    }
                    proVO.setNombre_producto(pro.get(0));
                    proVO.setMarca_producto(pro.get(1));
                    proVO.setCantidad_producto(Integer.parseInt(pro.get(2)));
                    proVO.setPrecio_producto(Double.parseDouble(pro.get(3)));
                    proVO.setDescripcion_producto(pro.get(4));
                    pdao.AgregarNuevoProducto(proVO);
                } catch (Exception e) {
                    System.err.println("" + e);
                }
                request.getRequestDispatcher("vistas/addProducto.jsp").forward(request, response);
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

    public void agregarCarrito(HttpServletRequest request) {
        cantidad = 1;
        int pos = 0;
        int idpp = Integer.parseInt(request.getParameter("id"));
        if (listaProductos.size() > 0) {
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getIdProducto() == idpp) {
                    pos = i;
                }
            }
            if (idpp == listaProductos.get(pos).getIdProducto()) {
                cantidad = listaProductos.get(pos).getCantidad() + cantidad;
                subtotal = listaProductos.get(pos).getPrecioCompra() * cantidad;
                listaProductos.get(pos).setCantidad(cantidad);
                listaProductos.get(pos).setSubTotal(subtotal);
            } else {
                car = new CarritoVO();
                proVO = pdao.listarId(idpp);
                car.setIdProducto(proVO.getId());
                car.setNombres(proVO.getNombre_producto());
                car.setMarca(proVO.getMarca_producto());
                car.setImagen(proVO.getImagen());
                car.setDescripcion(proVO.getDescripcion_producto());
                car.setPrecioCompra(proVO.getPrecio_producto());
                car.setCantidad(cantidad);
                subtotal = cantidad * proVO.getPrecio_producto();
                car.setSubTotal(subtotal);
                listaProductos.add(car);
            }
        } else {
            car = new CarritoVO();
            proVO = pdao.listarId(idpp);
            car.setIdProducto(proVO.getId());
            car.setNombres(proVO.getNombre_producto());
            car.setMarca(proVO.getMarca_producto());
            car.setImagen(proVO.getImagen());
            car.setDescripcion(proVO.getDescripcion_producto());
            car.setPrecioCompra(proVO.getPrecio_producto());
            car.setCantidad(cantidad);
            car.setSubTotal(cantidad * proVO.getPrecio_producto());
            car.setSubTotal(subtotal);
            listaProductos.add(car);

        }
    }
}
