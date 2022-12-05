/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
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
public class RolDAO  extends ConexionBD{
    public RolDAO() {
    }
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    private String id_rol="", nombre_rol="";

    public RolDAO(RolVO rVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_rol = rVO.getId_rol();
            nombre_rol = rVO.getNombre_rol();
            
        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

   
    public ArrayList<RolVO>Roles() {
        ArrayList<RolVO> ListarRol = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                RolVO rVO = new RolVO(mensajero.getString(1), mensajero.getString(2));
                ListarRol.add(rVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {

                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return ListarRol;
    }
}
