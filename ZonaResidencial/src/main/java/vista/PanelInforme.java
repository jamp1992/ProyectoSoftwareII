package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class PanelInforme extends JPanel{
	private static final long serialVersionUID = 1L;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
	private JDateChooser fechaDesde;
	private JDateChooser fechaHasta;

	public PanelInforme() {
		setBorder(null);
		setLayout(null);
		
		JButton MostrarPagoAdmin= new JButton("Informe pago administracion");
		MostrarPagoAdmin.setBounds(60, 10, 220, 20);
		add(MostrarPagoAdmin);
		
		JButton MostrarCuentaCorriente= new JButton("Informe pago mantenimiento");
		MostrarCuentaCorriente.setBounds(500, 10, 220, 20);
		add(MostrarCuentaCorriente);
		
		JLabel lblFechaDesde= new JLabel("Desde");
		lblFechaDesde.setBounds(10, 50, 50, 20);
		add(lblFechaDesde);
		
		fechaDesde = new JDateChooser();
		fechaDesde.setBounds(80,50,100,20);
		fechaDesde.getJCalendar();
		add(fechaDesde);
		
		JLabel lblFechaHasta= new JLabel("Hasta");
		lblFechaHasta.setBounds(320, 50, 50, 20);
		add(lblFechaHasta);
		
		
		fechaHasta = new JDateChooser();
		fechaHasta.setBounds(390,50,100,20);
		fechaHasta.getJCalendar();
		add(fechaHasta);
		
		JButton ButtonGenerarReporte= new JButton("Generar Reporte");
		ButtonGenerarReporte.setBounds(620, 50, 150, 20);
		add(ButtonGenerarReporte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 80, 765, 285);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Identificacion", "Torre","Apartamento","Valor","Fecha"
			}
		); 
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		//JOptionPane.showMessageDialog(null, c.);
	}


}
