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
	private CuentaCorrienteDAO CCDAO;
	private CuentaCorrienteSingleton CC1=CuentaCorrienteSingleton.getInstance();
	private Residente residente;
	private SimpleDateFormat formatoFecha;
	private Date fecha;
	private PagoConjunto pagoConjunto;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	private List<PagoAdmin> listaPagoAdmin= new ArrayList<>();
	private DatosPagoDTO datosPago;
	
	public ControladorPanelPagoAdminCliente(PanelPagoAdmin ppa) {
		this.ppa = ppa;
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case"Mostrar Pago Pendiente":
			listaPagoAdmin=PCDAO.ListarPagoAdmin(Integer.parseInt(ppa.textId.getText()));
			residente=admin.buscarResidente(admin.gestionarResidente().MostrarResidentes(),Integer.parseInt(ppa.textId.getText()));
			
					
			
				for(int i=this.ppa.modeloTabla.getRowCount(); i>0; i--){
                    this.ppa.modeloTabla.removeRow(i-1);
                }
				
				for(int j=0;j<listaPagoAdmin.size();j++) {
					this.ppa.modeloTabla.addRow(new Object[]{residente.getCedula(),residente.getNombre(),listaPagoAdmin.get(j).getFechaPago(),listaPagoAdmin.get(j).getValorPago(),listaPagoAdmin.get(j).isPagado()});
				}
				ppa.textCedula.setText(String.valueOf(residente.getCedula()));
				ppa.textNombre.setText(residente.getNombre());
				ppa.textCantidad.setText(String.valueOf(listaPagoAdmin.get(0).getValorPago()));
				
				
			
			
			break;
		case"Pagar Efectivo":
			formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			fecha=new Date();
			formatoFecha.format(fecha);
			JOptionPane.showMessageDialog(null, fecha);
			
			
			residente=admin.buscarResidente(admin.gestionarResidente().MostrarResidentes(),Integer.parseInt(ppa.textId.getText()));
			
			
			if(residente.pagarAdmin(Double.parseDouble(ppa.textCantidad.getText()), fecha,0,0,"Nada",0,null,"Efectivo").pagar()==true) {
				pagoConjunto =new PagoConjunto(fecha,Double.parseDouble(ppa.textCantidad.getText()));
				PCDAO= new PagoConjuntoDAO();
				PCDAO.savePagoAdmin(pagoConjunto, Integer.parseInt(ppa.textCantidad.getText()));
				CCDAO= new CuentaCorrienteDAO();
				CCDAO.ModificarCuentaCorriente(CC1);
				JOptionPane.showMessageDialog(null, "Has pagado con efectivo");
			}
			else {
				JOptionPane.showMessageDialog(null, "Pago en efectivo no realizado...");
			}
			break;
			
		case"Pagar Debito":
			formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			try {
				fecha=new Date();
				fecha=formatoFecha.parse(ppa.textFecha.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			residente= new Residente();
			
			
			//residente.pagarAdmin(Double.parseDouble(ppa.textCantidad.getText()), fecha);
			if(residente.pagarAdmin(Double.parseDouble(ppa.textCantidad.getText()), fecha,Integer.parseInt(ppa.textTarjeta.getText()),0,"",0,null,"Debito").pagar()==true) {
				/*pagoConjunto =new PagoConjunto(fecha,Double.parseDouble(ppa.textCantidad.getText()));
				PCDAO= new PagoConjuntoDAO();
				PCDAO.savePagoAdmin(pagoConjunto, Integer.parseInt(ppa.textCantidad.getText()));
				CCDAO= new CuentaCorrienteDAO();
				CCDAO.ModificarCuentaCorriente(CC1);*/
				JOptionPane.showMessageDialog(null, "Has realizado tu pago...gracias!!!");
			}
			else
				JOptionPane.showMessageDialog(null, "Sin saldo suficiente");
			break;
			
		case"Pagar Cheque":
			formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			try {
				fecha=new Date();
				fecha=formatoFecha.parse(ppa.textFecha.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			residente= new Residente();
			
			
			//residente.pagarAdmin(Double.parseDouble(ppa.textCantidad.getText()), fecha);
			if(residente.pagarAdmin(Double.parseDouble(ppa.textCantidad.getText()), fecha,0,Integer.parseInt(ppa.textCheque.getText()),ppa.textReceptorCheque.getText(),Integer.parseInt(ppa.textCuenta.getText()),null,"Cheque").pagar()==true) {
				/*pagoConjunto =new PagoConjunto(fecha,Double.parseDouble(ppa.textCantidad.getText()));
				PCDAO= new PagoConjuntoDAO();
				PCDAO.savePagoAdmin(pagoConjunto, Integer.parseInt(ppa.textCantidad.getText()));
				CCDAO= new CuentaCorrienteDAO();
				CCDAO.ModificarCuentaCorriente(CC1);*/
				JOptionPane.showMessageDialog(null, "Cheque girado...gracias!!!");
			}
			else
				JOptionPane.showMessageDialog(null, "Tu cheque no se ha girado");
			break;
		case "Pagar Online":
			formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			try {
				fecha=new Date();
				fecha=formatoFecha.parse(ppa.textFecha.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			residente= new Residente(Integer.parseInt(ppa.textCedula.getText()),ppa.textNombre.getText());
			
			
			if(residente.pagarAdmin(Double.parseDouble(ppa.textCantidad.getText()), fecha,Integer.parseInt(ppa.textTarjeta.getText()),0,"",0,residente,"Efectivo").pagar()==true) {
				/*pagoConjunto =new PagoConjunto(fecha,Double.parseDouble(ppa.textCantidad.getText()));
				PCDAO= new PagoConjuntoDAO();
				PCDAO.savePagoAdmin(pagoConjunto, Integer.parseInt(ppa.textCantidad.getText()));
				CCDAO= new CuentaCorrienteDAO();
				CCDAO.ModificarCuentaCorriente(CC1);*/
				JOptionPane.showMessageDialog(null, "Pago Online realizado");
			}
			else
				JOptionPane.showMessageDialog(null, "Pago Online no realizado...");
			break;
		case"Efectivo":
			ppa.textCedula.setEnabled(false);
			ppa.textNombre.setEnabled(false);
			ppa.textTarjeta.setEnabled(false);
			ppa.textCuenta.setEnabled(false);
			ppa.textReceptorCheque.setEnabled(false);
			ppa.textCheque.setEnabled(false);
			ppa.textCantidad.setEnabled(true);
			break;
		case"Debito":
			ppa.textCedula.setEnabled(false);
			ppa.textNombre.setEnabled(false);
			ppa.textTarjeta.setEnabled(true);
			ppa.textCuenta.setEnabled(false);
			ppa.textReceptorCheque.setEnabled(false);
			ppa.textCheque.setEnabled(false);
			ppa.textCantidad.setEnabled(true);
			break;
		case"Cheque":
			ppa.textCedula.setEnabled(false);
			ppa.textNombre.setEnabled(false);
			ppa.textTarjeta.setEnabled(false);
			ppa.textCuenta.setEnabled(true);
			ppa.textReceptorCheque.setEnabled(true);
			ppa.textCheque.setEnabled(true);
			ppa.textCantidad.setEnabled(true);
			break;
		case"Online":
			ppa.textCedula.setEnabled(false);
			ppa.textNombre.setEnabled(false);
			ppa.textTarjeta.setEnabled(true);
			ppa.textCuenta.setEnabled(false);
			ppa.textReceptorCheque.setEnabled(false);
			ppa.textCheque.setEnabled(false);
			ppa.textCantidad.setEnabled(true);
			break;
		case "Pagar":
			formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			fecha=new Date();
			formatoFecha.format(fecha);
			
			
			residente=admin.buscarResidente(admin.gestionarResidente().MostrarResidentes(),Integer.parseInt(ppa.textId.getText()));
			datosPago=new DatosPagoDTO(Double.parseDouble(ppa.textCantidad.getText()), fecha,Integer.parseInt(ppa.textTarjeta.getText()), Integer.parseInt(ppa.textCheque.getText()),ppa.textReceptorCheque.getText(),Integer.parseInt(ppa.textCuenta.getText()));
			String sel=ppa.grupoBoton.getSelection().getActionCommand();
			//residente.pagarAdmin(datosPago, residente, sel);
			
			JOptionPane.showMessageDialog(null,residente.pagarAdmin(datosPago, residente, sel).pagar());
			break;
					
		}
		
	}
	
	
	

}
