package modelo.facade;

import java.util.Date;

import modelo.persona.Residente;

public abstract class AbstractPagoFacadeAdaptee {
	
	abstract public boolean pagarOnline(Residente residente, double cantidad, int numeroTarjeta, Date fecha);
}
