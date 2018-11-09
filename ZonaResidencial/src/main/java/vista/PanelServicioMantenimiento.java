package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import controlador.ControladorPanelServicioMantenimiento;
import controlador.ControladorPanelTorre;

public class PanelServicioMantenimiento extends JPanel {

	public JTextField textDescripcion;
	public JTextField textCosto;
	public JTextField textId;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    
    public JDateChooser c;
	private static final long serialVersionUID = 1L;

	public PanelServicioMantenimiento() {
		setBorder(null);
		setLayout(null);
		
		JPanel panelmodificadorCrear = new JPanel();
		panelmodificadorCrear.setBorder(new TitledBorder(null, "Crear Servicio mantenimiento", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorCrear.setBounds(0, 0, 325, 365);
		add(panelmodificadorCrear);
		panelmodificadorCrear.setLayout(null);
		
	
		JLabel lblDescripcion= new JLabel("Descripcion");
		lblDescripcion.setBounds(100, 20, 100, 20);
		panelmodificadorCrear.add(lblDescripcion);
		textDescripcion= new JTextField();
		textDescripcion.setBounds(200, 20, 100, 20);
		textDescripcion.setEnabled(false);
		panelmodificadorCrear.add(textDescripcion);
		
		JLabel lblCosto= new JLabel("Costo");
		lblCosto.setBounds(100, 50, 100, 20);
		panelmodificadorCrear.add(lblCosto);
		textCosto= new JTextField();
		textCosto.setBounds(200, 50, 100, 20);
		textCosto.setEnabled(false);
		panelmodificadorCrear.add(textCosto);
		
	
		
		JButton btnCrearServicio= new JButton("Crear");
		btnCrearServicio.setBounds(10,20,70,20);
		btnCrearServicio.addActionListener(new ControladorPanelServicioMantenimiento(this));
		panelmodificadorCrear.add(btnCrearServicio);
		
		
		JButton btnGuardarServicioMantenimiento= new JButton("Guardar Servicio Mant.");
		btnGuardarServicioMantenimiento.setBounds(130,330,170,20);
		btnGuardarServicioMantenimiento.addActionListener(new ControladorPanelServicioMantenimiento(this));
		panelmodificadorCrear.add(btnGuardarServicioMantenimiento);
		
		//
		JButton btnBuscar = new JButton("Buscar Servicio");
		btnBuscar.setBounds(460, 11, 140, 20);
		add(btnBuscar);
		
		JLabel lbId = new JLabel("Id");
		lbId.setBounds(360, 15, 23, 20);
		add(lbId);
		
		textId = new JTextField();
		textId.setBounds(389, 12, 50, 20);
		add(textId);
		textId.setColumns(10);
		
		JButton btnMostrarServicioMantenimiento = new JButton("Mostrar Servicio");
		btnMostrarServicioMantenimiento.setBounds(620, 11, 140, 20);
		btnMostrarServicioMantenimiento.addActionListener(new ControladorPanelServicioMantenimiento(this));
		add(btnMostrarServicioMantenimiento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(330, 45, 450, 170);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"IdServicio", "Descripcion", "costo"
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
		panelmodificadorModificar.setBorder(new TitledBorder(null, "Modificar Servicio Mantenimiento", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorModificar.setBounds(330, 223, 450, 140);
		add(panelmodificadorModificar);
		panelmodificadorModificar.setLayout(null);
		
		
	}

}
