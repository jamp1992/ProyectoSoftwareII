package modelo.adapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.otros.DatosPagoDTO;
import modelo.otros.PagoAdmin;
import modelo.persona.Residente;
import modelo.singleton.CuentaCorrienteSingleton;

public class Efectivo extends IMetodoPagoAdapter {
	
	
    public Efectivo(double cantidad, Date fechaPago) {
		super(cantidad, fechaPago);
	}
    
	public Efectivo(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
	}

	@Override
	public boolean pagar() {
		/*CuentaCorrienteSingleton CC1=CuentaCorrienteSingleton.getInstance();
		CC1.sumarSaldo(this.getDatosPago().getPago());*/
		return true;
	}

	

}