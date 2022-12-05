/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sergio
 */
public class DetalleCompraVO {
 
    String id_detalle_compra;
    String id_producto_fk;
    String id_compra_fk; 
    String precio_compra; 
    String cantidad_compra;
    
            
    public DetalleCompraVO(){}

    public DetalleCompraVO(String id_detalle_compra, String id_producto_fk, String id_compra_fk, String precio_compra, String cantidad_compra) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_producto_fk = id_producto_fk;
        this.id_compra_fk = id_compra_fk;
        this.precio_compra = precio_compra;
        this.cantidad_compra = cantidad_compra;
    }

    public String getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(String id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public String getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(String id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public String getId_compra_fk() {
        return id_compra_fk;
    }

    public void setId_compra_fk(String id_compra_fk) {
        this.id_compra_fk = id_compra_fk;
    }

    public String getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(String cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }
            
        
    
}
