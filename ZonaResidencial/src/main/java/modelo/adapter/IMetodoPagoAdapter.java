package modelo.adapter;

import java.util.Date;

import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

public abstract class IMetodoPagoAdapter {
	private double cantidad;
	private Date fechaPago;
	private DatosPagoDTO datosPago;
	private Residente residente;
	
    public IMetodoPagoAdapter(double cantidad, Date fechaPago) {
		this.cantidad = cantidad;
		this.fechaPago = fechaPago;
	}
    
    
	public IMetodoPagoAdapter(DatosPagoDTO datosPago, Residente residente) {
		this.datosPago = datosPago;
		this.residente = residente;
	}


	public IMetodoPagoAdapter() {
		
	}

	abstract public boolean pagar();
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public DatosPagoDTO getDatosPago() {
		return datosPago;
	}

	public void setDatosPago(DatosPagoDTO datosPago) {
		this.datosPago = datosPago;
	}

	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}
	
    

}