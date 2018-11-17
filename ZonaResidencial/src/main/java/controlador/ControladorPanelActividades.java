package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.factorymethod.NotificacionDAO;
import modelo.factorymethod.PagoConjuntoDAO;
import modelo.factorymethod.TorreDAO;
import modelo.otros.Notificacion;
import modelo.otros.PagoAdmin;
import modelo.persona.AuxAdministrativo;
import modelo.persona.Residente;
import modelo.singleton.AdministradorSingleton;
import modelo.builder.Torre;
import vista.PanelActividades;

public class ControladorPanelActividades implements ActionListener {
	private PagoConjuntoDAO PCDAO=new PagoConjuntoDAO();
	private AuxAdministrativo auxAdmin=new AuxAdministrativo();
	private PanelActividades pa;
	private TorreDAO TDAO=new TorreDAO();
	private NotificacionDAO NDAO= new NotificacionDAO();
	private Notificacion notificacion;
	private Residente residente;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	public ControladorPanelActividades(PanelActividades pa) {
		this.pa = pa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Listar residente":
			List<Residente> residenteList=new ArrayList<>();
			residenteList=admin.gestionarResidente().MostrarResidentes();
			for(int i=this.pa.modeloTabla.getRowCount(); i>0; i--){
                this.pa.modeloTabla.removeRow(i-1);
            }
			for(Residente residente: residenteList){
				this.pa.modeloTabla.addRow(new Object[]{residente.cedula,residente.nombre,residente.apellido,residente.getFechaPagoAdmin(),residente.getValorAdmin()});
			}
			break;
		case "Listar pagos residente":
			List<PagoAdmin> pagoAdminList = new ArrayList<>();
			pagoAdminList=PCDAO.ListarPagoAdmin(Integer.parseInt(String.valueOf(this.pa.modeloTabla.getValueAt(this.pa.table.getSelectedRow(),0))));
			for(int i=this.pa.modeloTablaPago.getRowCount(); i>0; i--){
                this.pa.modeloTablaPago.removeRow(i-1);
            }
			for(PagoAdmin pagoAdmin:pagoAdminList) {
				this.pa.modeloTablaPago.addRow(new Object[] {pagoAdmin.getIdPago(),pagoAdmin.getValorPago(),pagoAdmin.getFechaPago(),pagoAdmin.isPagado()});
			}
			break;
		case "Notificar Cliente":
			notificacion=auxAdmin.notificarPagoAdminResidente(Double.parseDouble(String.valueOf(this.pa.modeloTablaPago.getValueAt(this.pa.tablePago.getSelectedRow(),1))), String.valueOf(this.pa.modeloTablaPago.getValueAt(this.pa.tablePago.getSelectedRow(),2)));
			NDAO.crearNotificacion(notificacion, Integer.parseInt(String.valueOf(this.pa.modeloTabla.getValueAt(this.pa.table.getSelectedRow(),0))));
			break;
		}
		
	}
	
}
