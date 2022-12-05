/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.PersonaVO;
import Util.ConexionBD;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author No se que poner
 */
public class PersonaDAO extends ConexionBD implements Crud {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;

    private boolean operacion = false;
    private String sql;
    String id = "", nombre = "", apellido = "", tdoc = "", documento = "", telefono = "", direccion = "", id_usuario_fk = "";
    int id_persona;

    public PersonaDAO() {
    }

    public PersonaDAO(PersonaVO perVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id = perVO.getId();
            id_persona = perVO.getId_persona();
            nombre = perVO.getNombre();
            apellido = perVO.getApellido();
            tdoc = perVO.getTdoc();
            documento = perVO.getDocumento();
            telefono = perVO.getTelefono();
            direccion = perVO.getDireccion();
            id_usuario_fk = perVO.getId_usuario_fk();

        } catch (Exception e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO `persona`( nombre, apellido, tdoc, documento, telefono, direccion, id_usuario_fk) VALUES (?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, apellido);
            puente.setString(3, tdoc);
            puente.setString(4, documento);
            puente.setString(5, telefono);
            puente.setString(6, direccion);
            puente.setString(7, id_usuario_fk);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;

    }

    public ArrayList<PersonaVO> ListarP() {
        PersonaVO perVO = null;
        ArrayList<PersonaVO> ListarPersonas = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from persona ";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                perVO = new PersonaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                ListarPersonas.add(perVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {

                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return ListarPersonas;
    }

    public PersonaVO consultarId(String id) {
        PersonaVO perVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select *from persona where id_usuario_fk=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                perVO = new PersonaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
            }
        } catch (SQLException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return perVO;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update persona set nombre= ?, apellido= ?, tdoc= ? , documento =?, telefono=?, direccion =?, id_usuario_fk=? where id_persona = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, apellido);
            puente.setString(3, tdoc);
            puente.setString(4, documento);
            puente.setString(5, telefono);
            puente.setString(6, direccion);
            puente.setString(7, id_usuario_fk);
            puente.setString(8, id);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

}
