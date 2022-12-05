/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CarritoVO;
import ModeloVO.VentaVO;
import ModeloVO.VentasVO;
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
 * @author No se que poner
 */
public class VentaDAO extends ConexionBD {

    Connection conexion;
    ResultSet mensajero;
    private PreparedStatement puente;
    String sql;

    int r = 0;
    private boolean operacionExitosa;

    public VentaDAO(VentaVO venVO) {

    }

    public VentaDAO() {

    }

    public List listar() {
        ArrayList<VentasVO> list = new ArrayList<>();
        String sql = "select * from venta";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentasVO vensVO = new VentasVO();
                vensVO.setId(mensajero.getInt("id_venta"));
                vensVO.setFecha_venta(mensajero.getString("fecha_venta"));
                vensVO.setFecha_entrega(mensajero.getString("fecha_entrega"));
                vensVO.setTotal_venta(mensajero.getString("total_venta"));
                vensVO.setId_persona_fk(mensajero.getString("id_persona_fk"));
                list.add(vensVO);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public VentasVO list(int id) {
        String sql = "select * from venta where id_venta=" + id;
        VentasVO vensVO = new VentasVO();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                vensVO.setId(mensajero.getInt("id_venta"));
                vensVO.setFecha_venta(mensajero.getString("fecha_venta"));
                vensVO.setFecha_entrega(mensajero.getString("fecha_entrega"));
                vensVO.setTotal_venta(mensajero.getString("total_venta"));
                vensVO.setId_persona_fk(mensajero.getString("id_persona_fk"));

            }
        } catch (SQLException e) {
        }
        return vensVO;
    }

    public boolean add(VentasVO vensVO) {
        String sql = "insert into venta(fecha_venta, fecha_entrega, total_venta, id_persona_fk)values('" + vensVO.getFecha_entrega() + "','" + vensVO.getFecha_venta() + "','" + vensVO.getTotal_venta() + "','" + vensVO.getId_persona_fk() + "')";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean edit(VentasVO vensVO) {
        String sql = "update venta set fecha_venta='" + vensVO.getFecha_venta() + "',fecha_entrega='" + vensVO.getFecha_entrega() + "',total_venta='" + vensVO.getTotal_venta() + "',id_persona_fk='" + vensVO.getId_persona_fk() + "'where id_venta=" + vensVO.getId();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "delete from persona where id_venta=" + id;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    public int GenerarVenta(VentaVO venVO) {
        int id_venta;
        sql = "insert into venta ( fecha_venta,fecha_entrega,total_venta,descuento,id_persona_fk) values(?,?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);

            puente.setString(1, venVO.getFecha_venta());
            puente.setString(2, venVO.getFecha_entrega());
            puente.setDouble(3, venVO.getTotal_venta());
            puente.setDouble(4, venVO.getDescuento());
            puente.setInt(5, venVO.getPersonaVO().getId_persona());
            r = puente.executeUpdate();

            sql = " select @@identity as id_venta";
            mensajero = puente.executeQuery(sql);
            mensajero.next();

            id_venta = mensajero.getInt("id_venta");
            mensajero.close();
            for (CarritoVO detalle : venVO.getDetalleventas()) {
                sql = "insert into detalleventa (id_venta_fk, id_producto_fk, cantidad, precio_venta) values(?,?,?,?)";
                puente = conexion.prepareStatement(sql);
                puente.setInt(1, id_venta);
                puente.setInt(2, detalle.getIdProducto());
                puente.setInt(3, detalle.getCantidad());
                puente.setDouble(4, detalle.getPrecioCompra());

                r = puente.executeUpdate();
            }

        } catch (Exception e) {
        }
        return r;

    }

    public List ListarVentas() {
        ArrayList<VentasVO> ventas = new ArrayList<>();
        sql = "select * from venta";
        try {

            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VentasVO ven = new VentasVO();
                ven.setId(mensajero.getInt(1));
                ven.setFecha_venta(mensajero.getString(2));
                ven.setFecha_entrega(mensajero.getString(3));
                ven.setTotal_venta(mensajero.getString(4));
                ven.setDescuento(mensajero.getDouble(5));
                ven.setId_persona_fk(mensajero.getString(6));
                ven.setEstado(mensajero.getString(7));
                ventas.add(ven);
            }
        } catch (SQLException e) {
        }
        return ventas;
    }

    public boolean InactivarVenta(int id) {
        sql = "update venta set estado='Entregado' where id_venta=?";
        try {

            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, id);
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
    
    public boolean ActivarVenta(int id) {
        try {
            sql = "update venta set estado='Pendiente' where id_venta=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, id);
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
