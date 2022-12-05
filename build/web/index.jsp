<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : index
    Created on : 30/08/2022, 08:40:48 AM
    Author     : SENA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>        
        <title>SI Autoparts</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="homeprincipal.jsp"><i>Autoparts</i></a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="./ControladorProductos?accion=Nuevo"><i class="fas fa-home"></i> Inicio<span class="sr-only">(current)</span></a>
                    </li>


                    <li class="nav-item">
                        <a class="nav-link" href="./ControladorProductos?accion=carrito"><i class="fas fa-cart-plus">(<label style="color:#FC1212">${cont}</label>)</i> Carrito</a>
                    </li> 


                </ul>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <form  method ="POST" action="ControladorProductos" class="form-inline my-2 my-lg-0">
                        <input  style="width:400px" class="form-control mr-sm-2" name="txtBuscar" id="txtBuscar">
                        <input type="hidden" name="accion" value="Buscar">
                        <button class="btn btn-outline-info my-2 my-sm-0" id="btnBuscar"><i class="fas fa-search"></i></button>
                    </form> 

                </ul>
                <ul class="navbar-nav btn-group my-2 my-lg-0" role="group">
                    <a style="color: white; cursor: pointer" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fas fa-user-tie"></i> ${email}</a>
                    <div class="dropdown-menu text-center dropdown-menu-right"><br>

                        <a class="dropdown-item" href="#"><img src="img/user_1.png" alt="60" height="60"/></a>                        
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#myModal">Iniciar Sesion</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="registrarQueja.jsp">Registrar queja</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="ControladorProductos?accion=MisCompras">Mis Compras</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="vistas/quejas.jsp">Mis Quejas</a>
                        <div class="dropdown-divider"></div>
                        <center>
                            <form method="POST" action="${pageContext.request.contextPath}/Sesiones">
                                <li class="nav-item">
                                    <input type="submit" class="nav-link btn btn-primary ms-1" value="Cerrar sesi&#243;n">  
                                </li>
                            </form> 
                        </center>
                    </div>
                </ul>     
            </div>
        </nav>

        <h1 class="Cata">Catálogo</h1>
        <div class="container mt-4" id="Catalogo">
            <div class="row">

                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="card">
                                <div class="card-header">
                                    <label class="col-sm-13">${p.getNombre_producto()}</label>                                    
                                </div>
                                <div class="card-body center d-flex">
                                    <img src="${p.getImagen()}" width="200" height="170">
                                </div>
                                <div class="card-body2 text-center">
                                    <label><i class="fas fa-dollar-sign" id="precio">${p.getPrecio_producto()}</i></label>                                       
                                </div>
                                <div class="card-footer">
                                    <div class="col-sm-12" >
                                        <div class="modal fade" id="product${p.getId()}" tabindex="-1" role="dialog">
                                            <div class="modal-dialog modal-dialog-centered" role="document">         
                                                <div class="modal-content">                   
                                                    <div class="modal-header text-center" id="Colorheader"> 
                                                        <h5 class="NombrePro">${p.getNombre_producto()}</h5>
                                                        <button type="button" class="close" data-dismiss="modal">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>  
                                                    </div>
                                                    <div class="modal-body"> 
                                                        <div class="tab-content" id="pills-tabContent">
                                                            <!-- Metodo Pago -->
                                                            <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                                                <h4 class="Descripcion">Descripcion:</h4>
                                                                ${p.getDescripcion_producto()}
                                                                <br>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                    <div class="modal-footer"> 
                                                        <div class="tab-content" id="pills-tabContent">
                                                            <div class="tab-pane fade show active" role="tabpanel">
                                                                <h4 class="Marca">Marca:</h4>
                                                                ${p.getMarca_producto()}
                                                                <br>
                                                            </div>
                                                        </div> 
                                                    </div>                                                 
                                                </div>
                                            </div>
                                        </div>                                 
                                    </div>
                                    <div class=" col-sm-12 text-center">              
                                        <a href="ControladorProductos?accion=AgregarCarrito&id=${p.getId()}" class="boton">Agregar<i class="fas fa-cart-plus"></i></a>
                                        <a href="ControladorProductos?accion=Comprar&id=${p.getId()}" class="boton2">Comprar</a>
                                        <br>
                                        <br>
                                        <a class="boton" href="#" data-toggle="modal" data-target="#product${p.getId()}">Ver más</a>
                                    </div>                          
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--Codigo del footer-->
        <footer class="pie-pagina">
            <center>
                <div class="grupo-1">
                    <div class="box">
                        <figure>
                            <h2>Sobre Nosotros</h2>
                            <p>Somos una grupo de desarrolladores encargados del sistema de información Autoparts </p>
                        </figure>
                    </div>
                    <div class="box">
                        <figure>
                            <img src="img/logov1.png" alt=""/>
                        </figure><
                    </div>
                    <div class="box">
                        <figure>
                            <h2>Redes Sociales</h2>
                            <img class="redes" src="img/face_logo.png" alt=""s/>
                            <img class="redes" src="img/twit_logo.png" alt=""/>
                        </figure>
                    </div>
                </div>
                <div class="grupo-2">
                    <center>
                        <small>&copy; 2022 <b>Andres Olaya, Michel Martinez , Jarrison Mican , Sergio Alonso, Sebastian Diaz</b> - Derechos Reservados<br> </small>

                    </center>
                </div>
            </center>
        </footer>

        <!-- Modal Iniciar Session o Registrarse -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="container col-lg-9">                   
                    <div class="modal-content">                   
                        <div class="pr-2 pt-1">                         
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                            </button>                    
                        </div>
                        <div class="text-center">                         
                            <img src="img/user.png" width="100" height="100">                         
                        </div>
                        <div class="modal-header text-center">                      
                            <ul class="nav nav-pills">                           
                                <li class="nav-item">
                                    <a  class="nav-link active" data-toggle="pill" href="#pills-iniciar">Iniciar Sesion</a>
                                </li>
                                <li class="nav-item">
                                    <a  class="nav-link" data-toggle="pill" href="#pills-registrar">Registrarse</a>
                                </li>       
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="pill" href="#pills-datos">Registrar Datos</a>
                                </li> 


                            </ul>  
                        </div>
                        <div class="modal-body"> 
                            <div class="tab-content" id="pills-tabContent">
                                <!-- Iniciar Session -->
                                <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                    <form name="inicio" method="post" action="ControladorUsuarios">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="email" name="textEmail" class="form-control" placeholder="email@example.com">
                                            <label id="Error12" style="color:red"></label>
                                        </div>
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                            <input type="password" name="textClave" class="form-control" placeholder="Contraseña">
                                            <label id="Error22" style="color:red"></label>
                                        </div>  
                                        <button class="btn btn-outline-danger btn-block" onmouseover="validacion()">Iniciar</button>
                                        <input type="hidden" value="4" name="opcion">
                                    </form>
                                    <script type="text/javascript">
                                        function validacion() {
                                            var Email = document.inicio.textEmail.value;
                                            var Contraseña = document.inicio.textClave.value;

                                            if (Email === "") {
                                                document.getElementById("Error12").innerText = "*Por favor ingresa tu correo";
                                            } else {
                                                document.getElementById("Error12").innerText = "";
                                            }
                                            if (Contraseña === "") {
                                                document.getElementById("Error22").innerText = "*Por favor ingresa tu contraseña";
                                            } else {
                                                document.getElementById("Error22").innerText = "";
                                            }
                                        }
                                    </script>
                                </div>
                                ${mensajeIniciarSesion}
                                <div class="tab-pane fade" id="pills-datos" role="tabpanel">
                                    <form name="ingresarD" method="POST" action="ControladorPersonas">
                                        <div class="form-group">
                                            <label> Nombres</label><br>
                                            <input class="controls" type="text" name="textNombre">
                                            <label id="Error10" style="color:red"></label>
                                        </div>
                                        <div class="form-group">
                                            <label>Apellidos</label><br>
                                            <input class="controls" type="text" name="textApe">
                                            <label id="Error20" style="color:red"></label>
                                        </div>
                                        <div class="form-group">
                                            <label> Tipo de documento</label><br>
                                            <input class="controls" type="text" name="textTdoc">
                                            <label id="Error30" style="color:red"></label>
                                        </div>
                                        <div class="form-group">
                                            <label> Numero de Documento</label><br>
                                            <input class="controls" type="text" name="textDocumento">
                                            <label id="Error40" style="color:red"></label>
                                        </div>
                                        <div class="form-group">
                                            <label> Telefono</label><br>
                                            <input class="controls" type="text" name="textTelefono">
                                            <label id="Error50" style="color:red"></label>
                                        </div>
                                        <div class="form-group">
                                            <label>Direccion</label><br>
                                            <input class="controls" type="text" name="textDireccion">
                                            <label id="Error60" style="color:red"></label>  
                                        </div>
                                        <input value="${UsuarioVO.id_usuario}" class="controls" type="hidden" name="textId_usuario">
                                        <button class="btn btn-outline-danger btn-block" onmouseover="validar()">Registrar</button>
                                        <input type="hidden" value="1" name="opcion">
                                        <center>
                                            <script type="text/javascript">
                                                function soloLetras(e) {
                                                    letrass = "abcdefghijklmnopqrstuvwxyz";
                                                    palabra = Array.from(e);
                                                    result = true;
                                                    letras = Array.from(letrass);
                                                    for (i = 0; i < letras.length; i++) {
                                                        for (f = 0; f < palabra.length; f++) {
                                                            console.log(letras[i], palabra[f]);
                                                            if (letras[i] === palabra[f]) {
                                                                result = false;
                                                            }
                                                        }
                                                    }
                                                    return result;
                                                }
                                                function soloNumeros(e) {
                                                    letrass = "abcdefghijklmnopqrstuvwxyz";
                                                    palabra = Array.from(e);
                                                    result = false;
                                                    letras = Array.from(letrass);
                                                    for (i = 0; i < letras.length; i++) {
                                                        for (f = 0; f < palabra.length; f++) {
                                                            console.log(letras[i], palabra[f]);
                                                            if (letras[i] === palabra[f]) {
                                                                result = true;
                                                            }
                                                        }
                                                    }
                                                    return result;
                                                }
                                                function validar() {
                                                    var datos1 = document.ingresarD.textNombre.value;
                                                    var datos2 = document.ingresarD.textApe.value;
                                                    var datos3 = document.ingresarD.textTdoc.value;
                                                    var datos4 = document.ingresarD.textDocumento.value;
                                                    var datos5 = document.ingresarD.textTelefono.value;
                                                    var datos6 = document.ingresarD.textDireccion.value;

                                                    if (datos1 === "") {
                                                        document.getElementById("Error10").innerText = "*Por favor ingresa tu nombre";
                                                    } else if (soloLetras(datos1)) {
                                                        document.getElementById("Error10").innerText = "*Solo ingrese el nombre de la persona";
                                                    } else {
                                                        document.getElementById("Error10").innerText = "";
                                                    }

                                                    if (datos2 === "") {
                                                        document.getElementById("Error20").innerText = "*Por favor ingresa tu apellido";
                                                    } else if (soloLetras(datos2)) {
                                                        document.getElementById("Error20").innerText = "*Solo ingrese el apellido de la persona";
                                                    } else {
                                                        document.getElementById("Error20").innerText = "";
                                                    }
                                                    if (datos3 === "") {
                                                        document.getElementById("Error30").innerText = "*Por favor ingresa tu tipo de documento";
                                                    } else if (soloLetras(datos3)) {
                                                        document.getElementById("Error30").innerText = "*Solo ingrese el tipo de documento";
                                                    } else {
                                                        document.getElementById("Error30").innerText = "";
                                                    }
                                                    if (datos4 === "") {
                                                        document.getElementById("Error40").innerText = "*Por favor ingresa tu numero de documento";
                                                    } else if (soloNumeros(datos4)) {
                                                        document.getElementById("Error40").innerText = "*Solo ingrese el numero de documento";
                                                    } else {
                                                        document.getElementById("Error40").innerText = "";
                                                    }
                                                    if (datos5 === "") {
                                                        document.getElementById("Error50").innerText = "*Por favor ingresa tu numero de telefono";
                                                    } else if (soloNumeros(datos5)) {
                                                        document.getElementById("Error50").innerText = "*Solo ingrese su numero telefonico";
                                                    } else {
                                                        document.getElementById("Error50").innerText = "";
                                                    }
                                                    if (datos6 === "") {
                                                        document.getElementById("Error60").innerText = "*Por favor ingresa tu direcion de residencia";
                                                    } else {
                                                        document.getElementById("Error60").innerText = "";
                                                    }
                                                }
                                            </script>
                                            <%                                                if (request.getAttribute("mensajeError") != null) {%>
                                            ${mensajeError}
                                            <%
                                            } else {%>
                                            ${mensajeExito}
                                            <%
                                                }
                                            %>
                                        </center>
                                    </form>
                                </div>
                                <!-- Registrarse --> 
                                <div class="tab-pane fade" id="pills-registrar" role="tabpanel">
                                    <form name="RegUsu" action="ControladorUsuarios">                               
                                        <div class="form-group">

                                            <div class="form-group">
                                                <l abel>Email address</label>
                                                    <input type="email" name="email" class="form-control" placeholder="email@ejemplo.com">
                                                    <label id="Error1" style="color:red"></label>
                                            </div>
                                            <div class="form-group">
                                                <label>Password</label>
                                                <input type="password" name="clave" class="form-control" placeholder="Contraseña">
                                                <label id="Error2" style="color:red"></label>
                                            </div>            

                                            <button type="submit" name="opcion" onmouseover="Validar()" value="1" class="btn btn-outline-danger btn-block">Crear Cuenta</button>
                                            <center>
                                                <script type="text/javascript">
                                                    function Validar() {
                                                        var Email = document.RegUsu.email.value;
                                                        var Contraseña = document.RegUsu.clave.value;

                                                        if (Email === "") {
                                                            document.getElementById("Error1").innerText = "*Por favor ingrese el correo";
                                                        } else {
                                                            document.getElementById("Error1").innerText = "";
                                                        }
                                                        if (Contraseña === "") {
                                                            document.getElementById("Error2").innerText = "*Por favor ingresa tu contraseña";
                                                        } else {
                                                            document.getElementById("Error2").innerText = "";
                                                        }
                                                    }
                                                </script>
                                                <%
                                                    if (request.getAttribute("mensajeError") != null) {%>
                                                ${mensajeError}
                                                <%
                                                } else {%>
                                                ${mensajeExito}
                                                <%
                                                    }
                                                %>
                                            </center>
                                    </form>
                                </div>                          
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/index.js" type="text/javascript"></script>

    <%
        if (request.getAttribute("iniciarSesion") != null) {
    %>

    <script>
                                                    window.$('#myModal').modal('show');
    </script>
    <%
        }
    %>
</body>
</html>