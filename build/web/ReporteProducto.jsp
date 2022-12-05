<%-- 
    Document   : ReporteProducto
    Created on : 5/10/2022, 07:36:51 PM
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
        <title>JSP Page</title>
    </head>
    <body>
         <%
            
            
       String nombreReporte= "Reportes/ReportesQueja.jasper";
File reporte = new File(application.getRealPath(nombreReporte));
Map<String,Object> parametros = new HashMap<String, Object>() ;
ConexionBD claseconexion = new ConexionBD();
Connection conexion = claseconexion.obtenerConexion();
byte[] reporteBytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametros,conexion);
response.setContentType("application/pdf");
response.setContentLength(reporteBytes.length);
response.setHeader("Content-Disposition", "filename=\"reporte_Producto.pdf\";");
try {
        ServletOutputStream salida = response.getOutputStream();
           salida.write(reporteBytes, 0, reporteBytes.length);
            salida.flush();
            salida.close();
    } catch (Exception e) {
        System.out.println("error"+e.toString());     
    }

        %>
    </body>
</html>
