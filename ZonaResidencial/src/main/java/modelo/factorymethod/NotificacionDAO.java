package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.builder.Nivel;
import modelo.otros.Notificacion;
import modelo.persona.Empleado;

public class NotificacionDAO {
	private IDBAdapter dbAdapter;
	public NotificacionDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
    
	//CRUD Notificacion
    public boolean crearNotificacion(Notificacion notificacion, int cedulaRes) {
    	
    	Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO notificacion(fecha, mensaje, Residente_cedula) Values(?,?,?)");
			statement.setDate(1,new java.sql.Date(notificacion.getFecha().getTime()));
			statement.setString(2, notificacion.getMensaje());
			statement.setInt(3, cedulaRes);
			statement.executeUpdate(); 
			JOptionPane.showMessageDialog(null, "Notificacion enviada");
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
    public boolean BorrarNotificacion(int cedulaResidente) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("DELETE FROM Notificacion WHERE Residente_cedula='"+cedulaResidente+"'");
			statement.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    public List<Notificacion> ListarNotificaciones(){
		Connection connection = dbAdapter.getConnection();
		List<Notificacion> notificacionList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT fecha, mensaje FROM notificacion");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				notificacionList.add(new Notificacion(results.getDate(1),results.getString(2)));	
			}
			return notificacionList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
    public List<Notificacion> ListarNotificacionesPorResidente(int cedula){
		Connection connection = dbAdapter.getConnection();
		List<Notificacion> notificacionList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT fecha, mensaje FROM notificacion WHERE Residente_cedula='"+cedula+"'");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				notificacionList.add(new Notificacion(results.getDate(1),results.getString(2)));	
			}
			return notificacionList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}

}
