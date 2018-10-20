package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import modelo.builder.Torre;

public class TorreDAO {

	private IDBAdapter dbAdapter;
	public TorreDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<Torre> finAllTorres(){
		Connection connection = dbAdapter.getConnection();
		List<Torre> TorreList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT idTorre,nombre"+",posicionX, posicionY FROM Torre");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				TorreList.add(new Torre(results.getInt(1),results.getString(2), results.getInt(3), results.getInt(4)));	
			}
			return TorreList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
	public boolean saveTorre(Torre torre, int idConjunto) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Torre(nombre,"+"posicionX, posicionY, ConjuntoResidencial_idConjuntoResidencial) Values(?,?,?,?)");
			statement.setString(1,torre.getNombre());
			statement.setInt(2,torre.getPosicionX());
			statement.setInt(3, torre.getPosicionY());
			statement.setInt(4,idConjunto);
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