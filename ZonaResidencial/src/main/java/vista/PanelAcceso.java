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

public class PanelAcceso extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public JScrollPane scroll;
    public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    public JTextField textNombre;
	public JTextField textEstado;
	public JTextField textHora;
	
    
    public PanelAcceso () {
    	setBorder(null);
		setLayout(null);
		
		JButton Residente= new JButton("Residente");
		Residente.setBounds(10, 10, 150, 20);
		add(Residente);
		
		JButton Buscar = new JButton("Buscar");
		Buscar.setBounds(400, 10, 150, 20);
		add(Buscar);
		
	
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(10, 80, 80, 20);
		add(lbNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(70, 80, 150, 20);
		add(textNombre);
	
		
		
		
    }

}
