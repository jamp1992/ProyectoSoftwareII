package modelo.persona;



import java.sql.Date;

import modelo.factorymethod.VisitanteDAO;
import modelo.otros.Estacionamiento;

/**
 * 
 */
public class Vigilante extends Empleado {

    
	
    public Vigilante(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaIngreso) {
		super(cedula, nombre, apellido, usuario, contrasena, fechaIngreso);
	}

    
    
    public VisitanteDAO controlAccesoVisitante () {
		VisitanteDAO visitante = new VisitanteDAO();
		return visitante;
	}
	
	//public void controlarAccesoVisitante(Visitante visitante) {
       
//   }

    /**
     * @param Residente 
     * @return
     */
    public void controlarAccesoResidente(Residente residente) {
        // TODO implement here
      
    }

    /**
     * @param Residente 
     * @param Estacionamiento 
     * @return
     */
    public void asignarParqueaderoResidente(Residente residente, Estacionamiento estacionamiento) {
        // TODO implement here
    }

    /**
     * @param Visitante 
     * @param Estacionamiento 
     * @return
     */
    public Visitante asignarParqueaderoVisitante(int cedula,String nombre, String apellido, Date fecha) {
    	
        Visitante visitante=new Visitante(cedula,nombre,apellido,fecha);
        return visitante;
        
    }

}