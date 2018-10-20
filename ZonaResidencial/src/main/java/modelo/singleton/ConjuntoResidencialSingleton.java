package modelo.singleton;


import java.util.List;

import modelo.builder.Torre;
import modelo.factorymethod.ConjuntoResidencialDAO;
import modelo.otros.Parqueadero;
import modelo.persona.Persona;

public class ConjuntoResidencialSingleton {
	
	private static ConjuntoResidencialSingleton singleton;
	
	private static final int Numero=0;
	
	private int idConjunto;
	private String direccion;
	private List<Persona> persona;
	private CuentaCorrienteSingleton cuenta;
	private AdministradorSingleton admin;
	private List<Torre> torre;
	private Parqueadero parqueadero; 
   
    private ConjuntoResidencialSingleton() {
    	ConjuntoResidencialDAO CRDAO = new ConjuntoResidencialDAO();
    	this.idConjunto=CRDAO.listarConjunto().get(Numero).getId();
    	this.direccion=CRDAO.listarConjunto().get(Numero).getDireccion();
    }
    
    private static synchronized void createInstance(){
		if(singleton ==null){
			singleton = new ConjuntoResidencialSingleton();
		}
	}



    public static ConjuntoResidencialSingleton getInstance() {
    	if(singleton == null) {
			createInstance();
		}
		return singleton;
    }
    
    @Override
	public String toString() {
		//return "ConfigurationSingleton{"+"appName=" + appName +", appVersion=" + appVersion +'}';
		return null;		
	}
    
    //Get and Set
	public static ConjuntoResidencialSingleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(ConjuntoResidencialSingleton singleton) {
		ConjuntoResidencialSingleton.singleton = singleton;
	}

	public int getIdConjunto() {
		return idConjunto;
	}

	public void setIdConjunto(int idConjunto) {
		this.idConjunto = idConjunto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static int getNumero() {
		return Numero;
	}

	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}

	public CuentaCorrienteSingleton getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorrienteSingleton cuenta) {
		this.cuenta = cuenta;
	}

	public AdministradorSingleton getAdmin() {
		return admin;
	}

	public void setAdmin(AdministradorSingleton admin) {
		this.admin = admin;
	}

	public List<Torre> getTorre() {
		return torre;
	}

	public void setTorre(List<Torre> torre) {
		this.torre = torre;
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}		
}