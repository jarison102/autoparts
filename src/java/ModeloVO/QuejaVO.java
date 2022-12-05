
package ModeloVO;



public class QuejaVO {
    private String id_queja, id_usuario_fk,fecha_queja,asunto,detalle,estado_queja;
    private String action;

    public QuejaVO(String id_queja, String id_usuario_fk, String fecha_queja, String asunto, String detalle, String estado_queja) {
        this.id_queja = id_queja;
        this.id_usuario_fk = id_usuario_fk;
        this.fecha_queja = fecha_queja;
        this.asunto = asunto;
        this.detalle = detalle;
        this.estado_queja = estado_queja;
    }
    public QuejaVO() {
    }

    public QuejaVO(String id_queja, String action) {
        this.id_queja = id_queja;
        this.action = action;
    }
    
    public String getId_queja() {
        return id_queja;
    }

    public void setId_queja(String id_queja) {
        this.id_queja = id_queja;
    }

    public String getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(String id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public String getFecha_queja() {
        return fecha_queja;
    }

    public void setFecha_queja(String fecha_queja) {
        this.fecha_queja = fecha_queja;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado_queja() {
        return estado_queja;
    }

    public void setEstado_queja(String estado_queja) {
        this.estado_queja = estado_queja;
    }
     
}