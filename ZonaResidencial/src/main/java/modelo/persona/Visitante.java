package modelo.persona;

import java.util.*;

/**
 * 
 */
public class Visitante extends Persona {

	
    public Visitante(int cedula, String nombre, String apellido) {
		super(cedula, nombre, apellido);
	}

	public Date fechaEntrada;

}