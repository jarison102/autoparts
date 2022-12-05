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
public class VentasVO {
    
     int id;
    String fecha_venta;
    String fecha_entrega;
    String total_venta;
    Double descuento;
    String id_persona_fk;
    String estado;

    public VentasVO() {
    }

    public VentasVO(int id, String fecha_venta, String fecha_entrega, String total_venta, Double descuento, String id_persona_fk, String estado) {
        this.id = id;
        this.fecha_venta = fecha_venta;
        this.fecha_entrega = fecha_entrega;
        this.total_venta = total_venta;
        this.descuento = descuento;
        this.id_persona_fk = id_persona_fk;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(String total_venta) {
        this.total_venta = total_venta;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getId_persona_fk() {
        return id_persona_fk;
    }

    public void setId_persona_fk(String id_persona_fk) {
        this.id_persona_fk = id_persona_fk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
}
