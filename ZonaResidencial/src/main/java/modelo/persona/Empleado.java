package modelo.persona;

import java.util.Date;

/**
 * 
 */
public class Empleado extends PersonaAcceso {
	
	private Date fechaIngreso;
    public Empleado(int cedula, String nombre, String apellido, String usuario, String contrasena, Date fechaIngreso) {
		super(cedula, nombre, apellido, usuario, contrasena);
		this.fechaIngreso=fechaIngreso;
	}
    
    public Empleado() {
		super();
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
   
}