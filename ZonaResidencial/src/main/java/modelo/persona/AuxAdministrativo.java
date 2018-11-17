package modelo.persona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.factorymethod.PagoConjuntoDAO;
import modelo.otros.Notificacion;
import modelo.otros.PagoAdmin;


public class AuxAdministrativo extends Empleado {
	
	
	public AuxAdministrativo(int cedula, String nombre, String apellido, String usuario, String contrasena,
			Date fechaIngreso) {
		super(cedula, nombre, apellido, usuario, contrasena, fechaIngreso);
	}
	
	
	
	public AuxAdministrativo() {
	}
	

	public Notificacion notificarPagoAdminResidente(double pago, String fechaPago) {
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaPagoAdmin = Calendar.getInstance();
		SimpleDateFormat sdformato=new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaPagoAdmin.setTime(sdformato.parse(fechaPago));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(fechaActual.get(Calendar.DAY_OF_MONTH)<=fechaPagoAdmin.get(Calendar.DAY_OF_MONTH)) {
			Notificacion notificacion= new Notificacion(fechaActual.getTime(),"Su pago se vence en '"+(fechaPagoAdmin.get(Calendar.DAY_OF_MONTH)-fechaActual.get(Calendar.DAY_OF_MONTH))+"' dias, por '" +pago+ "'$, se vence el '" +fechaPago+ "', PAGUE ROSCON.");
			return notificacion;
		}
		else {
		Notificacion notificacion= new Notificacion(fechaActual.getTime(),"Su pago por '" +pago+ "' ha vencido, Contacte al Aux Administrativo");
		return notificacion;
		}
	}
	public void cobrarAdmin(List<Residente> residente, PagoConjuntoDAO PCDAO) {
		
		Calendar calendarActual = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		Date fecha= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(fecha);
		List<Residente> listaResidente= new ArrayList<>();
		List<PagoAdmin> listaPagoAdmin=new ArrayList<>();
		listaResidente=residente;
		
		for(int i=0;i<listaResidente.size();i++) {
			listaPagoAdmin=PCDAO.ListarPagoAdmin(listaResidente.get(i).getCedula());
			calendar.setTime(listaPagoAdmin.get(listaPagoAdmin.size()-1).getFechaPago());
			if(calendarActual.get(Calendar.YEAR)==calendar.get(Calendar.YEAR)&&calendarActual.get(Calendar.MONTH)!=calendar.get(Calendar.MONTH)&&calendarActual.get(Calendar.DAY_OF_MONTH)==calendar.get(Calendar.DAY_OF_MONTH)-5) {
				PagoAdmin pagoAdmin= new PagoAdmin(new Date(),listaResidente.get(i).getValorAdmin(),false);
				PCDAO.savePagoAdmin(pagoAdmin, listaResidente.get(i).getCedula());
			}
			else if(calendarActual.get(Calendar.YEAR)!=calendar.get(Calendar.YEAR)&&calendarActual.get(Calendar.MONTH)!=calendar.get(Calendar.MONTH)&&calendarActual.get(Calendar.DAY_OF_MONTH)==calendar.get(Calendar.DAY_OF_MONTH)-5) {
				PagoAdmin pagoAdmin= new PagoAdmin(new Date(),listaResidente.get(i).getValorAdmin(),false);
				PCDAO.savePagoAdmin(pagoAdmin, listaResidente.get(i).getCedula());
			}
			else {
			}
		}
		
		
	}
	public boolean ingresarSistema(String usuario, String contrasena, List<Empleado> auxAdmin) {
		boolean estado=false;
		for(Empleado aux: auxAdmin) {
			if(usuario.equals(aux.getUsuario())&&contrasena.equals(aux.getContrasena())) {
				estado=true;
			}
		}
		return estado;
		
	}

}
