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


public class PanelParqueadero extends JPanel {
	
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textCedula;
	public JTextField textN_Apto;
	public JTextField textIdTorre;
	public JButton btnReservar;
	
	public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    public Object[][] datosResidente;
    public DefaultTableModel modeloTablaParqueadero;
    public JTable tableParqueadero;
    public JScrollPane scroll;
    

	public PanelParqueadero() {
		
		setBorder(null);
		setLayout(null);
                JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setBounds(0, 45, 677, 179);
		scrollPane.setBounds(5, 50, 430, 250);
		add(scrollPane);
    
		
		table = new JTable();
        modeloTabla = new DefaultTableModel(
	new Object[][] {
		{null, null, null, null, null, null, null},
	},
	new String[] {
		"ID_PARQUEADERO ", "ESTADO"
	}
);
        table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		
		JButton btnParqueaderos_Disponibles = new JButton("Parqueaderos_Disponibles");
		 btnParqueaderos_Disponibles.setBounds(50, 11, 280, 23);
		add( btnParqueaderos_Disponibles);
		
		
		JPanel paneldatos = new JPanel();
		paneldatos.setBorder(new TitledBorder(null, "Datos Residente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(80, 13, 255)));
		paneldatos.setBounds(450, 0, 325, 365);
		add(paneldatos);
		paneldatos.setLayout(null);
		
		JLabel lblNombre= new JLabel("Nombre");
		lblNombre.setBounds(30, 50, 100, 20);
		paneldatos.add(lblNombre);
		textNombre= new JTextField();
		textNombre.setBounds(90, 50, 200, 20);
		paneldatos.add(textNombre);
		
		JLabel lblApellido= new JLabel("Apellido");
		lblApellido.setBounds(30, 80, 100, 20);
		paneldatos.add(lblApellido);
		textApellido= new JTextField();
		textApellido.setBounds(90, 80, 200, 20);
		paneldatos.add(textApellido);
		
		JLabel lblCedula= new JLabel("Cedula");
		lblCedula.setBounds(30, 110, 100, 20);
		paneldatos.add(lblCedula);
		textCedula= new JTextField();
		textCedula.setBounds(90, 110, 200, 20);
		paneldatos.add(textCedula);
		
		
		JLabel lblNApto= new JLabel("N� Apto");
		lblNApto.setBounds(30, 140, 100, 20);
		paneldatos.add(lblNApto);
		textN_Apto= new JTextField();
		textN_Apto.setBounds(90, 140, 200, 20);
		paneldatos.add(textN_Apto);
		
		JLabel lblIdTorre= new JLabel("Id Torre");
		lblIdTorre.setBounds(30, 170, 100, 20);
		paneldatos.add(lblIdTorre);
		textIdTorre= new JTextField();
		textIdTorre.setBounds(90, 170, 200, 20);
		paneldatos.add(textIdTorre);
		
		
		
		
		JButton btnReservar= new JButton("RESERVAR");
		btnReservar.setBounds(90,230,200,20);
		paneldatos.add(btnReservar);
		
		
	}}     
		
             

