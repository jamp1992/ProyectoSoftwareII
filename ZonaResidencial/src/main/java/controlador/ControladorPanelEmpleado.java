package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import modelo.factorymethod.EmpleadoDAO;
import modelo.persona.Empleado;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.ConjuntoResidencialSingleton;
import vista.PanelEmpleado;

public class ControladorPanelEmpleado implements ActionListener {

	private PanelEmpleado pe;
	private Empleado empleado;
	private Date date;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	private ConjuntoResidencialSingleton crs=ConjuntoResidencialSingleton.getInstance();
	public ControladorPanelEmpleado(PanelEmpleado pe) {
		this.pe = pe;
	}
	

	public PanelEmpleado getPe() {
		return pe;
	}
	public void setPe(PanelEmpleado pe) {
		this.pe = pe;
	}
	
	public AdministradorSingleton getAdmin() {
		return admin;
	}


	public void setAdmin(AdministradorSingleton admin) {
		admin = admin;
	}


	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case "Guardar Aux. Admin":
			date=pe.c.getCalendar().getTime();
			empleado= new Empleado(Integer.parseInt(pe.textCedula.getText()),pe.textNombre.getText(),pe.textApellido.getText(),pe.textUsuario.getText(),pe.textContrasena.getText(),date);
			admin.gestionarEmpleado().crearAuxiliarAdmin(empleado, crs.getIdConjunto());
			
			break;
			
		case "Guardar Vigilante":
			date=pe.c.getCalendar().getTime();
			empleado= new Empleado(Integer.parseInt(pe.textCedula.getText()),pe.textNombre.getText(),pe.textApellido.getText(),pe.textUsuario.getText(),pe.textContrasena.getText(),date);
			admin.gestionarEmpleado().crearVigilante(empleado, crs.getIdConjunto());
			break;
			
		case "Guardar Personal Mant.":
			date=pe.c.getCalendar().getTime();
			empleado= new Empleado(Integer.parseInt(pe.textCedula.getText()),pe.textNombre.getText(),pe.textApellido.getText(),pe.textUsuario.getText(),pe.textContrasena.getText(),date);
			admin.gestionarEmpleado().crearPersonalMantenimiento(empleado, crs.getIdConjunto());
			break;
		}
		
	}

}
