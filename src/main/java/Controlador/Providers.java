package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProviderDAO;
import Modelo.providerDTO;


@WebServlet("/Providers")
public class Providers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final providerDTO ProvDto = null;
  
    public Providers() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
ProviderDAO ProvDao = new ProviderDAO();
		
		if (request.getParameter("registrar")!=null) {
			Long NIT;
			String  ciudad,direccion,nombre,telefono;
			NIT = Long.parseLong(request.getParameter("NIT"));
			ciudad = request.getParameter("ciudad");
			direccion = request.getParameter("direccion");
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("telefono");
			providerDTO ProvDto = new providerDTO(NIT,ciudad,direccion,nombre,telefono);
			if(ProvDao.createProvider(ProvDto)) {
				//JOptionPane.showMessageDialog(null, "Proveedor creado exitosamente....");
				response.sendRedirect("Proveedores.jsp?sten=Proveedor creado exitosamente ");
			}else {
				//JOptionPane.showMessageDialog(null, "Registro fallido");
				response.sendRedirect("Proveedores.jsp?sten=Registro fallido");
				}
			}
		
		if(request.getParameter("consultar")!=null) {
			Long NIT;
			String  ciudad,direccion,nombre,telefono;
			NIT = Long.parseLong(request.getParameter("NIT_Proveedor"));
			providerDTO ProvDto = ProvDao.readprovider(NIT);
			if(ProvDto!=null) {
			NIT = ProvDto.getNIT();
			ciudad = ProvDto.getCiudad();
			direccion = ProvDto.getDireccion();
			nombre = ProvDto.getNombre();
			telefono = ProvDto.getTelefono();
			response.sendRedirect("Proveedores.jsp?NIT="+NIT+"&&ciudad="+ciudad+"&&direccion="+direccion+"&&nombre="+nombre+"&&telefono="+telefono);
			}else {
				response.sendRedirect("Proveedores.jsp?sten=El proveedor no existe en la base de datos");
			}
			}
		
		if(request.getParameter("modificar")!=null) {
			Long NIT;
			String  ciudad,direccion,nombre,telefono;
			NIT = Long.parseLong(request.getParameter("NIT"));
			ciudad = request.getParameter("ciudad");
			direccion = request.getParameter("direccion");
			nombre = request.getParameter("nombre");
			telefono = request.getParameter("telefono");
			providerDTO ProvDto = new providerDTO(NIT,ciudad,direccion,nombre,telefono);
			if(ProvDao.updateprovider(ProvDto)) {
				//JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente");
				response.sendRedirect("Proveedores.jsp?sten=Proveedor actualizado exitosamente");
			}else {
				//JOptionPane.showMessageDialog(null, "Error al actualizar");
				response.sendRedirect("Proveedores.jsp?sten=Error al actualizar");
			}
			}
		
		
		if (request.getParameter("eliminar")!=null) {
			long NIT;
			
			NIT=Long.parseLong(request.getParameter("NIT"));
			int option=JOptionPane.showConfirmDialog(null, "Desea eliminar el proveedor con NIT: "+NIT);
			if(option==0) {
				if(ProvDao.deleteprovider(NIT)) {
					response.sendRedirect("Proveedores.jsp?sten=Proveedor eliminado exitosamente");
					}
				}else {
					response.sendRedirect("Proveedores.jsp");
				}
			}
		
		
	}

}
