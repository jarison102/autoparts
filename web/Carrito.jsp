<%@include file = "Sesion/cache.jsp" %>
<%@page import="Util.Fecha"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/Carrito.css" rel="stylesheet" type="text/css"/>
        <title>Carrito de Compras</title>
        <style>
            @media print{
                .btn, .accion{
                    display: none;
                }
            }
        </style>

    </head>
    <body>       
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#"><i>Auto Parts</i></a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="./ControladorProductos?accion=Nuevo"><i class="fas fa-home"></i> Home<span class="sr-only">(current)</span></a>
                    </li>                  
                    <li class="nav-item">
                        <a class="nav-link" href="./ControladorProductos?accion=home"><i class="fas fa-plus-circle"></i> Seguir Comprando</a>
                    </li>                  
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
                        <a class="dropdown-item" href="ControladorProductos?accion=MisQuejas">Mis Quejas</a>
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
        <div class="container mt-4">
            <div class="d-flex">
                <h2>Carrito</h2>     
                <%                    Fecha fechaSistema = new Fecha();
                %>                     
                <p class="ml-auto"><%= fechaSistema.Fecha()%></p>                               
            </div>                    
            <div class="row">             
                <div class="col-lg-9">                 
                    <table class="table">
                        <thead class="thead">
                            <tr class="text-center">
                                <th>Item</th>                               
                                <th>Articulo</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cantidad</th>                       
                                <th>SubTotal</th>                       
                                <th class="accion">Acciones</th>                       
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="c" items="${Carrito}"> 
                                <tr class="text-center tr">
                                    <td>${c.getItem()}</td>                                   
                                    <td>${c.getNombres()}
                                        <img src="${c.getImagen()}" width="130" height="110">
                                    </td>
                                    <td> <a class="Boton" href="#" data-toggle="modal" data-target="#product${c.getItem()}">Click aquí para ver la descripcion</a></td>
                                    <td>${c.getPrecioCompra()}</td>
                                    <td>        
                                        <input type="hidden" id="idpro" value="${c.getIdProducto()}">
                                        <input type="number" min="1"   id="Cantidad" class=" form-control text-center" value="${c.getCantidad()}">
                                    </td>   
                                    <td>${c.getSubTotal()}</td>                           
                                    <td class="text-center">                                         
                                        <input type="hidden" id="item2" value="${c.getIdProducto()}">
                                        <a id="deleteItem" href="#" class="btn"><i class="fas fa-trash-alt"></i></a>                                            
                                    </td>                           
                                </tr>
                                <!--                                Modal para ver más-->
                            <div class="col-sm-12" >
                                <div class="modal fade" id="product${c.getItem()}" tabindex="-1" role="dialog">
                                    <div class="modal-dialog modal-dialog-centered" role="document">         
                                        <div class="modal-content">                   
                                            <div class="modal-header text-center" id="Colorheader"> 
                                                <h5 class="NombrePro">${c.getNombres()}</h5>
                                                <button type="button" class="close" data-dismiss="modal">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>  
                                            </div>
                                            <div class="modal-body"> 
                                                <div class="tab-content" id="pills-tabContent">
                                                    <div class="tab-pane fade show active" id="pills-descripcion" role="tabpanel">
                                                        <h4 class="Descripcion">Descripcion:</h4>
                                                        ${c.getDescripcion()}
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="modal-footer"> 
                                                <div class="tab-content" id="pills-tabContent">
                                                    <div class="tab-pane fade show active" role="tabpanel">
                                                        <h4 class="Marca">Marca:</h4>
                                                        ${c.getMarca()}
                                                        <br>
                                                    </div>
                                                </div> 
                                            </div> 
                                        </div>
                                    </div>
                                </div>                                 
                            </div>
                        </c:forEach>
                        </tbody>
                    </table>                    
                </div>
                <div class="col-lg-3">                  
                    <div class="card">
                        <div class="card-header">
                            Datos de compra
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <a class="form-control text-center"><i class="fas fa-dollar-sign h5"> ${subtotal}0</i></a>
                            <label>Precio Envio:</label>
                            <a class="form-control text-center"><i class="fas fa-dollar-sign h5"> 0.00</i></a>
                            <label>Descuento:</label>
                            <a class="form-control text-center"><i class="fas fa-dollar-sign h5"> ${descuento}</i></a>
                            <label>Total a Pagar:</label>
                            <a class="form-control text-center"><i class="fas fa-dollar-sign h4 primary"> ${totalPagar}0</i></a>
                        </div>
                        <div class="card-footer">
                            <a href="ControladorProductos?accion=GenerarVenta" onclick="print()"class="btn btn-danger btn-block">Realizar Compra</a>
                            <a href="#" data-toggle="modal" data-target="#myModalPago" class="btn btn-info btn-block">Datos Pago</a>
                        </div>
                    </div>
                </div>
            </div>          
        </div>
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
                                        }   else {
                                            document.getElementById("Error12").innerText = "";
                                        }
                                        if (Contraseña === "") {
                                            document.getElementById("Error22").innerText = "*Por favor ingresa tu contraseña";
                                        }   else {
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
                                        }   else if (soloLetras(datos1)) {
                                            document.getElementById("Error10").innerText = "*Solo ingrese el nombre de la persona";
                                        } else {
                                            document.getElementById("Error10").innerText = "";
                                        }
                                        
                                        if (datos2 === "") {
                                            document.getElementById("Error20").innerText = "*Por favor ingresa tu apellido";
                                        }   else if (soloLetras(datos2)) {
                                            document.getElementById("Error20").innerText = "*Solo ingrese el apellido de la persona";
                                        } else {
                                            document.getElementById("Error20").innerText = "";
                                        }
                                        if (datos3 === "") {
                                            document.getElementById("Error30").innerText = "*Por favor ingresa tu tipo de documento";
                                        }   else if (soloLetras(datos3)) {
                                            document.getElementById("Error30").innerText = "*Solo ingrese el tipo de documento";
                                        } else {
                                            document.getElementById("Error30").innerText = "";
                                        }
                                        if (datos4 === "") {
                                            document.getElementById("Error40").innerText = "*Por favor ingresa tu numero de documento";
                                        }   else if (soloNumeros(datos4)) {
                                            document.getElementById("Error40").innerText = "*Solo ingrese el numero de documento";
                                        } else {
                                            document.getElementById("Error40").innerText = "";
                                        }
                                        if (datos5 === "") {
                                            document.getElementById("Error50").innerText = "*Por favor ingresa tu numero de telefono";
                                        }   else if (soloNumeros(datos5)) {
                                            document.getElementById("Error50").innerText = "*Solo ingrese su numero telefonico";
                                        } else {
                                            document.getElementById("Error50").innerText = "";
                                        }
                                        if (datos6 === "") {
                                            document.getElementById("Error60").innerText = "*Por favor ingresa tu direcion de residencia";
                                        }   else {
                                            document.getElementById("Error60").innerText = "";
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
                                                    function Validar(){
                                                          var Email = document.RegUsu.email.value;
                                                          var Contraseña = document.RegUsu.clave.value;
                                                          
                                                          if (Email === ""){
                                                              document.getElementById("Error1").innerText = "*Por favor ingrese el correo";
                                                          }
                                                          else {
                                                               document.getElementById("Error1").innerText = "";
                                                          }
                                                          if (Contraseña === ""){
                                                              document.getElementById("Error2").innerText = "*Por favor ingresa tu contraseña";
                                                          }
                                                          else {
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
        <!-- Modal de Pago -->
        <div class="modal fade" id="myModalPago" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">         
                <div class="modal-content">                   
                    <div class="modal-header text-center"> 
                        <label><i class="fa-dollar-sign"></i>Realizar Pago</label>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                        </button>  
                    </div>
                    <div class="modal-body"> 
                        <div class="tab-content" id="pills-tabContent">
                            <!-- Metodo Pago -->
                            <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                <form action="Controlador">
                                    <div class="form-group">
                                        <label>Card address</label>
                                        <input type="text" class="form-control" placeholder="9999-9999-9999-9999">
                                    </div>
                                    <div class="form-group">
                                        <label>Codigo Seguridad</label>
                                        <input type="text" class="form-control" placeholder="xxxx">
                                    </div>
                                    <div class="form-group">
                                        <label>Monto</label>
                                        <input type="text"  name="txtmonto"  value="$${totalPagar}" class="form-control h1" readonly>
                                    </div>
                                    <div class="card-footer">
                                        <a href="ControladorProductos?accion=GenerarVenta" class="btn btn-danger btn-block">Realizar Compra</a>
                                    </div>
                                </form>
                            </div>

                        </div> 
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/funciones.js" type="text/javascript"></script>

    </body>
</html>
