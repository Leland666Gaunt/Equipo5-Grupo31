package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class productoDAO {

	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null; 
	ResultSet result= null; 
	
public boolean createProducto(productoDTO producto) {
		
		boolean result=false;
		
		try {
			String sql="insert into productos values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, producto.getCodigo_producto());
			ps.setDouble(2, producto.getIvacompra());
			ps.setInt(3, producto.getNitproveedor());
			ps.setString(4, producto.getNombre_producto());
			ps.setDouble(5, producto.getPrecio_venta());
			ps.setDouble(6, producto.getPrecio_venta());
			result = ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al crear"+ex);
		}
		
		return result;
	}
	
	public productoDTO leerProducto(int Codigo_producto) {
		productoDTO producto = null;
		try {
			String sql="select* from productos where Codigo_producto=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Codigo_producto);
			result=ps.executeQuery();
			
			while(result.next()) {
				producto = new productoDTO(result.getInt(1),result.getDouble(2),result.getString(3),result.getInt(4),result.getDouble(5),result.getDouble(6));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al leer"+ex);
			}
		return producto;
		}
	
	public boolean actualizarProducto(productoDTO producto) {
		boolean result=false;
		try {
			String sql="update productos set ivacompra=?,nitproveedor=?,nombre_producto=?,precio_compra=?,precio_venta=? where codigo_producto=?";
			ps = con.prepareStatement(sql);
			
			
			ps.setDouble(1, producto.getIvacompra());
			ps.setInt(2, producto.getNitproveedor());
			ps.setString(2, producto.getNombre_producto());
			ps.setDouble(3, producto.getPrecio_compra());
			ps.setDouble(5, producto.getPrecio_venta());
			ps.setInt(5, producto.getCodigo_producto());
			result=ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"Error al actualizar"+ex);
			}
		return result;
		}
	
	public boolean eliminarProducto(int Codigo_producto) {
		boolean result=false;
		try {
			String sql="delete from productos where Codigo_producto=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, Codigo_producto);
			result=ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"Error al eliminar"+ex);
			}
		return result;
		}
	
	public boolean Cargar_Libros(String Url) {
		boolean resul=false;
		try {
			System.out.println("Entro 1");
		String sql="load data infile '"+Url+"' into table producto fields terminated by ',' lines terminated by '\r\n'";
		System.out.println("Entro 2");
		ps = con.prepareStatement(sql);
		System.out.println("Entro 3");
		//ps.setString(1, Url);
		resul=ps.executeUpdate()>-1;
		System.out.println("Entro 4");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al insertar productos: "+ex);
		}
		return resul;
		
	}

public ArrayList<productoDTO> cargar_select(){
		
		productoDTO pro = null;
		ArrayList<productoDTO> lista= new ArrayList<>();
		try {
		String sql="select * from productos";
		ps= con.prepareStatement(sql);
		result = ps.executeQuery();
		while(result.next()) {
			pro= new productoDTO(result.getInt(1),result.getDouble(2),result.getString(3),result.getInt(4),result.getDouble(5), result.getDouble(6));
		    lista.add(pro);
		}
		}catch(SQLException ex) {}
		
		return lista;
	}
	
}