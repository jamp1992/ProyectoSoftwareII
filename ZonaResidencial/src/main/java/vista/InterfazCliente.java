package vista;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.ConjuntoResidencialSingleton;
import javax.swing.border.EtchedBorder;


public class InterfazCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/*
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					InterfazCliente frame = new InterfazCliente();
					frame.setVisible(true);
                                    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
    
    public InterfazCliente () {
    	
    	setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 463);
                getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 801, 424);
                getContentPane().add(tabbedPane);
                
                /** Solicitud_Mantenimiento **/
                
                
                JPanel panelMantenimiento = new JPanel();
        		panelMantenimiento.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Servicios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        		tabbedPane.addTab("Solicitud_Mantenimiento", null, panelMantenimiento, null);
        		panelMantenimiento.setLayout(new GridLayout(0, 1, 0, 0));
    	
        		PanelMantenimiento mantenimiento = new PanelMantenimiento();
        		panelMantenimiento.add (mantenimiento).setVisible (true);
        		
        		 /** Solicitud_de_Parqueadero **/
        		
        		JPanel panelParqueadero = new JPanel();
                panelParqueadero.setBorder(new TitledBorder(null, "Parqueadero", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
                tabbedPane.addTab("Solicitud_de_Parqueadero", null, panelParqueadero, null);
                panelParqueadero.setLayout(new GridLayout(1, 0, 0, 0));
        		
                
                
                PanelParqueadero parqueadero = new PanelParqueadero();
                panelParqueadero.add(parqueadero);
                
                
                
                /** Pagos **/
                
                JPanel panelPagos = new JPanel();
                panelPagos.setBorder(new TitledBorder(null, "Pago Admin", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
                tabbedPane.addTab("Pago Administracion", null, panelPagos, null);
                panelPagos.setLayout(new GridLayout(1, 0, 0, 0));
        		
            	
        		
        		PanelPagoAdmin pagos = new PanelPagoAdmin ();
        		panelPagos.add(pagos);
                
        		
        		/**Segunda ventana
                
        		JPanel panelPagos2 = new JPanel();
                panelPagos2.setBorder(new TitledBorder(null, "Pagos2", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
                tabbedPane.addTab("Pagos2", null, panelPagos2, null);
                panelPagos2.setLayout(new GridLayout(1, 0, 0, 0));
        		
            	
        		
        		PanelPagos2 pagos2 = new PanelPagos2 ();
        		panelPagos2.add(pagos2); **/
               
    }

}
