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
	
	List<Object> listaPrincipal = new ArrayList<Object>();
	List<Residente> listaResidente = new ArrayList<>();
	List<PagoAdmin> listaPago=new ArrayList<>();
	
    public Efectivo(double cantidad, Date fechaPago) {
		super(cantidad, fechaPago);
	}
    
	public Efectivo(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
		listaPrincipal.add(listaResidente);
		listaPrincipal.add(listaPago);
		
	}



	@Override
	public boolean pagar() {
		/*CuentaCorrienteSingleton CC1=CuentaCorrienteSingleton.getInstance();
		CC1.sumarSaldo(this.getDatosPago().getPago());*/
		return true;
	}

	

}