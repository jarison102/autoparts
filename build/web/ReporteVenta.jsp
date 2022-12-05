<%-- 
    Document   : ReporteVenta
    Created on : 5/10/2022, 10:10:45 PM
    Author     : Jarrison
--%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Util.ConexionBD"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            var nombre = prompt("ingrese la nombre:");
            if (nombre==null) {
                window.location.href="ReporteVenta.jsp";
} else {
     window.location.href="ReporteVenta.jsp?nombre="+nombre;
}
    
    </script>
        <title>JSP Page</title>
        
    </head>
    <body>
        
          <%
            
            if (request.getParameter("nombre")!=null) {
            String valor =request.getParameter("nombre").toString();
File reporte = new File(application.getRealPath("Reportes/ReporteVenta.jasper"));
ConexionBD claseconexion = new ConexionBD();
Connection conexion = claseconexion.obtenerConexion();
Map parametro=new HashMap();
parametro.put("nombre",valor);
byte[] reporteBytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametro,conexion);
response.setContentType("application/pdf");
response.setContentLength(reporteBytes.length);
response.setHeader("Content-Disposition", "filename=\"reporte_Venta.pdf\";");
try {
        ServletOutputStream salida = response.getOutputStream();
           salida.write(reporteBytes, 0, reporteBytes.length);
            salida.flush();
            salida.close();
    } catch (Exception e) {
        System.out.println("error"+e.toString());     
    }
            }
        %>
    </body>
</html>
