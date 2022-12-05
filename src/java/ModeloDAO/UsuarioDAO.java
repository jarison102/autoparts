/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioStrings;
import ModeloVO.UsuarioVO;
import Util.ConexionBD;
import Util.Crud;
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
public class UsuarioDAO extends ConexionBD implements Crud {

    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;

    private double total_venta;
    private double precio_venta;
    String email = "", clave_usuario = "", estado_usuario = "", id_rol_fk = "";
    int rol = 2;
    String id_usuario;

    // Varaibles usuarioStrings
    String id;
    String email_usuario;
    String clave;
    String estado;
    ConexionBD con = new ConexionBD();
    private boolean operacionExitosa;

    public UsuarioDAO() {
    }

    public UsuarioDAO(UsuarioStrings usus) {
        super();
        try {
            conexion = this.obtenerConexion();
            id = usus.getId_usuario();
            email_usuario = usus.getEmail();
            clave = usus.getClave_usuario();
            estado = usus.getEstado_usuario();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            int id_usuario = usuVO.getId_usuario();
            email = usuVO.getEmail();
            clave_usuario = usuVO.getClave_usuario();
            boolean estado_usuario = usuVO.isEstado_usuario();
            id_rol_fk = usuVO.getId_rol_fk();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public UsuarioVO login(String email, String clave_usuario) {
        UsuarioVO usuVO = null;

        sql = "Select * from usuario where email = ? AND clave_usuario = ?";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email);
            puente.setString(2, clave_usuario);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                int id_usuario = mensajero.getInt("id_usuario");
                email = mensajero.getString("email");
                clave_usuario = mensajero.getString("clave_usuario");
                boolean estado_usuario = mensajero.getBoolean("estado_usuario");
                id_rol_fk = mensajero.getString("id_rol_fk");

                usuVO = new UsuarioVO(id_usuario, email, clave_usuario, estado_usuario, id_rol_fk);
            }

        } catch (SQLException e) {
            System.out.println("Error en el login");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuVO;
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO `usuario`( email, clave_usuario, id_rol_fk) VALUES (?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email_usuario);
            puente.setString(2, clave);
            puente.setInt(3, rol);
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

    public ArrayList<UsuarioStrings> ListarU() {
        ArrayList<UsuarioStrings> ListarUsuarios = new ArrayList<>();
        UsuarioStrings usus = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select u.id_usuario, u.email, u.estado_usuario,u.id_rol_fk, r.nombre_rol from usuario u inner join rol r on u.id_rol_fk = r.id_rol order by r.id_rol";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usus = new UsuarioStrings(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

                ListarUsuarios.add(usus);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {

                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return ListarUsuarios;
    }

    public UsuarioStrings consultarId(String id_usuario) {
        UsuarioStrings usus = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select *from usuario where id_usuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_usuario);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usus = new UsuarioStrings(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return usus;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update usuario set email= ?, clave_usuario= ?, estado_usuario= ? where id_usuario = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email);
            puente.setString(2, clave);
            puente.setString(3, estado);
            puente.setString(4, id);
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
    public List Listar() {
        ArrayList<UsuarioStrings> usuarios = new ArrayList<>();
        sql = "select * from usuario";
        try {

            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                UsuarioStrings usus = new UsuarioStrings();
                usus.setId_usuario(mensajero.getString(1));
                usus.setEmail(mensajero.getString(2));
                usus.setClave_usuario(mensajero.getString(3));
                usus.setEstado_usuario(mensajero.getString(4));
                usus.setId_rol_fk(mensajero.getString(5));
                usuarios.add(usus);
            }
        } catch (SQLException e) {
        }
        return usuarios;
    }

    public boolean InactivarUsuario(int id) {
        try {
            sql = "update usuario set estado_usuario='0' where id_usuario=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, id);
            puente.executeUpdate();
            operacionExitosa = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacionExitosa;

    }

    public boolean ActivarUsuario(int id) {
        try {
            sql = "update usuario set estado_usuario='1' where id_usuario=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, id);
            puente.executeUpdate();
            operacionExitosa = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacionExitosa;

    }

}
