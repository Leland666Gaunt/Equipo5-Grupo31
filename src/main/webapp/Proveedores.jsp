<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Módulo Proveedores</title>
</head>

<body>
<%!String mensaje=""; 
Long NIT;
String ciudad="",direccion="",nombre="",telefono="",estado="";
%>

<%
if(request.getParameter("NIT")!=null){
NIT=Long.parseLong(request.getParameter("NIT"));
ciudad=request.getParameter("ciudad");
direccion=request.getParameter("direccion");
nombre=request.getParameter("nombre");
telefono=request.getParameter("telefono");
estado="readonly";
}
%>
<%
if(request.getParameter("sten")!=null){
NIT=null;
ciudad="";
nombre="";
direccion="";
telefono="";
estado="";
mensaje=request.getParameter("sten");
out.print("<script>alert('"+mensaje+"')</script>");//Mensaje con alert de js
}
%>

    <div class="topnav">
        <a href="Administrador.jsp">Inicio</a>
        <a href="Usuarios.jsp">Usuarios</a>
        <a href="Customers.jsp">Clientes</a>
        <a href="Proveedores.jsp">Proveedores</a>
        <a href="products.jsp">Productos</a>
        <a href="Ventas.jsp">Ventas</a>
        <a href="Reports.jsp">Reportes</a>
    </div>
    <h1 class="title">Modulo Proveedores</h1>
           <form action="Providers" method="post">
           <div class="form-content">
            <div class="form-container">
                <div>
                    <form>
                        <div class="form-group">
                            <label for="identifier">Nit</label><br>
                            <input type="number" id="identifier" name="NIT" value=<%=NIT %> required <%=estado %>><br>
                        </div>
                        <div class="form-group">
                            <label for="name">Nombre Proveedor</label><br>
                            <input type="text" id="name" name="nombre" value="<%=nombre %>">
                        </div>
                        <div class="form-group">
                            <label for="email">Dirección</label><br>
                            <input type="text" id="direction" name="direccion" value="<%=direccion %>">
                        </div>
                        </form>
                        <!-- -- -->
                        
                        <div class="form-group">
                            <label for="identifier">Teléfono</label><br>
                            <input type="number" id="phone" name="telefono" value="<%=telefono %>"><br>
                        </div>
                        <div class="form-group">
                            <label for="name">Ciudad</label><br>
                            <input type="text" id="city" name="ciudad" value="<%=ciudad %>">
                        </div>
                        
                </div>
                
            </div>
            <div class="btn-group">
                <div><input type="submit" name="registrar" value="registrar">
				<input type="submit" name="modificar" value="modificar">
				<input type="submit" name="eliminar" value="eliminar"></div>
				</form>
				<fieldset>
				<legend>Consultar</legend>
				<form action="Providers" method="post">
					<div class="form-container"><label for="identifier">Nit</label><br>
					<input type="number" name="NIT_Proveedor" required></div>
					<input type="submit" name="consultar" value="consultar">
					</form>
					</fieldset>
            </div>
        </div>
</body>

</html>