package modelo.persona;



import java.sql.Date;

import modelo.otros.Estacionamiento;

/**
 * 
 */
public class Vigilante extends Empleado {

    
	
    public Vigilante(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaIngreso) {
		super(cedula, nombre, apellido, usuario, contrasena, fechaIngreso);
	}

	public void controlarAccesoVisitante(Visitante visitante) {
        // TODO implement here
    }

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
    public void asignarParqueaderoVisitante(Visitante visitante, Estacionamiento estacionamiento) {
        // TODO implement here
        
    }

}