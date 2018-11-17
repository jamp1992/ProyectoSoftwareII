package modelo.facade;

import java.util.ArrayList;
import java.util.List;

import modelo.persona.Residente;
import modelo.singleton.AdministradorSingleton;

public class CRMSystem {
	private AdministradorSingleton admin=AdministradorSingleton.getInstance();
	public boolean verificarResidente(Residente residente) {
		boolean estado=false;
		
		List<Residente> residenteList= new ArrayList<>();
		residenteList=admin.gestionarResidente().MostrarResidentes();
		for(Residente res: residenteList) {
			if(residente.getCedula()==res.getCedula()&&residente.getNombre().equals(res.getNombre())) {
				estado=true;
			}
			else
			{
				estado=false;
			}
		}
		return estado;
	}

}
