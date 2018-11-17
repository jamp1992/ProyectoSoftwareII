package modelo.factorymethod;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.persona.Visitante;
import java.util.List;



public class VisitanteDAO {

	private IDBAdapter dbAdapter;
	public VisitanteDAO() {
		dbAdapter= DBFactory.getDefaultDBAdapter();
}
	
 //CRUD Visitante
	
	public boolean crearVisitante ( Visitante visitante, int idConjuntoResidencial ) {
		
		Connection connection = dbAdapter.getConnection();
		try {
			
			PreparedStatement statement= connection.prepareStatement("INSERT INTO Visitante(cedula,"+"nombre, apellido,fechaEntrada, ConjuntoResidencial_idConjuntoResidencial) Values(?,?,?,?,?)");
			statement.setInt(1,visitante.getCedula());
			statement.setString(2,visitante.getNombre());
			statement.setString(3, visitante.getApellido());
			statement.setDate(4,new java.sql.Date(visitante.getFechaEntrada().getTime()));
			statement.setInt(5, idConjuntoResidencial);
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
		
		public List<Visitante> MostarVisitante(){
				Connection connection = dbAdapter.getConnection();
				List<Visitante> VisitanteList = new ArrayList<>();
				try {
					PreparedStatement statement= connection.prepareStatement("SELECT cedula,nombre"+",apellido, fechaEntrada FROM Visitante");
					ResultSet results = statement.executeQuery();
					while(results.next()) {
						VisitanteList.add(new Visitante(results.getInt(1),results.getString(2), results.getString(3),results.getDate(4)));	
					}
					return VisitanteList;
				}catch(Exception e){
					e.printStackTrace();
					return null;
				}finally {
					try {
						connection.close();
					}catch (Exception e) {}
				}	
			}
		    

		    public boolean EliminarVisitante (int cedula) {
		    	Connection connection=dbAdapter.getConnection();
		    	try {
					@SuppressWarnings("unused")
					PreparedStatement statement=connection.prepareStatement("DELETE FROM Visitante WHERE cedula='"+cedula+"'");
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
		    }
		    
		    public boolean ModificarVisitante (Visitante visitante) {
		    	Connection connection=dbAdapter.getConnection();
		    	try {
					@SuppressWarnings("unused")
					PreparedStatement statement=connection.prepareStatement("UPDATE Visitante SET nombre='"+visitante.getNombre()+"', apellido='"+visitante.getApellido()+"',fechaIngreso='"+visitante.getFechaEntrada()+"' "+" WHERE cedula="+visitante.getCedula());
					return true;
		    	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
		    }
    }
			
		
		





