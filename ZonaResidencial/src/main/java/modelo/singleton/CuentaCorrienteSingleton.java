package modelo.singleton;

import java.util.*;

import modelo.factorymethod.CuentaCorrienteDAO;

public class CuentaCorrienteSingleton {
	
	private static CuentaCorrienteSingleton singleton;
    private int numeroCuenta;
    private String nombreCuenta;
    private Double saldo;
    
    private CuentaCorrienteSingleton() {
    	CuentaCorrienteDAO CCDAO = new CuentaCorrienteDAO();
    	CCDAO.ObtenerCuenta(this);
    }
    
    private static synchronized void createInstance(){
		if(singleton ==null){
			singleton = new CuentaCorrienteSingleton();
		}
	}

    public static CuentaCorrienteSingleton getInstance() {
    	if(singleton == null) {
			createInstance();
		}
		return singleton;
    }

	public static CuentaCorrienteSingleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(CuentaCorrienteSingleton singleton) {
		CuentaCorrienteSingleton.singleton = singleton;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public void sumarSaldo(Double saldo) {
		this.saldo=this.saldo+saldo;
	}
    
    


}