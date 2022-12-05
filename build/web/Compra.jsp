<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
        <title>Vista Productos</title>
    </head>
    <body>
        <style>
            @media print{
                .accion , .btn{
                    display: none;
                }
            }
        </style>

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
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="container-fluid">
                    <div class="container-fluid py-5" id="about">
                        <div class="card"><form action="ControladorCompras?menu=NuevaCompra" method="POST">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label>Datos del Proveedor</label>
                                    </div>
                                    <div class="form-group d-flex">
                                        <div class="col-sm-6 d-flex">
                                            <input type="text" name="codigoproveedor"  value="${p.getId_proveedor()}" class="form-control" placeholder="Codigo proveedor">
                                            <input type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-info">

                                        </div>

                                        <div class="col-sm-6">
                                            <input type="text" name="nombreproveedor" value="${p.getNombre_proveedor()}"  class="form-control" placeholder="Codigo proveedor" readonly>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Datos Producto</label>
                                    </div>
                                    <div class="form-group d-flex">
                                        <div class="col-sm-6 d-flex">
                                            <input type="text" name="codigoproducto" value="${producto.getId_producto()}" class="form-control" placeholder="Codigo producto">
                                            <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="nombreproducto"  value="${producto.getNombre_producto()}" class="form-control" placeholder="Datos Producto" readonly>
                                        </div>
                                    </div>
                                    <div class="form-group d-flex">
                                        <div class="col-sm-6 d-flex">
                                            <input type="text" name="Precio" class="form-control" value="${producto.getPrecio_producto()}" placeholder="$/.0.00">
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="number" value="1" name="Cantidad" value="Buscar" class="btn btn-outline-info">
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <input type="submit" name="accion"  value="Agregar" class="btn btn-outline-info">
                                    </div>                                
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="col-sm-7">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex ml-auto col-sm-6">
                                    <label>Numero de Serie</label>
                                    <input type="text" name="NumeroSerie" value="${numeroserie}" class="form-control">
                                </div>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Numero</th>
                                            <th>Codigo</th>
                                            <th>Descripcion</th>
                                            <th>Precio</th>
                                            <th>Cantidad</th>
                                            <th>Subtotal</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach var="list" items="${lista}">
                                            <tr>
                                                <td>${list.getItem()}</td>
                                                <td>${list.getId_producto_fk()}</td>
                                                <td>${list.getNombre()}</td>
                                                <td>${list.getPrecio()}</td>
                                                <td>${list.getCantidad()}</td>
                                                <td>${list.getSubtotal()}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                            <div class="card-footer d-flex">
                                <div class="col-sm-6">  
                                    <a href="ControladorCompras?menu=NuevaCompra&&accion=GenerarCompra" onclick="print()" class="btn btn-success">Generar Compra</a>
                                    <input type="submit" name="accion"  value="Cancelar" class="btn btn-danger">
                                </div>
                                <div class="col-sm-4 ml-auto">
                                    <input type="text" name="txtTotal"  value="#${totalpagar}" class="form-control">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/dashboard.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </body>
</html>
