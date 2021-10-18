package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class SalesDAO {
	
	// P R E P A R A N D O  C O N E X I O N 
	
	    // 2RAUMWOHNUNG - D A  STEHST D U
	
	Conexion plug = new Conexion();
	Connection plugIn = plug.Conectar();
	PreparedStatement ps = null;
	ResultSet result = null;                  
	
	public boolean createSale(SalesDTO sale) {
		boolean result=false;
		try {
			String sql="INSERT INTO ventas(cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) VALUES(?,?,?,?,?)";
			ps = plugIn.prepareStatement(sql);
			ps.setLong(1, sale.getId_customer());
			ps.setLong(2, sale.getId_user());
			ps.setFloat(3, sale.getIva_sale());
			ps.setFloat(4, sale.getTotal_sale());
			ps.setFloat(5, sale.getSale_());
			result=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al registrar venta"+ex);
		}
		
		return result;
	}
	
	public boolean insertDetail(DetailsDTO detail) {
		boolean result=false;
		try {
			String sql="Select codigo_venta from ventas order by codigo_venta desc limit 1";
			ps= plugIn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			long codigo=0;
			while(res.next()) {
				codigo=res.getInt(1);
			}
			sql="INSERT INTO detalle_ventas(cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_venta,valoriva) VALUES(?,?,?,?,?,?)";
			ps = plugIn.prepareStatement(sql);
			ps.setLong(1, detail.getAmount());
			ps.setLong(2, detail.getCode_producto());
			ps.setLong(3, codigo);
			ps.setDouble(4, detail.getTotal());
			ps.setDouble(5, detail.getSale());
			ps.setDouble(6, detail.getTotaliva());
			result=ps.executeUpdate()>0;
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar detalle de venta"+ex);
		}
		return result;
	}
	
	
	
	
	}
	                                      //---I  A M  H O M E
                                              //M A S S I V E
	                                         // A T T A C K
	

	


