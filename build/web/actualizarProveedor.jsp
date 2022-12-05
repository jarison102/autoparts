<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarProveedor
    Created on : 16/08/2022, 10:34:18 PM
    Author     : kevin
--%>

<%@page import="ModeloVO.ProveedorVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos/estilos de actualizar/ActualizarProveedor.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>

    <%
        if (request.getAttribute("proveedorConsultado") != null) {
            ProveedorVO prvVO = (ProveedorVO) request.getAttribute("proveedorConsultado");

    %>
    <body>
        

    <center>
        <section class="form-register">

            <form method="post" action="Proveedor" class="one">

                <h1 class="principal">Actualizar Proveedor</h1>

                Id proveedor<br>
                <input class="controls" type="hidden" name="textId"  value="<%=prvVO.getId_proveedor()%>" readonly><br>
                <br><br>
                Nombre proveedor<br>
                <input class="controls" type="text" name="textNombre"  value="<%=prvVO.getNombre_proveedor()%> "readonly><br>
                <br><br>
                Telefono proveedor<br>
                <input class="controls" type="text" name="textTelefono" value="<%=prvVO.getTelefono_proveedor()%>"><br>
                <br><br>

                Correo proveedor<br>
                <input class="controls" type="text" name="textCorreo" value="<%=prvVO.getCorreo_proveedor()%>"><br>
                <br><br>
                <button class="botons"> Actualizar </button>
                <input type="hidden" value="2" name="opcion">

                <button class="botons"><a href="index.jsp" class="Atras"> Atras</a></button>
            </form><br>

            <%
          if (request.getAttribute("mensajeError") != null) { %>
            <h5>
                ${mensajeError} 
            </h5>

            <%} else {%>
            <h5>
                ${mensajeExito}

            </h5>
            <% }%>

            <%} else {%>

            <h4>No se ha ingresado ningun proveedor</h4>
            <%}%>
            <a href="index.jsp">Index</a>
            </body>
            </html>
