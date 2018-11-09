package modelo.adapter;

import java.util.Date;

import modelo.facade.AbstractPagoFacadeAdaptee;
import modelo.facade.OnlinePagoFacade;
import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

public class OnlineAdapter extends IMetodoPagoAdapter {
	
	private int numeroTarjeta;
	private Residente residente;
	private DatosPagoDTO datosPago;
	
	
	public OnlineAdapter() {
		super();
		
	}

	public OnlineAdapter(double cantidad, Date fechaPago, int numeroTarjeta, Residente residente) {
		super(cantidad, fechaPago);
		this.numeroTarjeta=numeroTarjeta;
		this.residente=residente;
	}

	@Override
	public boolean pagar() {
		boolean estado=false;
		AbstractPagoFacadeAdaptee pagoOnline = new OnlinePagoFacade();
		if(pagoOnline.pagarOnline(residente, datosPago.getPago(), datosPago.getNumeroTarjeta(), datosPago.getFecha())==true)
			estado=true;
		else
			estado=false;
		
		return estado;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	public DatosPagoDTO getDatosPago() {
		return datosPago;
	}

	public void setDatosPago(DatosPagoDTO datosPago) {
		this.datosPago = datosPago;
	}
	
	

}
