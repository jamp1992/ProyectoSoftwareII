package modelo.otros;

import modelo.persona.Residente;

/**
 * 
 */
public class Estacionamiento {

	private int idEstacionamiento;
	private String estado;
	
	public Estacionamiento(int idEstacionamiento, String estado) {
		this.idEstacionamiento = idEstacionamiento;
		this.estado = estado;
	}
	
	public Estacionamiento(String estado) {
		this.estado = estado;
	}
		
	public Estacionamiento(int idEstacionamiento) {
		this.idEstacionamiento = idEstacionamiento;
	}

	public Estacionamiento() {
		
	}

	public int getIdEstacionamiento() {
		return idEstacionamiento;
	}



	public void setIdEstacionamiento(int idEstacionamiento) {
		this.idEstacionamiento = idEstacionamiento;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



}