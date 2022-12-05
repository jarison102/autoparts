
<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@include file = "Sesion/cache.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/estilosdashboard.css" rel="stylesheet" type="text/css"/> 
        <link href="Estilos/RegistrarEmpleado.css" rel="stylesheet" type="text/css"/>
        <title>Vista almacenista</title>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">
                    <i class='bx bxs-car-mechanic'></i>
                    Autoparts
                </div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Compra.jsp"> <i class='bx bx-purchase-tag'></i> Compra</a>                    
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="registrarEmpleado.jsp"> <i class='bx bx-folder-plus'></i> Registro Empleado</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="registrarProveedor.jsp"> <i class='bx bx-folder-plus'></i> Registro Proveedor</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Listar?variable=ListarCompras"> <i class='bx bx-file-find'></i>Consulta compra</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Listar?variable=ListarUsuarios"> <i class='bx bx-file-find'></i>Consulta usuario</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Listar?variable=ListarProveedores"> <i class='bx bx-file-find'></i>Consulta proveedor</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="ControladorProductos?accion=NuevoProducto"> <i class='bx bx-file-find'></i> Consulta productos</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="./ReporteCompra.jsp"> <i class='bx bxs-report'></i> Reporte compra</a>
                    <form method="POST" action="${pageContext.request.contextPath}/Sesiones">
                        <li class="nav-item">
                            <input type="submit" class="nav-link btn btn-primary ms-1" value="Cerrar sesi&#243;n " style="color:#FFF">  
                        </li>
                    </form> 
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle"><i class='bx bx-menu' ></i></button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">


                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-user-tie"></i> ${email}</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">

                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
                    <div class="container-fluid py-5" id="about">
                        <div class="container mt-4">            
                            <div class="row">
                                <div class="col-sm-5">
                                    <section class="form-register">
                                        <form method="post" action="ControladorEmpleados">
                                            <table>
                                                <tr>
                                                <label>Email</label><br><br>
                                                <input type="email" name="email"  class="controls" class="form-control" placeholder="email@example.com">



                                                <label>Rol</label><br><br>
                                                <select name="rol"  class="controls">
                                                    <option>Seleccione</option>
                                                    <% RolDAO rdao = new RolDAO();
                                                        for (RolVO rvo : rdao.Roles()) {
                                                    %>


                                                    <option value="<%=rvo.getId_rol()%>"><%=rvo.getNombre_rol()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                </tr>
                                            </table>

                                            <center><button  style="cursor:pointer" class="envio">Registrar</button></center>
                                            <input type="hidden" value="1" name="opcion">
                                        </form>
                                    </section>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/dashboard.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </body>
</html>

