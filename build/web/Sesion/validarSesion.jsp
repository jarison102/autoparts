<%-- 
    Document   : validarSesion
    Created on : 18/11/2022, 07:09:57 PM
    Author     : Sergio
--%>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("UsuarioVO") == null) {
        request.setAttribute("mensajeOperacion", "Debe iniciar sesion");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>