package modelo.builder;

import java.util.List;

import modelo.prototype.AptoImpl;
import modelo.prototype.ComponenteAptoPrototype;

public class Nivel {
	
	private int idPiso;
	private List<ComponenteAptoPrototype> apto;
	
	
    public Nivel(int idPiso, List<ComponenteAptoPrototype> apto) {
		this.idPiso = idPiso;
		this.apto = apto;
	}

	public Nivel(int idPiso) {
		this.idPiso = idPiso;
	}

	public Nivel() {
    }

    public int getIdPiso() {
		return idPiso;
	}

	public void setIdPiso(int idPiso) {
		this.idPiso = idPiso;
	}

	public List<ComponenteAptoPrototype> getApto() {
		return apto;
	}

	public void setApto(List<ComponenteAptoPrototype> apto) {
		this.apto = apto;
	}
	


}