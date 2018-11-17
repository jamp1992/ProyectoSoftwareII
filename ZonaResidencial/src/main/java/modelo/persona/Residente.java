package modelo.persona;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.adapter.ChequeAdapter;
import modelo.adapter.DebitoAdapter;
import modelo.adapter.Efectivo;
import modelo.adapter.IMetodoPagoAdapter;
import modelo.adapter.OnlineAdapter;
import modelo.factorymethod.NotificacionDAO;
import modelo.otros.DatosPagoDTO;
import modelo.otros.Estacionamiento;
import modelo.otros.Notificacion;
import modelo.otros.PagoAdmin;
import modelo.otros.PagoConjunto;
import modelo.prototype.AptoImpl;

public class Residente extends PersonaAcceso {
	
	private Date fechaAdquisicionApto;
	private Boolean propietario;
	private Date fechaPagoAdmin;
	private double valorAdmin;
	private AptoImpl apto;
	private Estacionamiento estacionamiento;
	private List<PagoConjunto> pagoConjunto;

	public Residente(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaAdquisicionApto, Boolean propietario, Date fechaPagoAdmin, double valorAdmin) {
		super(cedula, nombre, apellido, usuario, contrasena);
		this.fechaAdquisicionApto=fechaAdquisicionApto;
		this.propietario=propietario;
		this.fechaPagoAdmin=fechaPagoAdmin;
		this.valorAdmin=valorAdmin;
	}
	
	public Residente(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaAdquisicionApto, Boolean propietario, Date fechaPagoAdmin, double valorAdmin, AptoImpl apto, Estacionamiento estacionamiento) {
		super(cedula, nombre, apellido, usuario, contrasena);
		this.fechaAdquisicionApto=fechaAdquisicionApto;
		this.propietario=propietario;
		this.fechaPagoAdmin=fechaPagoAdmin;
		this.valorAdmin=valorAdmin;
		this.apto=apto;
		this.estacionamiento=estacionamiento;
	}
	

	public Residente(int cedula, String nombre) {
		super(cedula, nombre);
	}
	

	public Residente() {
		super();
		
	}

	public Date getFechaAdquisicionApto() {
		return fechaAdquisicionApto;
	}

	public void setFechaAdquisicionApto(Date fechaAdquisicionApto) {
		this.fechaAdquisicionApto = fechaAdquisicionApto;
	}

	public Boolean getPropietario() {
		return propietario;
	}

	public void setPropietario(Boolean propietario) {
		this.propietario = propietario;
	}

	public Date getFechaPagoAdmin() {
		return fechaPagoAdmin;
	}

	public void setFechaPagoAdmin(Date fechaPagoAdmin) {
		this.fechaPagoAdmin = fechaPagoAdmin;
	}

	public double getValorAdmin() {
		return valorAdmin;
	}

	public void setValorAdmin(double valorAdmin) {
		this.valorAdmin = valorAdmin;
	}

	public AptoImpl getApto() {
		return apto;
	}

	public void setApto(AptoImpl apto) {
		this.apto = apto;
	}

	public Estacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public List<PagoConjunto> getPagoConjunto() {
		return pagoConjunto;
	}

	public void setPagoConjunto(List<PagoConjunto> pagoConjunto) {
		this.pagoConjunto = pagoConjunto;
	}
	
	
public  IMetodoPagoAdapter pagarAdmin(DatosPagoDTO datosPago, Residente residente, String sel) {
		
		IMetodoPagoAdapter ip=null;
		
		try {
			Class c = Class.forName("modelo.adapter."+sel);
			//Constructor[] userConstructors=c.getConstructors();
			Constructor userConstructor;
			try {
				userConstructor = c.getConstructor(new Class[] {DatosPagoDTO.class, Residente.class});
				try {
					ip = (IMetodoPagoAdapter) userConstructor.newInstance(datosPago,residente);
					ip.pagar();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ip;
	}
	
	public Date avanzarDia(Date fecha,int dias) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(fecha); 
		 calendar.add(Calendar.DAY_OF_YEAR, dias);  
		 return calendar.getTime();
	}
	public boolean BuscarPagoConjunto(List<PagoAdmin> list, Date fecha) {
		boolean estado=true;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getFechaPago().getTime()==fecha.getTime()) {
				estado=false;
			}
		}
		return estado;
	}
	public boolean ingresarSistema(String usuario, String contrasena, List<Residente> residenteList) {
		boolean estado=false;
		for(Residente res: residenteList) {
			if(usuario.equals(res.getUsuario())&&contrasena.equals(res.getContrasena())) {
				estado=true;
			}
		}
		return estado;
	}
	
	public void RevisarNotificacion(NotificacionDAO notificacionDAO, List<Residente> residenteList, String usuario, String contrasena) {
		Residente residente=null;
		List<Notificacion> notificacionList = new ArrayList<>();
		for(Residente res:residenteList) {
			if(res.getUsuario().equals(usuario)&&res.getContrasena().equals(contrasena)) {
				residente=res;
			}
		}
		notificacionList=notificacionDAO.ListarNotificacionesPorResidente(residente.getCedula());
		
		if(notificacionList.isEmpty()==false) {
			JOptionPane.showMessageDialog(null, notificacionList.get(notificacionList.size()-1).getMensaje());
		}
		else {
			JOptionPane.showMessageDialog(null, "No tiene notificaciones pendientes...");
		}
	}

}