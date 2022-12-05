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
public class PersonaVO {
    int id_persona;
    String id;
    String nombre;
    String apellido;
    String tdoc;
    String documento;
    String telefono;
    String direccion;
    String id_usuario_fk;

    public PersonaVO() {
    }

    public PersonaVO(String id, String nombre, String apellido, String tdoc, String documento, String telefono, String direccion, String id_usuario_fk) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tdoc = tdoc;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_usuario_fk = id_usuario_fk;
    }

   

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTdoc() {
        return tdoc;
    }

    public void setTdoc(String tdoc) {
        this.tdoc = tdoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(String id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    
  
    
}
