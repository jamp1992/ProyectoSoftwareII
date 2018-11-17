package modelo.adapter;

import java.util.Date;

import modelo.facade.AbstractPagoFacadeAdaptee;
import modelo.facade.OnlinePagoFacade;
import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

public class OnlineAdapter extends IMetodoPagoAdapter {
	
	
	public OnlineAdapter() {
		super();	
	}

	public OnlineAdapter(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
	}

	@Override
	public boolean pagar() {
		boolean estado=false;
		AbstractPagoFacadeAdaptee pagoOnline = new OnlinePagoFacade();
		if(pagoOnline.pagarOnline(this.getResidente(), this.getDatosPago().getPago(), this.getDatosPago().getNumeroTarjeta(), this.getDatosPago().getFecha())==true)
			estado=true;
		else
			estado=false;
		
		return estado;
	}
	
}
