package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import modelo.factorymethod.VisitanteDAO;
import modelo.persona.Vigilante;
import modelo.persona.Visitante;
import modelo.singleton.ConjuntoResidencialSingleton;
import vista.PanelControlAccesoVisitante;

public class ControladorPanelVigilante implements ActionListener {

	private PanelControlAccesoVisitante accesoVisitante;
	private Vigilante vigilante1;
	private Visitante visitante;
	private Date fechaEntrada;
	private ConjuntoResidencialSingleton crs = ConjuntoResidencialSingleton.getInstance();

	public ControladorPanelVigilante(PanelControlAccesoVisitante accesoVisitante) {
		super();
		this.accesoVisitante = accesoVisitante;
	}

	public PanelControlAccesoVisitante getAccesoVisitante() {
		return accesoVisitante;
	}

	public void setAccesoVisitante(PanelControlAccesoVisitante accesoVisitante) {
		this.accesoVisitante = accesoVisitante;

	}

	public Vigilante getVigilante() {
		return vigilante1;
	}

	public void setVigilante(Vigilante vigilante) {
		this.vigilante1 = vigilante;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Crear":
			accesoVisitante.textCedula.setEnabled(true);
			accesoVisitante.textNombre.setEnabled(true);
			accesoVisitante.textApellido.setEnabled(true);

			break;

		case "Registrar":

			fechaEntrada = (Date) accesoVisitante.Fecha_Entrada.getCalendar().getTime();
			visitante = new Visitante(Integer.parseInt(accesoVisitante.textCedula.getText()),
			accesoVisitante.textNombre.getText(), accesoVisitante.textApellido.getText(), fechaEntrada);
			vigilante1.controlAccesoVisitante().crearVisitante(visitante, crs.getIdConjunto());
		
			
			accesoVisitante.textCedula.setText("");
			accesoVisitante.textNombre.setText("");
		    accesoVisitante.textApellido.setText(""); 
		break;
		}
		
		

	}

}
