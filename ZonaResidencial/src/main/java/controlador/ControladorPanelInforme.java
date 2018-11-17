package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.singleton.AdministradorSingleton;
import vista.PanelInforme;

public class ControladorPanelInforme implements ActionListener {
	private PanelInforme pi;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	public ControladorPanelInforme(PanelInforme pi) {
		this.pi=pi;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case"Generar Reporte":
			admin.solicitarInformePagoAdmin();
			
			break;
		}
		
	}

}
