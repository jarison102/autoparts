/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Jarrison
 */
public class VentaVariablesVO {
    int idusuario;
    int idpersona;
    String correo;
    String persona;
    int idventa;
    String fechaventa;
    String fechaentrega;
    String nombreproducto;
    int cantidad;
    double precioVenta;
    double totalventa;
    boolean estado;

    

    public VentaVariablesVO(int idusuario, int idpersona, String correo, String persona, int idventa, String fechaventa, String fechaentrega, String nombreproducto, int cantidad, double precioVenta, double totalventa, boolean estado) {
        this.idusuario = idusuario;
        this.idpersona = idpersona;
        this.correo = correo;
        this.persona = persona;
        this.idventa = idventa;
        this.fechaventa = fechaventa;
        this.fechaentrega = fechaentrega;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.totalventa = totalventa;
        this.estado = estado;
    }

    public VentaVariablesVO() {
    }
    
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(double totalventa) {
        this.totalventa = totalventa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    
}
