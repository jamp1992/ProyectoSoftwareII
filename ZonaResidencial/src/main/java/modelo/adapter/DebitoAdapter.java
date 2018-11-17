package modelo.adapter;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

/**
 * 
 */
public class DebitoAdapter extends IMetodoPagoAdapter {

	public DebitoAdapter(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
	}
	
	@Override
	public boolean pagar() {
		boolean estado=false;
		DebitoAdaptee debitoAdaptee= new DebitoAdaptee();
		debitoAdaptee.consultarSaldo(this.getDatosPago().getPago());
		if(debitoAdaptee.realizarTransaccion()==true) {
			estado=true;
		}
		else {
			estado=false;
		}
		return estado;
	}
	
	
}