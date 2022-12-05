/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author No se que poner
 */
public class UsuarioStrings {
    String id_usuario;
    String email; 
    String clave_usuario;
    String estado_usuario;
    String id_rol_fk;
    String cargo;

    public UsuarioStrings(String cargo) {
        this.cargo = cargo;
    }

    public UsuarioStrings() {
    }

   
    
    public UsuarioStrings(String id_usuario, String email, String clave_usuario, String estado_usuario, String id_rol_fk) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.clave_usuario = clave_usuario;
        this.estado_usuario = estado_usuario;
        this.id_rol_fk = id_rol_fk;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getId_rol_fk() {
        return id_rol_fk;
    }

    public void setId_rol_fk(String id_rol_fk) {
        this.id_rol_fk = id_rol_fk;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

  
 
    
}
