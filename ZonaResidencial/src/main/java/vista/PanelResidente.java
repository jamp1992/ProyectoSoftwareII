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

public class PanelResidente extends JPanel{
	public JTextField textCedula;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textUsuario;
	public JTextField textContrasena;
	public JTextField textFechaAdquisicionApto;
	public JTextField textFechaPagoAdmin;
	public JTextField textValorAdmin;
	public JTextField textIdEstacionamiento;
	public JTextField textId;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    public JScrollPane scrollEstacionamiento;
    public Object[][] datosEstacionamiento;
    public DefaultTableModel modeloTablaEstacionamiento;
    public JTable tableEstacionamiento;
	private static final long serialVersionUID = 1L;

	public PanelResidente() {
		setBorder(null);
		setLayout(null);
		
		JPanel panelmodificadorCrear = new JPanel();
		panelmodificadorCrear.setBorder(new TitledBorder(null, "Crear Residente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorCrear.setBounds(0, 0, 325, 365);
		add(panelmodificadorCrear);
		panelmodificadorCrear.setLayout(null);
		
		JButton btnCrearEmpleado= new JButton("Crear");
		btnCrearEmpleado.setBounds(10,20,70,20);
		panelmodificadorCrear.add(btnCrearEmpleado);
		
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
		
		JLabel lblUsuario= new JLabel("Usuario");
		lblUsuario.setBounds(100, 110, 100, 20);
		panelmodificadorCrear.add(lblUsuario);
		textUsuario= new JTextField();
		textUsuario.setBounds(200, 110, 100, 20);
		panelmodificadorCrear.add(textUsuario);
		
		JLabel lblContrasena= new JLabel("Contraseña");
		lblContrasena.setBounds(100, 140, 100, 20);
		panelmodificadorCrear.add(lblContrasena);
		textContrasena= new JTextField();
		textContrasena.setBounds(200, 140, 100, 20);
		panelmodificadorCrear.add(textContrasena);
		
		JLabel lblFechaAdquisicionApto= new JLabel("Fecha adquisicion apto");
		lblFechaAdquisicionApto.setBounds(100, 170, 100, 20);
		panelmodificadorCrear.add(lblFechaAdquisicionApto);
		textFechaAdquisicionApto= new JTextField();
		textFechaAdquisicionApto.setBounds(200, 170, 100, 20);
		panelmodificadorCrear.add(textFechaAdquisicionApto);
		
		JLabel lblFechaPagoAdmin= new JLabel("Fecha pago admin");
		lblFechaPagoAdmin.setBounds(100, 200, 100, 20);
		panelmodificadorCrear.add(lblFechaPagoAdmin);
		textFechaPagoAdmin= new JTextField();
		textFechaPagoAdmin.setBounds(200, 200, 100, 20);
		panelmodificadorCrear.add(textFechaPagoAdmin);
		
		JLabel lblValorAdmin= new JLabel("Valor Admin");
		lblValorAdmin.setBounds(100, 230, 100, 20);
		panelmodificadorCrear.add(lblValorAdmin);
		textValorAdmin= new JTextField();
		textValorAdmin.setBounds(200, 230, 100, 20);
		panelmodificadorCrear.add(textValorAdmin);
		
		JLabel lblIdEstacionamiento= new JLabel("Id Estacionamiento");
		lblIdEstacionamiento.setBounds(100, 260, 100, 20);
		panelmodificadorCrear.add(lblIdEstacionamiento);
		textIdEstacionamiento= new JTextField();
		textIdEstacionamiento.setBounds(200, 260, 100, 20);
		panelmodificadorCrear.add(textIdEstacionamiento);
		
		JButton btnGuardarResidente= new JButton("Registrar Residente");
		btnGuardarResidente.setBounds(150, 330, 150, 20);
		panelmodificadorCrear.add(btnGuardarResidente);
		//
		JButton btnBuscar = new JButton("Buscar Residente");
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
				{null, null, null, null, null, null,null,null,null},
			},
			new String[] {
				"Cedula", "Nombre", "Apellido","Usuario","Contrasena","F.A. Apto","Propietario","F.P. Admin","Valor Admin"
			}
		); 
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		//Tabla estacionamiento
		
		JButton btnMostrarEstacionamiento = new JButton("Mostrar Todo");
		btnMostrarEstacionamiento.setBounds(330, 233, 120, 20);
		add(btnMostrarEstacionamiento);
		
		JButton btnMostrarEstacionamientoDisponible = new JButton("Mostrar Dispo.");
		btnMostrarEstacionamientoDisponible.setBounds(452, 233, 120, 20);
		add(btnMostrarEstacionamientoDisponible);
		
		JScrollPane scrollPaneEstacionamiento = new JScrollPane();
		scrollPaneEstacionamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEstacionamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneEstacionamiento.setBounds(330, 263, 245, 100);
		add(scrollPaneEstacionamiento);
		
                tableEstacionamiento = new JTable();
                modeloTablaEstacionamiento = new DefaultTableModel(
			new Object[][] {
				{null, null,null},
			},
			new String[] {
				"IdEstacionamiento", "Estado"
			}
		); 
		tableEstacionamiento.setForeground(new Color(0, 0, 0));
		tableEstacionamiento.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableEstacionamiento.setBackground(new Color(255, 255, 0));
		tableEstacionamiento.setModel(modeloTablaEstacionamiento);
		tableEstacionamiento.getColumnModel().getColumn(0).setPreferredWidth(64);
		tableEstacionamiento.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneEstacionamiento.setViewportView(tableEstacionamiento);
		
		
		
		JPanel panelmodificadorModificar = new JPanel();
		panelmodificadorModificar.setBorder(new TitledBorder(null, "Modificar Residente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorModificar.setBounds(580, 223, 200, 140);
		add(panelmodificadorModificar);
		panelmodificadorModificar.setLayout(null);
		
		
		
	}

}
