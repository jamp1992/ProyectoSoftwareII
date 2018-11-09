package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import modelo.builder.Torre;
import modelo.factorymethod.EmpleadoDAO;
import modelo.factorymethod.TorreDAO;
import modelo.persona.Empleado;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.ConjuntoResidencialSingleton;
import vista.PanelEmpleado;
import modelo.otros.ServicioMantenimiento;

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
		case "Crear":
			pe.textCedula.setEnabled(true);
			pe.textNombre.setEnabled(true);
			pe.textApellido.setEnabled(true);
			pe.textUsuario.setEnabled(true);
			pe.textContrasena.setEnabled(true);
			ServicioMantenimiento sm;
			Iterator<ServicioMantenimiento> itr = admin.gestionarServicioMantenimiento().finAllServiciosMantenimiento().iterator();
            while(itr.hasNext()){
                sm=(ServicioMantenimiento) itr.next();
                this.pe.comboBoxOpcServicio.addItem(sm.getDescripcion());
            }
			break;
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
			admin.gestionarEmpleado().crearPersonalMantenimiento(empleado, crs.getIdConjunto(), admin.BuscarServicioMantenimiento(admin.gestionarServicioMantenimiento().finAllServiciosMantenimiento(), pe.comboBoxOpcServicio.getSelectedItem().toString()));
			break;
		case"Buscar Empleado":
			//admin.buscarEmpleado(admin.gestionarEmpleado().MostrarAuxiliaresAdmin(), admin.gestionarEmpleado().MostrarVigilantes(), admin.gestionarEmpleado().MostrarPersonalMantenimiento(), Integer.parseInt(pe.textId.getText()));
			empleado=admin.buscarEmpleado(admin.gestionarEmpleado().MostrarAuxiliaresAdmin(),admin.gestionarEmpleado().MostrarVigilantes(),admin.gestionarEmpleado().MostrarPersonalMantenimiento(), Integer.parseInt(pe.textId.getText()));
			
				if(empleado==null) {
					JOptionPane.showMessageDialog(null, "Id no existe");
				}	
					else{
						for(int i=this.pe.modeloTabla.getRowCount(); i>0; i--){
		                    this.pe.modeloTabla.removeRow(i-1);
		                }
						this.pe.modeloTabla.addRow(new Object[]{empleado.getCedula(),empleado.getNombre(),empleado.getApellido(),empleado.getUsuario(),empleado.getContrasena(),empleado.getFechaIngreso()});
					}
			break;
		case "Listar Aux":
			List<Empleado> listaAuxiliarAdministrativo= new ArrayList<>();
			Empleado ea;
			for(int i=this.pe.modeloTabla.getRowCount(); i>0; i--){
                this.pe.modeloTabla.removeRow(i-1);
            }
            
			listaAuxiliarAdministrativo=admin.gestionarEmpleado().MostrarAuxiliaresAdmin();
            Iterator<Empleado> itrAux = listaAuxiliarAdministrativo.iterator();
            while(itrAux.hasNext()){
                ea=(Empleado) itrAux.next();
                this.pe.modeloTabla.addRow(new Object[]{ea.cedula,ea.nombre,ea.apellido,ea.getUsuario(),ea.getContrasena(),ea.getFechaIngreso()});
            }
			break;
			
		case"Listar Vigilantes":
			List<Empleado> listaVigilantes= new ArrayList<>();
			Empleado v;
			for(int i=this.pe.modeloTabla.getRowCount(); i>0; i--){
                this.pe.modeloTabla.removeRow(i-1);
            }
            
			listaVigilantes=admin.gestionarEmpleado().MostrarVigilantes();
            Iterator<Empleado> itrVig = listaVigilantes.iterator();
            while(itrVig.hasNext()){
                v=(Empleado) itrVig.next();
                this.pe.modeloTabla.addRow(new Object[]{v.cedula,v.nombre,v.apellido,v.getUsuario(),v.getContrasena(),v.getFechaIngreso()});
            }
			break;
			
		case"Listar Personal M.":
			List<Empleado> listaPersonalMantenimiento= new ArrayList<>();
			Empleado pm;
			for(int i=this.pe.modeloTabla.getRowCount(); i>0; i--){
                this.pe.modeloTabla.removeRow(i-1);
            }
            
			listaPersonalMantenimiento=admin.gestionarEmpleado().MostrarPersonalMantenimiento();
            Iterator<Empleado> itrPerMant = listaPersonalMantenimiento.iterator();
            while(itrPerMant.hasNext()){
                pm=(Empleado) itrPerMant.next();
                this.pe.modeloTabla.addRow(new Object[]{pm.cedula,pm.nombre,pm.apellido,pm.getUsuario(),pm.getContrasena(),pm.getFechaIngreso()});
            }
			break;
		}
		
	}

}
