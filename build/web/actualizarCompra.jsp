<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarCompra
    Created on : 16/08/2022, 10:18:11 PM
    Author     : Sergio
--%>

<%@page import="ModeloVO.CompraVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos/estilos de actualizar/ActualizarCompra.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <body>
     <%
        if (request.getAttribute("CompraConsultada") != null) {
            CompraVO comVO = (CompraVO) request.getAttribute("CompraConsultada");

    %>
    <body>
       
      

    <center>
        <section class="form-register">
            
        <form method="post" action="Compra" class="one">
                <h1 class="principal"><b>Actualizar Compra</h1></b>
            <label> id_compra</label><br>
            <input class="controls" type="text" name="textId"  value="<%=comVO.getId_compra()%>" readonly><br><br>
            
            <label>fecha_compra</label><br>
            <input class="controls" type="date" name="textFecha"  value="<%=comVO.getFecha_compra()%>"><br><br>
            
            <label>estado_compra</label><br>
            <input class="controls" type="text" name="textEstado" value="<%=comVO.getEstado_compra()%>"><br><br>
            
            
            <label>factura</label><br>
            <input class="controls" type="text" name="textFactura" value="<%=comVO.getFactura()%>"><br><br>

            <label>id_proveedor_fk</label><br>
            <input class="controls" type="text" name="textProveedor" value="<%=comVO.getId_proveedor_fk()%>" readonly><br><br>
              
        
            <button class="botons"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            
            <button class="botons"><a href="consultarCompra.jsp" class="Atras"> Atras</a></button>
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
