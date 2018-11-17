  package modelo.singleton;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.builder.Nivel;
import modelo.builder.Torre;
import modelo.factorymethod.AdmnistradorDAO;

import modelo.factorymethod.EmpleadoDAO;
import modelo.factorymethod.ResidenteDAO;
import modelo.factorymethod.ServicioMantenimientoDAO;
import modelo.otros.PagoAdmin;
import modelo.otros.PagoServicioMantenimeinto;
import modelo.otros.ServicioMantenimiento;
import modelo.persona.Empleado;
import modelo.persona.PersonaAcceso;
import modelo.persona.Residente;
import modelo.prototype.AptoImpl;


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

    public ResidenteDAO gestionarResidente() {
        ResidenteDAO residente = new ResidenteDAO();
        return residente;
    }
    public ServicioMantenimientoDAO gestionarServicioMantenimiento() {
    	ServicioMantenimientoDAO servicioMantenimiento= new ServicioMantenimientoDAO();
    	return servicioMantenimiento;
    }
    
    public Torre buscarTorre(List<Torre> listaTorre, int idTorre) {
    	
    	Torre torre=null;
    	for(int i=0;i<listaTorre.size();i++) {
			if(listaTorre.get(i).getIdTorre()==idTorre)
				torre=listaTorre.get(i);
		}
    	return torre;
    	//JOptionPane.showMessageDialog(null, torre.getNombre());
    	
    }
    
    public Empleado buscarEmpleado(List<Empleado> listaAux, List<Empleado> listaVig, List<Empleado> listaPersMant , int idEmpleado) {
    	Empleado e=null;
    	List<Empleado> empleados= new ArrayList<>();
    	for(Empleado empleado:listaAux) {
    		empleados.add(empleado);
    	}
    	for(Empleado empleado:listaVig) {
    		empleados.add(empleado);
    	}
    	for(Empleado empleado:listaPersMant) {
    		empleados.add(empleado);
    	}
    	
    	for(int i=0;i<empleados.size();i++) {
			if(empleados.get(i).getCedula()==idEmpleado)
				e=empleados.get(i);
		}
    	return e;
    	
    }
    public Residente buscarResidente(List<Residente> listaRes, int idCedula) {
    	Residente r=null;
    	for(int i=0;i<listaRes.size();i++) {
			if(listaRes.get(i).getCedula()==idCedula)
				r=listaRes.get(i);
		}
    	return r;
    }
    
    public int BuscarServicioMantenimiento(List<ServicioMantenimiento> servicioMantenimiento, String nombreServicio) {
    	int idServicio=0;
    	for(int i=0;i<servicioMantenimiento.size();i++) {
			if(servicioMantenimiento.get(i).equals(nombre));
				idServicio=servicioMantenimiento.get(i).getIdServicioMantenimiento();
		}
    	return idServicio;
    }
    
    public List<PagoAdmin> solicitarInformePagoAdmin() {
       // List<List<Torre>,List<AptoImpl>, List<Residente>,List<PagoAdmin>> listaDatos= new ArrayList<>();
    	List<String> listaObjetos= new ArrayList<>();
    	listaObjetos.add("Ole");
    	listaObjetos.add("MK");
    	
    	JOptionPane.showMessageDialog(null, listaObjetos.get(0));
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
	
	public boolean ingresarSistema(String usuario,String contrasena,String usuarioAdmin, String contrasenaAdmin) {
		boolean estado=false;
		if(usuarioAdmin.equals(usuario) && contrasenaAdmin.equals(contrasena)) {
			estado=true;
		}
			
		return estado;
			
	}
    

}