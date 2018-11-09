package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.otros.ConjuntoResidencial;
import modelo.singleton.AdministradorSingleton;

public class AdmnistradorDAO {
	private IDBAdapter dbAdapter;
	public AdmnistradorDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public boolean ObtenerAdmin(AdministradorSingleton AS){
		boolean obtener=false;
		Connection connection = dbAdapter.getConnection();
		//List<AdministradorSingleton> AdminList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT cedula"+",nombre,apellido,usuario,contrasena FROM Administrador");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				AS.setCedula(results.getInt(1));
				AS.setNombre(results.getString(2));
				AS.setApellido(results.getString(3));
				AS.setUsuario(results.getString(4));
				AS.setContrasena(results.getString(5));
			}
			obtener=true;
		}catch(Exception e){
			e.printStackTrace();
			return obtener;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}
		return obtener;	
	}

}
