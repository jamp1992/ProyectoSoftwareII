package vista;


import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPanelPagoAdminCliente;



public class PanelPagoAdmin extends JPanel {
	
	public JTextField textCedula;
	public JTextField textNombre;
	public JTextField textTarjeta;
	public JTextField textCheque;
	public JTextField textReceptorCheque;
	public JTextField textCuenta;
	public JTextField textId;
	public JTextField textNumeroIngresar;
	public JTextField textFecha;
	public JTextField textCantidad;
	
	public JRadioButton radioButtonEfectivo;
	public JRadioButton radioButtonDebito;
	public JRadioButton radioButtonCheque;
	public JRadioButton radioButtonOnline;
	public ButtonGroup grupoBoton;
	
	public JTextField textN_Apto;
	public JTextField textIdTorre;
	public Object[][] datos;
    public DefaultTableModel modeloTabla;
    public JTable table;
    public Object[][] datosResidente;
    public DefaultTableModel modeloTablaMantenimiento;
    public JTable tableMantenimiento;
    public JScrollPane scroll;
    
    private static final long serialVersionUID = 1L;

	
	public PanelPagoAdmin() {
		
	
	setBorder(null);
	setLayout(null);
	
	JPanel paneldatos = new JPanel();
	paneldatos.setBorder(new TitledBorder(null, "Datos Residente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(80, 13, 255)));
	paneldatos.setBounds(0, 0, 240, 365);
	add(paneldatos);
	paneldatos.setLayout(null);
	
	
	JLabel lblCedula= new JLabel("Cedula");
	lblCedula.setBounds(10, 30, 100, 20);
	paneldatos.add(lblCedula);
	textCedula= new JTextField();
	textCedula.setBounds(120, 30, 100, 20);
	textCedula.setEnabled(false);
	textCedula.setText("123");
	paneldatos.add(textCedula);
	
	JLabel lblNombre= new JLabel("Nombre");
	lblNombre.setBounds(10, 60, 100, 20);
	paneldatos.add(lblNombre);
	textNombre= new JTextField();
	textNombre.setBounds(120, 60, 100, 20);
	textNombre.setEnabled(false);
	textNombre.setText("Ejemplo");
	paneldatos.add(textNombre);
	//30, 110, 100, 20//30, 50, 100, 20
	
	JLabel lblTarjeta= new JLabel("N. Tarjeta");
	lblTarjeta.setBounds(10, 90, 100, 20);
	paneldatos.add(lblTarjeta);
	textTarjeta= new JTextField();
	textTarjeta.setBounds(120, 90, 100, 20);
	textTarjeta.setEnabled(false);
	textTarjeta.setText("0");
	paneldatos.add(textTarjeta);
	
	JLabel lblCheque= new JLabel("N. Cheque");
	lblCheque.setBounds(10, 120, 100, 20);
	paneldatos.add(lblCheque);
	textCheque= new JTextField();
	textCheque.setBounds(120, 120, 100, 20);
	textCheque.setEnabled(false);
	textCheque.setText("0");
	paneldatos.add(textCheque);
	
	JLabel lblReceptorCheque= new JLabel("Nombre Receptor");
	lblReceptorCheque.setBounds(10, 150, 100, 20);
	paneldatos.add(lblReceptorCheque);
	textReceptorCheque= new JTextField();
	textReceptorCheque.setBounds(120, 150, 100, 20);
	textReceptorCheque.setEnabled(false);
	textReceptorCheque.setText("Alguien");
	paneldatos.add(textReceptorCheque);
	
	JLabel lblCuenta= new JLabel("N. Cuenta");
	lblCuenta.setBounds(10, 180, 100, 20);
	paneldatos.add(lblCuenta);
	textCuenta= new JTextField();
	textCuenta.setBounds(120, 180, 100, 20);
	textCuenta.setEnabled(false);
	textCuenta.setText("0");
	paneldatos.add(textCuenta);
	
	JLabel lblCantidad= new JLabel("Cantidad");
	lblCantidad.setBounds(10, 210, 100, 20);
	paneldatos.add(lblCantidad);
	textCantidad= new JTextField();
	textCantidad.setBounds(120, 210, 100, 20);
	textCantidad.setEnabled(false);
	textCantidad.setText("0");
	paneldatos.add(textCantidad);
	
	JButton btnPagarEfectivo= new JButton("Pagar");
	btnPagarEfectivo.setBounds(120, 270, 100, 20);
	btnPagarEfectivo.addActionListener(new ControladorPanelPagoAdminCliente(this));
	paneldatos.add(btnPagarEfectivo);
	
	
	radioButtonEfectivo=new JRadioButton("Efectivo",false);
	radioButtonEfectivo.setBounds(310, 280, 100, 20);
	radioButtonEfectivo.setActionCommand("Efectivo");
	radioButtonEfectivo.addActionListener(new ControladorPanelPagoAdminCliente(this));
	
	radioButtonDebito=new JRadioButton("Debito",false);
	radioButtonDebito.setBounds(420, 280, 100, 20);
	radioButtonDebito.setActionCommand("DebitoAdapter");
	radioButtonDebito.addActionListener(new ControladorPanelPagoAdminCliente(this));
	
	radioButtonCheque=new JRadioButton("Cheque",false);
	radioButtonCheque.setBounds(530, 280, 100, 20);
	radioButtonCheque.setActionCommand("ChequeAdapter");
	radioButtonCheque.addActionListener(new ControladorPanelPagoAdminCliente(this));
	
	
	radioButtonOnline=new JRadioButton("Online",false);
	radioButtonOnline.setBounds(640, 280, 100, 20);
	radioButtonOnline.setActionCommand("OnlineAdapter");
	radioButtonOnline.addActionListener(new ControladorPanelPagoAdminCliente(this));
	
	add(radioButtonEfectivo);
	add(radioButtonDebito);
	add(radioButtonCheque);
	add(radioButtonOnline);
	grupoBoton= new ButtonGroup();
	grupoBoton.add(radioButtonEfectivo);
	grupoBoton.add(radioButtonDebito);
	grupoBoton.add(radioButtonCheque);
	grupoBoton.add(radioButtonOnline);
	
	
	//paneldatos.add(grupoBoton);
	
	JLabel lblId= new JLabel("Cedula");
	lblId.setBounds(250, 10, 100, 20);
	add(lblId);
	textId= new JTextField();
	textId.setBounds(350, 10, 100, 20);
	add(textId);
	
	JButton btnMostrarPagoAdmin= new JButton("Mostrar Pago Pendiente");
	btnMostrarPagoAdmin.addActionListener(new ControladorPanelPagoAdminCliente(this));
	btnMostrarPagoAdmin.setBounds(600, 10, 180, 20);
	add(btnMostrarPagoAdmin);

         JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setBounds(0, 45, 677, 179);
		scrollPane.setBounds(250, 40, 530, 200);
		add(scrollPane);
    
		
		table = new JTable();
        modeloTabla = new DefaultTableModel(
	new Object[][] {
		{null, null, null, null,null,null},
	},
	new String[] {
		"Cedula ","Nombre","Fecha Pago Admin","Valor Admin","Pagado","idPago"
	}
);
        table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(new Color(255, 255, 0));
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		
		
	}
	
	
	
	
}
