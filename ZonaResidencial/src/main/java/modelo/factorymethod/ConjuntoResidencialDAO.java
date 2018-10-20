package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.otros.ConjuntoResidencial;


public class ConjuntoResidencialDAO {
	private IDBAdapter dbAdapter;
	public ConjuntoResidencialDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<ConjuntoResidencial> listarConjunto(){
		Connection connection = dbAdapter.getConnection();
		List<ConjuntoResidencial> ConjuntoList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT idConjuntoResidencial"+",direccion FROM ConjuntoResidencial");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				ConjuntoList.add(new ConjuntoResidencial(results.getInt(1),results.getString(2)));	
			}
			return ConjuntoList;
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
