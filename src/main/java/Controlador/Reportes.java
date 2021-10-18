package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.CustomerDAO;
import Modelo.CustomerDTO;
import Modelo.ReportsDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		//String men=request.getParameter("mensaje");
		//JOptionPane.showMessageDialog(null, men);
		PrintWriter salida= response.getWriter();
		Gson datos = new Gson();
		
		if(op.equals("Usuarios")) {
			UsuarioDAO UsuDao= new UsuarioDAO();
			ArrayList<UsuarioDTO> lista=new ArrayList<>();
			lista=UsuDao.cargar_select();
			salida.println(datos.toJson(lista));
		}
		
		if(op.equals("Clientes")) {
			CustomerDAO CliDao= new CustomerDAO();
			ArrayList<CustomerDTO> lista=new ArrayList<>();
			lista=CliDao.cargar_select();
			salida.println(datos.toJson(lista));
		}

		if(op.equals("Ventas")) {
			CustomerDAO CliDao= new CustomerDAO();
			ArrayList<ReportsDTO> lista=new ArrayList<>();
			lista=CliDao.cargar_ventas();
			salida.println(datos.toJson(lista));
		}
		
	}

}
