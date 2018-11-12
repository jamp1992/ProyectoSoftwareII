package modelo.persona;

import java.util.*;


/**
 * 
 */
public class Visitante extends Persona {

	private Date fechaEntrada;
	public Visitante(int cedula, String nombre, String apellido, Date fechaEntrada) {
		super(cedula, nombre, apellido);
		this.fechaEntrada=fechaEntrada;
		// TODO Auto-generated constructor stub
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

}