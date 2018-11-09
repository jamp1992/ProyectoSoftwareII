package modelo.factorymethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.otros.PagoAdmin;
import modelo.otros.PagoConjunto;

public class PagoConjuntoDAO {
	
	private IDBAdapter dbAdapter;
	public PagoConjuntoDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
	}
	public List<PagoAdmin> ListarPagoAdmin(int cedula){
		Connection connection = dbAdapter.getConnection();
		List<PagoAdmin> pagoAdminList = new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT idPagoConjunto,fechaPago,valorPago,pagado FROM PagoAdministracion WHERE Residente_cedula='"+cedula+"'");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				pagoAdminList.add(new PagoAdmin(results.getInt(1),results.getDate(2),results.getDouble(3),results.getBoolean(4)));	
			}
			return pagoAdminList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch (Exception e) {}
		}	
	}
	public boolean savePagoAdmin(PagoConjunto pagoConjunto, int cedula) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= connection.prepareStatement("INSERT INTO PagoAdministracion(fechaPago,valorPago,Residente_cedula) Values(?,?,?)");
			statement.setDate(1,new java.sql.Date(pagoConjunto.getFechaPago().getTime()));
			statement.setDouble(2, pagoConjunto.getValorPago());
			statement.setInt(3, cedula);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro exitoso");
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
