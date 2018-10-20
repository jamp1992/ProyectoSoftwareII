package modelo.otros;

import java.util.List;

import modelo.persona.Persona;

public class ConjuntoResidencial {
	private int id;
	private String direccion;
	private List<Persona> persona;
	
	public ConjuntoResidencial(int id, String direccion, List<Persona> persona) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.persona = persona;
	}
	public ConjuntoResidencial(int id, String direccion) {
		super();
		this.id = id;
		this.direccion = direccion;
	}
	public ConjuntoResidencial(String direccion) {
		super();
		this.direccion = direccion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Persona> getPersona() {
		return persona;
	}
	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}
	
	
}
