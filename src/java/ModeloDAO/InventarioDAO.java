/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.InventarioVO;
import Util.Crud;
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
public class InventarioDAO extends ConexionBD implements Crud {
     public InventarioDAO (){}
    
    

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;

    private boolean operacion = false;
    private String sql;
    private String id_inventario = "", informacion_inventario = "", fecha_inventario = "", perdidas_productos = "", id_producto_fk = "", id_empleado_fk = "";

    public InventarioDAO(InventarioVO invVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_inventario = invVO.getId_inventario();
            informacion_inventario = invVO.getInformacion_inventario();
            fecha_inventario = invVO.getFecha_inventario();
            perdidas_productos = invVO.getPerdidas_productos();
            id_producto_fk = invVO.getId_producto_fk();
            id_empleado_fk = invVO.getId_empleado_fk();

        } catch (Exception e) {
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO inventario(id_inventario, informacion_inventario, fecha_inventario, perdidas_productos, id_producto_fk, id_persona_fk) values (?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_inventario);
            puente.setString(2, informacion_inventario);
            puente.setString(3, fecha_inventario);
            puente.setString(4, perdidas_productos);
            puente.setString(5, id_producto_fk);
            puente.setString(6, id_empleado_fk); 
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
            return operacion;
        }
    }
    
     public InventarioVO consultarId(String id_inventario){
        InventarioVO ivvVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql = "select *from inventario where id_inventario =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_inventario);
            mensajero = puente.executeQuery();
            while(mensajero.next())
            {
                ivvVO = new InventarioVO(mensajero.getString(1),mensajero.getString(2), mensajero.getString(3),mensajero.getString(4), mensajero.getString(5),mensajero.getString(6));
            }
        } catch (Exception e) {
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
                
            }
        }
        return ivvVO;
    }
    
    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update inventario set informacion_inventario = ?, fecha_inventario = ?, perdidas_productos = ?, id_producto_fk = ?, id_empleado_fk = ? where id_inventario = ?"; 
            puente = conexion.prepareStatement(sql);    
            puente.setString(1, informacion_inventario);
            puente.setString(2, fecha_inventario);
            puente.setString(3, perdidas_productos);
            puente.setString(4, id_producto_fk);
            puente.setString(5, id_empleado_fk);
            puente.setString(6, id_inventario);
            puente.executeUpdate();
            operacion = true;
            System.out.println("El Inventario se actualizo correctamente");
        } catch (SQLException e) {
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                 Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
     return operacion;

    }    

     public List ListarInventario() {
        ArrayList<InventarioVO> inventario = new ArrayList<>();
        sql = "select * from inventario";
        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                InventarioVO inv = new InventarioVO();
                inv.setId_inventario(mensajero.getString(1));
                inv.setInformacion_inventario(mensajero.getString(2));
                inv.setFecha_inventario(mensajero.getString(3));
                inv.setPerdidas_productos(mensajero.getString(4));
                inv.setId_producto_fk(mensajero.getString(5));
                inv.setId_empleado_fk(mensajero.getString(6));
                inventario.add(inv);
            }
        } catch (SQLException e) {
        }
        return inventario;
    }

}
