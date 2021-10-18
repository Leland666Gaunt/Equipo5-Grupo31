<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/Reportes.js" ></script>
    <link rel="stylesheet" href="css/styles.css">
    <title>Modulo Reportes</title>
</head>

<body>
    <div class="topnav">
        <a href="Administrador.jsp">Inicio</a>
        <a href="Usuarios.jsp">Usuarios</a>
        <a href="Customers.jsp">Clientes</a>
        <a href="Proveedores.jsp">Proveedores</a>
        <a href="products.jsp">Productos</a>
        <a href="Ventas.jsp">Ventas</a>
        <a href="Reports.jsp">Reportes</a>
    </div>
    <h1 class="title">Modulo Reportes</h1>
    <center>
    <div id="boton1"><button  class="ListarUsuarios"> LISTADO USUARIOS</button>
    <button class="ListarClientes"> LISTADO CLIENTES</button>
    <button class="ListarVentas"> VENTAS POR CLIENTE</button></div>
    
    <table id="tabla">
    
    </table>
    </center>
</body>

</html>