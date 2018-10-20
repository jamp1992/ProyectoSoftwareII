package modelo.persona;

public class PersonaAcceso extends Persona {

    

    private String usuario;
    private String contrasena;
    
    
	public PersonaAcceso(int cedula, String nombre, String apellido, String usuario, String contrasena) {
		super(cedula, nombre, apellido);
		this.usuario = usuario;
		this.contrasena = contrasena;
	}



	public void ingresarSistema() {
        // TODO implement here
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