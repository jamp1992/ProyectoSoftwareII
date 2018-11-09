package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.otros.Estacionamiento;
import modelo.persona.Empleado;
import modelo.persona.Residente;
import modelo.prototype.AptoImpl;

/**
 * 
 */
public class ResidenteDAO {
	private IDBAdapter dbAdapter;
	public ResidenteDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
 

  //CRUD Residente
    public boolean crearResidente(Residente residente,int idEstacionamiento ,int idConjuntoResidencial, int idApto) {
    	
    	Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Residente(cedula,"+"nombre, apellido,usuario,contrasena,fechaAdquisicionApto,Propietario,fechaPagoAdmin, valorAdmin, ConjuntoResidencial_idConjuntoResidencial, Estacionamiento_idEstacionamiento, Apto_idApto) Values(?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1,residente.getCedula());
			statement.setString(2,residente.getNombre());
			statement.setString(3, residente.getApellido());
			statement.setString(4,residente.getUsuario());
			statement.setString(5,residente.getContrasena());
			statement.setDate(6,new java.sql.Date(residente.getFechaAdquisicionApto().getTime()));
			statement.setBoolean(7, residente.getPropietario());
			statement.setDate(8,new java.sql.Date(residente.getFechaPagoAdmin().getTime()));
			statement.setDouble(9, residente.getValorAdmin());
			statement.setInt(10, idConjuntoResidencial);
			statement.setInt(11, idEstacionamiento);
			statement.setInt(12, idApto);
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
    
    public List<Residente> MostrarResidentes(){
		Connection connection = dbAdapter.getConnection();
		List<Residente> ResidenteList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT cedula,nombre"+",apellido, usuario, contrasena, fechaAdquisicionApto, Propietario, fechaPagoAdmin, valorAdmin, Apto_idApto, Estacionamiento_idEstacionamiento FROM Residente");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				ResidenteList.add(new Residente(results.getInt(1),results.getString(2), results.getString(3), results.getString(4),results.getString(5), results.getDate(6), results.getBoolean(7),results.getDate(8),results.getDouble(9),new AptoImpl(results.getInt(10)),new Estacionamiento(results.getInt(11))));	
			}
			return ResidenteList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
    
    public boolean BorrarResidente(int cedula) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			
			PreparedStatement statement=connection.prepareStatement("DELETE FROM Residente WHERE cedula='"+cedula+"'");
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Empleado eliminado");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean ModificarResidente(Residente residente) {
    	Connection connection=dbAdapter.getConnection();
    	try {
		
			PreparedStatement statement=connection.prepareStatement("UPDATE Residente SET nombre='"+residente.getNombre()+"', apellido='"+residente.getApellido()+"',usuario='"+residente.getUsuario()+"',contrasena='"+residente.getContrasena()+"',fechaAdquisicionApto='"+residente.getFechaAdquisicionApto()+"',fechaPagoAdmin='"+residente.getFechaPagoAdmin()+"',valorAdmin='"+residente.getValorAdmin()+"' "+" WHERE cedula="+residente.getCedula());
			statement.executeUpdate();
			return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
    }

}