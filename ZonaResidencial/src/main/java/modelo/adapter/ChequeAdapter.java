package modelo.adapter;

import java.util.Date;

import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

public class ChequeAdapter extends IMetodoPagoAdapter {

	
	public ChequeAdapter(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
	}



	public ChequeAdapter() {
		super();
	}

	@Override
	public boolean pagar() {
		boolean estado=false;
		ChequeAdaptee chequeAdaptee= new ChequeAdaptee();
		chequeAdaptee.verificarFondos(this.getDatosPago().getPago());
		if(chequeAdaptee.girarCheque()==true)
			estado=true;
		
		else
			estado=false;
		
		return estado;
				
	}
	

}