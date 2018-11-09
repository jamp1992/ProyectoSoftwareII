package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.builder.Nivel;
import modelo.otros.ServicioMantenimiento;

public class ServicioMantenimientoDAO {
	
	private IDBAdapter dbAdapter;
	public ServicioMantenimientoDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<ServicioMantenimiento> finAllServiciosMantenimiento(){
		Connection connection = dbAdapter.getConnection();
		List<ServicioMantenimiento> servicioMantenimientoList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT idServicioMantenimiento,descripcion,costo FROM ServicioMantenimiento");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				servicioMantenimientoList.add(new ServicioMantenimiento(results.getInt(1),results.getString(2),results.getDouble(3)));	
			}
			return servicioMantenimientoList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
	public boolean saveServicioMantenimiento(ServicioMantenimiento servicioMantenimiento) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO ServicioMantenimiento(descripcion,costo) Values(?,?)");
			statement.setString(1,servicioMantenimiento.getDescripcion());
			statement.setDouble(2, servicioMantenimiento.getCosto());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro exitoso");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
				
			}
		}
	

}
