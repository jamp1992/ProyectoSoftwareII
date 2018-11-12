package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class PanelAsignacion_Parqueadero extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField textCedula;
	public JTextField textNombre;
	public JTextField textApellido;
	public JScrollPane scroll;
	public Object[][] datos;
	public DefaultTableModel modeloTabla;
	public JTable table;
	 public JDateChooser Fecha_Entrada;
	public PanelAsignacion_Parqueadero() {

		setBorder(null);
		setLayout(null);

		JButton btnBuscarParqueaderosDisponibles = new JButton("Buscar Parquederos Disponibles");
		btnBuscarParqueaderosDisponibles.setBounds(50, 11, 280, 23);
		add(btnBuscarParqueaderosDisponibles);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 50, 400, 310);
		add(scrollPane);

		table = new JTable();
		modeloTabla = new DefaultTableModel(new Object[][] { { null, null }, },
				new String[] { "ID_PARQUEADERO", "ESTADO" });

		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblDatos= new JLabel("*** DATOS VISITANTE ***");
		lblDatos.setBounds(530, 11, 280, 20);
		add(lblDatos);
		
		JLabel lblCedula= new JLabel("Cedula");
		lblCedula.setBounds(480, 80, 280, 20);
		add(lblCedula);
		
		textCedula = new JTextField ();
		textCedula.setBounds(580, 80, 200, 20);
		add(textCedula);
		
		
		JLabel lblNombre= new JLabel("Nombre");
		lblNombre.setBounds(480, 110, 280, 20);
		add(lblNombre);
		
		textNombre = new JTextField ();
		textNombre.setBounds(580, 110, 200, 20);
		add(textNombre);
		
		JLabel lblApellido= new JLabel("Apellido");
		lblApellido.setBounds(480, 140, 280, 20);
		add(lblApellido);
		
		textApellido = new JTextField ();
		textApellido.setBounds(580, 140, 200, 20);
		add(textApellido);
		
		
		JLabel lblFecha_Entrada= new JLabel("Fecha_Entrada");
		lblFecha_Entrada.setBounds(480, 170, 280, 20);
		add(lblFecha_Entrada);
		Fecha_Entrada = new JDateChooser();
		Fecha_Entrada.setBounds(580, 170,200,20);
		Fecha_Entrada.getJCalendar();
		add(Fecha_Entrada);
		
		
		
		JButton btnRegistarEntrada = new JButton("REGISTRAR VISITANTE");
		btnRegistarEntrada.setBounds(550, 250, 200, 23);
		add(btnRegistarEntrada);
		
		JButton btnModificarEntrada = new JButton("MODIFICAR VISITANTE");
		btnModificarEntrada.setBounds(550, 280, 200, 23);
		add(btnModificarEntrada);
		
		JButton btnEliminarEntrada = new JButton("ELIMINAR VISITANTE");
		btnEliminarEntrada.setBounds(550, 310, 200, 23);
		add(btnEliminarEntrada);

	}

}
