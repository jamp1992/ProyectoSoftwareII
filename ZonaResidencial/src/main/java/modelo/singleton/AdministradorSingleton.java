  package modelo.singleton;
import java.util.*;

import modelo.factorymethod.AdmnistradorDAO;

import modelo.factorymethod.EmpleadoDAO;
import modelo.factorymethod.ResidenteDAO;
import modelo.otros.PagoAdmin;
import modelo.otros.PagoServicioMantenimeinto;
import modelo.persona.PersonaAcceso;


public class AdministradorSingleton {
	
	private static AdministradorSingleton singleton;
	private int cedula;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasena;
    
	private AdministradorSingleton() {
    	AdmnistradorDAO ADAO = new AdmnistradorDAO();
    	ADAO.ObtenerAdmin(this);
    }
	
	private static synchronized void createInstance(){
		if(singleton ==null){
			singleton = new AdministradorSingleton();
		}
	}



    public static AdministradorSingleton getInstance() {
    	if(singleton == null) {
			createInstance();
		}
		return singleton;
    }

    private void AdministradorSingleton() {
        // TODO implement here
        
    }


    public void gestionarTorre() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public EmpleadoDAO gestionarEmpleado() {
        EmpleadoDAO empleado = new EmpleadoDAO();
        return empleado;
    }

    /**
     * @return
     */
    public ResidenteDAO gestionarResidente() {
        ResidenteDAO residente = new ResidenteDAO();
        return residente;
    }
    
    public List<PagoAdmin> solicitarInformePagoAdmin() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<PagoServicioMantenimeinto> solicitarInformeAptos() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void solicitarGastosMantenimiento() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public CuentaCorrienteSingleton revisarCuentaCorriente() {
        // TODO implement here
        return null;
    }

	public static AdministradorSingleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(AdministradorSingleton singleton) {
		AdministradorSingleton.singleton = singleton;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
    

}