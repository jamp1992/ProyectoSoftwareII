package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controlador.ControladorPanelEmpleado;

public class PanelEmpleado extends JPanel {
	public JTextField textCedula;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textFechaIngreso;
	public JTextField textUsuario;
	public JTextField textContrasena;
	public JTextField textId;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    
    public JDateChooser c;
	private static final long serialVersionUID = 1L;

	public PanelEmpleado() {
		setBorder(null);
		setLayout(null);
		
		JPanel panelmodificadorCrear = new JPanel();
		panelmodificadorCrear.setBorder(new TitledBorder(null, "Crear Empleado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorCrear.setBounds(0, 0, 325, 365);
		add(panelmodificadorCrear);
		panelmodificadorCrear.setLayout(null);
		
	
		JLabel lblCedula= new JLabel("Cedula");
		lblCedula.setBounds(100, 20, 100, 20);
		panelmodificadorCrear.add(lblCedula);
		textCedula= new JTextField();
		textCedula.setBounds(200, 20, 100, 20);
		panelmodificadorCrear.add(textCedula);
		
		JLabel lblNombre= new JLabel("Nombre");
		lblNombre.setBounds(100, 50, 100, 20);
		panelmodificadorCrear.add(lblNombre);
		textNombre= new JTextField();
		textNombre.setBounds(200, 50, 100, 20);
		panelmodificadorCrear.add(textNombre);
		
		JLabel lblApellido= new JLabel("Apellido");
		lblApellido.setBounds(100, 80, 100, 20);
		panelmodificadorCrear.add(lblApellido);
		textApellido= new JTextField();
		textApellido.setBounds(200, 80, 100, 20);
		panelmodificadorCrear.add(textApellido);
		
		JLabel lblFechaIngreso= new JLabel("Fecha de ingreso");
		lblFechaIngreso.setBounds(100, 110, 100, 20);
		panelmodificadorCrear.add(lblFechaIngreso);
		c = new JDateChooser();
		c.setBounds(200,110,100,20);
		c.getJCalendar();
		panelmodificadorCrear.add(c);
		
		/*textFechaIngreso= new JTextField();
		textFechaIngreso.setBounds(200, 110, 100, 20);
		panelmodificadorCrear.add(textFechaIngreso);*/
		
		JLabel lblUsuario= new JLabel("Usuario");
		lblUsuario.setBounds(100, 140, 100, 20);
		panelmodificadorCrear.add(lblUsuario);
		textUsuario= new JTextField();
		textUsuario.setBounds(200, 140, 100, 20);
		panelmodificadorCrear.add(textUsuario);
		
		JLabel lblContrasena= new JLabel("Contraseña");
		lblContrasena.setBounds(100, 170, 100, 20);
		panelmodificadorCrear.add(lblContrasena);
		textContrasena= new JTextField();
		textContrasena.setBounds(200, 170, 100, 20);
		panelmodificadorCrear.add(textContrasena);
		
		JButton btnCrearEmpleado= new JButton("Crear");
		btnCrearEmpleado.setBounds(10,20,70,20);
		panelmodificadorCrear.add(btnCrearEmpleado);
		
		JButton btnGuardarAuxAdministrativo= new JButton("Guardar Aux. Admin");
		btnGuardarAuxAdministrativo.setBounds(130, 270, 170, 20);
		btnGuardarAuxAdministrativo.addActionListener(new ControladorPanelEmpleado(this));
		panelmodificadorCrear.add(btnGuardarAuxAdministrativo);
		
		JButton btnGuardarVigilante= new JButton("Guardar Vigilante");
		btnGuardarVigilante.setBounds(130, 300, 170, 20);
		panelmodificadorCrear.add(btnGuardarVigilante);
		
		JButton btnGuardarPersonalMantenimiento= new JButton("Guardar Personal Mant.");
		btnGuardarPersonalMantenimiento.setBounds(130,330,170,20);
		panelmodificadorCrear.add(btnGuardarPersonalMantenimiento);
		
		//
		JButton btnBuscar = new JButton("Buscar Empleado");
		btnBuscar.setBounds(460, 11, 140, 20);
		add(btnBuscar);
		
		JLabel lbId = new JLabel("Id");
		lbId.setBounds(360, 15, 23, 20);
		add(lbId);
		
		textId = new JTextField();
		textId.setBounds(389, 12, 50, 20);
		add(textId);
		textId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(330, 45, 450, 170);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Cedula", "Nombre", "Apellido","Usuario","Contrasena","F. Ingreso"
			}
		); 
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		JPanel panelmodificadorModificar = new JPanel();
		panelmodificadorModificar.setBorder(new TitledBorder(null, "Modificar Empleado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorModificar.setBounds(330, 223, 450, 140);
		add(panelmodificadorModificar);
		panelmodificadorModificar.setLayout(null);
		
		
	}
}
