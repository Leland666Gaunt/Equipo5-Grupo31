package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {

	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null; 
	ResultSet res= null; 
	
	public boolean Inserta_Usuario(UsuarioDTO usu) {
		
		boolean resul=false;
		
		try {
			String sql="insert into usuarios values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, usu.getCedula_usuario());
			ps.setString(2, usu.getEmail_usuario());
			ps.setString(3, usu.getNombre_usuario());
			ps.setString(4, usu.getPassword());
			ps.setString(5, usu.getUsuario());
			resul = ps.executeUpdate()>0;
		}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error al insertar: "+ex);
		}
		return resul;
	}
	
	public UsuarioDTO Buscar_Usuario(Long cedula) {
		
		UsuarioDTO usu=null;
		try {
		String sql="select * from usuarios where cedula_usuario=?";
		ps=con.prepareStatement(sql);
		ps.setLong(1, cedula);
		res=ps.executeQuery();
		while(res.next()) {
			usu = new UsuarioDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Error al consultar "+e);
			
		}
		return usu;
	}
	public boolean Actualizar_Usuario(UsuarioDTO usu) {
	    boolean resul=false;
		try {
		String sql="update usuarios set email_usuario=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, usu.getEmail_usuario());
		ps.setString(2, usu.getNombre_usuario());
		ps.setString(3, usu.getPassword());
		ps.setString(4, usu.getUsuario());
		ps.setLong(5, usu.getCedula_usuario());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
		}
		return resul;
	}
	public boolean Eliminar_Usuario(Long cedula) {
	    boolean resul=false;
		try {
		String sql="delete from usuarios where cedula_usuario=?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, cedula);
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al eliminar: "+ex);
		}
		return resul;
	}
	
	public ArrayList<UsuarioDTO> cargar_select(){
		
		UsuarioDTO usu=null;
		ArrayList<UsuarioDTO> lista=new ArrayList<>();
		try {
		String sql="select * from usuarios";
		ps=con.prepareStatement(sql);
		res=ps.executeQuery();
		while(res.next()) {
			usu=new UsuarioDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			lista.add(usu);
		}
		}catch(SQLException ex) {}
		
		return lista;
	}
}
