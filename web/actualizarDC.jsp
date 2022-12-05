<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarDC
    Created on : 17/08/2022, 08:12:20 AM
    Author     : kevin
--%>

<%@page import="ModeloVO.DetalleCompraVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos/estilos de actualizar/ActualizarDC.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
         <%
        if (request.getAttribute("DetalleConsultado") != null) {
            DetalleCompraVO detVO = (DetalleCompraVO) request.getAttribute("DetalleConsultado");

    %>
    <body>
           <section class="form-register">

    <center>
        <form method="post" action="DC" class="one">
             <h1 class="principal">Actualizar detalle compra</h1>

            Id detalle compra<br>
            <input class="controls" type="text" name="textIddetalleC"  value="<%=detVO.getId_detalle_compra()%>" readonly><br>
            
            id producto fk<br>
            <input class="controls" type="text" name="textIdproducto"  value="<%=detVO.getId_producto_fk()%>"><br>
            
            Precio compra<br>
            <input class="controls" type="text" name="textPreciocompra" value="<%=detVO.getPrecio_compra()%>"><br>
            
            
            Cantidad compra<br>
            <input class="controls" type="text" name="textCantidad" value="<%=detVO.getCantidad_compra()%>"><br>
            
            id compra fk<br>
            <input class="controls" type="text" name="textIdcompra" value="<%=detVO.getId_compra_fk()%>"><br>


            <button class="botons"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            
            <button class="botons"><a href="index.jsp" class="Atras"> Atras</a></button>
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
    
    <h4>No se ha ingresado ningun Id de detalle compra</h4>
    <%}%>
    <a href="index.jsp">Index</a>
    </body>
   
</html>
