package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import controlador.ControladorPanelLogin;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelLogin extends JFrame {

	public JPanel contentPane;
	public JPasswordField pwcontrasena;
	public JTextField textusuario;
	public JComboBox<String> rol;
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					PanelLogin frame = new PanelLogin();
					frame.setVisible(true);
                                       
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PanelLogin() {
		setTitle("\t\t\t\t\t\t\t\tLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Login Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiquetas de texto
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(20, 46, 46, 14);
		contentPane.add(lblUsuario);
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(20, 79, 70, 14);
		contentPane.add(lblContrasea);
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(20, 112, 70, 14);
		contentPane.add(lblRol);
		
		//Cuadros de texto
		textusuario = new JTextField();
		textusuario.setBounds(100, 40, 129, 23);
		contentPane.add(textusuario);
		pwcontrasena = new JPasswordField();
		pwcontrasena.setEchoChar('#');
		pwcontrasena.setBounds(100, 75, 129, 23);
		contentPane.add(pwcontrasena);
		rol= new JComboBox<String>();
		rol.setBounds(100,110,129,23);
		rol.addItem("Administrador");
		rol.addItem("AuxAdministrador");
		rol.addItem("Vigilante");
		rol.addItem("Cliente");
		contentPane.add(rol);
		
		//Boton ingresar
		JButton btnentrar = new JButton("Ingresar");       
		btnentrar.setBounds(235, 110, 100, 23);
		btnentrar.addActionListener(new ControladorPanelLogin(this));
		contentPane.add(btnentrar);
		
	}
	
}
