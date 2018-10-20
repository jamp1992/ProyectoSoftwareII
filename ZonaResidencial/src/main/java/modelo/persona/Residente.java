package modelo.persona;

import java.util.*;

public class Residente extends PersonaAcceso {
	
	private Date fechaAdquisicionApto;
	private Boolean propietario;
	private Date fechaPagoAdmin;
	private double valorAdmin;
	
	public Residente(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaAdquisicionApto, Boolean propietario, Date fechaPagoAdmin, double valorAdmin) {
		super(cedula, nombre, apellido, usuario, contrasena);
		this.fechaAdquisicionApto=fechaAdquisicionApto;
		this.propietario=propietario;
		this.fechaPagoAdmin=fechaPagoAdmin;
		this.valorAdmin=valorAdmin;
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
	
	
	
	
	

}