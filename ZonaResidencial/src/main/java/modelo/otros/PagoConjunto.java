package modelo.otros;

import java.util.*;

public class PagoConjunto {
	
	private int idPago;
    private Date fechaPago;
    private Double valorPago;
    private boolean pagado;
    
    public PagoConjunto() {
    }
    
    public PagoConjunto(Date fechaPago, Double valorPago) {
		super();
		this.fechaPago = fechaPago;
		this.valorPago = valorPago;
	}
    
    
    
	public PagoConjunto(Date fechaPago, Double valorPago, boolean pagado) {
		super();
		this.fechaPago = fechaPago;
		this.valorPago = valorPago;
		this.pagado = pagado;
	}

	public PagoConjunto(int idPago, Date fechaPago, Double valorPago) {
		super();
		this.idPago = idPago;
		this.fechaPago = fechaPago;
		this.valorPago = valorPago;
	}
	
	

	public PagoConjunto(int idPago, Date fechaPago, Double valorPago, boolean pagado) {
		super();
		this.idPago = idPago;
		this.fechaPago = fechaPago;
		this.valorPago = valorPago;
		this.pagado = pagado;
	}

	public void registrarPago() { 
        
    }

    public void mostrarPago() {
        
    }

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	
	
    

}