package Controlador;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.productoDAO;
import Modelo.productoDTO;


@WebServlet("/producto")
@MultipartConfig
public class producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final providerDTO ProvDto = null;
  
    public producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
productoDAO producto = new productoDAO();
		
		if (request.getParameter("registrar")!=null) {
			int Codigo, NIT;
			double ivacompra, precioventa, preciocompra;
			String  nombre;
			Codigo = Integer.parseInt(request.getParameter("Codigo"));
			ivacompra = Double.parseDouble(request.getParameter("ivacompra"));
			NIT = Integer.parseInt(request.getParameter("NIT"));
			nombre = request.getParameter("nombre");
			preciocompra = Double.parseDouble(request.getParameter("preciocompra"));
			precioventa = Double.parseDouble(request.getParameter("precioventa"));
			productoDTO productoDTO = new productoDTO(Codigo,ivacompra,nombre,NIT,preciocompra,precioventa);
			if(producto.createProducto(productoDTO)) {
				response.sendRedirect("producto.jsp?sten=producto creado exitosamente ");
			}else {
				response.sendRedirect("producto.jsp?sten=Registro fallido");
				}
			}
		
		if(request.getParameter("consultar")!=null) {
			int Codigo, NIT;
			double ivacompra, precioventa, preciocompra;
			String  nombre;
			Codigo = Integer.parseInt(request.getParameter("Codigo"));
			productoDTO productoR = producto.leerProducto(Codigo);
			if(productoR!=null) {
			Codigo = productoR.getCodigo_producto();
			ivacompra = productoR.getIvacompra();
			NIT = productoR.getNitproveedor();
			nombre = productoR.getNombre_producto();
			preciocompra = productoR.getPrecio_compra();
			precioventa = productoR.getPrecio_venta();
			response.sendRedirect("productos.jsp?Codigo="+Codigo+"&&ivacompra="+ivacompra+"&&NIT="+NIT+"&&nombre="+nombre+"&&preciocompra="+preciocompra+"&&precioventa="+precioventa);
			}else {
				response.sendRedirect("productos.jsp?sten=El producto no existe en la base de datos");
			}
		}
		
		if(request.getParameter("modificar")!=null) {
			int Codigo, NIT;
			double ivacompra, precioventa, preciocompra;
			String  nombre;
			Codigo = Integer.parseInt(request.getParameter("Codigo"));
			ivacompra = Double.parseDouble(request.getParameter("ivacompra"));
			NIT = Integer.parseInt(request.getParameter("NIT"));
			nombre = request.getParameter("nombre");
			preciocompra = Double.parseDouble(request.getParameter("preciocompra"));
			precioventa = Double.parseDouble(request.getParameter("precioventa"));
			productoDTO productoDTO = new productoDTO(Codigo,ivacompra,nombre,NIT,preciocompra,precioventa);
			if(producto.actualizarProducto(productoDTO)) {
				response.sendRedirect("productos.jsp?sten=Cliente actualizado exitosamente");
			}else {
				response.sendRedirect("productos.jsp?sten=Error al actualizar");
			}
			}
		if (request.getParameter("eliminar")!=null) {
			int Codigo;
			Codigo= Integer.parseInt(request.getParameter("Codigo"));
			int option=JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente con identificacion: "+Codigo);
			if(option==0) {
				if(producto.eliminarProducto(Codigo)) {
					response.sendRedirect("productos.jsp?sten=Cliente eliminado exitosamente");
					}
				}else {
					response.sendRedirect("productos.jsp");
				}
			}
		
		
	
	
	
		// CORREGIR
	
		if(request.getParameter("cargar")!=null) {
			
			Part archivo = request.getPart("archivo");
			String nombre=request.getParameter("nombre");
			String Url="C:/Users/usuario/Downloads/Equipo5-Grupo31/src/main/webapp/doc/";
			System.out.println(archivo.getContentType());
			if(archivo.getContentType().equals("text/csv")) {
				try {
				System.out.print("Entro al condicional 2");
				InputStream file= archivo.getInputStream();	
				System.out.print("Entro al condicional 3");
				File copia = new File(Url+nombre+".csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				System.out.print("Entro al condicional 4");
				int num=file.read();
					while(num != -1) {
						escribir.write(num);
						num=file.read();
					}
				escribir.close();
				file.close();
				JOptionPane.showMessageDialog(null, "Archivo Cargado Correctamente");
					if(producto.Cargar_Libros(Url+nombre+".csv")) {
						response.sendRedirect("products.jsp?men= Registrado Correctamente");
					}
					else {
						response.sendRedirect("products.jsp?men=Libros no se Registraron");
					}
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error al cargar Archivo"+e);
				}
			} else {	
				response.sendRedirect("products.jsp?men=Formato de Archivo no permitido");
				}
		}
		
        //Formato JSON para cargar select, cuando cargue el jsp
		
		PrintWriter salida= response.getWriter();
		ArrayList<productoDTO> lista=new ArrayList<>();
		lista=producto.cargar_select();
		Gson datos= new Gson();
		salida.println(datos.toJson(lista));
		
	}


	private boolean productoDAO(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}