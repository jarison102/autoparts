<%@include file = "../../Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarInventario
    Created on : 16/08/2022, 08:46:46 PM
    Author     : Sergio
--%>

<%@page import="ModeloVO.InventarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%
        if (request.getAttribute("inventarioConsultado") != null) {
            InventarioVO invVO = (InventarioVO) request.getAttribute("inventarioConsultado");

    %>
    <body>
       
        <h1 class="principal"><b>Actualizar Inventario</h1></b>

    <center>
        <form method="post" action="Inventario" class="one">

            <label> id_inventario</label><br>
            <input type="text" name="textIdinventario"  value="<%=invVO.getId_inventario()%>" readonly><br><br>
            
            <label>informacion_inventario</label><br>
            <input type="text" name="textInformacion"  value="<%=invVO.getInformacion_inventario()%>"><br><br>
            
            <label>fecha_inventario</label><br>
            <input type="date" name="textFecha" value="<%=invVO.getFecha_inventario()%>"><br><br>
            
            
            <label>perdidas_productos</label><br>
            <input type="text" name="textPerdidas" value="<%=invVO.getPerdidas_productos()%>"><br><br>

            <label>id_producto_fk</label><br>
            <input type="text" name="textProducto" value="<%=invVO.getId_producto_fk()%>" readonly><br><br>
              
            
            <label>id_empleado_fk</label><br>
            <input type="text" name="textEmpleado" value="<%=invVO.getId_empleado_fk()%>"><br><br>
            <br>
            
            <button class="btn"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            
            <button class="btn"><a href="listarInventario.jsp" class="Atras"> Atras</a></button>
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
    
    <h4>No se ha ingresado ningun Inventario</h4>
    <%}%>
    <a href="index.jsp">Index</a>
    </body>
</html>
