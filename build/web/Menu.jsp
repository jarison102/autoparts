<%@page import = "ModeloVO.UsuarioVO" %>

<% HttpSession sesion = request.getSession();
    
    UsuarioVO usuVO = (UsuarioVO) sesion.getAttribute("UsuarioVO");
    String id_rol_fk = usuVO.getId_rol_fk(); 

if (id_rol_fk.equals("1") ) {
         request.getRequestDispatcher("Gerente/gerente.jsp").forward(request,response);
    } else if (id_rol_fk.equals("2")) {
         request.getRequestDispatcher("index.jsp").forward(request, response);
     
    } else if (id_rol_fk.equals("3")) {
        request.getRequestDispatcher("Almacenista/almacenista.jsp").forward(request, response);
    }else if (id_rol_fk.equals("4")) {
        request.getRequestDispatcher("Repartidor/repartidor.jsp").forward(request, response);
    } else if (id_rol_fk.equals("5")) {
        request.getRequestDispatcher("AtencionCliente/atencioncli.jsp").forward(request, response);
    } else {
    response.sendRedirect("index.jsp");
    }    

%>
