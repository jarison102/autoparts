/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ComprasVO;
import ModeloVO.VentaVariablesVO;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sergio
 */
public class CompraDAO extends ConexionBD  {

    private boolean operacionExitosa;

    public CompraDAO() {
    }

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;

    private String sql;
    int r; 

    public CompraDAO(ComprasVO comVO) {
    }

   
 
    public String idCompra (){
    String id_compras ="";
    sql="Select max(id_compra) from compra";
        try {
            conexion = this.obtenerConexion();
            puente= conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                id_compras = mensajero.getString(1);
                
            }
            
        } catch (Exception e) {
        }
        return id_compras;
        
    }
    public int GuardarCompra(ComprasVO c){
        sql ="insert into compra (fecha_compra, total_compra,estado_compra, id_proveedor_fk) values(?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            
            puente.setString(1, c.getFecha_compra());
            puente.setDouble(2, c.getTotal_compra());
            puente.setString(3, c.getEstado_compra());
            puente.setString(4, c.getId_proveedor_fk());
            puente.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int GuardarDetalleCompra(ComprasVO c){
        sql = "insert into detallecompra(id_producto_fk, id_compra_fk, precio_compra,cantidad_compra) values(?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, c.getId_producto_fk());
            puente.setInt(2, c.getId_compra_fk());
            puente.setDouble(3, c.getPrecio());
            puente.setInt(4, c.getCantidad());
            puente.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
   public List misCompras(int id) {
        List lista = new ArrayList();
        sql = "SELECT usuario.id_usuario as IdUsu, venta.id_persona_fk as IdPersona,usuario.email as Correo,concat(persona.nombre,' ',persona.apellido) AS Persona, venta.id_venta as IdVenta,venta.fecha_venta as FechaVenta,venta.fecha_entrega as FechaEntrega,producto.nombre_producto as Nombre, detalleventa.cantidad as Cantidad ,detalleventa.precio_venta as PrecioVenta, venta.total_venta as Total FROM usuario INNER JOIN persona on usuario.id_usuario=persona.id_usuario_fk INNER JOIN venta on venta.id_persona_fk=persona.id_persona INNER JOIN detalleventa on venta.id_venta=detalleventa.id_venta_fk INNER JOIN producto on detalleventa.id_producto_fk=producto.id_producto WHERE id_persona = ?" ;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, id);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentaVariablesVO com = new VentaVariablesVO();
                com.setIdusuario(mensajero.getInt(1));
                com.setIdpersona(mensajero.getInt(2));
                com.setCorreo(mensajero.getString(3));
                com.setPersona(mensajero.getString(4));
                com.setIdventa(mensajero.getInt(5));
                com.setFechaventa(mensajero.getString(6));
                com.setFechaentrega(mensajero.getString(7));
                com.setNombreproducto(mensajero.getString(8));
                com.setCantidad(mensajero.getInt(9));
                com.setPrecioVenta(mensajero.getDouble(10));
                com.setTotalventa(mensajero.getDouble(11));
                lista.add(com);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List ListarCompras() {
        ArrayList<ComprasVO> compras = new ArrayList<>();
        sql = "select * from compra";
        try {

            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ComprasVO com = new ComprasVO();
                com.setId(mensajero.getString(1));
                com.setFecha_compra(mensajero.getString(2));
                com.setTotal_compra(mensajero.getDouble(3));
                com.setEstado_compra(mensajero.getString(4));
                com.setId_proveedor_fk(mensajero.getString(5));
                compras.add(com);
            }
        } catch (SQLException e) {
        }
        return compras;
    }   
    
        public boolean InactivarCompra(String id) {
          sql = "update compra set estado_compra='Entregado' where id_compra=?";
        try {
          
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.executeUpdate();
            operacionExitosa = true;

        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacionExitosa;

    }

    public boolean ActivarCompra(String id) {
        try {
            sql = "update compra set estado_compra='Pendiente' where id_compra=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.executeUpdate();
            operacionExitosa = true;

        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacionExitosa;

    }

    
    
    
    
}
