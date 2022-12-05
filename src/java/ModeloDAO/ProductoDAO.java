/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
import Util.ConexionBD;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author No se que poner
 */
public class ProductoDAO extends ConexionBD  {

    public ProductoDAO() {
    }

    ConexionBD con = new ConexionBD();
    Connection conexion;
    PreparedStatement puente;
    ResultSet mensajero;
    private String sql;
    int r=0;

    //Listar productos en general ( para carrito ) 
    public List Listar() {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        sql = "select * from producto where estado = 'Disponible'  order by nombre_producto ";
        try {

            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO proVO = new ProductoVO();
                proVO.setId(mensajero.getInt(1));
                proVO.setNombre_producto(mensajero.getString(2));
                proVO.setMarca_producto(mensajero.getString(3));
                proVO.setCantidad_producto(mensajero.getInt(4));
                proVO.setImagen(mensajero.getString(5));
//                proVO.setFoto(mensajero.getString(5));
                proVO.setPrecio_producto(mensajero.getDouble(6));
                proVO.setDescripcion_producto(mensajero.getString(7));
                proVO.setEstado(mensajero.getString(8));
                productos.add(proVO);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
    
    
       public List ListarProductos() {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        sql = "select * from producto order by nombre_producto ";
        try {

            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO proVO = new ProductoVO();
                proVO.setId(mensajero.getInt(1));
                proVO.setNombre_producto(mensajero.getString(2));
                proVO.setMarca_producto(mensajero.getString(3));
                proVO.setCantidad_producto(mensajero.getInt(4));
                proVO.setImagen(mensajero.getString(5));
//                proVO.setFoto(mensajero.getString(5));
                proVO.setPrecio_producto(mensajero.getDouble(6));
                proVO.setDescripcion_producto(mensajero.getString(7));
                proVO.setEstado(mensajero.getString(8));
                productos.add(proVO);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
    

// Listar para la imagen
    public void listarImg(int id, HttpServletResponse response) {
        sql = "select *from producto where id_producto=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = response.getOutputStream();
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                inputStream = mensajero.getBinaryStream("foto");

            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;

            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);

            }
        } catch (Exception e) {
        }

    }
    
    //Listar Producto por id

   public ProductoVO listarId(int id) {
        ProductoVO p = new ProductoVO();
        String sql = "select * from producto where id_producto=" + id;
        try {
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                p.setId(mensajero.getInt(1));
                p.setNombre_producto(mensajero.getString(2));
                p.setMarca_producto(mensajero.getString(3));
                p.setCantidad_producto(mensajero.getInt(4));
                p.setImagen(mensajero.getString(5));
//                p.setFoto(rs.getBinaryStream(5));
                p.setPrecio_producto(mensajero.getDouble(6));
                p.setDescripcion_producto(mensajero.getString(7));
                             
            }
        } catch (Exception e) {
        }
        return p;
    }
   
   
   // Listar para la compra al proveedor
   public ProductoVO listarIdproducto(String Id_producto) {
        ProductoVO p = new ProductoVO();
        String sql = "select * from producto where id_producto=" + Id_producto;
        try {
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                p.setId_producto(mensajero.getString(1));
                p.setNombre_producto(mensajero.getString(2));
                p.setMarca_producto(mensajero.getString(3));
                p.setCantidad_producto(mensajero.getInt(4));
                p.setImagen(mensajero.getString(5));
//                p.setFoto(rs.getBinaryStream(5));
                p.setPrecio_producto(mensajero.getDouble(6));
                p.setDescripcion_producto(mensajero.getString(7));
                             
            }
        } catch (Exception e) {
        }
        return p;
    }
   //Buscar producto funcional
    public List buscar(String nombre) {
        List list=new ArrayList();
        String sql = "select * from producto where nombre_producto like '%"+nombre+"%'";
        try {
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO p=new ProductoVO();
                p.setId(mensajero.getInt(1));
                p.setNombre_producto(mensajero.getString(2));
                p.setMarca_producto(mensajero.getString(3));
                p.setCantidad_producto(mensajero.getInt(4));
                p.setImagen(mensajero.getString(5));
//               p.setFoto(rs.getBinaryStream(5));
                p.setPrecio_producto(mensajero.getDouble(6));
                p.setDescripcion_producto(mensajero.getString(7));               
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    // Metodo agregar productos con imagen funcional
     public int AgregarNuevoProducto(ProductoVO p) {
        sql = "insert into producto(nombre_producto,marca_producto,cantidad_producto,foto,precio_producto,descripcion_producto)values(?,?,?,?,?,?)";
        try {
            puente = conexion.prepareStatement(sql);
            puente.setString(1, p.getNombre_producto());
            puente.setString(2, p.getMarca_producto());
            puente.setInt(3, p.getCantidad_producto());
            puente.setString(4, p.getImagen());
            puente.setDouble(5, p.getPrecio_producto());
            puente.setString(6, p.getDescripcion_producto());
            puente.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     

}
