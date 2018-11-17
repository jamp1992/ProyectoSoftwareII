package modelo.otros;

import java.util.*;

/**
 * 
 */
public class PagoAdmin extends PagoConjunto {

	public PagoAdmin() {
		super();
	}

	public PagoAdmin(Date fechaPago, Double valorPago) {
		super(fechaPago, valorPago);
	}

	public PagoAdmin(int idPago, Date fechaPago, Double valorPago) {
		super(idPago, fechaPago, valorPago);
	}

	public PagoAdmin(int idPago, Date fechaPago, Double valorPago, boolean pagado) {
		super(idPago, fechaPago, valorPago, pagado);
	}
	public PagoAdmin(Date fechaPago, Double valorPago, boolean pagado) {
		super(fechaPago, valorPago, pagado);
	}
	
}