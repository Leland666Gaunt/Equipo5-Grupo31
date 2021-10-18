package Controlador;

import java.io.IOException;
import java.nio.LongBuffer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.CustomerDAO;
import Modelo.CustomerDTO;
import Modelo.DetailsDTO;
import Modelo.SalesDAO;
import Modelo.SalesDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.productoDAO;
import Modelo.productoDTO;

/**
 * Servlet implementation class Sales
 */
@WebServlet("/Sales")
public class Sales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("consultar_cedulaCliente")!=null) {
			CustomerDAO custDao = new CustomerDAO();
			long Id;
			String customer;
			Id=Long.parseLong(request.getParameter("cedula"));
			CustomerDTO custDto=custDao.readCustomer(Id);
			
			if (custDto!=null) {
				Id=custDto.getId();
				customer=custDto.getName();
				
				response.sendRedirect("Ventas.jsp?cedula="+Id+"&&customer="+customer);
			}else {
				response.sendRedirect("Ventas.jsp?sten=El cliente no existe en la base de datos"); //Alert!!!
			}
		}
		
		if (request.getParameter("consultar_cedulaUsuario")!=null) {
			UsuarioDAO userDao = new UsuarioDAO();
			Long Id;
			String user;
			Id=Long.parseLong(request.getParameter("cedulau"));
			UsuarioDTO userDto=userDao.Buscar_Usuario(Id);
			
			if (userDto!=null) {
				Id=userDto.getCedula_usuario();
				user=userDto.getNombre_usuario();
				
				response.sendRedirect("Ventas.jsp?cedulau="+Id+"&&usuario="+user);
			}else {
				response.sendRedirect("Ventas.jsp?sten=El usuario no existe en la base de datos");
			}
		}
			
		if (request.getParameter("Consultar_producto1")!=null) {
			productoDAO productDao = new productoDAO();   //LLAVE FORANEA¿¿¿??? (Codigo_producto debería ser llave foranea en ventas?) 
			Integer ref;
			String name;
			Double unitValue;
			
			
			ref=Integer.parseInt(request.getParameter("cod_producto1"));
			productoDTO productDto = productDao.leerProducto(ref);
			
			if (productDto!=null) {
				ref=productDto.getCodigo_producto();
				name=productDto.getNombre_producto();
				unitValue=productDto.getPrecio_compra();
				
				response.sendRedirect("Ventas.jsp?cod_producto1="+ref+"&&nombre_producto1="+name+"&&valor_producto1="+unitValue);
			}else {
				response.sendRedirect("Ventas.jsp?sten=El producto no existe en la base de datos");
			}
		}
		
		if (request.getParameter("Consultar_producto2")!=null) {
			productoDAO productDao = new productoDAO();    
			Integer ref,aux2=1;
			String name;
			Double unitValue;
			
			ref=Integer.parseInt(request.getParameter("cod_producto2"));
			productoDTO productDto = productDao.leerProducto(ref);
			
			if (productDto!=null) {
				ref=productDto.getCodigo_producto();
				name=productDto.getNombre_producto();
				unitValue=productDto.getPrecio_compra();
				
				response.sendRedirect("Ventas.jsp?=aux2="+aux2+"&&cod_producto2="+ref+"&&nombre_producto2="+name+"&&valor_producto2="+unitValue);
			}else {
				response.sendRedirect("Ventas.jsp?sten=El producto no existe en la base de datos");
			}
		}
		
		if (request.getParameter("Consultar_producto3")!=null) {
			productoDAO productDao = new productoDAO();    
			Integer ref,aux3=1;
			String name;
			Double unitValue;
			
			ref=Integer.parseInt(request.getParameter("cod_producto3"));
			productoDTO productDto = productDao.leerProducto(ref);
			
			if (productDto!=null) {
				ref=productDto.getCodigo_producto();
				name=productDto.getNombre_producto();
				unitValue=productDto.getPrecio_compra();
				
				response.sendRedirect("Ventas.jsp?=aux3="+aux3+"&&cod_producto3="+ref+"&&nombre_producto3="+name+"&&valor_producto3="+unitValue);
			}else {
				response.sendRedirect("Ventas.jsp?sten=El producto no existe en la base de datos");
			}
		}
		
		if (request.getParameter("ok1")!=null) {
			
			//productoDAO productDao = new productoDAO();   
			Integer ref,aux11=0;
			String name;
			Double unitValue,totalValue;
			Integer cant;
			
			
			ref=Integer.parseInt(request.getParameter("cod_producto1"));
			//productoDTO productDto = productDao.leerProducto(ref);
			unitValue=Double.parseDouble(request.getParameter("valorUnitarioP1"));
			cant=Integer.parseInt(request.getParameter("cantidad_producto1"));
			totalValue=unitValue*cant;
			
			response.sendRedirect("Ventas.jsp?=aux11="+aux11+"&&totalValue1="+totalValue+"&&can1="+cant);
			}
		
		if (request.getParameter("ok2")!=null) {
			
			//productoDAO productDao = new productoDAO();   
			Integer ref,aux12=0;
			String name;
			Double unitValue,totalValue;
			Integer cant;
			
			
			ref=Integer.parseInt(request.getParameter("cod_producto2"));
			//productoDTO productDto = productDao.leerProducto(ref);
			unitValue=Double.parseDouble(request.getParameter("valorUnitarioP2"));
			cant=Integer.parseInt(request.getParameter("cantidad_producto2"));
			totalValue=unitValue*cant;
			
			response.sendRedirect("Ventas.jsp?=aux12="+aux12+"&&totalValue2="+totalValue+"&&can2="+cant);
		}
		
		if (request.getParameter("ok3")!=null) {
			
			//productoDAO productDao = new productoDAO();   
			Integer ref,aux13=0;
			String name;
			Double unitValue,totalValue;
			Integer cant;
			
			
			ref=Integer.parseInt(request.getParameter("cod_producto3"));
			//productoDTO productDto = productDao.leerProducto(ref);
			unitValue=Double.parseDouble(request.getParameter("valorUnitarioP3"));
			cant=Integer.parseInt(request.getParameter("cantidad_producto3"));
			totalValue=unitValue*cant;
			
			response.sendRedirect("Ventas.jsp?=aux13="+aux13+"&&totalValue3="+totalValue+"&&can3="+cant);
			}
		
		if (request.getParameter("calcular")!=null) {
			Integer aux21=0;
			Double sellOut,taxes,sales,sale1,sale2,sale3;
			sale1=Double.parseDouble(request.getParameter("valorUnitarioP1"));
			sale2=Double.parseDouble(request.getParameter("valorUnitarioP2"));
			sale3=Double.parseDouble(request.getParameter("valorUnitarioP3"));
			sales=sale1+sale2+sale3;
			taxes=sales*0.19;
			sellOut=sales+taxes;
			
			response.sendRedirect("Ventas.jsp?=aux21="+aux21+"&&sales="+sales+"&&taxes="+taxes+"&&sellOut="+sellOut);
		}
		if (request.getParameter("confirmar")!=null) {
			SalesDAO salDao=new SalesDAO();
			Long code_detail,amount,code_producto,code_sale,Id_customer,Id_user;
			Float total,sale,totalIva,valorVenta,valorIva,iva_sale,total_sale,sale_;
			Double valorVentad,valorIvad,total_saled;
			//Venta:
		
			Id_customer=Long.parseLong(request.getParameter("cedula"));
			Id_user=Long.parseLong(request.getParameter("cedulau"));
			iva_sale=Float.parseFloat(request.getParameter("total_iva"));
			total_sale=Float.parseFloat(request.getParameter("total_con_iva"));
			sale_=Float.parseFloat(request.getParameter("total_venta")); 
			SalesDTO salDto= new SalesDTO(Id_customer,Id_user,iva_sale,total_sale,sale_);
			if(salDao.createSale(salDto)) {
				
			}
			
			
			//Detalle de Venta 1
		
			amount=Long.parseLong(request.getParameter("cantidad_producto1"));
			code_producto=Long.parseLong(request.getParameter("cod_producto1"));
			valorVentad=Double.parseDouble(request.getParameter("valorTotalP1"));
			valorIvad=valorVentad*0.19;
			total_saled=valorVentad+valorIvad;
			DetailsDTO detDto = new DetailsDTO(amount,code_producto,total_saled,valorVentad,valorIvad);
			if(salDao.insertDetail(detDto)) {
				
			}
			
			//Detalle de Venta 2
			
			
			amount=Long.parseLong(request.getParameter("cantidad_producto2"));
			code_producto=Long.parseLong(request.getParameter("cod_producto2"));
			valorVentad=Double.parseDouble(request.getParameter("valorTotalP2"));
			valorIvad=valorVentad*0.19;
			total_saled=valorVentad+valorIvad;
			DetailsDTO det2Dto = new DetailsDTO(amount,code_producto,total_saled,valorVentad,valorIvad);
			if(salDao.insertDetail(det2Dto)) {
				
			}
			//Detalle de venta 3
			
			
			amount=Long.parseLong(request.getParameter("cantidad_producto3"));
			code_producto=Long.parseLong(request.getParameter("cod_producto3"));
			valorVentad=Double.parseDouble(request.getParameter("valorTotalP3"));
			valorIvad=valorVentad*0.19;
			total_saled=valorVentad+valorIvad;
			DetailsDTO det3Dto = new DetailsDTO(amount,code_producto,total_saled,valorVentad,valorIvad);
			if(salDao.insertDetail(det3Dto)) {
				
			}
			int consec=Integer.parseInt(request.getParameter("consec"));
			consec=consec+1;		
			response.sendRedirect("Ventas.jsp?=consec="+consec);			
		}


		
		
		}
	}
			
		



