<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarUsuario
    Created on : 12/08/2022, 12:17:56 PM
    Author     : kevin
--%>

<%@page import="ModeloVO.UsuarioStrings"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos/estilos de actualizar/ActualizarUsuario.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        
       
        
        
    </head>
    <%
        if (request.getAttribute("usuarioConsultado") != null) {
            UsuarioStrings usus = (UsuarioStrings) request.getAttribute("usuarioConsultado");
            
    %>
    <body>
       

    <center>
        <section class="form-register">
        <form method="post" action="ControladorUsuarios" class="one">
                 
        <h1 class="principal"><b>Actualizar Usuario</h1></b>
    
            <label> Id usuario</label><br>
            <input class="controls" type="text" name="id"  value="<%=usus.getId_usuario()%>" readonly><br>
            
            
            <label>Email</label><br>
            <input  class="controls" type="text" name="email" value="<%=usus.getEmail()%>"><br>
            
            
            <label>Clave</label><br>
            <input  class="controls" type="text" name="clave" value="<%=usus.getClave_usuario()%>"><br>

            <label>Estado Usuario</label><br>
            <input  class="controls" type="text" name="estado" value="<%=usus.getEstado_usuario()%>" readonly><br>
              
            
            <label>Id rol</label><br>
            <input  class="controls" type="text" name="rol" value="<%=usus.getId_rol_fk()%>"><br>
           
            <br>
            
            <button class="botons" class="btn"> Actualizar </button>
            <input  class="botons" type="hidden" value="2" name="opcion">
            <button class="botons"><a href="consultarUsuario.jsp" class="Atras">Atras</a></button>
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
    
    <h4>No se ha ingresado ningun Usuario</h4>
    <%}%>
    <a href="index.jsp">Index</a>
    </body>
</html>
