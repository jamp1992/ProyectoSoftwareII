package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.builder.Nivel;
import modelo.otros.Estacionamiento;
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
			PreparedStatement statement= connection.prepareStatement("SELECT idApto,descripcion,numeroApto,largo, ancho,m2,valor,estado FROM Apto where Nivel_idNivel in (select idNivel from nivel where Torre_idTorre='"+idTorre+"')");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				AptoList.add(new AptoImpl(results.getInt(1),results.getString(2),results.getInt(3),results.getFloat(4),results.getFloat(5),results.getInt(6),results.getDouble(7),results.getString(8)));	
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
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Apto(largo,"+"ancho, m2, valor,descripcion, numeroApto, estado,Nivel_idNivel) Values(?,?,?,?,?,?,?,?)");
			statement.setFloat(1, AptoImpl.getAptoLargo());
			statement.setFloat(2, AptoImpl.getAptoAncho());
			statement.setInt(3, AptoImpl.getMetro2());
			statement.setDouble(4, AptoImpl.getValorAgregado());
			statement.setString(5,AptoImpl.getDescripcion());
			statement.setInt(6, AptoImpl.getNumApto());
			statement.setString(7, AptoImpl.getEstate());
			statement.setInt(8,idNivel);
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
	public List<AptoImpl> finAllAptosDisponibles(){
		Connection connection = dbAdapter.getConnection();
		List<AptoImpl> AptoList = new ArrayList<>();
		try {
			//PreparedStatement statement= connection.prepareStatement("SELECT idApto"+ "nombreApto,numeroApto,largo, ancho,m2,valor,Residente_idResidente FROM Apto");
			PreparedStatement statement= connection.prepareStatement("SELECT idApto,descripcion,numeroApto,largo, ancho,m2,valor,estado FROM Apto where estado='"+"Disponible"+"'");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				AptoList.add(new AptoImpl(results.getInt(1),results.getString(2),results.getInt(3),results.getFloat(4),results.getFloat(5),results.getInt(6),results.getDouble(7),results.getString(8)));	
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
	
	public boolean ModificarApto(AptoImpl apto) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			@SuppressWarnings("unused")
			PreparedStatement statement=connection.prepareStatement("UPDATE Apto SET estado='"+apto.getEstado()+"' WHERE idApto='"+apto.getIdApto()+"'");
			statement.executeUpdate();
			return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
 }

}
