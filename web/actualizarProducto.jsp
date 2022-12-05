<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : actualizarProducto
    Created on : 17/08/2022, 03:34:42 PM
    Author     : Sergio
--%>

<%@page import="ModeloVO.ProductoVO"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    ProductoDAO proDAO = new ProductoDAO();
                    int id_producto = Integer.parseInt((String) request.getAttribute("idper"));
                    ProductoVO proVO = (ProductoVO) proDAO.list(id_producto);
                %>
                <h1>Editar Producto</h1>
                <form action="ControladorP">
                    Nombre<br>
                    <input class="form-control" type="text" name="txtNombre" value="<%= proVO.getNombre_producto()%>"><br><br>
                    Marca <br>
                    <input class="form-control" type="text" name="txtMarca" value="<%= proVO.getMarca_producto()%>"><br><br>
                    Cantidad<br>
                    <input class="form-control" type="text" name="txtCantidad" value="<%= proVO.getCantidad_producto()%> "><br><br>
                    Foto <br>
                    <input class="form-control" type="text" name="txtFoto" value="<%= proVO.getFoto()%>"><br><br>
                    Precio<br>
                    <input class="form-control" type="text" name="txtPrecio" value="<%= proVO.getPrecio_producto()%>"><br><br>
                    Descripcion <br>
                    <input class="form-control" type="text" name="txtDescripcion" value="<%= proVO.getDescripcion_producto()%>"><br><br>

                    <input type="hidden" name="txtid" value="<%= proVO.getId_producto()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="ControladorP?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>