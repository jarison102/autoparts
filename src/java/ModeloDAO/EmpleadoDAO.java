/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

/**
 *
 * @author Jarrison
 */
import ModeloVO.UsuarioStrings;
import Util.ConexionBD;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoDAO extends ConexionBD implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String id_usuario;
    private String email;
    private String clave_usuario;
    private String estado_usuario;
    private String id_rol_fk;
    private int estado = 1;

    public EmpleadoDAO(UsuarioStrings usuStrings) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_usuario = usuStrings.getId_usuario();
            email = usuStrings.getEmail();
            clave_usuario = usuStrings.getClave_usuario();
            estado_usuario = usuStrings.getEstado_usuario();
            id_rol_fk = usuStrings.getId_rol_fk();

        } catch (Exception e) {
            Logger.getLogger(DetalleCompraDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO `usuario`( email, clave_usuario,id_rol_fk) VALUES (?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email); 
            puente.setString(2, clave_usuario);
            puente.setString(3, id_rol_fk);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
