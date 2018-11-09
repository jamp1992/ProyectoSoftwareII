package modelo.chainofresponsibility;

import java.util.Date;

public abstract class AbstractServicioFactory {
	public abstract boolean ServicioMantenimiento(Date fecha, int codServicio, int cedula);
}
