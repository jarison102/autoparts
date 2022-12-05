<%@include file = "Sesion/cache.jsp" %>
<%@page import="ModeloVO.PersonaVO"%>
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
        if (request.getAttribute("personaConsultada") != null) {
            PersonaVO perVO = (PersonaVO) request.getAttribute("personaConsultada");

    %>
    <body>
        

    <center>
        <section class="form-register">

            <form method="post" action="ControladorPersonas" class="one">

                <h1 class="principal">Actualizar Persona</h1>

                Id persona<br>
                <input class="controls" type="hidden" name="textId"  value="<%=perVO.getId_persona()%>" readonly><br>
                <br><br>
                Nombre <br>
                <input class="controls" type="text" name="textNombre"  value="<%=perVO.getNombre()%> "><br>
                <br><br>
                apellido<br>
                <input class="controls" type="text" name="textTelefono" value="<%=perVO.getApellido()%>"><br>
                <br><br>

                Tipo Doc<br>
                <input class="controls" type="text" name="textCorreo" value="<%=perVO.getTdoc()%>"><br>
                <br><br>
                Numero de Documento<br>
                <input class="controls" type="text" name="textCorreo" value="<%=perVO.getDocumento()%>"><br>
                <br><br>
                 telefono <br>
                <input class="controls" type="text" name="textCorreo" value="<%=perVO.getTelefono()%>"><br>
                <br><br>
                 Direccion<br>
                <input class="controls" type="text" name="textCorreo" value="<%=perVO.getDireccion()%>"><br>
                <br><br>
                 id usuario <br>
                 <input class="controls" type="text" name="textCorreo" value="<%=perVO.getId_usuario_fk()%>" readonly=""><br>
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

            <h4>No se ha ingresado ninguna persona</h4>
            <%}%>
            <a href="index.jsp">Index</a>
            </body>
            </html>
