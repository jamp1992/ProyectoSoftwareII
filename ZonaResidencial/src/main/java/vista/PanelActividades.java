package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;



public class PanelActividades extends JPanel{
	private static final long serialVersionUID = 1L;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
	public JTextArea areaComentario;
	
	public PanelActividades() {
		setBorder(null);
		setLayout(null);
		
		JButton MostrarPagoAdmin= new JButton("Listar pago residente");
		MostrarPagoAdmin.setBounds(10, 10, 220, 20);
		add(MostrarPagoAdmin);
		
		JButton ButtonGenerarReporte= new JButton("Enviar notificacion");
		ButtonGenerarReporte.setBounds(520, 10, 150, 20);
		add(ButtonGenerarReporte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 50, 500, 310);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Identificacion", "Torre","Apartamento","Valor","Fecha pago","Pagado"
			}
		); 
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		areaComentario = new JTextArea(10,1);
		areaComentario.setBounds(520, 50, 250, 50);
		areaComentario.setLineWrap(true);
		areaComentario.setWrapStyleWord(true);
		add(areaComentario);
	}
}
