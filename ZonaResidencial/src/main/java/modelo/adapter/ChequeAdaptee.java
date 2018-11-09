package modelo.adapter;

import javax.swing.JOptionPane;

import modelo.singleton.CuentaCorrienteSingleton;

public class ChequeAdaptee {
	private boolean aceptado=false;
	private double cantidad;
  
    public ChequeAdaptee() {
    }

    public void verificarFondos(double cantidad) {
    	double numero = (Math.random() * 1000000) + 1;
    	if(cantidad<=numero) {
    		aceptado=true;
    		this.cantidad=cantidad;
    		//JOptionPane.showMessageDialog(null, "Tu cheque posee fondos");
    	}
    	else if(cantidad>numero) {
    		aceptado=false;
    		//JOptionPane.showMessageDialog(null, "Lo sentimos tu cheque no posee fondos");
    	}
       
    }

    public boolean girarCheque() {
    	boolean estado=false;
    	if(this.aceptado==true) {
    		CuentaCorrienteSingleton CC1=CuentaCorrienteSingleton.getInstance();
    		CC1.sumarSaldo(cantidad);
    		estado=true;
    	}
    	else if(this.aceptado==false) {
    		
    		estado=false;
    	}
    	return estado;
        
    }

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
    

}