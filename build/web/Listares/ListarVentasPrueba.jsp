<%@include file = "../Sesion/cache.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sistema Autoparts</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>    
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/estilosdashboard.css" rel="stylesheet" type="text/css"/> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/3ed465e9fb.js" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="${pageContext.request.contextPath}/js/CambioEstado.js" type="text/javascript"></script>

    </head>
    <body class="hold-transition skin-blue sidebar-mini">


        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">
                    <i class='bx bxs-car-mechanic'></i>
                    Autoparts
                    <br>
                    ${email}
                </div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="./vistas/addProducto.jsp"> <i class='bx bx-folder-plus'></i> Registro Producto</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="../registrarInventario.jsp"> <i class='bx bx-folder-plus'></i> Registro Inventario</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Listar?variable=ListarProductos"><i class='bx bx-file-find'></i> Consulta productos</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Listar?variable=ListarInventario"> <i class='bx bx-file-find'></i>  Consulta inventario</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="Listar?variable=ListarVentas"> <i class='bx bx-file-find'></i> Consulta ventas </a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="./ReporteVenta.jsp"> <i class='bx bxs-report'></i> Reporte venta</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="./ReporteInventario.jsp"> <i class='bx bxs-report'></i> Reporte inventario </a>
                    <form method="POST" action="${pageContext.request.contextPath}/Sesiones">
                        <li class="nav-item">
                            <input type="submit" class="nav-link btn btn-primary ms-1" value="Cerrar sesi&#243;n " style="color:#FFF">  
                        </li>
                    </form> 
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
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

                <center>
                    <section class="content">
                        <div class="box">    
                            <div class="box-header with-border">             
                                <h3 class="box-title">Listado de Ventas</h3>
                            </div>
                            <div class="box-body">
                                <div class="table-responsive" >                                 
                                    <table class="table tab-pane"">
                                        <thead class="thead-light">
                                            <tr>
                                                <th>Id</th>
                                                <th>Fecha Venta</th>
                                                <th>Fecha Entrega</th>
                                                <th>Total venta</th>
                                                <th>Descuento</th>
                                                <th>Codigo Persona</th>
                                                <th>Estado</th>
                                                <th>Acciones</th> 
                                            </tr>
                                        </thead>
                                        <c:forEach var="que" items="${ventas}" varStatus="iteracion">                                                    
                                            <tr>
                                                <td>${que.getId()}</td>
                                                <td>${que.getFecha_venta()}</td>
                                                <td>${que.getFecha_entrega()}</td>
                                                <td>${que.getTotal_venta()}</td>
                                                <td>${que.getDescuento()}</td>
                                                <td>${que.getId_persona_fk()}</td>
                                                <td>${que.getEstado()}</td>
                                                <td><a class="btn btn-warning" href="#">Editar</a>
                                                    <c:if test="${que.getEstado() eq 'Pendiente'}" >

                                                        <input type="hidden" name="id" value="${que.getId()}">
                                                        <button class="btn-transparetn border-0 bg-transparent py-2"
                                                                onclick="alertaInactivarV(${que.getId()}, 'Pendiente')">
                                                            <i class="fas fa-truck-loading" style="font-size:25px;"></i></button>


                                                    </c:if>
                                                    <c:if test="${que.getEstado() eq 'Entregado'}" >

                                                        <input type="hidden" name="id" value="${que.getId()}">
                                                        <button class="btn-transparetn border-0 bg-transparent py-2"
                                                                onclick="alertaActivarV(${que.getId()}, 'Entregado')">
                                                            <i class="fa-solid fa-circle-check" text-danger style="font-size: 25px;"></i></button>
                                                    </td>
                                                </c:if>
                                                </td>
                                            </tr>                                            
                                        </c:forEach>                                               
                                    </table>
                                </div>                        
                            </div>

                            <!-- /.box-body -->
                            <div class="box-footer">
                                <!--Pie de página-->
                            </div>
                            <!-- /.box-footer-->
                        </div>
                    </section>
                </center>

            </div>
            <script src="${pageContext.request.contextPath}/js/dashboard.js" type="text/javascript"></script>
            <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>           
    </body>
</html>