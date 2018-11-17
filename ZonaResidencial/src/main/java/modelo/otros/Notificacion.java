package modelo.otros;

import java.util.Date;

import modelo.persona.Residente;

public class Notificacion {
	private int idNotificacion;
	private Date fecha;
	private String mensaje;

	public Notificacion(int idNotificacion, Date fecha, String mensaje) {
		this.idNotificacion = idNotificacion;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}
	public Notificacion(Date fecha, String mensaje) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
	}
	public int getIdNotificacion() {
		return idNotificacion;
	}
	public void setIdNotificacion(int idNotificacion) {
		this.idNotificacion = idNotificacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}