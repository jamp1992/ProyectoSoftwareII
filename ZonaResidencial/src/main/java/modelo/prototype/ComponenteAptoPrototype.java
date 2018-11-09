package modelo.prototype;

import modelo.persona.Residente;

public abstract class ComponenteAptoPrototype <T extends ComponenteAptoPrototype> implements Cloneable {
	private int idAptoImpl;
	//private String nombreApto;
    private int numeroApto;
    private float largo;
    private float ancho;
    private int m2;
    private String estado;
    
	public ComponenteAptoPrototype(int idAptoImpl) {
		this.idAptoImpl = idAptoImpl;
	}
	
	public ComponenteAptoPrototype(int idAptoImpl, String estado) {
		this.idAptoImpl = idAptoImpl;
		this.estado = estado;
	}


	public ComponenteAptoPrototype(int idAptoImpl, int numeroApto, float largo, float ancho, int m2) {
		super();
		this.idAptoImpl = idAptoImpl;
		this.numeroApto = numeroApto;
		this.largo = largo;
		this.ancho = ancho;
		this.m2 = m2;
	}
	public ComponenteAptoPrototype(int idAptoImpl, String nombreApto, int numeroApto, float largo, float ancho, int m2,
			double valor, String estado) {
		this.idAptoImpl = idAptoImpl;
		//this.nombreApto = nombreApto;
		this.numeroApto = numeroApto;
		this.largo = largo;
		this.ancho = ancho;
		this.m2 = m2;
		this.estado=estado;
		//this.valor = valor;
		
	}
	public ComponenteAptoPrototype() {
	}

	public int getIdAptoImpl() {
		return idAptoImpl;
	}
	public void setIdAptoImpl(int idAptoImpl) {
		this.idAptoImpl = idAptoImpl;
	}
	
	public int getNumeroApto() {
		return numeroApto;
	}
	public void setNumeroApto(int numeroApto) {
		this.numeroApto = numeroApto;
	}
	public float getLargo() {
		return largo;
	}
	public void setLargo(float largo) {
		this.largo = largo;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public int getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public abstract T clone();
	public abstract T deepClone();
	public abstract String getDescripcion();
	public abstract double getValorAgregado();
	public abstract int getIdApto();
	public abstract int getNumApto();
	public abstract float getAptoLargo();
	public abstract float getAptoAncho();
	public abstract int getMetro2();
	public abstract String getEstate();
}
