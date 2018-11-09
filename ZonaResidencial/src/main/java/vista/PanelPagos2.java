package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class PanelPagos2 extends JPanel {
	
	public Object[][] datos;
	public DefaultTableModel modeloTabla;
	public JTable table;
	public Object[][] datosResidente;
	public DefaultTableModel modeloTablaMantenimiento;
	public JTable tableMantenimiento;
	public JScrollPane scroll;

	
private static final long serialVersionUID = 1L;
	


	public PanelPagos2() {
		
		setBorder(null);
		setLayout(null);
		
    JScrollPane scrollPane = new JScrollPane();
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	//scrollPane.setBounds(0, 45, 677, 179);
	scrollPane.setBounds(10, 20, 750, 200);
	add(scrollPane);

	
	table = new JTable();
   modeloTabla = new DefaultTableModel(
new Object[][] {
	{null, null, null, null, null, null, null},
},
new String[] {
	"Nombre ","Cedula","N° Apto", "Id_Torre", "Administración", "Mantenimiento"
}
);
   table.setForeground(new Color(0, 0, 0));
	table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	table.setBackground(new Color(255, 255, 0));
	table.setModel(modeloTabla);
	table.getColumnModel().getColumn(0).setPreferredWidth(64);
	table.getColumnModel().getColumn(2).setResizable(false);
	scrollPane.setViewportView(table);
	
	
	
	
	JLabel lblMedioDePago= new JLabel("Medio de pago");
	lblMedioDePago.setBounds(30, 200, 150, 100);
	add(lblMedioDePago);
	
	JRadioButton rbEfectivo= new JRadioButton("Efectivo");
	rbEfectivo.setBounds(200, 220, 80, 100);
	add(rbEfectivo);
	
	JRadioButton rbTajetaDebito= new JRadioButton("Tajeta Debito");
	rbTajetaDebito.setBounds(300, 220, 150, 100);
	add(rbTajetaDebito);
	
	JRadioButton rbCheque= new JRadioButton("Cheque");
	rbCheque.setBounds(450, 220, 150, 100);
	add(rbCheque);
	
	JButton btnGenerarPago = new JButton("Generar Pago");
	 btnGenerarPago.setBounds(600, 330, 150, 23);
	add( btnGenerarPago);
	
	
	
	JButton btnVolver = new JButton("Volver");
	 btnVolver.setBounds(20, 330, 150, 23);
	add( btnVolver);
	}
	
	

}
