package modelo.persona;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.chainofresponsibility.ServiceChainOfResponsability;

public class PersonaServicioGeneral extends PersonalMantenimiento implements ServiceChainOfResponsability {

	private ServiceChainOfResponsability next;
	
	public PersonaServicioGeneral(int cedula, String nombre, String apellido) {
		super(cedula, nombre, apellido);
	}
	
	
	public PersonaServicioGeneral() {
		super();
	}



	@Override
	public void setNext(ServiceChainOfResponsability SCOR) {
		this.next=SCOR;
		
	}

	@Override
	public ServiceChainOfResponsability getNext() {
		return this.next;
	}

	@Override
	public boolean SolicitarServicioMantenimiento(Date fecha, int codServicio, int cedula) {
		boolean estado=false;
		if(codServicio==3) {
			JOptionPane.showMessageDialog(null, "Soy Personal de mantenimiento");
			estado=true;
		}
		else {
			next.SolicitarServicioMantenimiento(fecha, codServicio, cedula);
		}
		
		return estado;
	}


}