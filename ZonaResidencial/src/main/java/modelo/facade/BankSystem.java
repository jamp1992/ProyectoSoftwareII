package modelo.facade;

public class BankSystem {
	
	public boolean verificarSaldo(double cantidad, int numeroTarjeta) {
		boolean aceptado=false;
		double numero = (Math.random() * 1000000) + 1;
    	if(cantidad<=numero) {
    		aceptado=true;
    	}
    	else if(cantidad>numero) {
    		aceptado=false;
    	}
		return aceptado;
	}
}
