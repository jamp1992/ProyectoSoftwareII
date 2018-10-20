package vista;

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


public class InterfazAdministrador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
       public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					InterfazAdministrador frame = new InterfazAdministrador();
					frame.setVisible(true);
                                       
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InterfazAdministrador() {
		
		
		setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 463);
                getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 801, 424);
                getContentPane().add(tabbedPane);
		
		/** panel de torre----------------------*******------------------mas bien se llama a -------------------------------------------------------torre----------------------------------------------------------------*/
		
		JPanel paneltorre = new JPanel();
		paneltorre.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Conjunto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addTab("Gestionar Conjunto", null, paneltorre, null);
		paneltorre.setLayout(new GridLayout(0, 1, 0, 0));
		

		/**   aqui se modifica la torre  ------------------------------------llama mas bien-----------------------------------------------------torre-------------------------------------*/
		
		PanelTorre torre=new PanelTorre();
		paneltorre.add(torre).setVisible(true);
		/** ---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/**-------------------------------------panel    empleado**************************-*----------------------------------------------------------------------------------------------------------***********************/
		JPanel panelempleado = new JPanel();
		panelempleado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addTab("Gestionar Empleado", null, panelempleado, null);
		panelempleado.setLayout(new GridLayout(1, 0, 0, 0));
		
		/**   aqui se modifica el empleado  --------------------------------------llama---------------------------------------------------empleado-------------------------------------*/
			PanelEmpleado empleado=new PanelEmpleado();
			panelempleado.add(empleado).setVisible(true);
		/** ---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		
                /**-------------------------------------panel    Residente**************************-*----------------------------------------------------------------------------------------------------------***********************/
		JPanel panelresidente = new JPanel();
		panelresidente.setBorder(new TitledBorder(null, "Residente", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		tabbedPane.addTab("Gestionar Residente", null, panelresidente, null);
		panelresidente.setLayout(new GridLayout(1, 0, 0, 0));
		
		/**   aqui se modifica el residente ---------------------------------------llama--------------------------------------------------residente-------------------------------------*/
			PanelResidente caja=new PanelResidente();
			panelresidente.add(caja).setVisible(true);
		/** ---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/**------------------------------------¨Panel    informe**************************-*----------------------------------------------------------------------------------------------------------***********************/
                JPanel panelinforme = new JPanel();
                panelinforme.setBorder(new TitledBorder(null, "Informe", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		tabbedPane.addTab("Gestionar Informe", null, panelinforme, null);
		panelinforme.setLayout(new GridLayout(1, 0, 0, 0));
		
		/**   aqui se modifica el informe  -------------------------------------llama----------------------------------------------------informe------------------------------------*/
		PanelInforme informe=new PanelInforme();
		panelinforme.add(informe).setVisible(true);
		/** ---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
		            
	}
	
}