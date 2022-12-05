<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarQueja
    Created on : 13/08/2022, 08:02:39 AM
    Author     : kevin
--%>

<%@page import="ModeloVO.QuejaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos/estilos de actualizar/ActualizarQueja.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <%
        if (request.getAttribute("quejaConsultada") != null) {
            QuejaVO qejVO = (QuejaVO) request.getAttribute("quejaConsultada");

    %>
    <body>
        <center>
            <section class="form-register">
     
        <form method="POST" action="Quejas" class="one">
         
             <h1>Actualizar queja</h1>
             
            <label> Id queja</label><br>
            <input class="controls" type="text" name="textId"  value="<%=qejVO.getId_queja()%>" readonly><br>
            
            <label>Id persona</label><br>
            <input class="controls" type="text" name="textIdP"  value="<%=qejVO.getId_persona_fk()%>" readonly><br>
            
            <label>Fecha</label><br>
            <input class="controls" type="text" name="textFe"  value="<%=qejVO.getFecha_queja()%> "readonly><br>
            
            <label>Detalle queja</label><br>
            <input class="controls" type="text" name="textDet" value="<%=qejVO.getDetalle_queja()%>" ><br>
            
            <label>Correo</label><br>
            <input class="controls" type="text" name="textC" value="<%=qejVO.getCorreo()%>"><br>
            
            <label>Asunto queja</label><br>
            <input class="controls" type="text" name="textA" value="<%=qejVO.getAsunto_queja()%>"><br>
            
            <label>Estado queja</label><br>
            <input class="controls" type="text" name="textE" value="<%=qejVO.getEstado_queja()%>"><br><br>
            
            <button class="botons">Actualizar</button>
            <input type="hidden" value="2" name="opcion">
            
            <button class="botons"><a href="consultarQueja.jsp" class="Atras"> Atras</a></button>
        </form><br><br>

          <center>
        <%
        if (request.getAttribute("mensajeError")!= null)
        {%>
            ${mensajeError}
        <%
        }
        else{%>
            ${mensajeExito}
        <%  
            }
        %>
    </center>
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
    
    <center> <h4>No se ha ingresado ninguna queja</h4></center>
    <%}%>

        <a href="index.jsp">Index</a>
    </body>
</html>
