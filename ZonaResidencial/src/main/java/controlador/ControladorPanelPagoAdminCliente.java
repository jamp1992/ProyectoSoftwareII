package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.adapter.Efectivo;
import modelo.adapter.IMetodoPagoAdapter;
import modelo.factorymethod.CuentaCorrienteDAO;
import modelo.factorymethod.NotificacionDAO;
import modelo.factorymethod.PagoConjuntoDAO;
import modelo.otros.DatosPagoDTO;
import modelo.otros.PagoAdmin;
import modelo.otros.PagoConjunto;
import modelo.persona.Residente;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.CuentaCorrienteSingleton;
import vista.PanelPagoAdmin;

public class ControladorPanelPagoAdminCliente implements ActionListener {

	private PanelPagoAdmin ppa;
	private PagoConjuntoDAO PCDAO = new PagoConjuntoDAO();
	private NotificacionDAO NDAO = new NotificacionDAO();
	private CuentaCorrienteDAO CCDAO;
	private CuentaCorrienteSingleton CC1=CuentaCorrienteSingleton.getInstance();
	private Residente residente;
	private SimpleDateFormat formatoFecha;
	private Date fecha;
	private PagoAdmin pagoAdmin;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	private List<PagoAdmin> listaPagoAdmin= new ArrayList<>();
	private DatosPagoDTO datosPago;
	
	public ControladorPanelPagoAdminCliente(PanelPagoAdmin ppa) {
		this.ppa = ppa;
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case"Revisar notificacion":
			JOptionPane.showMessageDialog(null, "No tiene notificaciones");
			break;
		case"Mostrar Pago Pendiente":
			
			residente=admin.buscarResidente(admin.gestionarResidente().MostrarResidentes(),Integer.parseInt(ppa.textId.getText()));
			listaPagoAdmin=PCDAO.ListarPagoAdmin(residente.getCedula());
					
			
				for(int i=this.ppa.modeloTabla.getRowCount(); i>0; i--){
                    this.ppa.modeloTabla.removeRow(i-1);
                }
				
				for(int j=0;j<listaPagoAdmin.size();j++) {
					this.ppa.modeloTabla.addRow(new Object[]{residente.getCedula(),residente.getNombre(),listaPagoAdmin.get(j).getFechaPago(),listaPagoAdmin.get(j).getValorPago(),listaPagoAdmin.get(j).isPagado(),listaPagoAdmin.get(j).getIdPago()});
				}
			break;
			
		case"Efectivo":
			ppa.textCedula.setEnabled(false);
			ppa.textCedula.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),0)));
			ppa.textNombre.setEnabled(false);
			ppa.textNombre.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),1)));
			ppa.textTarjeta.setEnabled(false);
			ppa.textCuenta.setEnabled(false);
			ppa.textReceptorCheque.setEnabled(false);
			ppa.textCheque.setEnabled(false);
			ppa.textCantidad.setEnabled(false);
			ppa.textCantidad.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),3)));
			break;
		case"DebitoAdapter":
			ppa.textCedula.setEnabled(false);
			ppa.textCedula.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),0)));
			ppa.textNombre.setEnabled(false);
			ppa.textNombre.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),1)));
			ppa.textTarjeta.setEnabled(true);
			ppa.textCuenta.setEnabled(false);
			ppa.textReceptorCheque.setEnabled(false);
			ppa.textCheque.setEnabled(false);
			ppa.textCantidad.setEnabled(true);
			ppa.textCantidad.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),3)));
			break;
		case"ChequeAdapter":
			ppa.textCedula.setEnabled(false);
			ppa.textCedula.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),0)));
			ppa.textNombre.setEnabled(false);
			ppa.textNombre.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),1)));
			ppa.textTarjeta.setEnabled(false);
			ppa.textCuenta.setEnabled(true);
			ppa.textReceptorCheque.setEnabled(true);
			ppa.textCheque.setEnabled(true);
			ppa.textCantidad.setEnabled(true);
			ppa.textCantidad.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),3)));
			break;
		case"OnlineAdapter":
			ppa.textCedula.setEnabled(false);
			ppa.textCedula.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),0)));
			ppa.textNombre.setEnabled(false);
			ppa.textNombre.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),1)));
			ppa.textTarjeta.setEnabled(true);
			ppa.textCuenta.setEnabled(false);
			ppa.textReceptorCheque.setEnabled(false);
			ppa.textCheque.setEnabled(false);
			ppa.textCantidad.setEnabled(true);
			ppa.textCantidad.setText(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),3)));
			break;
		case "Pagar":
			if(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),4)).equals("true")) {
				JOptionPane.showMessageDialog(null, "Pago ya realizado");
			}
			else {
				formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
				fecha=new Date();
				formatoFecha.format(fecha);
				residente=admin.buscarResidente(admin.gestionarResidente().MostrarResidentes(),Integer.parseInt(ppa.textId.getText()));
				datosPago=new DatosPagoDTO(Double.parseDouble(ppa.textCantidad.getText()), fecha,Integer.parseInt(ppa.textTarjeta.getText()), Integer.parseInt(ppa.textCheque.getText()),ppa.textReceptorCheque.getText(),Integer.parseInt(ppa.textCuenta.getText()));
				String sel=ppa.grupoBoton.getSelection().getActionCommand();
				if(residente.pagarAdmin(datosPago, residente, sel).pagar()==true) {
					PCDAO= new PagoConjuntoDAO();
					PCDAO.actualizarPagoAdmin(Integer.parseInt(String.valueOf(this.ppa.modeloTabla.getValueAt(this.ppa.table.getSelectedRow(),5))));
					CCDAO= new CuentaCorrienteDAO();
					CCDAO.ModificarCuentaCorriente(CC1);
					NDAO.BorrarNotificacion(Integer.parseInt(ppa.textId.getText()));
					JOptionPane.showMessageDialog(null, "Pago realizado...");
				}
				else {
					JOptionPane.showMessageDialog(null, "Pago no realizado...");
				}
			}
			break;
					
		}
		
	}
	
	
	

}
