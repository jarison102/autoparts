/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.io.InputStream;

/**
 *
 * @author No se que poner
 */
public class ProductoVO {
    
     public ProductoVO() {
    }
    
    int id;
  
    String nombre_producto;
    String marca_producto;
    int cantidad_producto;
    String imagen;
    InputStream foto;
    double precio_producto;
    String descripcion_producto;
    String estado;
    String id_producto;

    public ProductoVO(int id, String nombre_producto, String marca_producto, int cantidad_producto, String imagen, InputStream foto, double precio_producto, String descripcion_producto, String estado, String id_producto) {
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.marca_producto = marca_producto;
        this.cantidad_producto = cantidad_producto;
        this.imagen = imagen;
        this.foto = foto;
        this.precio_producto = precio_producto;
        this.descripcion_producto = descripcion_producto;
        this.estado = estado;
        this.id_producto = id_producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    
    
   
   

}