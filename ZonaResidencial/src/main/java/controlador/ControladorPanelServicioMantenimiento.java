package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.builder.Torre;
import modelo.factorymethod.ServicioMantenimientoDAO;
import modelo.factorymethod.TorreDAO;
import modelo.otros.ServicioMantenimiento;
import modelo.singleton.AdministradorSingleton;
import vista.PanelServicioMantenimiento;

public class ControladorPanelServicioMantenimiento implements ActionListener {
	
	private PanelServicioMantenimiento psm;
	private ServicioMantenimiento servicioMantenimiento;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	
	public ControladorPanelServicioMantenimiento(PanelServicioMantenimiento psm) {
		this.psm = psm;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case"Crear":
			psm.textDescripcion.setEnabled(true);
			psm.textCosto.setEnabled(true);
			break;
		case"Guardar Servicio Mant.":
			servicioMantenimiento= new ServicioMantenimiento(psm.textDescripcion.getText(),Double.valueOf(psm.textCosto.getText()));
			admin.gestionarServicioMantenimiento().saveServicioMantenimiento(servicioMantenimiento);
			break;
		case"Mostrar Servicio":
			List<ServicioMantenimiento> listaservicioMantenimiento= new ArrayList<>();
			ServicioMantenimiento s;
			for(int i=this.psm.modeloTabla.getRowCount(); i>0; i--){
                this.psm.modeloTabla.removeRow(i-1);
            }
            
			listaservicioMantenimiento=admin.gestionarServicioMantenimiento().finAllServiciosMantenimiento();
            Iterator<ServicioMantenimiento> itr = listaservicioMantenimiento.iterator();
            while(itr.hasNext()){
                s=(ServicioMantenimiento) itr.next();
                this.psm.modeloTabla.addRow(new Object[]{s.getIdServicioMantenimiento(),s.getDescripcion(),s.getCosto()});
            }
            
			break;
		}
		
	}

}
