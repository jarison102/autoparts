<%@include file = "../../Sesion/cache.jsp" %>
<%-- 
    Document   : listarProductos
    Created on : 15/08/2022, 08:31:41 PM
    Author     : Sergio
--%>

<%@page import="ModeloVO.InventarioVO"%>
<%@page import="ModeloDAO.InventarioDAO"%>
<%@page import="ModeloVO.ProductoVO"%>
<%@page import="java.util.List"%>

<%@page import="ModeloDAO.ProductoDAO"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
        
         <form method="POST" action="../../Inventario">
                <h3>Consultar Inventario</h3><br>
            <table>
                <tr>
                    <th>
                    <label for="id">Id Inventario</label>
                    <input type="text"  name="textIdinventario">
                    <br><br>
                    <button class="consultar" >Consultar usuario</button>
                    </th>
                </tr>
            </table><br><br>
            <input type="hidden" value="3" name="opcion">
        </form><br><br>
        <%
        if (request.getAttribute("mensajeError")!= null)
        {%>
            ${mensajeError}
        <%
        }
        else{%>
            ${mensajeExito}
        <%  
            }
        %>
        
        
        
    <a href="registrarInventario.jsp" >Nuevo</a>
    </head>
    <body>
      <center>

           </table>

        </form><br>

        <%             if (request.getAttribute("mensajeError") != null) {
        %>

        ${mensajeError}

        <%
        } else {
        %>

        <%
            }
        %>

        <br>

        <form>
            <table border="1">
                <tr>
                    <th> id_inventario  </th>
                    <th> informacion_inventario     </th>
                    <th> fecha_inventario     </th>
                    <th> perdidas_productos </th>
                    <th> id_producto_fk  </th>
                    <th> id_empleado_fk </th> 
                   
                    


                </tr>

                <%
                    InventarioVO invVO = new InventarioVO();
                    InventarioDAO invDAO = new InventarioDAO();
                    ArrayList<InventarioVO> listaInventario = invDAO.Listar();
                    for (int i = 0; i < listaInventario.size(); i++) {
                        invVO = listaInventario.get(i);

                %>
                <tr>
                    <td><%=invVO.getId_inventario()%></td>
                    <td><%=invVO.getInformacion_inventario()%></td>
                    <td><%=invVO.getFecha_inventario()%></td>
                    <td><%=invVO.getPerdidas_productos()%></td>
                    <td><%=invVO.getId_producto_fk()%></td>
                    <td><%=invVO.getId_empleado_fk()%></td>                 
                    
                    <td>                        
                    </td>
                   

                </tr>
                <%}%>
            </table>
        </form>    
    </center>



</body>
</html>
