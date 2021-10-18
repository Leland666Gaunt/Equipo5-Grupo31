package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	private String bd="Grupo31_Equipo_5";
	//private String bd="ticsupps";
	private String url="jdbc:mariadb://prestamosvf.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+bd;
	private String user="admin";
	private String pass="Ciclo3_admi123";
	Connection conec=null;
	
	public Connection Conectar() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conec= DriverManager.getConnection(url,user,pass);
			//JOptionPane.showMessageDialog(null, "Conexion ok.....");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error en conexion.. hola "+e);
			
		}
		
		return conec;
	}
}
