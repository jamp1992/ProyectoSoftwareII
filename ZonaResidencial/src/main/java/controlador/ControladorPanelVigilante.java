package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.factorymethod.VisitanteDAO;
import modelo.persona.Empleado;
import modelo.persona.Vigilante;
import modelo.persona.Visitante;
import modelo.singleton.ConjuntoResidencialSingleton;
import vista.PanelControlAccesoVisitante;

public class ControladorPanelVigilante implements ActionListener {

	private PanelControlAccesoVisitante accesoVisitante;
	private Vigilante vigilante1 = new Vigilante();
	private VisitanteDAO VDAO=new VisitanteDAO();
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

		case "REGISTRAR VISITANTE":

			fechaEntrada= accesoVisitante.Fecha_Entrada.getCalendar().getTime();
			
			visitante=vigilante1.controlarAccesoVisitante(Integer.parseInt(accesoVisitante.textCedula.getText()),accesoVisitante.textNombre.getText(), accesoVisitante.textApellido.getText(), fechaEntrada);
			//vigilante1.controlAccesoVisitante().crearVisitante(visitante, crs.getIdConjunto());
			VDAO.crearVisitante(visitante, crs.getIdConjunto());
			
			accesoVisitante.textCedula.setText("");
			accesoVisitante.textNombre.setText("");
		    accesoVisitante.textApellido.setText(""); 
		break;
		case "Mostrar Visitantes":
			List<Visitante> listaVisitante= new ArrayList<>();
		
			for(int i=this.accesoVisitante.modeloTabla.getRowCount(); i>0; i--){
                this.accesoVisitante.modeloTabla.removeRow(i-1);
            }
            
			listaVisitante=VDAO.MostarVisitante();
            Iterator<Visitante> itrVig = listaVisitante.iterator();
            while(itrVig.hasNext()){
                visitante=(Visitante) itrVig.next();
                this.accesoVisitante.modeloTabla.addRow(new Object[]{visitante.getCedula(),visitante.getNombre(),visitante.getApellido(),visitante.getFechaEntrada()});
            }
            break;
		case "ELIMINAR VISITANTE":
			VDAO.EliminarVisitante(Integer.parseInt(String.valueOf(this.accesoVisitante.modeloTabla.getValueAt(this.accesoVisitante.table.getSelectedRow(), 0))));
            break;
            
		}
		
		
		

	}

}
