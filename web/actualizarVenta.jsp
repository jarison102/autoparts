<%-- 
    Document   : actualizarVenta
    Created on : 16/08/2022, 08:28:51 PM
    Author     : kevin
--%>

<%@page import="ModeloVO.VentaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
        if (request.getAttribute("ventaConsultada") != null) {
            VentaVO venVO = (VentaVO) request.getAttribute("ventaConsultada");

    %>
    <body>
          <body>
       
        <h1 class="principal"><b>Actualizar venta</h1></b>

    <center>
        <form method="post" action="Venta" class="one">

           
            <label>id_venta</label><br>
            <input type="text" name="textIdventa"  value="<%=venVO.getId_venta()%>"readonly><br><br>
            
            <label>fecha venta</label><br>
            <input type="date" name="textFechaVenta"  value="<%=venVO.getFecha_venta()%>"><br><br>
            
            
            <label>fecha entrega</label><br>
            <input type="date" name="textFechaEntrega" value="<%=venVO.getFecha_entrega()%>" ><br><br>
            
            
            <label>cantidad</label><br>
            <input type="text" name="textCantidad" value="<%=venVO.getCantidad()%>"><br><br>

            <label>total venta</label><br>
            <input type="text" name="textTotalventa" value="<%=venVO.getTotal_venta()%>"><br><br>
            
            <label>id cliente</label><br>
            <input type="text" name="textIdCliente" value="<%=venVO.getId_cliente_fk()%>" readonly><br><br>
            
            <label>id empleado</label><br>
            <input type="text" name="textIdEmpleado" value="<%=venVO.getId_empleado_fk()%>" readonly><br><br>
              
        
            <button class="btn"> Actualizar </button>
            <input type="hidden" value="3" name="opcion">
            
            <button class="btn"><a href="consultarCompra.jsp" class="Atras"> Atras</a></button>
        </form><br>

      <%
                if (request.getAttribute("mensajeError") != null) 
          { %>
            <h5>
                ${mensajeError} 
            </h5>

            <%} else {%>
            <h5>
                ${mensajeExito}

            </h5>
            <% }%>
    
    <%}else{%>
    
    <h4>No se ha ingresado ninguna venta</h4>
    <%}%>
    <a href="index.jsp">Index</a>
    </body>
</html>
