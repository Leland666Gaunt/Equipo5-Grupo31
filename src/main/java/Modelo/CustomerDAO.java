package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

//Clase para acceder a la consulta SQL

public class CustomerDAO {  
	Conexion plug = new Conexion();
	Connection plugIn = plug.Conectar();
	PreparedStatement ps = null;
	ResultSet result = null;
	
	//Preparo el estamento de la consulta y le doy valor al result con el metodo excecuteUpdate
	public boolean createCustomer(CustomerDTO cust) {
		boolean result=false;
		try {
			String sql="INSERT INTO clientes VALUES(?,?,?,?,?)";
			ps = plugIn.prepareStatement(sql);
			ps.setLong(1, cust.getId());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getEmail());
			ps.setString(4, cust.getName());
			ps.setString(5, cust.getPhone());
			result=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al crear"+ex);
		}
		
		return result;
	}
	
	public CustomerDTO readCustomer(Long Id) {
		CustomerDTO cust = null;
		try {
			String sql="select* from clientes where cedula_cliente=?";
			ps = plugIn.prepareStatement(sql);
			ps.setLong(1, Id);
			result=ps.executeQuery();
			
			while(result.next()) {
				cust = new CustomerDTO(result.getLong(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al leer"+ex);
			}
		return cust;
		}
	
	public boolean updateCustomer(CustomerDTO cust) {
		boolean result=false;
		try {
			String sql="update clientes set dirección_cliente=?,email_cliente=?,nombre_completo=?,telefono_cliente=? where cedula_cliente=?";
			ps = plugIn.prepareStatement(sql);
			
			ps.setString(1, cust.getAddress());
			ps.setString(2, cust.getEmail());
			ps.setString(3, cust.getName());
			ps.setString(4, cust.getPhone());
			ps.setLong(5, cust.getId());
			result=ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"Error al actualizar"+ex);
			}
		return result;
		}
	
	public boolean deleteCustomer(Long Id) {
		boolean result=false;
		try {
			String sql="delete from clientes where cedula_cliente=?";
			ps = plugIn.prepareStatement(sql);
			ps.setLong(1, Id);
			result=ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"Error al eliminar"+ex);
			}
		return result;
		}
	
	public ArrayList<CustomerDTO> cargar_select(){
		
		CustomerDTO cli=null;
		ArrayList<CustomerDTO> lista=new ArrayList<>();
		try {
		String sql="select * from clientes";
		ps=plugIn.prepareStatement(sql);
		result=ps.executeQuery();
		while(result.next()) {
			cli=new CustomerDTO(result.getLong(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
			lista.add(cli);
		}
		}catch(SQLException ex) {}
		
		return lista;
	}

	public ArrayList<ReportsDTO> cargar_ventas(){
		
		ReportsDTO rep=null;
		ArrayList<ReportsDTO> lista=new ArrayList<>();
		try {
		String sql="select c.cedula_cliente,c.nombre_completo,sum(v.total_venta) from clientes as c inner join ventas as v on c.cedula_cliente=v.cedula_cliente group by v.cedula_cliente";
		ps=plugIn.prepareStatement(sql);
		result=ps.executeQuery();
		while(result.next()) {
			rep=new ReportsDTO(result.getLong(1),result.getString(2),result.getLong(3));
			lista.add(rep);
		}
		}catch(SQLException ex) {}
		
		return lista;
	}
	
}

