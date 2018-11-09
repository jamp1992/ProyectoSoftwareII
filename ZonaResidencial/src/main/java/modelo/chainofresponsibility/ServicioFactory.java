package modelo.chainofresponsibility;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.persona.Electrico;
import modelo.persona.Fontanero;
import modelo.persona.PersonaServicioGeneral;

public class ServicioFactory extends AbstractServicioFactory {

	@Override
	public boolean ServicioMantenimiento(Date fecha, int codServicio, int cedula) {
		JOptionPane.showMessageDialog(null, "Ya empezo");
		Electrico electrico= new Electrico();
		electrico.setNext(electrico);
		
		Fontanero fontanero=new Fontanero();
		electrico.setNext(fontanero);
		
		PersonaServicioGeneral psm= new PersonaServicioGeneral();
		fontanero.setNext(psm);
		
		return false;
	}

}
