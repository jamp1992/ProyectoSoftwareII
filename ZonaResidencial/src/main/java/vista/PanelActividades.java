package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPanelActividades;



public class PanelActividades extends JPanel{
	private static final long serialVersionUID = 1L;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    
    public JScrollPane scrollPago;
    public Object[][] datosPago;
    public DefaultTableModel modeloTablaPago;
    public JTable tablePago;
    
	public JComboBox comboBoxOpcTorre;
	public JButton mostrarResidente,mostrarPagoAdmin;
	
	public PanelActividades() {
		setBorder(null);
		setLayout(null);
		
		mostrarResidente= new JButton("Listar residente");
		mostrarResidente.setBounds(10, 10, 220, 20);
		mostrarResidente.setName("Listar");
		mostrarResidente.addActionListener(new ControladorPanelActividades(this));
		add(mostrarResidente);
		
		mostrarPagoAdmin= new JButton("Listar pagos residente");
		mostrarPagoAdmin.setBounds(10, 200, 220, 20);
		mostrarPagoAdmin.addActionListener(new ControladorPanelActividades(this));
		add(mostrarPagoAdmin);
		
		JButton ButtonGenerarNotificacion= new JButton("Notificar Cliente");
		ButtonGenerarNotificacion.setBounds(520, 10, 150, 20);
		ButtonGenerarNotificacion.addActionListener(new ControladorPanelActividades(this));
		add(ButtonGenerarNotificacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 40, 768, 150);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Cedula", "Nombre", "Apellido","Fecha pago admin","Valor admin"
			}
		); 
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPanePago = new JScrollPane();
		scrollPanePago.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanePago.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanePago.setBounds(10, 230, 768, 140);
		add(scrollPanePago);
		
                tablePago = new JTable();
                modeloTablaPago = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id pago", "Valor pago", "Fecha pago","Pagado"
			}
		); 
		tablePago.setForeground(new Color(0, 0, 0));
		tablePago.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tablePago.setBackground(new Color(255, 255, 0));
		tablePago.setModel(modeloTablaPago);
		tablePago.getColumnModel().getColumn(0).setPreferredWidth(64);
		tablePago.getColumnModel().getColumn(2).setResizable(false);
		scrollPanePago.setViewportView(tablePago);
		
		
	}
}
