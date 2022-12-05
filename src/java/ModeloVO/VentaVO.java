/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.util.List;

/**
 *
 * @author No se que poner
 */
public class VentaVO {

    int id;
    String fecha_venta;
    String fecha_entrega;
    Double total_venta;
    Double descuento;
    int id_persona_fk;
    PersonaVO personaVO;
    List<CarritoVO> detalleventas;
    private String action;

    public VentaVO() {
    }

    public VentaVO(String fecha_venta, String fecha_entrega, Double total_venta, Double descuento, PersonaVO personaVO, List<CarritoVO> detalleventas) {
        this.fecha_venta = fecha_venta;
        this.fecha_entrega = fecha_entrega;
        this.total_venta = total_venta;
        this.descuento = descuento;
        this.personaVO = personaVO;
        this.detalleventas = detalleventas;
    }

    public VentaVO(int id, String action) {
        this.id = id;
        this.action = action;
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

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public int getId_persona_fk() {
        return id_persona_fk;
    }

    public void setId_persona_fk(int id_persona_fk) {
        this.id_persona_fk = id_persona_fk;
    }

    public PersonaVO getPersonaVO() {
        return personaVO;
    }

    public void setPersonaVO(PersonaVO personaVO) {
        this.personaVO = personaVO;
    }

    public List<CarritoVO> getDetalleventas() {
        return detalleventas;
    }

    public void setDetalleventas(List<CarritoVO> detalleventas) {
        this.detalleventas = detalleventas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
