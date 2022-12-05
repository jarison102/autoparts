/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.QuejaVO;
import Util.ConexionBD;
import Util.Crud;
import Util.Fecha;
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
 * @author kevin
 */
public class QuejaDAO extends ConexionBD implements Crud {
    
    Fecha fechasystem = new Fecha();
    private boolean operacionExitosa;
    public QuejaDAO() {
    }
    
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    Fecha fechaSistem = new Fecha();
    private String id_queja = "", id_usuario_fk = "",fecha_queja = "",asunto= "",detalle= "",estado_queja = "";
    
    public QuejaDAO(QuejaVO qejVO){
            super();
        try {
            conexion=this.obtenerConexion();
            id_queja= qejVO.getId_queja();
            id_usuario_fk=qejVO.getId_usuario_fk();
            fecha_queja =qejVO.getFecha_queja();
            asunto=qejVO.getAsunto();
            detalle=qejVO.getDetalle();
            estado_queja=qejVO.getEstado_queja();
        } catch (Exception e) {
             Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    

           
    }
    @Override
    public boolean agregarRegistro() {
        try {
            sql="INSERT INTO queja(id_usuario_fk,fecha_queja,asunto,detalle,estado_queja) values(?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_usuario_fk);
            puente.setString(2, fechaSistem.FechaBD());
            puente.setString(3, asunto);
            puente.setString(4, detalle);
            puente.setString(5, estado_queja);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update queja set id_usuario_fk = ?,fecha_queja = ?,asunto =?,detalle= ?, estado_queja = ? where id_queja = ?"; 
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_usuario_fk);
            puente.setString(2, fecha_queja);
            puente.setString(3, asunto);
            puente.setString(4, detalle);
            puente.setString(5, estado_queja);
            puente.setString(6, id_queja);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                 Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
     return operacion;

    }

 
    
    public QuejaVO consultarId(String id_queja){
        QuejaVO quejaVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql = "select *from queja where id_queja =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_queja);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                quejaVO = new QuejaVO(mensajero.getString(1),mensajero.getString(2), mensajero.getString(3),mensajero.getString(4), mensajero.getString(5),mensajero.getString(6));
            }
            
        } catch (Exception e) {
            Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
                
            }
        }
        return quejaVO;
    }
    
       public List ListarQuejas() {
        ArrayList<QuejaVO> quejas = new ArrayList<>();
        sql = "select * from queja ";
        try {

            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                QuejaVO que = new QuejaVO();
                que.setId_queja(mensajero.getString(1));
                que.setId_usuario_fk(mensajero.getString(2));
                que.setFecha_queja(mensajero.getString(3));
                que.setAsunto(mensajero.getString(4));
                que.setDetalle(mensajero.getString(5));
                que.setEstado_queja(mensajero.getString(6));
                quejas.add(que);
            }
        } catch (SQLException e) {
        }
        return quejas;
    }
       public List misQuejas(int id) {
        List lista = new ArrayList();
        String sql = "Select * from queja  WHERE id_usuario_fk=? ORDER BY fecha_queja";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, id);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                QuejaVO  queVO = new QuejaVO();
                queVO.setId_queja(mensajero.getString(1));
                queVO.setId_usuario_fk(mensajero.getString(2));
                queVO.setFecha_queja(mensajero.getString(3));
                queVO.setAsunto(mensajero.getString(4));
                queVO.setDetalle(mensajero.getString(5));
                queVO.setEstado_queja(mensajero.getString(6));
                lista.add(queVO);
            }
        } catch (Exception e) {
        }
        return lista;
    }
       
       
    public boolean InactivarQueja(String id_queja) {
        sql = "update queja set estado_queja='Finalizado' where id_queja=?";
        try {

            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_queja);
            puente.executeUpdate();
            operacionExitosa = true;

        } catch (SQLException e) {
            Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacionExitosa;

    }

    public boolean ActivarQueja(String id_queja) {
        try {
            sql = "update queja set estado_queja='Pendiente' where id_queja=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_queja);
            puente.executeUpdate();
            operacionExitosa = true;

        } catch (SQLException e) {
            Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(QuejaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacionExitosa;

    }
       
       
}
    

