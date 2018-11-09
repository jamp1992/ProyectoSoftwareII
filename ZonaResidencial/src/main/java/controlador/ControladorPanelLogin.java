package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.persona.AuxAdministrativo;
import modelo.singleton.AdministradorSingleton;
import vista.InterfazAdministrador;
import vista.PanelLogin;

public class ControladorPanelLogin implements ActionListener{

	private PanelLogin pl;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	
	public ControladorPanelLogin(PanelLogin pl) {
		this.pl = pl;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case "Ingresar":
			admin.gestionarResidente().MostrarResidentes();
			AuxAdministrativo aa= new AuxAdministrativo();
			aa.cobrarAdmin(admin.gestionarResidente().MostrarResidentes());
			
			/*JOptionPane.showMessageDialog(null, admin.getContrasena()+" shsshshhssh"+pl.pwcontrasena.getText());
			if(admin.ingresarSistema(pl.textusuario.getText(), pl.pwcontrasena.getText(),admin.getUsuario(),admin.getContrasena())==true)
			{
				InterfazAdministrador frame = new InterfazAdministrador();
				frame.setVisible(true);
				this.pl.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario invalido");
			}*/
				
			break;
		}
		
		
	}

}
