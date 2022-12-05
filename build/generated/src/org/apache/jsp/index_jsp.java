package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Sesion/cache.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\" integrity=\"sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>        \n");
      out.write("        <title>SI Autoparts</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo03\" aria-controls=\"navbarTogglerDemo03\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <a class=\"navbar-brand\" href=\"homeprincipal.jsp\"><i>Autoparts</i></a>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo03\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"./ControladorProductos?accion=Nuevo\"><i class=\"fas fa-home\"></i> Inicio<span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"./ControladorProductos?accion=carrito\"><i class=\"fas fa-cart-plus\">(<label style=\"color:#FC1212\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cont}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>)</i> Carrito</a>\n");
      out.write("                    </li> \n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n");
      out.write("                    <form  method =\"POST\" action=\"ControladorProductos\" class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                        <input  style=\"width:400px\" class=\"form-control mr-sm-2\" name=\"txtBuscar\" id=\"txtBuscar\">\n");
      out.write("                        <input type=\"hidden\" name=\"accion\" value=\"Buscar\">\n");
      out.write("                        <button class=\"btn btn-outline-info my-2 my-sm-0\" id=\"btnBuscar\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("                    </form> \n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"navbar-nav btn-group my-2 my-lg-0\" role=\"group\">\n");
      out.write("                    <a style=\"color: white; cursor: pointer\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                        <i class=\"fas fa-user-tie\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    <div class=\"dropdown-menu text-center dropdown-menu-right\"><br>\n");
      out.write("\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"><img src=\"img/user_1.png\" alt=\"60\" height=\"60\"/></a>                        \n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">Iniciar Sesion</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"registrarQueja.jsp\">Registrar queja</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"ControladorProductos?accion=MisCompras\">Mis Compras</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"vistas/quejas.jsp\">Mis Quejas</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <center>\n");
      out.write("                            <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Sesiones\">\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <input type=\"submit\" class=\"nav-link btn btn-primary ms-1\" value=\"Cerrar sesi&#243;n\">  \n");
      out.write("                                </li>\n");
      out.write("                            </form> \n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                </ul>     \n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <h1 class=\"Cata\">Catálogo</h1>\n");
      out.write("        <div class=\"container mt-4\" id=\"Catalogo\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Codigo del footer-->\n");
      out.write("        <footer class=\"pie-pagina\">\n");
      out.write("            <center>\n");
      out.write("                <div class=\"grupo-1\">\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <figure>\n");
      out.write("                            <h2>Sobre Nosotros</h2>\n");
      out.write("                            <p>Somos una grupo de desarrolladores encargados del sistema de información Autoparts </p>\n");
      out.write("                        </figure>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <figure>\n");
      out.write("                            <img src=\"img/logov1.png\" alt=\"\"/>\n");
      out.write("                        </figure><\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <figure>\n");
      out.write("                            <h2>Redes Sociales</h2>\n");
      out.write("                            <img class=\"redes\" src=\"img/face_logo.png\" alt=\"\"s/>\n");
      out.write("                            <img class=\"redes\" src=\"img/twit_logo.png\" alt=\"\"/>\n");
      out.write("                        </figure>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"grupo-2\">\n");
      out.write("                    <center>\n");
      out.write("                        <small>&copy; 2022 <b>Andres Olaya, Michel Martinez , Jarrison Mican , Sergio Alonso, Sebastian Diaz</b> - Derechos Reservados<br> </small>\n");
      out.write("\n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("            </center>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <!-- Modal Iniciar Session o Registrarse -->\n");
      out.write("        <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("                <div class=\"container col-lg-9\">                   \n");
      out.write("                    <div class=\"modal-content\">                   \n");
      out.write("                        <div class=\"pr-2 pt-1\">                         \n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\n");
      out.write("                                <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                            </button>                    \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"text-center\">                         \n");
      out.write("                            <img src=\"img/user.png\" width=\"100\" height=\"100\">                         \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-header text-center\">                      \n");
      out.write("                            <ul class=\"nav nav-pills\">                           \n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a  class=\"nav-link active\" data-toggle=\"pill\" href=\"#pills-iniciar\">Iniciar Sesion</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a  class=\"nav-link\" data-toggle=\"pill\" href=\"#pills-registrar\">Registrarse</a>\n");
      out.write("                                </li>       \n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a class=\"nav-link\" data-toggle=\"pill\" href=\"#pills-datos\">Registrar Datos</a>\n");
      out.write("                                </li> \n");
      out.write("\n");
      out.write("\n");
      out.write("                            </ul>  \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\"> \n");
      out.write("                            <div class=\"tab-content\" id=\"pills-tabContent\">\n");
      out.write("                                <!-- Iniciar Session -->\n");
      out.write("                                <div class=\"tab-pane fade show active\" id=\"pills-iniciar\" role=\"tabpanel\">\n");
      out.write("                                    <form name=\"inicio\" method=\"post\" action=\"ControladorUsuarios\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Email</label>\n");
      out.write("                                            <input type=\"email\" name=\"textEmail\" class=\"form-control\" placeholder=\"email@example.com\">\n");
      out.write("                                            <label id=\"Error12\" style=\"color:red\"></label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Contraseña</label>\n");
      out.write("                                            <input type=\"password\" name=\"textClave\" class=\"form-control\" placeholder=\"Contraseña\">\n");
      out.write("                                            <label id=\"Error22\" style=\"color:red\"></label>\n");
      out.write("                                        </div>  \n");
      out.write("                                        <button class=\"btn btn-outline-danger btn-block\" onmouseover=\"validacion()\">Iniciar</button>\n");
      out.write("                                        <input type=\"hidden\" value=\"4\" name=\"opcion\">\n");
      out.write("                                    </form>\n");
      out.write("                                    <script type=\"text/javascript\">\n");
      out.write("                                        function validacion() {\n");
      out.write("                                            var Email = document.inicio.textEmail.value;\n");
      out.write("                                            var Contraseña = document.inicio.textClave.value;\n");
      out.write("\n");
      out.write("                                            if (Email === \"\") {\n");
      out.write("                                                document.getElementById(\"Error12\").innerText = \"*Por favor ingresa tu correo\";\n");
      out.write("                                            } else {\n");
      out.write("                                                document.getElementById(\"Error12\").innerText = \"\";\n");
      out.write("                                            }\n");
      out.write("                                            if (Contraseña === \"\") {\n");
      out.write("                                                document.getElementById(\"Error22\").innerText = \"*Por favor ingresa tu contraseña\";\n");
      out.write("                                            } else {\n");
      out.write("                                                document.getElementById(\"Error22\").innerText = \"\";\n");
      out.write("                                            }\n");
      out.write("                                        }\n");
      out.write("                                    </script>\n");
      out.write("                                </div>\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeIniciarSesion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"pills-datos\" role=\"tabpanel\">\n");
      out.write("                                    <form name=\"ingresarD\" method=\"POST\" action=\"ControladorPersonas\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label> Nombres</label><br>\n");
      out.write("                                            <input class=\"controls\" type=\"text\" name=\"textNombre\">\n");
      out.write("                                            <label id=\"Error10\" style=\"color:red\"></label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Apellidos</label><br>\n");
      out.write("                                            <input class=\"controls\" type=\"text\" name=\"textApe\">\n");
      out.write("                                            <label id=\"Error20\" style=\"color:red\"></label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label> Tipo de documento</label><br>\n");
      out.write("                                            <input class=\"controls\" type=\"text\" name=\"textTdoc\">\n");
      out.write("                                            <label id=\"Error30\" style=\"color:red\"></label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label> Numero de Documento</label><br>\n");
      out.write("                                            <input class=\"controls\" type=\"text\" name=\"textDocumento\">\n");
      out.write("                                            <label id=\"Error40\" style=\"color:red\"></label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label> Telefono</label><br>\n");
      out.write("                                            <input class=\"controls\" type=\"text\" name=\"textTelefono\">\n");
      out.write("                                            <label id=\"Error50\" style=\"color:red\"></label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label>Direccion</label><br>\n");
      out.write("                                            <input class=\"controls\" type=\"text\" name=\"textDireccion\">\n");
      out.write("                                            <label id=\"Error60\" style=\"color:red\"></label>  \n");
      out.write("                                        </div>\n");
      out.write("                                        <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${UsuarioVO.id_usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"controls\" type=\"hidden\" name=\"textId_usuario\">\n");
      out.write("                                        <button class=\"btn btn-outline-danger btn-block\" onmouseover=\"validar()\">Registrar</button>\n");
      out.write("                                        <input type=\"hidden\" value=\"1\" name=\"opcion\">\n");
      out.write("                                        <center>\n");
      out.write("                                            <script type=\"text/javascript\">\n");
      out.write("                                                function soloLetras(e) {\n");
      out.write("                                                    letrass = \"abcdefghijklmnopqrstuvwxyz\";\n");
      out.write("                                                    palabra = Array.from(e);\n");
      out.write("                                                    result = true;\n");
      out.write("                                                    letras = Array.from(letrass);\n");
      out.write("                                                    for (i = 0; i < letras.length; i++) {\n");
      out.write("                                                        for (f = 0; f < palabra.length; f++) {\n");
      out.write("                                                            console.log(letras[i], palabra[f]);\n");
      out.write("                                                            if (letras[i] === palabra[f]) {\n");
      out.write("                                                                result = false;\n");
      out.write("                                                            }\n");
      out.write("                                                        }\n");
      out.write("                                                    }\n");
      out.write("                                                    return result;\n");
      out.write("                                                }\n");
      out.write("                                                function soloNumeros(e) {\n");
      out.write("                                                    letrass = \"abcdefghijklmnopqrstuvwxyz\";\n");
      out.write("                                                    palabra = Array.from(e);\n");
      out.write("                                                    result = false;\n");
      out.write("                                                    letras = Array.from(letrass);\n");
      out.write("                                                    for (i = 0; i < letras.length; i++) {\n");
      out.write("                                                        for (f = 0; f < palabra.length; f++) {\n");
      out.write("                                                            console.log(letras[i], palabra[f]);\n");
      out.write("                                                            if (letras[i] === palabra[f]) {\n");
      out.write("                                                                result = true;\n");
      out.write("                                                            }\n");
      out.write("                                                        }\n");
      out.write("                                                    }\n");
      out.write("                                                    return result;\n");
      out.write("                                                }\n");
      out.write("                                                function validar() {\n");
      out.write("                                                    var datos1 = document.ingresarD.textNombre.value;\n");
      out.write("                                                    var datos2 = document.ingresarD.textApe.value;\n");
      out.write("                                                    var datos3 = document.ingresarD.textTdoc.value;\n");
      out.write("                                                    var datos4 = document.ingresarD.textDocumento.value;\n");
      out.write("                                                    var datos5 = document.ingresarD.textTelefono.value;\n");
      out.write("                                                    var datos6 = document.ingresarD.textDireccion.value;\n");
      out.write("\n");
      out.write("                                                    if (datos1 === \"\") {\n");
      out.write("                                                        document.getElementById(\"Error10\").innerText = \"*Por favor ingresa tu nombre\";\n");
      out.write("                                                    } else if (soloLetras(datos1)) {\n");
      out.write("                                                        document.getElementById(\"Error10\").innerText = \"*Solo ingrese el nombre de la persona\";\n");
      out.write("                                                    } else {\n");
      out.write("                                                        document.getElementById(\"Error10\").innerText = \"\";\n");
      out.write("                                                    }\n");
      out.write("\n");
      out.write("                                                    if (datos2 === \"\") {\n");
      out.write("                                                        document.getElementById(\"Error20\").innerText = \"*Por favor ingresa tu apellido\";\n");
      out.write("                                                    } else if (soloLetras(datos2)) {\n");
      out.write("                                                        document.getElementById(\"Error20\").innerText = \"*Solo ingrese el apellido de la persona\";\n");
      out.write("                                                    } else {\n");
      out.write("                                                        document.getElementById(\"Error20\").innerText = \"\";\n");
      out.write("                                                    }\n");
      out.write("                                                    if (datos3 === \"\") {\n");
      out.write("                                                        document.getElementById(\"Error30\").innerText = \"*Por favor ingresa tu tipo de documento\";\n");
      out.write("                                                    } else if (soloLetras(datos3)) {\n");
      out.write("                                                        document.getElementById(\"Error30\").innerText = \"*Solo ingrese el tipo de documento\";\n");
      out.write("                                                    } else {\n");
      out.write("                                                        document.getElementById(\"Error30\").innerText = \"\";\n");
      out.write("                                                    }\n");
      out.write("                                                    if (datos4 === \"\") {\n");
      out.write("                                                        document.getElementById(\"Error40\").innerText = \"*Por favor ingresa tu numero de documento\";\n");
      out.write("                                                    } else if (soloNumeros(datos4)) {\n");
      out.write("                                                        document.getElementById(\"Error40\").innerText = \"*Solo ingrese el numero de documento\";\n");
      out.write("                                                    } else {\n");
      out.write("                                                        document.getElementById(\"Error40\").innerText = \"\";\n");
      out.write("                                                    }\n");
      out.write("                                                    if (datos5 === \"\") {\n");
      out.write("                                                        document.getElementById(\"Error50\").innerText = \"*Por favor ingresa tu numero de telefono\";\n");
      out.write("                                                    } else if (soloNumeros(datos5)) {\n");
      out.write("                                                        document.getElementById(\"Error50\").innerText = \"*Solo ingrese su numero telefonico\";\n");
      out.write("                                                    } else {\n");
      out.write("                                                        document.getElementById(\"Error50\").innerText = \"\";\n");
      out.write("                                                    }\n");
      out.write("                                                    if (datos6 === \"\") {\n");
      out.write("                                                        document.getElementById(\"Error60\").innerText = \"*Por favor ingresa tu direcion de residencia\";\n");
      out.write("                                                    } else {\n");
      out.write("                                                        document.getElementById(\"Error60\").innerText = \"\";\n");
      out.write("                                                    }\n");
      out.write("                                                }\n");
      out.write("                                            </script>\n");
      out.write("                                            ");
                                                if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                            ");

                                            } else {
      out.write("\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                        </center>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Registrarse --> \n");
      out.write("                                <div class=\"tab-pane fade\" id=\"pills-registrar\" role=\"tabpanel\">\n");
      out.write("                                    <form name=\"RegUsu\" action=\"ControladorUsuarios\">                               \n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <l abel>Email address</label>\n");
      out.write("                                                    <input type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"email@ejemplo.com\">\n");
      out.write("                                                    <label id=\"Error1\" style=\"color:red\"></label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label>Password</label>\n");
      out.write("                                                <input type=\"password\" name=\"clave\" class=\"form-control\" placeholder=\"Contraseña\">\n");
      out.write("                                                <label id=\"Error2\" style=\"color:red\"></label>\n");
      out.write("                                            </div>            \n");
      out.write("\n");
      out.write("                                            <button type=\"submit\" name=\"opcion\" onmouseover=\"Validar()\" value=\"1\" class=\"btn btn-outline-danger btn-block\">Crear Cuenta</button>\n");
      out.write("                                            <center>\n");
      out.write("                                                <script type=\"text/javascript\">\n");
      out.write("                                                    function Validar() {\n");
      out.write("                                                        var Email = document.RegUsu.email.value;\n");
      out.write("                                                        var Contraseña = document.RegUsu.clave.value;\n");
      out.write("\n");
      out.write("                                                        if (Email === \"\") {\n");
      out.write("                                                            document.getElementById(\"Error1\").innerText = \"*Por favor ingrese el correo\";\n");
      out.write("                                                        } else {\n");
      out.write("                                                            document.getElementById(\"Error1\").innerText = \"\";\n");
      out.write("                                                        }\n");
      out.write("                                                        if (Contraseña === \"\") {\n");
      out.write("                                                            document.getElementById(\"Error2\").innerText = \"*Por favor ingresa tu contraseña\";\n");
      out.write("                                                        } else {\n");
      out.write("                                                            document.getElementById(\"Error2\").innerText = \"\";\n");
      out.write("                                                        }\n");
      out.write("                                                    }\n");
      out.write("                                                </script>\n");
      out.write("                                                ");

                                                    if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("                                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                                ");

                                                } else {
      out.write("\n");
      out.write("                                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                            </center>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>                          \n");
      out.write("                            </div> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.js\" integrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"js/index.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    ");

        if (request.getAttribute("iniciarSesion") != null) {
    
      out.write("\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("                                                    window.$('#myModal').modal('show');\n");
      out.write("    </script>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("p");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${productos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <div class=\"col-sm-4\">\n");
          out.write("                        <div class=\"form-group\">\n");
          out.write("                            <div class=\"card\">\n");
          out.write("                                <div class=\"card-header\">\n");
          out.write("                                    <label class=\"col-sm-13\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getNombre_producto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</label>                                    \n");
          out.write("                                </div>\n");
          out.write("                                <div class=\"card-body center d-flex\">\n");
          out.write("                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getImagen()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" width=\"200\" height=\"170\">\n");
          out.write("                                </div>\n");
          out.write("                                <div class=\"card-body2 text-center\">\n");
          out.write("                                    <label><i class=\"fas fa-dollar-sign\" id=\"precio\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getPrecio_producto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</i></label>                                       \n");
          out.write("                                </div>\n");
          out.write("                                <div class=\"card-footer\">\n");
          out.write("                                    <div class=\"col-sm-12\" >\n");
          out.write("                                        <div class=\"modal fade\" id=\"product");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" tabindex=\"-1\" role=\"dialog\">\n");
          out.write("                                            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">         \n");
          out.write("                                                <div class=\"modal-content\">                   \n");
          out.write("                                                    <div class=\"modal-header text-center\" id=\"Colorheader\"> \n");
          out.write("                                                        <h5 class=\"NombrePro\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getNombre_producto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\n");
          out.write("                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\n");
          out.write("                                                            <span aria-hidden=\"true\">&times;</span>\n");
          out.write("                                                        </button>  \n");
          out.write("                                                    </div>\n");
          out.write("                                                    <div class=\"modal-body\"> \n");
          out.write("                                                        <div class=\"tab-content\" id=\"pills-tabContent\">\n");
          out.write("                                                            <!-- Metodo Pago -->\n");
          out.write("                                                            <div class=\"tab-pane fade show active\" id=\"pills-iniciar\" role=\"tabpanel\">\n");
          out.write("                                                                <h4 class=\"Descripcion\">Descripcion:</h4>\n");
          out.write("                                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getDescripcion_producto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                                                <br>\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </div> \n");
          out.write("                                                    </div>\n");
          out.write("                                                    <div class=\"modal-footer\"> \n");
          out.write("                                                        <div class=\"tab-content\" id=\"pills-tabContent\">\n");
          out.write("                                                            <div class=\"tab-pane fade show active\" role=\"tabpanel\">\n");
          out.write("                                                                <h4 class=\"Marca\">Marca:</h4>\n");
          out.write("                                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getMarca_producto()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                                                <br>\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </div> \n");
          out.write("                                                    </div>                                                 \n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                        </div>                                 \n");
          out.write("                                    </div>\n");
          out.write("                                    <div class=\" col-sm-12 text-center\">              \n");
          out.write("                                        <a href=\"ControladorProductos?accion=AgregarCarrito&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"boton\">Agregar<i class=\"fas fa-cart-plus\"></i></a>\n");
          out.write("                                        <a href=\"ControladorProductos?accion=Comprar&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"boton2\">Comprar</a>\n");
          out.write("                                        <br>\n");
          out.write("                                        <br>\n");
          out.write("                                        <a class=\"boton\" href=\"#\" data-toggle=\"modal\" data-target=\"#product");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Ver más</a>\n");
          out.write("                                    </div>                          \n");
          out.write("                                </div>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
