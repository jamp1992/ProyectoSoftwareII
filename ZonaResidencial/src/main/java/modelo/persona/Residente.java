package modelo.persona;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import modelo.adapter.ChequeAdapter;
import modelo.adapter.DebitoAdapter;
import modelo.adapter.Efectivo;
import modelo.adapter.IMetodoPagoAdapter;
import modelo.adapter.OnlineAdapter;
import modelo.otros.DatosPagoDTO;
import modelo.otros.Estacionamiento;
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
	
	public  IMetodoPagoAdapter pagarAdmin(double valorPago, Date fecha, int numeroTarjeta, int numeroCheque, String nombreReceptor, int numeroCuenta, Residente residente, String sel) {
		
		IMetodoPagoAdapter ip=null;
		
		try {
			Class c = Class.forName("modelo.adapter."+sel);
			
			//c.getConstructor(DatosPagoDTO.class, Residente.class);
			
			
			ip = (IMetodoPagoAdapter) c.newInstance();
			ip.pagar();
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
		
		if(sel=="Efectivo") {
		IMetodoPagoAdapter pagoEfectivo = new Efectivo(valorPago,fecha);
		pagoEfectivo.pagar();
		ip=pagoEfectivo;
		}
		else if(sel=="Debito") {
			IMetodoPagoAdapter pagoDebito = new DebitoAdapter(valorPago,fecha,numeroTarjeta);
			pagoDebito.pagar();
			ip=pagoDebito;
		}
		else if(sel=="Cheque") {
			IMetodoPagoAdapter pagoCheque = new ChequeAdapter(valorPago,fecha,numeroCheque,nombreReceptor,numeroCuenta);
			pagoCheque.pagar();
			ip=pagoCheque;
		}
		else if(sel=="Online") {
			IMetodoPagoAdapter pagoOnline = new OnlineAdapter(valorPago,fecha,numeroTarjeta,residente);
			pagoOnline.pagar();
			ip=pagoOnline;
		}
		return ip;
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
	

}