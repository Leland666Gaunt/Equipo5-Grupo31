$(document).ready(function(){
	
	function ListarUsuarios(){
		
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcion: "Usuarios"},
			success:function(result){
				console.log(result)
				var tabla=document.querySelector("#tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>CEDULA</th>
				<th>EMAIL</th>
				<th>NOMBRE</th>
				<th>CONTRASENA</th>
				<th>USUARIO</th>
				</tr>`
				for(let usu of result){
					tabla.innerHTML+=`<tr>
					<td>${usu.cedula_usuario}</td>
					<td>${usu.email_usuario}</td>
					<td>${usu.nombre_usuario}</td>
					<td>${usu.password}</td>
					<td>${usu.usuario}</td>
					</tr>`
				}
			}
		})
	}
	
	function ListarClientes(){
	
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcion: "Clientes"},
			success:function(result){
				console.log(result)
				var tabla=document.querySelector("#tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>CEDULA</th>
				<th>DIRECCION</th>
				<th>EMAIL</th>
				<th>NOMBRE</th>
				<th>TELEFONO</th>
				</tr>`
				for(let cli of result){
					tabla.innerHTML+=`<tr>
					<td>${cli.Id}</td>
					<td>${cli.address}</td>
					<td>${cli.email}</td>
					<td>${cli.name}</td>
					<td>${cli.phone}</td>
					</tr>`
				}
			
			
			}
		})
	}
	
	function ListarVentas(){
		
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcion: "Ventas"},
			success:function(result){
				console.log(result)
				var tabla=document.querySelector("#tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>CEDULA</th>
				<th>NOMBRE</th>
				<th>VALOR TOTAL VENTAS</th>
				</tr>`
				for(let rep of result){
					tabla.innerHTML+=`<tr>
					<td>${rep.cedula}</td>
					<td>${rep.nombre}</td>
					<td>${rep.valor_total}</td>
					</tr>`
				}
				tabla.innerHTML+=`<tr>
				<td>TOTAL VENTAS: </td>
				</tr>`			
			}
		})
	}		
	
$('.ListarUsuarios').on('click',function(){
	ListarUsuarios();
})	
$('.ListarClientes').on('click',function(){
	ListarClientes();	
	
$('.ListarVentas').on('click',function(){
	ListarVentas();
})	
})	
})


