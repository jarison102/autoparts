<%-- 
    Document   : ReporteDetalleCompra
    Created on : 5/10/2022, 09:33:07 PM
    Author     : Jarrison
--%>


<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Util.ConexionBD"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>

<!DOCTYPE html>
<html>
    <head>
      
        <title>JSP Page</title>
    </head>
    <body>
         <%
            
            
       String nombreReporte= "Reportes/ReporteDetalleCompra.jasper";
File reporte = new File(application.getRealPath(nombreReporte));
Map<String,Object> parametros = new HashMap<String, Object>() ;
ConexionBD claseconexion = new ConexionBD();
Connection conexion = claseconexion.obtenerConexion();
byte[] reporteBytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametros,conexion);
response.setContentType("application/pdf");
response.setContentLength(reporteBytes.length);
response.setHeader("Content-Disposition", "filename=\"ReporteDetalleCompra.pdf\";");
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
