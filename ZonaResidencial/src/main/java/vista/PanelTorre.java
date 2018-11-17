package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPanelTorre;




public class PanelTorre extends JPanel {
	
	public JTextField textid;
	public JTextField textNombre;
	public JTextField textNumeroPisos;
	public JTextField textNumeroAptos;
	public JTextField textPosicionX;
	public JTextField textPosicionY;
	public JButton btnMostrarApto;
        public JScrollPane scroll;
        public Object[][] datos;
        public DefaultTableModel modeloTabla;
        public JTable table;
        public Object[][] datosApto;
        public DefaultTableModel modeloTablaApto;
        public JTable tableApto;
        
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelTorre() {
		
		setBorder(null);
		setLayout(null);
                JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setBounds(0, 45, 677, 179);
		scrollPane.setBounds(0, 45, 280, 179);
		add(scrollPane);
		
                table = new JTable();
                modeloTabla = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"idTorre", "Nombre", "PosicionX","PosicionY"
			}
		); 
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPaneApto = new JScrollPane();
		scrollPaneApto.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneApto.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setBounds(0, 45, 677, 179);
		scrollPaneApto.setBounds(284, 45, 498, 179);
		add(scrollPaneApto);
		
                tableApto = new JTable();
                modeloTablaApto = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"idApto", "Estado","# Apto","Valor","Descripcion","Largo","Ancho","m2"
			}
		); 
		tableApto.setForeground(new Color(0, 0, 0));
		tableApto.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableApto.setBackground(new Color(255, 255, 0));
		tableApto.setModel(modeloTablaApto);
		tableApto.getColumnModel().getColumn(0).setPreferredWidth(64);
		tableApto.getColumnModel().getColumn(2).setResizable(false);
		scrollPaneApto.setViewportView(tableApto);
		
		
		JButton btnBuscar = new JButton("Buscar Torre");
		btnBuscar.setActionCommand("mTorre");
		btnBuscar.setBounds(110, 11, 120, 23);
		btnBuscar.addActionListener(new ControladorPanelTorre(this));
		add(btnBuscar);
		
		JLabel lbid = new JLabel("Id");
		lbid.setBounds(10, 15, 23, 14);
		add(lbid);
		
		textid = new JTextField();
		textid.setBounds(29, 12, 50, 20);
		add(textid);
		textid.setColumns(10);
		
		btnMostrarApto = new JButton("Mostrar Aptos");
		btnMostrarApto.setActionCommand("mApto");
		btnMostrarApto.setBounds(655, 11, 120, 23);
		btnMostrarApto.addActionListener(new ControladorPanelTorre(this));
		btnMostrarApto.setEnabled(false);
		add(btnMostrarApto);
                
		
		JButton btnMostrarTorre = new JButton("Mostrar Torres");
		btnMostrarTorre.setBounds(240, 11, 130, 23);
		btnMostrarTorre.addActionListener(new ControladorPanelTorre(this));
		add(btnMostrarTorre);
                
                
		
		JPanel panelmodificadorCrear = new JPanel();
		panelmodificadorCrear.setBorder(new TitledBorder(null, "Crear Torre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorCrear.setBounds(0, 223, 498, 140);
		add(panelmodificadorCrear);
		panelmodificadorCrear.setLayout(null);
		
		JButton crearTorre= new JButton("Crear");
		crearTorre.setBounds(10, 23, 89, 23);
		crearTorre.addActionListener(new ControladorPanelTorre(this));
		panelmodificadorCrear.add(crearTorre);
		                         
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(120, 75, 89, 14);
		panelmodificadorCrear.add(lbNombre);
		
		JLabel lbNumeroApto = new JLabel("No Aptos");
		lbNumeroApto.setBounds(120, 51, 105, 14);
		panelmodificadorCrear.add(lbNumeroApto);
		
		JLabel lbNumeroPisos = new JLabel("No Pisos");
		lbNumeroPisos.setBounds(120, 23, 89, 14);
		panelmodificadorCrear.add(lbNumeroPisos);
		
		JLabel lbPosicionX = new JLabel("Posicion X");
		lbPosicionX.setBounds(350, 23, 89, 14);
		panelmodificadorCrear.add(lbPosicionX);
		
		JLabel lbPosicionY = new JLabel("Posicion Y");
		lbPosicionY.setBounds(350, 51, 89, 14);
		panelmodificadorCrear.add(lbPosicionY);
		
		textNumeroPisos = new JTextField();
		textNumeroPisos.setColumns(10);
		textNumeroPisos.setBounds(180, 20, 131, 23);
		textNumeroPisos.setEnabled(false);
        panelmodificadorCrear.add(textNumeroPisos);
		
        textNumeroAptos = new JTextField();
        textNumeroAptos.setColumns(10);
        textNumeroAptos.setBounds(180, 48, 131, 20);
        textNumeroAptos.setEnabled(false);
		panelmodificadorCrear.add(textNumeroAptos);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(180, 73, 131, 20);
        textNombre.setEnabled(false);
		panelmodificadorCrear.add(textNombre);
		
		textPosicionX = new JTextField();
		textPosicionX.setColumns(10);
		textPosicionX.setBounds(420, 20, 70, 23);
		textPosicionX.setEnabled(false);
		panelmodificadorCrear.add(textPosicionX);
		
		textPosicionY = new JTextField();
		textPosicionY.setColumns(10);
		textPosicionY.setBounds(420, 48, 70, 20);
		textPosicionY.setEnabled(false);
		panelmodificadorCrear.add(textPosicionY);
                       
        JButton btnRegistrar = new JButton("Registrar Torre");
		btnRegistrar.setBounds(180, 100, 131, 23);
		btnRegistrar.addActionListener(new ControladorPanelTorre(this));
		panelmodificadorCrear.add(btnRegistrar);
		
		JPanel panelmodificadorModificar = new JPanel();
		panelmodificadorModificar.setBorder(new TitledBorder(null, "Modificar Torre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panelmodificadorModificar.setBounds(500, 223, 282, 140);
		add(panelmodificadorModificar);
		panelmodificadorModificar.setLayout(null);
       
        
	}

}
