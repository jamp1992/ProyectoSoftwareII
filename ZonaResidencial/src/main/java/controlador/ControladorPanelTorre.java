package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import modelo.builder.Nivel;
import modelo.builder.Torre;
import modelo.factorymethod.AptoDAO;
import modelo.factorymethod.EstacionamientoDAO;
import modelo.factorymethod.NivelDAO;
import modelo.factorymethod.TorreDAO;
import modelo.otros.Estacionamiento;
import modelo.prototype.AptoImpl;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.ConjuntoResidencialSingleton;
import vista.PanelTorre;

public class ControladorPanelTorre implements ActionListener {
	
	private PanelTorre pt;
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	public ControladorPanelTorre(PanelTorre pt) {
		this.pt = pt;
	}
	
	public PanelTorre getPt() {
		return pt;
	}
	public void setPt(PanelTorre pt) {
		this.pt = pt;
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
			case "Crear":
				pt.textNumeroPisos.setEnabled(true);
				pt.textNumeroAptos.setEnabled(true);
				pt.textNombre.setEnabled(true);
				pt.textPosicionX.setEnabled(true);
				pt.textPosicionY.setEnabled(true);
				break;
			case "Registrar Torre":
				//Se crea instancia unica ConjuntoResidencialSingleton
				ConjuntoResidencialSingleton CRS1= ConjuntoResidencialSingleton.getInstance();
				//Se crea la torre
				Torre torre=new Torre.TorreBuilder().setNombre(pt.textNombre.getText()).setPosicionX(Integer.parseInt(pt.textPosicionX.getText())).setPosicionY(Integer.parseInt(pt.textPosicionY.getText())).addNivel(Integer.parseInt(pt.textNumeroPisos.getText()),Integer.parseInt(pt.textNumeroAptos.getText())).build();
				//Se instancia torreDAO y se almacena la torre con el id del conjunto correspondiente
				TorreDAO TDAO = new TorreDAO();
				TDAO.saveTorre(torre, CRS1.getIdConjunto());
				//Se instancia NivelDAO y AptoDAO
				List<Torre> torreList=TDAO.finAllTorres();
				NivelDAO NDAO = new NivelDAO();
				AptoDAO ADAO= new AptoDAO();
				EstacionamientoDAO EDAO= new EstacionamientoDAO();
				//El primer for leera los niveles que tiene la torre creada, luego los almacena en la BD.
				//El segundo for almacenara a la BD los aptos por cada nivel.
				for(int i=0;i<torre.getNivel().size(); i++) {
					NDAO.saveNivel(torre.getNivel().get(i) , torreList.get(torreList.size()-1).getIdTorre());
					for(int j=0;j<torre.getNivel().get(i).getApto().size();j++) {
						ADAO.saveApto(torre.getNivel().get(i).getApto().get(j), NDAO.finAllNiveles().get(NDAO.finAllNiveles().size()-1).getIdPiso());
						//Por cada apto almacenado, se guardara un estacionamiento
						Estacionamiento estacionamiento= new Estacionamiento("Disponible");
						EDAO.saveEstacionamiento(estacionamiento);
					}
				}
				pt.textNumeroPisos.setText("");
				pt.textNumeroAptos.setText("");
				pt.textNombre.setText("");
				pt.textPosicionX.setText("");
				pt.textPosicionY.setText("");
				break;
				
			case "Mostrar Torres":
				List<Torre> listaTorre= new ArrayList<>();
				Torre t;
				for(int i=this.pt.modeloTabla.getRowCount(); i>0; i--){
                    this.pt.modeloTabla.removeRow(i-1);
                }
                TorreDAO TMDAO = new TorreDAO();
                listaTorre=TMDAO.finAllTorres();
                Iterator<Torre> itr = listaTorre.iterator();
                while(itr.hasNext()){
                    t=(Torre) itr.next();
                    this.pt.modeloTabla.addRow(new Object[]{t.getIdTorre(),t.getNombre(),t.getPosicionX(),t.getPosicionY()});
                }
                pt.btnMostrarApto.setEnabled(true);
				break;
			
			case "Mostrar Aptos":
				List<AptoImpl> listaApto= new ArrayList<>();
				AptoImpl a;
				for(int i=this.pt.modeloTablaApto.getRowCount();i>0;i--) {
					this.pt.modeloTablaApto.removeRow(i-1);
				}
				AptoDAO AMDAO= new AptoDAO();
				listaApto=AMDAO.finAllAptos(Integer.parseInt(String.valueOf(this.pt.modeloTabla.getValueAt(this.pt.table.getSelectedRow(),0))));
				Iterator<AptoImpl> itrApto = listaApto.iterator();
                while(itrApto.hasNext()){
                    a=(AptoImpl) itrApto.next();
                    this.pt.modeloTablaApto.addRow(new Object[]{a.getIdAptoImpl(),a.getEstado(),a.getNumeroApto(),a.getValor(),a.getNombreApto(),a.getLargo(),a.getAncho(),a.getM2()});
                }
                
			case"Buscar Torre":
				TorreDAO tdao= new TorreDAO();
				Torre torreBusqueda = new Torre();
				torreBusqueda=admin.buscarTorre(tdao.finAllTorres(), Integer.parseInt(pt.textid.getText()));
				//JOptionPane.showMessageDialog(null, admin.buscarTorre(tdao.finAllTorres(), Integer.parseInt(pt.textid.getText())).getNombre());
					if(torreBusqueda==null) {
						JOptionPane.showMessageDialog(null, "Id no existe");
					}	
						else{
							for(int i=this.pt.modeloTabla.getRowCount(); i>0; i--){
			                    this.pt.modeloTabla.removeRow(i-1);
			                }
							this.pt.modeloTabla.addRow(new Object[]{torreBusqueda.getIdTorre(),torreBusqueda.getNombre(),torreBusqueda.getPosicionX(),torreBusqueda.getPosicionY()});
						}
					
				break;
				
				
		}
		
	}

}
