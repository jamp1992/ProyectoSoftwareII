package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.otros.Estacionamiento;


public class EstacionamientoDAO {
	private IDBAdapter dbAdapter;
	public EstacionamientoDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<Estacionamiento> finAllEstacionamiento(){
		Connection connection = dbAdapter.getConnection();
		List<Estacionamiento> EstacionamientoList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT idEstacionamiento,Estado FROM Estacionamiento WHERE estado='"+"Disponible"+"'");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				EstacionamientoList.add(new Estacionamiento(results.getInt(1),results.getString(2)));	
			}
			return EstacionamientoList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
	public boolean saveEstacionamiento(Estacionamiento estacionamiento) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Estacionamiento(Estado,Parqueadero_idParqueadero) Values(?,?)");
			statement.setString(1,estacionamiento.getEstado());
			statement.setInt(2, 1);
			statement.executeUpdate();
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
	
	 public boolean ModificarEstacionamiento(Estacionamiento estacionamiento) {
	    	Connection connection=dbAdapter.getConnection();
	    	try {
				
				PreparedStatement statement=connection.prepareStatement("UPDATE Estacionamiento SET estado='"+estacionamiento.getEstado()+"' WHERE idEstacionamiento='"+estacionamiento.getIdEstacionamiento()+"'");
				statement.executeUpdate();
				return true;
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
	 }
	 public boolean BorrarEstacionamiento(int idEstacionamiento) {
	    	Connection connection=dbAdapter.getConnection();
	    	try {
				@SuppressWarnings("unused")
				PreparedStatement statement=connection.prepareStatement("DELETE FROM Estacionamiento WHERE cedula='"+idEstacionamiento+"'");
				statement.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	    }

}
