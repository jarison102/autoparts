/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author No se que poner
 */
public class ConexionBD {
    //1 - Declarar variables y objetos 
    private String driver,userDB,passwordDB,database,urlDB;
    private Connection conexion;
    
    public ConexionBD(){
        //2 - Asignar valores
        driver ="com.mysql.jdbc.Driver";
        userDB="root";
        passwordDB="";
        database="autoparts";
        urlDB="jdbc:mysql://localhost:3306/"+database;
        
        //3 - Conectarse
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlDB, userDB, passwordDB);
            System.out.println("Conexión tabien");
        } 
        catch (Exception e) {
            System.out.println("Error:c" + e.toString());
        }
    }
    
    public Connection obtenerConexion(){
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    
    public static void main(String[] args) {
        new ConexionBD();
    }
}
