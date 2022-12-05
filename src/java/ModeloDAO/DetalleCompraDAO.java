/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DetalleCompraVO;
import Util.Crud;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class DetalleCompraDAO  extends ConexionBD implements Crud{
    
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    private String  id_detalle_compra ="",id_producto_fk="",id_compra_fk="", precio_compra="",cantidad_compra="";

    public DetalleCompraDAO() {
    }
    
      public DetalleCompraDAO(DetalleCompraVO decVO){
    super();
        try {
            conexion = this.obtenerConexion();
            id_detalle_compra = decVO.getId_detalle_compra();
            id_producto_fk = decVO.getId_producto_fk();
            id_compra_fk = decVO.getId_compra_fk();
            precio_compra = decVO.getPrecio_compra();
            cantidad_compra = decVO.getCantidad_compra();
           
        } catch (Exception e) {
            Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO detallecompra(id_producto_fk,id_compra_fk,precio_compra,cantidad_compra,) VALUES(?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_producto_fk);
            puente.setString(2, id_compra_fk);
            puente.setString(3, precio_compra);
            puente.setString(4, cantidad_compra);
            puente.executeUpdate();
            operacion = true;
        } 
        catch (SQLException e) {
            Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {
            try {
                this.cerrarConexion();
            } 
            catch (SQLException e) {
                Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update detallecompra set id_producto_fk = ?, id_compra_fk = ?,precio_compra= ?, cantidad_compra= ? where id_detalle_compra = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_producto_fk);
            puente.setString(2, id_compra_fk);
            puente.setString(3, precio_compra);
            puente.setString(4, cantidad_compra);
            puente.setString(5, id_detalle_compra);
            puente.executeUpdate();
            operacion = true;
            System.out.println("La compra se actualizo correctamente");
        } catch (SQLException e) {
            Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    public DetalleCompraVO consultarId(String id_detalle_compra){
        DetalleCompraVO DetalleCompraVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql = "select *from detallecompra where id_detalle_compra=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_detalle_compra);
            mensajero = puente.executeQuery();
            while(mensajero.next())
            {
                DetalleCompraVO = new DetalleCompraVO(mensajero.getString(1),mensajero.getString(2), mensajero.getString(3),mensajero.getString(4), mensajero.getString(5));
            }
        } catch (Exception e) {
            Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
                
            }
        }
        return DetalleCompraVO;
    }
    public ArrayList<DetalleCompraVO>listard(){
        ArrayList<DetalleCompraVO>Listardetalles = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "Select *from detallecompra";
            puente= conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            
            while(mensajero.next())
            {
                DetalleCompraVO detaVO = new DetalleCompraVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3),mensajero.getString(4), mensajero.getString(5));
                Listardetalles.add(detaVO);
            }    
             
        } 
        catch (SQLException e) {
            Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return Listardetalles;
}

}
