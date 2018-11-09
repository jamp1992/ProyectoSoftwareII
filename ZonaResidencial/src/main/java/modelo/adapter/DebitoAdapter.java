package modelo.adapter;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

/**
 * 
 */
public class DebitoAdapter extends IMetodoPagoAdapter {

	private int numeroTarjeta;
	private DatosPagoDTO datosPago;
	private Residente residente;
	
	public DebitoAdapter(double cantidad, Date fechaPago, int numeroTarjeta) {
		super(cantidad, fechaPago);
		this.numeroTarjeta=numeroTarjeta;
	}
	

	public DebitoAdapter(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
		// TODO Auto-generated constructor stub
	}


	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}



	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
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

	@Override
	public boolean pagar() {
		boolean estado=false;
		DebitoAdaptee debitoAdaptee= new DebitoAdaptee();
		debitoAdaptee.consultarSaldo(this.getDatosPago().getPago());
		if(debitoAdaptee.realizarTransaccion()==true) {
			estado=true;
		}
		else
			estado=false;
		
		return estado;
	}
	
	
}