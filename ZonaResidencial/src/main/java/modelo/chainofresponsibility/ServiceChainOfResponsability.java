package modelo.chainofresponsibility;

import java.util.Date;

public interface  ServiceChainOfResponsability {
	public void setNext(ServiceChainOfResponsability SCOR);
	public ServiceChainOfResponsability getNext();
	public boolean SolicitarServicioMantenimiento(Date fecha, int codServicio, int cedula);
}
