<%@include file = "Sesion/cache.jsp" %>
<%@page import="ModeloVO.VentasVO"%>
<%@page import="ModeloDAO.VentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              VentaDAO venDAO=new VentaDAO();
              int id=Integer.parseInt((String)request.getAttribute("id_venta"));
              VentasVO vensVO=(VentasVO)venDAO.list(id);
          %>
            <h1>Modificar Persona</h1>
            <form action="ControladorVen">
                fecha_venta<br>
                    <input class="form-control" type="text" name="txtfechaVenta" value="<%= vensVO.getFecha_venta()%>"><br>
                    fecha_entrega <br>
                    <input class="form-control" type="text" name="txtfechaEntrega" value="<%= vensVO.getFecha_entrega()%>"><br>
                    total_venta<br>
                    <input class="form-control" type="text" name="txttotalVenta" value="<%= vensVO.getTotal_venta()%>"><br>
                    id_persona_fk <br>
                    <input class="form-control" type="text" name="txtid_persna_fk" value="<%= vensVO.getId_persona_fk()%>"><br>
   
                <input type="hidden" name="txtid" value="<%= vensVO.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorVen?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
