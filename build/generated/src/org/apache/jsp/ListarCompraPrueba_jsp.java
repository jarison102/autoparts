package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ListarCompraPrueba_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Sesion/cache.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>Sistema Autoparts</title>\n");
      out.write("        <link href=\"css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>    \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\" integrity=\"sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay\" crossorigin=\"anonymous\">\n");
      out.write("        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/estilosdashboard.css\" rel=\"stylesheet\" type=\"text/css\"/> \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        \n");
      out.write("        <script src=\"https://kit.fontawesome.com/3ed465e9fb.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/CambioEstado.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition skin-blue sidebar-mini\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"d-flex\" id=\"wrapper\">\n");
      out.write("            <!-- Sidebar-->\n");
      out.write("            <div class=\"border-end bg-white\" id=\"sidebar-wrapper\">\n");
      out.write("                <div class=\"sidebar-heading border-bottom bg-light\">\n");
      out.write("                    <i class='bx bxs-car-mechanic'></i>\n");
      out.write("                    Autoparts\n");
      out.write("                    <br>\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"list-group list-group-flush\">\n");
      out.write("\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"Compra.jsp\"> <i class='bx bx-purchase-tag'></i> Compra</a>                    \n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"registrarEmpleado.jsp\"> <i class='bx bx-folder-plus'></i> Registro Empleado</a>\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"/registrarProveedor.jsp\"> <i class='bx bx-folder-plus'></i> Registro Proveedor</a>\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"Listar?variable=ListarCompras\"> <i class='bx bx-file-find'></i>Consulta compra</a>\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"Listar?variable=ListarUsuarios\"> <i class='bx bx-file-find'></i>Consulta usuario</a>\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"Listar?variable=ListarProveedores\"> <i class='bx bx-file-find'></i>Consulta proveedor</a>\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"ControladorProductos?accion=NuevoProducto\"> <i class='bx bx-file-find'></i> Consulta productos</a>\n");
      out.write("                    <a class=\"list-group-item list-group-item-action list-group-item-light p-3\" href=\"./ReporteCompra.jsp\"> <i class='bx bxs-report'></i> Reporte compra</a>\n");
      out.write("                    <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Sesiones\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <input type=\"submit\" class=\"nav-link btn btn-primary ms-1\" value=\"Cerrar sesi&#243;n \" style=\"color:#FFF\">  \n");
      out.write("                        </li>\n");
      out.write("                    </form> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Page content wrapper-->\n");
      out.write("            <div id=\"page-content-wrapper\">\n");
      out.write("                <!-- Top navigation-->\n");
      out.write("                <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark border-bottom\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <button class=\"btn btn-primary\" id=\"sidebarToggle\"><i class='bx bx-menu' ></i></button>\n");
      out.write("                        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"><span class=\"navbar-toggler-icon\"></span></button>\n");
      out.write("                        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                            <ul class=\"navbar-nav ms-auto mt-2 mt-lg-0\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <li class=\"nav-item dropdown\">\n");
      out.write("                                    <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                        <i class=\"fas fa-user-tie\"></i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                                    <div class=\"dropdown-menu dropdown-menu-end\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("                <!-- Page content-->\n");
      out.write("\n");
      out.write("                <center>\n");
      out.write("                    <section class=\"content\">\n");
      out.write("                        <div class=\"box\">    \n");
      out.write("                            <div class=\"box-header with-border\">             \n");
      out.write("                                <h3 class=\"box-title\">Listado de Compras</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"box-body\">\n");
      out.write("                                <div class=\"table-responsive\" >                                 \n");
      out.write("                                    <table class=\"table tab-pane\"\">\n");
      out.write("                                        <thead class=\"thead-light\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Id</th>\n");
      out.write("                                                <th>Fecha</th>\n");
      out.write("                                                <th>Total</th>\n");
      out.write("                                                <th>Estado</th>\n");
      out.write("                                                <th>Proveedor</th>\n");
      out.write("                                                <th>Acciones</th> \n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("                                               \n");
      out.write("                                    </table>\n");
      out.write("                                </div>                        \n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <!-- /.box-body -->\n");
      out.write("                            <div class=\"box-footer\">\n");
      out.write("                                <!--Pie de página-->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.box-footer-->\n");
      out.write("                        </div>\n");
      out.write("                    </section>\n");
      out.write("                </center>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/dashboard.js\" type=\"text/javascript\"></script>\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.4.1.js\" integrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\" crossorigin=\"anonymous\"></script>           \n");
      out.write("    </body>\n");
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
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("com");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Lc}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("iteracion");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("                                                    \n");
          out.write("                                            <tr>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getFecha_compra()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getTotal_compra()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getEstado_compra()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</</td>\n");
          out.write("                                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getId_proveedor_fk()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</</td>\n");
          out.write("                                                <td><a class=\"btn btn-danger\" href=\"#\">Editar</a>                                    \n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                    ");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("\n");
          out.write("                                                </</td>\n");
          out.write("                                            </tr>                                                    \n");
          out.write("                                        ");
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
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getEstado_compra() eq 'Pendiente'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                                                        <input type=\"hidden\" name=\"id\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                                        <button class=\"btn-transparetn border-0 bg-transparent py-2\"\n");
        out.write("                                                                onclick=\"alertaInactivarC(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(", 'Pendiente')\">\n");
        out.write("                                                            <i class=\"fas fa-truck-loading\" style=\"font-size:25px;\"></i></button>\n");
        out.write("\n");
        out.write("\n");
        out.write("                                                    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getEstado_compra() eq 'Entregado'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                                                        <input type=\"hidden\" name=\"id\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                                        <button class=\"btn-transparetn border-0 bg-transparent py-2\"\n");
        out.write("                                                                onclick=\"alertaActivarC(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(", 'Entregado')\">\n");
        out.write("                                                            <i class=\"fa-solid fa-circle-check\" text-danger style=\"font-size: 25px;\"></i></button>\n");
        out.write("                                                    </td>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
