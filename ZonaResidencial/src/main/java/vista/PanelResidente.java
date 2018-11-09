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
import controlador.ControladorPanelResidente;

public class PanelResidente extends JPanel{
	public JTextField textCedula;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textUsuario;
	public JTextField textContrasena;
	public JTextField textValorAdmin;
	public JTextField textIdEstacionamiento;
	public JTextField textId;
	public JTextField textIdApto;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    public JScrollPane scrollEstacionamiento;
    public Object[][] datosEstacionamiento;
    public DefaultTableModel modeloTablaEstacionamiento;
    public JTable tableEstacionamiento;
    public JScrollPane scrollApto;
    public Object[][] datosApto;
    public DefaultTableModel modeloTablaApto;
    public JTable tableApto;
    
    public JDateChooser calendarioFechaAdquisicion;
    public JDateChooser calendarioFechaPagoAdmin;
	private static final long serialVersionUID = 1L;

	public PanelResidente() {
		setBorder(null);
		setLayout(null);
		
		JPanel panelmodificadorCrear = new JPanel();
		panelmodificadorCrear.setBorder(new TitledBorder(null, "Crear Residente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorCrear.setBounds(0, 0, 220, 365);
		add(panelmodificadorCrear);
		panelmodificadorCrear.setLayout(null);
		
		JButton btnCrearEmpleado= new JButton("Crear");
		btnCrearEmpleado.setBounds(10,20,70,20);
		panelmodificadorCrear.add(btnCrearEmpleado);
		
		JLabel lblCedula= new JLabel("Cedula");
		lblCedula.setBounds(10, 50, 100, 20);
		panelmodificadorCrear.add(lblCedula);
		textCedula= new JTextField();
		textCedula.setBounds(110, 50, 100, 20);
		panelmodificadorCrear.add(textCedula);
		
		JLabel lblNombre= new JLabel("Nombre");
		lblNombre.setBounds(10, 80, 100, 20);
		panelmodificadorCrear.add(lblNombre);
		textNombre= new JTextField();
		textNombre.setBounds(110, 80, 100, 20);
		panelmodificadorCrear.add(textNombre);
		
		JLabel lblApellido= new JLabel("Apellido");
		lblApellido.setBounds(10, 110, 100, 20);
		panelmodificadorCrear.add(lblApellido);
		textApellido= new JTextField();
		textApellido.setBounds(110, 110, 100, 20);
		panelmodificadorCrear.add(textApellido);
		
		JLabel lblUsuario= new JLabel("Usuario");
		lblUsuario.setBounds(10, 140, 100, 20);
		panelmodificadorCrear.add(lblUsuario);
		textUsuario= new JTextField();
		textUsuario.setBounds(110, 140, 100, 20);
		panelmodificadorCrear.add(textUsuario);
		
		JLabel lblContrasena= new JLabel("Contrase�a");
		lblContrasena.setBounds(10, 170, 100, 20);
		panelmodificadorCrear.add(lblContrasena);
		textContrasena= new JTextField();
		textContrasena.setBounds(110, 170, 100, 20);
		panelmodificadorCrear.add(textContrasena);
		
		JLabel lblFechaAdquisicionApto= new JLabel("Fecha adquisicion apto");
		lblFechaAdquisicionApto.setBounds(10, 200, 100, 20);
		panelmodificadorCrear.add(lblFechaAdquisicionApto);
		calendarioFechaAdquisicion = new JDateChooser();
		calendarioFechaAdquisicion.setBounds(110,200,100,20);
		calendarioFechaAdquisicion.getJCalendar();
		panelmodificadorCrear.add(calendarioFechaAdquisicion);
		
		
		JLabel lblFechaPagoAdmin= new JLabel("Fecha pago admin");
		lblFechaPagoAdmin.setBounds(10, 230, 100, 20);
		panelmodificadorCrear.add(lblFechaPagoAdmin);
		calendarioFechaPagoAdmin = new JDateChooser();
		calendarioFechaPagoAdmin.setBounds(110,230,100,20);
		calendarioFechaPagoAdmin.getJCalendar();
		panelmodificadorCrear.add(calendarioFechaPagoAdmin);
		
		
		JLabel lblValorAdmin= new JLabel("Valor Admin");
		lblValorAdmin.setBounds(10, 260, 100, 20);
		panelmodificadorCrear.add(lblValorAdmin);
		textValorAdmin= new JTextField();
		textValorAdmin.setBounds(110, 260, 100, 20);
		panelmodificadorCrear.add(textValorAdmin);
		
		JLabel lblIdEstacionamiento= new JLabel("Id Estacionamiento");
		lblIdEstacionamiento.setBounds(10, 290, 100, 20);
		panelmodificadorCrear.add(lblIdEstacionamiento);
		textIdEstacionamiento= new JTextField();
		textIdEstacionamiento.setBounds(110, 290, 100, 20);
		textIdEstacionamiento.setEnabled(false);
		panelmodificadorCrear.add(textIdEstacionamiento);
		
		JLabel lblIdApto= new JLabel("Id Apto");
		lblIdApto.setBounds(10, 320, 100, 20);
		panelmodificadorCrear.add(lblIdApto);
		textIdApto= new JTextField();
		textIdApto.setBounds(110, 320, 100, 20);
		textIdApto.setEnabled(false);
		panelmodificadorCrear.add(textIdApto);
		
		JButton btnGuardarResidente= new JButton("Registrar");
		btnGuardarResidente.setBounds(110, 20, 100, 20);
		btnGuardarResidente.addActionListener(new ControladorPanelResidente(this));
		panelmodificadorCrear.add(btnGuardarResidente);
		
		
		//
		JButton btnBuscar = new JButton("Buscar Residente");
		btnBuscar.setBounds(330, 11, 140, 20);
		btnBuscar.addActionListener(new ControladorPanelResidente(this));
		add(btnBuscar);
		
		JLabel lbId = new JLabel("Id");
		lbId.setBounds(230, 15, 23, 20);
		add(lbId);
		
		textId = new JTextField();
		textId.setBounds(259, 12, 50, 20);
		add(textId);
		textId.setColumns(10);
		
		JButton btnMostrar = new JButton("Listar residente");
		btnMostrar.setBounds(480, 11, 140, 20);
		btnMostrar.addActionListener(new ControladorPanelResidente(this));
		add(btnMostrar);
		
		JButton btnEliminar = new JButton("Eliminar residente");
		btnEliminar.setBounds(630, 11, 140, 20);
		btnEliminar.addActionListener(new ControladorPanelResidente(this));
		add(btnEliminar);
		
		
		//Tabla residentes
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(225, 45, 555, 170);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null,null,null,null},
			},
			new String[] {
				"Cedula", "Nombre", "Apellido","Usuario","Contrasena","F.A. Apto","Propietario","F.P. Admin","Valor Admin","idEstacionamiento","idApto"
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
		
		JButton btnMostrarEstacionamiento = new JButton("Listar Estacionamiento");
		btnMostrarEstacionamiento.setBounds(225, 223, 150, 20);
		btnMostrarEstacionamiento.addActionListener(new ControladorPanelResidente(this));
		add(btnMostrarEstacionamiento);
		
		/*JButton btnMostrarEstacionamientoDisponible = new JButton("Mostrar Dispo.");
		btnMostrarEstacionamientoDisponible.setBounds(342, 233, 120, 20);
		btnMostrarEstacionamientoDisponible.addActionListener(new ControladorPanelResidente(this));
		add(btnMostrarEstacionamientoDisponible);*/
		
		JScrollPane scrollPaneEstacionamiento = new JScrollPane();
		scrollPaneEstacionamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEstacionamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneEstacionamiento.setBounds(225, 253, 150, 110);
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
		//textIdEstacionamiento.setText(String.valueOf(modeloTablaEstacionamiento.getValueAt(table.getSelectedRow(), 0)));
		
		//Tabla Aptos
		JButton btnMostrarApto = new JButton("Listar Aptos");
		btnMostrarApto.setBounds(385, 223, 150, 20);
		btnMostrarApto.addActionListener(new ControladorPanelResidente(this));
		add(btnMostrarApto);
		
		JScrollPane scrollPaneApto = new JScrollPane();
		scrollPaneApto.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneApto.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneApto.setBounds(385, 253, 395, 110);
		add(scrollPaneApto);
		
                tableApto = new JTable();
                modeloTablaApto = new DefaultTableModel(
                		new Object[][] {
            				{null, null, null, null, null},
            			},
            			new String[] {
            				"idApto", "Estado","# Apto","Valor","Descripcion"
            			}
		); 
		tableApto.setForeground(new Color(0, 0, 0));
		tableApto.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableApto.setBackground(new Color(255, 255, 0));
		tableApto.setModel(modeloTablaApto);
		tableApto.getColumnModel().getColumn(0).setPreferredWidth(64);
		tableApto.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneApto.setViewportView(tableApto);
		
		JButton btnSeleccionar = new JButton("Seleccionar Apto y Estacionamiento");
		btnSeleccionar.setBounds(545, 223, 233, 20);
		btnSeleccionar.addActionListener(new ControladorPanelResidente(this));
		add(btnSeleccionar);
		
	}

}
