package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.persona.AuxAdministrativo;
import modelo.persona.Residente;
import modelo.persona.Vigilante;
import modelo.factorymethod.NotificacionDAO;
import modelo.singleton.AdministradorSingleton;
import vista.InterfazAdministrador;
import vista.InterfazCliente;
import vista.PanelLogin;

public class ControladorPanelLogin implements ActionListener{

	private PanelLogin pl;
	private NotificacionDAO NDAO= new NotificacionDAO();
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	private AuxAdministrativo auxAdmin=new AuxAdministrativo();
	private Vigilante vigilante=new Vigilante();
	private Residente residente= new Residente();
	
	public ControladorPanelLogin(PanelLogin pl) {
		this.pl = pl;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case "Ingresar":
			
			if(pl.rol.getSelectedItem().toString()=="Administrador") {
				if(admin.ingresarSistema(pl.textusuario.getText(), pl.pwcontrasena.getText(),admin.getUsuario(),admin.getContrasena())==true){
					InterfazAdministrador frame = new InterfazAdministrador();
					frame.setVisible(true);
					this.pl.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Administrador invalido");
				}
			}
			else if(pl.rol.getSelectedItem().toString()=="AuxAdministrador") {
				if(auxAdmin.ingresarSistema(pl.textusuario.getText(), pl.pwcontrasena.getText(), admin.gestionarEmpleado().MostrarAuxiliaresAdmin())==true){
					auxAdmin.cobrarAdmin(admin.gestionarResidente().MostrarResidentes());
					InterfazAdministrador frame = new InterfazAdministrador();
					frame.setVisible(true);
					this.pl.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Administrador invalido");
				}
			}
			else if(pl.rol.getSelectedItem().toString()=="Vigilante") {
				if(vigilante.ingresarSistema(pl.textusuario.getText(), pl.pwcontrasena.getText(), admin.gestionarEmpleado().MostrarVigilantes())==true);
				InterfazAdministrador frame = new InterfazAdministrador();
				frame.setVisible(true);
				this.pl.dispose();
			}
			else if(pl.rol.getSelectedItem().toString()=="Cliente") {
				if(residente.ingresarSistema(pl.textusuario.getText(), pl.pwcontrasena.getText(), admin.gestionarResidente().MostrarResidentes())==true) {
					InterfazCliente frame= new InterfazCliente();
					frame.setVisible(true);
					this.pl.dispose();
					residente.RevisarNotificacion(NDAO, admin.gestionarResidente().MostrarResidentes(), pl.textusuario.getText(),pl.pwcontrasena.getText());
				}
				
			}
			
				
			break;
		}
		
		
	}

}
