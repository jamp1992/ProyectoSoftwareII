package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.persona.Empleado;

public class EmpleadoDAO {

	private IDBAdapter dbAdapter;
	public EmpleadoDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
    
	//CRUD AuxiliarAdmin
    public boolean crearAuxiliarAdmin(Empleado empleado, int idConjuntoResidencial) {
    	
    	Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO AuxAdministrativo(cedula,"+"nombre, apellido,usuario,contrasena,fechaIngreso, ConjuntoResidencial_idConjuntoResidencial) Values(?,?,?,?,?,?,?)");
			statement.setInt(1,empleado.getCedula());
			statement.setString(2,empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setString(4,empleado.getUsuario());
			statement.setString(5,empleado.getContrasena());
			statement.setDate(6,new java.sql.Date(empleado.getFechaIngreso().getTime()));
			statement.setInt(7, idConjuntoResidencial);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
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
    
    public List<Empleado> MostrarAuxiliaresAdmin(){
		Connection connection = dbAdapter.getConnection();
		List<Empleado> EmpleadoList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT cedula,nombre"+",apellido, usuario, contrasena, fechaIngreso FROM AuxAdministrativo");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				EmpleadoList.add(new Empleado(results.getInt(1),results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getDate(6)));	
			}
			return EmpleadoList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
    
    public boolean BorrarAuxiliarAdmin(int cedula) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("DELETE FROM AuxAdministrativo WHERE cedula='"+cedula+"'");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean ModificarAuxiliarAdmin(Empleado empleado) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("UPDATE AuxAdministrativo SET nombre='"+empleado.getNombre()+"', apellido='"+empleado.getApellido()+"',usuario='"+empleado.getUsuario()+"',contrasena='"+empleado.getContrasena()+"',fechaIngreso='"+empleado.getFechaIngreso()+"' "+" WHERE cedula="+empleado.getCedula());
			return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
    }

    //CRUD VIGILANTE
    public boolean crearVigilante(Empleado empleado, int idConjuntoResidencial) {
    	Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Vigilante(cedula,"+"nombre, apellido,usuario,contrasena, fechaIngreso, ConjuntoResidencial_idConjuntoResidencial) Values(?,?,?,?,?,?,?)");
			statement.setInt(1,empleado.getCedula());
			statement.setString(2,empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setString(4,empleado.getUsuario());
			statement.setString(5,empleado.getContrasena());
			statement.setDate(6,new java.sql.Date(empleado.getFechaIngreso().getTime()));
			statement.setInt(7, idConjuntoResidencial);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
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
    
    public List<Empleado> MostrarVigilantes(){
		Connection connection = dbAdapter.getConnection();
		List<Empleado> EmpleadoList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT cedula,nombre"+",apellido, usuario, contrasena, fechaIngreso FROM Vigilante");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				EmpleadoList.add(new Empleado(results.getInt(1),results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getDate(6)));	
			}
			return EmpleadoList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
    
    public boolean BorrarVigilante(int cedula) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("DELETE FROM Vigilante WHERE cedula='"+cedula+"'");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean ModificarVigilante(Empleado empleado) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("UPDATE Vigilante SET nombre='"+empleado.getNombre()+"', apellido='"+empleado.getApellido()+"',usuario='"+empleado.getUsuario()+"',contrasena='"+empleado.getContrasena()+"',fechaIngreso='"+empleado.getFechaIngreso()+"' "+" WHERE cedula="+empleado.getCedula());
			return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
    }
    
    //CRUD PersonalMantenimiento
    public boolean crearPersonalMantenimiento(Empleado empleado, int idConjuntoResidencial,int idServicioMantenimiento) {
    	Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO personalmantenimiento(cedula,"+"nombre, apellido, fechaIngreso, ConjuntoResidencial_idConjuntoResidencial, ServicioMantenimiento_idServicioMantenimiento) Values(?,?,?,?,?,?)");
			statement.setInt(1,empleado.getCedula());
			statement.setString(2,empleado.getNombre());
			statement.setString(3, empleado.getApellido());
			statement.setDate(4,new java.sql.Date(empleado.getFechaIngreso().getTime()));
			statement.setInt(5, idConjuntoResidencial);
			statement.setInt(6, idServicioMantenimiento);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
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
    
    public List<Empleado> MostrarPersonalMantenimiento(){
		Connection connection = dbAdapter.getConnection();
		List<Empleado> EmpleadoList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT cedula,nombre"+",apellido,fechaIngreso FROM PersonalMantenimiento");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				EmpleadoList.add(new Empleado(results.getInt(1),results.getString(2), results.getString(3), "No", "No", results.getDate(4)));	
			}
			return EmpleadoList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
    
    public boolean BorrarPersonalMantenimiento(int cedula) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("DELETE FROM PersonalMantenimiento WHERE cedula='"+cedula+"'");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean ModificarPersonalMantenimiento(Empleado empleado) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("UPDATE PersonalMantenimiento SET nombre='"+empleado.getNombre()+"', apellido='"+empleado.getApellido()+"',fechaIngreso='"+empleado.getFechaIngreso()+"' "+" WHERE cedula="+empleado.getCedula());
			return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
    }


}