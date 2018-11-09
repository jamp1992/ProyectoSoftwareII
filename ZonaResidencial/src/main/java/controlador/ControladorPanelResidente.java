package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.builder.Torre;
import modelo.factorymethod.AptoDAO;
import modelo.factorymethod.EstacionamientoDAO;
import modelo.factorymethod.TorreDAO;
import modelo.otros.Estacionamiento;
import modelo.persona.Empleado;
import modelo.persona.Residente;
import modelo.prototype.AptoImpl;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.ConjuntoResidencialSingleton;
import vista.PanelResidente;

public class ControladorPanelResidente implements ActionListener {
	
	private PanelResidente pr;
	private Residente residente;
	private Date dateFechaAdquisicion;
	private Date dateFechaPagoAdmin;
	private EstacionamientoDAO EDAOActualizar;
	private AptoDAO ADAOActualizar;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	private ConjuntoResidencialSingleton crs=ConjuntoResidencialSingleton.getInstance();

	public ControladorPanelResidente(PanelResidente pr) {
		this.pr = pr;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case "Registrar":
			dateFechaAdquisicion=pr.calendarioFechaAdquisicion.getCalendar().getTime();
			dateFechaPagoAdmin=pr.calendarioFechaPagoAdmin.getCalendar().getTime();
			residente= new Residente(Integer.parseInt(pr.textCedula.getText()),pr.textNombre.getText(),pr.textApellido.getText(),pr.textUsuario.getText(),pr.textContrasena.getText(),dateFechaAdquisicion,false,dateFechaPagoAdmin,Double.parseDouble(pr.textValorAdmin.getText()));
			admin.gestionarResidente().crearResidente(residente, Integer.parseInt(pr.textIdEstacionamiento.getText()), crs.getIdConjunto(),Integer.parseInt(pr.textIdApto.getText()));
			//Cuando se registra un residente, acontinuacion se actualiza el estado del estacionamiento seleccionado, actualizando de estado disponible a no disponible
			EDAOActualizar= new EstacionamientoDAO();
			EDAOActualizar.ModificarEstacionamiento(new Estacionamiento(Integer.parseInt(pr.textIdEstacionamiento.getText()),"No disponible"));
			//Cuando se registra un residente, acontinuacion se actualiza el estado del apto seleccionado, actualizando de estado disponible a no disponible
			ADAOActualizar = new AptoDAO();
			ADAOActualizar.ModificarApto(new AptoImpl(Integer.parseInt(pr.textIdApto.getText()),"No disponible"));
			break;
			
		case "Buscar Residente":
			residente=admin.buscarResidente(admin.gestionarResidente().MostrarResidentes(), Integer.parseInt(pr.textId.getText()));
			if(residente==null) {
				JOptionPane.showMessageDialog(null, "Cedula no existe");
			}	
				else{
					for(int i=this.pr.modeloTabla.getRowCount(); i>0; i--){
	                    this.pr.modeloTabla.removeRow(i-1);
	                }
					this.pr.modeloTabla.addRow(new Object[]{residente.getCedula(),residente.getNombre(),residente.getApellido(),residente.getUsuario(),residente.getContrasena(),residente.getFechaAdquisicionApto(),residente.getPropietario(),residente.getFechaPagoAdmin(),residente.getValorAdmin()});
				}
			
		break;
		
		case "Eliminar residente":
			admin.gestionarResidente().BorrarResidente(Integer.parseInt(String.valueOf(this.pr.modeloTabla.getValueAt(this.pr.table.getSelectedRow(), 0))));
			//Cuando se registra un residente, acontinuacion se actualiza el estado del estacionamiento seleccionado, actualizando de estado disponible a no disponible
			EDAOActualizar= new EstacionamientoDAO();
			EDAOActualizar.ModificarEstacionamiento(new Estacionamiento(Integer.parseInt(String.valueOf(this.pr.modeloTabla.getValueAt(this.pr.table.getSelectedRow(), 9))),"Disponible"));
			//Cuando se registra un residente, acontinuacion se actualiza el estado del apto seleccionado, actualizando de estado disponible a no disponible
			ADAOActualizar = new AptoDAO();
			ADAOActualizar.ModificarApto(new AptoImpl(Integer.parseInt(String.valueOf(this.pr.modeloTabla.getValueAt(this.pr.table.getSelectedRow(), 10))),"Disponible"));
			break;
		
		case "Listar Estacionamiento":
			List<Estacionamiento> listaEstacionamiento= new ArrayList<>();
			Estacionamiento e;
			for(int i=this.pr.modeloTablaEstacionamiento.getRowCount(); i>0; i--){
                this.pr.modeloTablaEstacionamiento.removeRow(i-1);
            }
            EstacionamientoDAO EDAO = new EstacionamientoDAO();
            listaEstacionamiento=EDAO.finAllEstacionamiento();
            Iterator<Estacionamiento> itr = listaEstacionamiento.iterator();
            while(itr.hasNext()){
                e=(Estacionamiento) itr.next();
                this.pr.modeloTablaEstacionamiento.addRow(new Object[]{e.getIdEstacionamiento(),e.getEstado()});
            }
            
			break;
			
		case "Mostrar Dispo.":
			List<Estacionamiento> listaEstacionamientoDispo= new ArrayList<>();
			Estacionamiento eDispo;
			for(int i=this.pr.modeloTablaEstacionamiento.getRowCount(); i>0; i--){
                this.pr.modeloTablaEstacionamiento.removeRow(i-1);
            }
            EstacionamientoDAO EDAODispo = new EstacionamientoDAO();
            listaEstacionamientoDispo=EDAODispo.finAllEstacionamiento();
            Iterator<Estacionamiento> itrDispo = listaEstacionamientoDispo.iterator();
            while(itrDispo.hasNext()){
            	if(itrDispo.next().getEstado().equals("Disponible")) {
	                eDispo=(Estacionamiento) itrDispo.next();
	                this.pr.modeloTablaEstacionamiento.addRow(new Object[]{eDispo.getIdEstacionamiento(),eDispo.getEstado()});
            	}
            }
		case "Listar residente":
			List<Residente> listaResidente= new ArrayList<>();
			Residente r;
			for(int i=this.pr.modeloTabla.getRowCount(); i>0; i--){
                this.pr.modeloTabla.removeRow(i-1);
            }
            listaResidente=admin.gestionarResidente().MostrarResidentes();
            //JOptionPane.showMessageDialog(null, listaResidente.get(0).getNombre());
            Iterator<Residente> itrRes = listaResidente.iterator();
            while(itrRes.hasNext()){
	                r=(Residente) itrRes.next();
	                this.pr.modeloTabla.addRow(new Object[]{r.getCedula(),r.getNombre(),r.getApellido(),r.getUsuario(),r.getContrasena(),r.getFechaAdquisicionApto(),r.getPropietario(),r.getFechaPagoAdmin(),r.getValorAdmin(),r.getEstacionamiento().getIdEstacionamiento(),r.getApto().getIdApto()});
            	
            }
		break;
		case"Listar Aptos":
			List<AptoImpl> listaApto= new ArrayList<>();
			AptoImpl a;
			for(int i=this.pr.modeloTablaApto.getRowCount();i>0;i--) {
				this.pr.modeloTablaApto.removeRow(i-1);
			}
			AptoDAO AMDAO= new AptoDAO();
			listaApto=AMDAO.finAllAptosDisponibles();
			Iterator<AptoImpl> itrApto = listaApto.iterator();
            while(itrApto.hasNext()){
                a=(AptoImpl) itrApto.next();
                this.pr.modeloTablaApto.addRow(new Object[]{a.getIdAptoImpl(),a.getEstado(),a.getNumeroApto(),a.getValor(),a.getNombreApto(),a.getLargo(),a.getAncho(),a.getM2()});
            }
			break;
		case"Seleccionar Apto y Estacionamiento":
			pr.textIdEstacionamiento.setText(String.valueOf(this.pr.modeloTablaEstacionamiento.getValueAt(this.pr.tableEstacionamiento.getSelectedRow(), 0)));
			pr.textIdApto.setText(String.valueOf(this.pr.modeloTablaApto.getValueAt(this.pr.tableApto.getSelectedRow(), 0)));
			
			break;
		
			
		}
		
	}
	

}
