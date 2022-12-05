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
public class UsuarioVO {

    private int id_usuario;
    private String email;
    private String clave_usuario;
    private boolean estado_usuario;
    private String id_rol_fk;
    private String action;
   

    public UsuarioVO(String email, String clave_usuario) {
        this.email = email;
        this.clave_usuario = clave_usuario;
    }

    public UsuarioVO(int id_usuario, String email, String clave_usuario, boolean estado_usuario, String id_rol_fk) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.clave_usuario = clave_usuario;
        this.estado_usuario = estado_usuario;
        this.id_rol_fk = id_rol_fk;
    }

    public UsuarioVO(int id, String action) {
        this.id_usuario = id;
        this.action = action;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
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

    public boolean isEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(boolean estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getId_rol_fk() {
        return id_rol_fk;
    }

    public void setId_rol_fk(String id_rol_fk) {
        this.id_rol_fk = id_rol_fk;
    }

    public UsuarioVO() {
    }

}
