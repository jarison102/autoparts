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
public class ComprasVO {

    String id;
    int id2;
    int id_compra;
    int item;
    String fecha_compra;
    String estado_compra;
    String id_proveedor_fk;
    String id_producto_fk;
    int id_compra_fk;
    double precio;
    int cantidad;
    double subtotal;
    String Nombre;
    double total_compra;
    private String action;

    public ComprasVO() {
    }

    public ComprasVO(String id, int id2, int id_compra, int item, String fecha_compra, String estado_compra, String id_proveedor_fk, String id_producto_fk, int id_compra_fk, double precio, int cantidad, double subtotal, String Nombre, double total_compra) {
        this.id = id;
        this.id2 = id2;
        this.id_compra = id_compra;
        this.item = item;
        this.fecha_compra = fecha_compra;
        this.estado_compra = estado_compra;
        this.id_proveedor_fk = id_proveedor_fk;
        this.id_producto_fk = id_producto_fk;
        this.id_compra_fk = id_compra_fk;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.Nombre = Nombre;
        this.total_compra = total_compra;
    }

    public ComprasVO(String id, String action) {
        this.id = id;
        this.action = action;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getEstado_compra() {
        return estado_compra;
    }

    public void setEstado_compra(String estado_compra) {
        this.estado_compra = estado_compra;
    }

    public String getId_proveedor_fk() {
        return id_proveedor_fk;
    }

    public void setId_proveedor_fk(String id_proveedor_fk) {
        this.id_proveedor_fk = id_proveedor_fk;
    }

    public String getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(String id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public int getId_compra_fk() {
        return id_compra_fk;
    }

    public void setId_compra_fk(int id_compra_fk) {
        this.id_compra_fk = id_compra_fk;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(double total_compra) {
        this.total_compra = total_compra;
    }

}
