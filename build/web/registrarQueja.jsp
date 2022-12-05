<%@include file = "Sesion/cache.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ModeloVO.QuejaVO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>  
        <link href="Estilos/RegistrarEmpleado.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
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
                        <a class="nav-link" href="./ControladorProductos?accion=Nuevo"><i class="fas fa-home"></i> Volver al Catalogo<span class="sr-only">(current)</span></a>
                    </li>
                </ul>

                </ul>
                <ul class="navbar-nav btn-group my-2 my-lg-0" role="group">
                    <a style="color: white; cursor: pointer" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fas fa-user-tie"></i> ${email}</a>
                </ul>     
            </div>
        </nav>        
        <section class="form-register">
            <center>
                <form name="Quej" method="POST" action="Quejas" class="login">
                    <h3>Registrar Queja</h3><br>
                    <table>
                        <tr>
                        <input class="controls" type="hidden" value="${UsuarioVO.id_usuario}" name="textusu" required>
                        <label id="Error1" style="color:red"></label>
                        <br><br>
                        Asunto <br>
                        <input class="controls" type="text" name="textA" required>
                        <label id="Error5" style="color:red"></label>
                        <br><br>

                        Detalle <br>
                        <textarea class="controls" type="text" name="textD" required></textarea>
                        <label id="Error5" style="color:red"></label>
                        <br><br>
                        
                        </tr>
                    </table><br>
                    <button style="cursor:pointer" class="envio" onmouseover="validar()">Registrar</button>
                    <input type="hidden" value="1" name="opcion"><br><br> 
                    <script type="text/javascript">


                        function validar() {
                            var id_persona_fk = document.Quej.textIdP.value;
                            var queja = document.Quej.textDet.value;
                            var Correo = document.Quej.textC.value;
                            var Asunto = document.Quej.textA.value;
                            if (id_persona_fk === "") {
                                document.getElementById("Error1").innerText = "*Error, se necesita una persona";


                            } else {
                                document.getElementById("Error1").innerText = "";
                            }

                            if (queja === "") {
                                document.getElementById("Error3").innerText = "*Error,Escribe tu queja";
                            } else {
                                document.getElementById("Error3").innerText = "";
                            }
                            if (Correo === "") {
                                document.getElementById("Error4").innerText = "*Error, ingresa tu correo";
                            } else {
                                document.getElementById("Error4").innerText = "";

                            }
                            if (Asunto === "") {
                                document.getElementById("Error5").innerText = "*Error,pon tu asunto por favor";
                            } else {
                                document.getElementById("Error5").innerText = "";
                            }

                        }
                    </script>
                    </section>
            </center>
            <center>
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
    </body>
</html>
