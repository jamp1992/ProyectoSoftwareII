package modelo.persona;



import java.util.Date;
import java.util.List;

import modelo.factorymethod.VisitanteDAO;
import modelo.otros.Estacionamiento;

/**
 * 
 */
public class Vigilante extends Empleado {

    
	
    public Vigilante(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaIngreso) {
		super(cedula, nombre, apellido, usuario, contrasena, fechaIngreso);
	}
    
    
	public Vigilante() {
		super();
	}


	public void controlarAccesoVisitante(Visitante visitante) {
       
    }

    
    
    public VisitanteDAO controlAccesoVisitante () {
		VisitanteDAO visitante = new VisitanteDAO();
		return visitante;
	}
	
	//public void controlarAccesoVisitante(Visitante visitante) {
       
//   }


    public void controlarAccesoResidente(Residente residente) {
      
    }

    public void asignarParqueaderoResidente(Residente residente, Estacionamiento estacionamiento) {

    }

    /**
     * @param Visitante 
     * @param Estacionamiento 
     * @return
     */
    public Visitante controlarAccesoVisitante(int cedula,String nombre, String apellido, Date fecha) {
    	
        Visitante visitante=new Visitante(cedula,nombre,apellido,fecha);
        return visitante;
        
    }
    public void asignarParqueaderoVisitante(Visitante visitante, Estacionamiento estacionamiento) {
        
    }
    public boolean ingresarSistema(String usuario, String contrasena, List<Empleado> vigilanteList) {
    	boolean estado=false;
    	for(Empleado vigilante: vigilanteList) {
    		if(usuario.equals(vigilante.getUsuario())&&contrasena.equals(vigilante.getContrasena())) {
    			estado=true;
    		}
    	}
    	return estado;
    }

}