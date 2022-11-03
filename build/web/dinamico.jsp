<%-- 
    Document   : dinamico
    Created on : 27 oct 2022, 0:09:47
    Author     : berliz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.menu" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.Map.Entry"%>
<!DOCTYPE html>
<html>
 
    <head>
        <style type="text/css">
		*{
		padding:0px;
		margin:0px;

}

#header{
	margin:auto;
	width: 500px;
	font-family: arial, helvetica, sans-serif;
}
ul,ol{
	list-style: none;
}

.nav li a{
	background-color:#000;
	color: #fff;
	text-decoration: none;
	padding: 10px 15px;
	display: block;
}

.nav li a:hover {
	background-color: #434343;
}
        .nav > li {
	float:left;

}

.nav li ul {
display: none;
position: absolute;
min-width: 140px;
}

.nav li:hover > ul {
display: block;
}

.nav li ul li {
position: relative;
}	
.nav li ul li ul {
right: -140px;
top: 0px;	
}

</style>

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu dinamico</title>
        
    </head>
    <body>
        
        <h1 id="header">Menu Principal</h1>
        
            <div id="header">
            
                <% menu menu = new menu();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = menu.leer();
                    out.println("<ul class='nav'>");
                    //Inicio For
                    for (int t= 0; t<tabla.getRowCount(); t++) {
                       
                                                     
                            if(tabla.getValueAt(t,2).equals("0")){
                                            out.println("<li><a>"+ tabla.getValueAt (t,1) + "</a>");
                                            
                                            }
                                            
                                            //Inicio Producto
                                            out.println("<ul");
                                            out.println("</li>");
                                            if(tabla.getValueAt(t,2).equals("1")){
                                                                    out.println("<li><a href='marcas.jsp'>"+ tabla.getValueAt (t,1) + "</a></li>" );            
                                                       } 
                                                       out.println("</ul>");
                                            // Fin Producto
                                            
                                            //Inicio Ventas 2
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("3")){
                                                                    
                                                                    out.println("<li><a href='clientes.jsp'> "+ tabla.getValueAt (t,1)+ "</a></li>");
                                                                    
                                                        }
                                            if(tabla.getValueAt(t,2).equals("5")){
                                                                    out.println("<ul>");
                                                                    out.println("<li><a href='puesto.jsp'>"+ tabla.getValueAt (t,1) + "</a></li>" );
                                                                    out.println("</ul>"); 
                                                       } 
                                                       out.println("</ul>");
                                                       //Fin Ventas 2
                                                       
                                            //Inicio compras 3
                                            out.println("<ul>");
                                            if(tabla.getValueAt(t,2).equals("7")){
                                                                    
                                                                    out.println("<li><a href='proveedores.jsp'>"+ tabla.getValueAt (t,1)+ "</a></li>");
                                                                    
                                                        }
                                                       out.println("</ul>");
                                            //Fin compras 3
            
                                            //Fin del For
                                           }                         
                           out.println("</ul>");
                  %>
            
        </div>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
