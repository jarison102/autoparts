/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProveedorVO;
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
 * @author Sergio
 */


public class ProveedorDAO  extends ConexionBD implements Crud{
    public ProveedorDAO(){} 
    
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;

    private boolean operacion = false;
    private String sql; 
    private String id_proveedor = "", nombre_proveedor = "", telefono_proveedor = "", correo_proveedor = "";
    
public ProveedorVO buscar(String Id_proveedor){
    ProveedorVO p = new ProveedorVO();
    
    String sql="Select * from proveedor where id_proveedor = "+Id_proveedor;
    try {
        conexion = this.obtenerConexion();
        puente = conexion.prepareStatement(sql);
        mensajero = puente.executeQuery();
        while(mensajero.next()){
            p.setId_proveedor(mensajero.getString(1));
            p.setNombre_proveedor(mensajero.getString(2));
            p.setTelefono_proveedor(mensajero.getString(3));
            p.setCorreo_proveedor(mensajero.getString(4));
        }
        
    } catch (Exception e) {
    }
        return p;
}
    public ProveedorDAO(ProveedorVO prvVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_proveedor = prvVO.getId_proveedor();
            nombre_proveedor = prvVO.getNombre_proveedor();
            telefono_proveedor = prvVO.getTelefono_proveedor();
            correo_proveedor = prvVO.getCorreo_proveedor();
           
        } catch (Exception e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
 try {
            sql = "INSERT INTO proveedor( nombre_proveedor, telefono_proveedor, correo_proveedor) VALUES (?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre_proveedor);
            puente.setString(2, telefono_proveedor);
            puente.setString(3, correo_proveedor);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);

            }
            
        } 
        return operacion;
    }
    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update proveedor set nombre_proveedor = ?, telefono_proveedor = ?, correo_proveedor = ? where id_proveedor = ?"; 
            puente = conexion.prepareStatement(sql);
            puente.setString(1,nombre_proveedor);
            puente.setString(2,telefono_proveedor);
            puente.setString(3, correo_proveedor);
            puente.setString(4,id_proveedor);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                 Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
     return operacion;

    }
    
    
     public ProveedorVO consultarId(String id_proveedor){
        ProveedorVO prvVO = null;
        
        try {
            conexion = this.obtenerConexion();
            sql = "select *from proveedor where id_proveedor =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_proveedor);
            mensajero = puente.executeQuery();
            while(mensajero.next())
            {
                prvVO = new ProveedorVO(mensajero.getString(1),mensajero.getString(2), mensajero.getString(3),mensajero.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, e);
                
            }
        }
        return prvVO;
    }
     
     public List ListarProveedores() {
        ArrayList<ProveedorVO> proveedores = new ArrayList<>();
        sql = "select * from proveedor";
        try {
            conexion = obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProveedorVO pro = new ProveedorVO();
                pro.setId_proveedor(mensajero.getString(1));
                pro.setNombre_proveedor(mensajero.getString(2));
                pro.setTelefono_proveedor(mensajero.getString(3));
                pro.setCorreo_proveedor(mensajero.getString(4));
                proveedores.add(pro);
            }
        } catch (SQLException e) {
        }
        return proveedores;
    }
  
     public ProveedorVO BuscarProveedor(int id){
        ProveedorVO proveedor = new ProveedorVO();
        String consulta = "SELECT * FROM proveedor WHERE id_proveedor = ?";
        conexion = this.obtenerConexion();
        try {
            puente = conexion.prepareStatement(consulta);
            puente.setInt(1, id);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                proveedor.setId_proveedor(mensajero.getString("id_proveedor"));
                proveedor.setNombre_proveedor(mensajero.getString("nombre_proveedor"));
                proveedor.setTelefono_proveedor(mensajero.getString("telefono"));
                proveedor.setCorreo_proveedor(mensajero.getString("correo_proveedor"));
                System.err.println(""+proveedor.getNombre_proveedor());
              }
        } catch (Exception e) {
        }
        return proveedor;
    }

}