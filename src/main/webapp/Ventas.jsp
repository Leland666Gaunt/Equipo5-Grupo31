<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/stylesVentas.css">
</head>
<body>
<%!long Id_Customer,cedula_usuario;
String customer="",nombre_usuario="", estado="",nombre_producto1="",nombre_producto2="",nombre_producto3="",valor_producto1="",valor_producto2="",valor_producto3="",codigo_producto2="",total_producto1="",total_producto2="",total_producto3="",can1="",can2="",can3="",valor_venta="",total_venta="",iva_venta="";
int codigo_producto1,codigo_producto3,consec=1;
%>
<%
if(request.getParameter("cedula")!=null){
	Id_Customer=Long.parseLong(request.getParameter("cedula"));
	customer=request.getParameter("customer");
	estado="readonly";
}
if(request.getParameter("cedulau")!=null){
	cedula_usuario=Long.parseLong(request.getParameter("cedulau"));
	nombre_usuario=request.getParameter("usuario");
}
if(request.getParameter("cod_producto1")!=null){
	codigo_producto1=Integer.parseInt(request.getParameter("cod_producto1"));
	nombre_producto1=request.getParameter("nombre_producto1");
	valor_producto1=request.getParameter("valor_producto1");
}
if(request.getParameter("cod_producto2")!=null){
	codigo_producto2=request.getParameter("cod_producto2");
	nombre_producto2=request.getParameter("nombre_producto2");
	valor_producto2=request.getParameter("valor_producto2");
}
if(request.getParameter("cod_producto3")!=null){
	codigo_producto3=Integer.parseInt(request.getParameter("cod_producto3"));
	nombre_producto3=request.getParameter("nombre_producto3");
	valor_producto3=request.getParameter("valor_producto3");
}
if(request.getParameter("totalValue1")!=null){
	total_producto1=request.getParameter("totalValue1");
	can1=request.getParameter("can1");
	
}
if(request.getParameter("totalValue2")!=null){
	total_producto2=request.getParameter("totalValue2");
	can2=request.getParameter("can2");
}
if(request.getParameter("totalValue3")!=null){
	total_producto3=request.getParameter("totalValue3");
	can3=request.getParameter("can3");
}
if(request.getParameter("sales")!=null){
	valor_venta=request.getParameter("sales");
	total_venta=request.getParameter("sellOut");
	iva_venta=request.getParameter("taxes");
}
if(request.getParameter("consec")!=null){
	consec=Integer.parseInt(request.getParameter("consec"));
}
%>

<div class="topnav"> <!-- cambiar el hipervinculo en todos -->
        <a href="Administrador.jsp">Inicio</a>
        <a href="Usuarios.jsp">Usuarios</a>
        <a href="Customers.jsp">Clientes</a>
        <a href="Proveedores.jsp">Proveedores</a>
        <a href="products.jsp">Productos</a>
        <a href="Ventas.jsp">Ventas</a>
        <a href="Reports.jsp">Reportes</a>
    </div>
    <h1 class="title">TIC SUPPS</h1>

    <form action="Sales" method="post">
      <div class="form-content">
            <div class="form-container">
                <div>
                    <form>
                        <div class="form-group">
                            <label for="identifier">Cedula</label>
                            <input type="number" name="cedula" value="<%=Id_Customer%>">
                            <input type="submit" name="consultar_cedulaCliente" value="Consultar"  id="boton">
                            <label for="identifier">Cliente</label>
                            <input type="text" name="cliente" value = "<%=customer%>">
                            
                            <label for="identifier">Consec</label>
                            <input type="text" name="consec" value="<%=consec%>" > <br>
                            
                            <label for="identifier">Cedula</label>
                            <input type="number" name="cedulau" value="<%=cedula_usuario%>">
                            <input type="submit" name="consultar_cedulaUsuario" value="Consultar" id="boton">
                            <label for="identifier">Usuario</label>
                            <input type="text" name="usuario" value="<%=nombre_usuario%>" >
                          
                       
                        	<br><br> 
                            <label for="name" id="titulo_columna">Cod. Producto-</label><label for="name" id="titulo_columna">Nombre Producto-</label><label for="name" id="titulo_columna">Vlr. Unitario-</label><label for="name" id="titulo_columna">Cant-</label><label for="name" id="titulo_columna">Vlr. Total</label><br>
                            <input type="text" name="cod_producto1" value="<%=codigo_producto1%>">
                            <input type="submit" name="Consultar_producto1" value="Consultar" id="boton">
                            <input type="text" name="nombre_producto1" value="<%=nombre_producto1%>">
                            <input type="text" name="valorUnitarioP1" value="<%=valor_producto1%>">
                            <input type="text" name="cantidad_producto1" value="<%=can1%>" id="cantidad">
                            <input type="submit" name="ok1" value="ok" id="boton">
                            <input type="text" name="valorTotalP1" value="<%=total_producto1%>"><br>
                            
                            <input type="text" name="cod_producto2" value="<%=codigo_producto2%>">
                            <input type="submit" name="Consultar_producto2" value="Consultar" id="boton">
                            <input type="text" name="nombre_producto2" value="<%=nombre_producto2%>">
                            <input type="text" name="valorUnitarioP2" value="<%=valor_producto2%>">
                            <input type="text" name="cantidad_producto2" value="<%=can2%>" id="cantidad">
                            <input type="submit" name="ok2" value="ok" id="boton">
                            <input type="text" name="valorTotalP2" value="<%=total_producto2%>"><br>
                            
                            <input type="text" name="cod_producto3" value="<%=codigo_producto3%>">
                            <input type="submit" name="Consultar_producto3" value="Consultar" id="boton">
                            <input type="text" name="nombre_producto3" value="<%=nombre_producto3%>">
                            <input type="text" name="valorUnitarioP3" value="<%=valor_producto3%>">
                            <input type="text" name="cantidad_producto3" value="<%=can3%>" id="cantidad">
                            <input type="submit" name="ok3" value="ok" id="boton">
                            <input type="text" name="valorTotalP3" value="<%=total_producto3%>"><br>
                           </div>
                           <div class="form-group1">
                            <label for="name">Total Venta</label>
                            <input type="text" name="total_venta" value="<%=valor_venta%>" ><br>
                            <label for="name">Total IVA</label>
                            <input type="text" name="total_iva" value="<%=iva_venta%>" ><br>
                            <label for="name">Total con IVA</label>
                            <input type="text" name="total_con_iva" value="<%=total_venta%>" ><br>
                            
                            <input type="submit" name="calcular" value="Calcular" id="boton">
                            <input type="submit" name="confirmar" value="Confirmar" id="boton">
                        	</div>
                        	</form>
                        	</div>
                        	</div>
                        	</div>
                        	</form>
</body>
</html>