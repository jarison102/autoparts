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
public class InventarioVO {
    public InventarioVO(){}
    
    String id_inventario;
    String informacion_inventario;
    String fecha_inventario;
    String perdidas_productos;
    String id_producto_fk;
    String id_empleado_fk;

    public InventarioVO(String id_inventario, String informacion_inventario, String fecha_inventario, String perdidas_productos, String id_producto_fk, String id_empleado_fk) {
        this.id_inventario = id_inventario;
        this.informacion_inventario = informacion_inventario;
        this.fecha_inventario = fecha_inventario;
        this.perdidas_productos = perdidas_productos;
        this.id_producto_fk = id_producto_fk;
        this.id_empleado_fk = id_empleado_fk;
    }

    public String getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getInformacion_inventario() {
        return informacion_inventario;
    }

    public void setInformacion_inventario(String informacion_inventario) {
        this.informacion_inventario = informacion_inventario;
    }

    public String getFecha_inventario() {
        return fecha_inventario;
    }

    public void setFecha_inventario(String fecha_inventario) {
        this.fecha_inventario = fecha_inventario;
    }

    public String getPerdidas_productos() {
        return perdidas_productos;
    }

    public void setPerdidas_productos(String perdidas_productos) {
        this.perdidas_productos = perdidas_productos;
    }

    public String getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(String id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public String getId_empleado_fk() {
        return id_empleado_fk;
    }

    public void setId_empleado_fk(String id_empleado_fk) {
        this.id_empleado_fk = id_empleado_fk;
    }
}
