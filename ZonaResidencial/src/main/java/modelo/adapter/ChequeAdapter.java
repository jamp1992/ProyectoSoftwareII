package modelo.adapter;

import java.util.Date;

import modelo.otros.DatosPagoDTO;
import modelo.persona.Residente;

/**
 * 
 */
public class ChequeAdapter extends IMetodoPagoAdapter {

	private int numeroCheque;
    private String nombreReceptor;
    private int numeroCuenta;
    
    private DatosPagoDTO datosPago;
    private Residente residente;
    
	public ChequeAdapter(double cantidad, Date fechaPago, int numeroCheque, String nombreReceptor, int numeroCuenta) {
		super(cantidad, fechaPago);
		this.numeroCheque=numeroCheque;
		this.nombreReceptor=nombreReceptor;
		this.numeroCuenta=numeroCuenta;
	}
	
	
	public ChequeAdapter(DatosPagoDTO datosPago, Residente residente) {
		super(datosPago, residente);
	}



	public ChequeAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumeroCheque() {
		return numeroCheque;
	}
	public void setNumeroCheque(int numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	public String getNombreReceptor() {
		return nombreReceptor;
	}
	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
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
		ChequeAdaptee chequeAdaptee= new ChequeAdaptee();
		chequeAdaptee.verificarFondos(this.getDatosPago().getPago());
		if(chequeAdaptee.girarCheque()==true)
			estado=true;
		
		else
			estado=false;
		
		return estado;
				
	}
	

}