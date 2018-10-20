package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class PanelInforme extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JDateChooser c;

	public PanelInforme() {
		setBorder(null);
		setLayout(null);
		
		
		// Instanciar Componente
		c = new JDateChooser();
		 
		// Ubicar y agregar al panel
		c.setBounds(10,300,200,20);
		c.getJCalendar();
		 
		add(c);
		JButton prueba= new JButton("Mostrar");
		prueba.setBounds(10, 10, 100, 20);
		prueba.addActionListener(this);
		add(prueba);
		
		//JOptionPane.showMessageDialog(null, c.);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()) {
		
		case "Mostrar":
			JOptionPane.showMessageDialog(null, c.getCalendar().DATE);
			JOptionPane.showMessageDialog(null, c.getCalendar().MONTH);
			JOptionPane.showMessageDialog(null, c.getCalendar().YEAR);
			break;
		}
		
	}

}
