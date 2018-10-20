package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.builder.Nivel;
import modelo.prototype.AptoImpl;
import modelo.prototype.ComponenteAptoPrototype;

public class AptoDAO {
	private IDBAdapter dbAdapter;
	public AptoDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<AptoImpl> finAllAptos(int idTorre){
		Connection connection = dbAdapter.getConnection();
		List<AptoImpl> AptoList = new ArrayList<>();
		try {
			//PreparedStatement statement= connection.prepareStatement("SELECT idApto"+ "nombreApto,numeroApto,largo, ancho,m2,valor,Residente_idResidente FROM Apto");
			PreparedStatement statement= connection.prepareStatement("SELECT idApto,nombreApto,numeroApto,largo, ancho,m2,valor,Residente_idResidente FROM Apto where Nivel_idNivel in (select idNivel from nivel where Torre_idTorre='"+idTorre+"')");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				AptoList.add(new AptoImpl(results.getInt(1),results.getString(2),results.getInt(3),results.getFloat(4),results.getFloat(5),results.getInt(6),results.getDouble(7)));	
			}
			return AptoList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
	public boolean saveApto(ComponenteAptoPrototype AptoImpl, int idNivel) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Apto(largo,"+"ancho, m2, valor, Nivel_idNivel, numeroApto,nombreApto) Values(?,?,?,?,?,?,?)");
			statement.setFloat(1, AptoImpl.getAptoLargo());
			statement.setFloat(2, AptoImpl.getAptoAncho());
			statement.setInt(3, AptoImpl.getMetro2());
			statement.setDouble(4, AptoImpl.getValorAgregado());
			statement.setInt(5,idNivel);
			statement.setInt(6, AptoImpl.getNumApto());
			statement.setString(7,AptoImpl.getDescripcion());
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
