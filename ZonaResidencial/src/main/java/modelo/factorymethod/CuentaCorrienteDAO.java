package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.persona.Empleado;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.CuentaCorrienteSingleton;

public class CuentaCorrienteDAO {
	private IDBAdapter dbAdapter;
	public CuentaCorrienteDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public boolean ObtenerCuenta(CuentaCorrienteSingleton CCS){
		boolean obtener=false;
		Connection connection = dbAdapter.getConnection();
	
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT numeroCuenta"+",nombreCuenta,saldo FROM CuentaCorriente");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				CCS.setNumeroCuenta(results.getInt(1));
				CCS.setNombreCuenta(results.getString(2));
				CCS.setSaldo(results.getDouble(3));
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
	
	public boolean ModificarCuentaCorriente(CuentaCorrienteSingleton CCS) {
    	Connection connection=dbAdapter.getConnection();
    	try {
			
			PreparedStatement statement=connection.prepareStatement("UPDATE CuentaCorriente SET numeroCuenta='"+CCS.getNumeroCuenta()+"', nombreCuenta='"+CCS.getNombreCuenta()+"',saldo='"+CCS.getSaldo()+"' "+" WHERE numeroCuenta="+CCS.getNumeroCuenta());
			statement.executeUpdate();
			return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
    }

}
