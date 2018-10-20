package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.builder.Nivel;
import modelo.builder.Torre;

public class NivelDAO {
	
	private IDBAdapter dbAdapter;
	public NivelDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<Nivel> finAllNiveles(){
		Connection connection = dbAdapter.getConnection();
		List<Nivel> NivelList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT idnivel FROM Nivel");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				NivelList.add(new Nivel(results.getInt(1)));	
			}
			return NivelList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
	public boolean saveNivel(Nivel nivel, int idTorre) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Nivel(Torre_idTorre) Values(?)");
			statement.setInt(1,idTorre);
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
	

}
