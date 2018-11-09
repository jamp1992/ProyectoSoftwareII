package modelo.persona;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.factorymethod.PagoConjuntoDAO;
import modelo.otros.PagoAdmin;
import modelo.otros.PagoConjunto;

public class AuxAdministrativo extends Empleado {
	
	
	public AuxAdministrativo(int cedula, String nombre, String apellido, String usuario, String contrasena,
			Date fechaIngreso) {
		super(cedula, nombre, apellido, usuario, contrasena, fechaIngreso);
	}
	
	
	
	public AuxAdministrativo() {
		super();
	}



	public void notificarPagoAdminResidente(Residente residente, double valor) {
		
	}
	public void cobrarAdmin(List<Residente> residente) {
		
		
		Calendar calendarActual = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		Date fecha= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(fecha);
		PagoConjuntoDAO PCDAO= new PagoConjuntoDAO();
		List<Residente> listaResidente= new ArrayList<>();
		List<Residente> listaResidenteActualizada=new ArrayList<>();
		List<PagoAdmin> listaPagoAdmin=new ArrayList<>();
		listaResidente=residente;
		
	
	
		for(Residente res:listaResidente) {
			listaPagoAdmin=PCDAO.ListarPagoAdmin(res.getCedula());
			calendar.setTime(res.getFechaPagoAdmin());
			
			if(calendarActual.get(Calendar.DAY_OF_MONTH)!=calendar.get(Calendar.DAY_OF_MONTH)-5) {
				listaResidenteActualizada.add(res);
			}
			/*else {
				JOptionPane.showMessageDialog(null, "Factura ha sido registrada");
			}*/
		}
		
		for(int i=0;i<listaResidenteActualizada.size();i++) {
			calendar.setTime(listaResidenteActualizada.get(i).getFechaPagoAdmin());
			if(calendarActual.get(Calendar.DAY_OF_MONTH)==calendar.get(Calendar.DAY_OF_MONTH)-5) {
				PagoConjunto pagoConjunto= new PagoConjunto(new Date(),listaResidenteActualizada.get(i).getValorAdmin());
				PCDAO.savePagoAdmin(pagoConjunto, listaResidenteActualizada.get(i).getCedula());
			}
			
		}
		
	}
	public void ingresarSistema() {
		
	}

}
