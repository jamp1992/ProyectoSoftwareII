package modelo.otros;

import java.util.Date;

public class DatosPagoDTO {
	private double pago;
	private Date fecha;
	private int numeroTarjeta;
	private int numeroCheque;
	private String nombreReceptor;
	private int numeroCuenta;
	
	
	
	public DatosPagoDTO(double pago, Date fecha,int numeroTarjeta ,int numeroCheque, String nombreReceptor, int numeroCuenta) {
		this.pago = pago;
		this.fecha = fecha;
		this.numeroTarjeta=numeroTarjeta;
		this.numeroCheque = numeroCheque;
		this.nombreReceptor = nombreReceptor;
		this.numeroCuenta = numeroCuenta;
	}
	
	public DatosPagoDTO(double pago, Date fecha, int numeroTarjeta) {
		this.pago = pago;
		this.fecha = fecha;
		this.numeroTarjeta = numeroTarjeta;
	}

	public DatosPagoDTO(double pago, Date fecha) {
		this.pago = pago;
		this.fecha = fecha;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
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
	
}
