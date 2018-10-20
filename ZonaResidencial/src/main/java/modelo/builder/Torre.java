package modelo.builder;

import java.util.ArrayList;
import java.util.List;


import modelo.decorator.PisoMadera;
import modelo.persona.Residente;
import modelo.prototype.AptoImpl;
import modelo.prototype.AptoPrototype;
import modelo.prototype.ComponenteAptoPrototype;


public class Torre {

    private int idTorre;
    private String nombre;
    private int posicionX;
    private int posicionY;
    private List<Nivel> nivel;
    
    
    

	public Torre(String nombre, int posicionX, int posicionY) {
		super();
		this.nombre = nombre;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public Torre(String nombre, int posicionX, int posicionY, List<Nivel> nivel) {
		this.nombre = nombre;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.nivel = nivel;
	}
    
	public Torre(int idTorre, String nombre, int posicionX, int posicionY) {
		this.idTorre = idTorre;
		this.nombre = nombre;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	

	public Torre(int idTorre, String nombre, int posicionX, int posicionY, List<Nivel> nivel) {
		this.idTorre = idTorre;
		this.nombre = nombre;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.nivel = nivel;
	}

	public Torre() {
	}


	public static class TorreBuilder implements IBuilder<Torre>{
		
		private int idTorre;
	    private String nombre;
	    private int posicionX;
	    private int posicionY;
	    private final List<Nivel> nivel= new ArrayList<>();
	    
	    public TorreBuilder setIdTorre(int idTorre) {
			this.idTorre=idTorre;
			return this;
		}
	    
		public TorreBuilder setNombre(String nombre) {
			this.nombre=nombre;
			return this;
		}
		public TorreBuilder setPosicionX(int posicionX) {
			this.posicionX=posicionX;
			return this;
		}
		public TorreBuilder setPosicionY(int posicionY) {
			this.posicionY=posicionY;
			return this;
		}
		public TorreBuilder addNivel(int idNivel) {
			for(int i=0;i<idNivel;i++)
				nivel.add(new Nivel(i));
			
			return this;
		}
		public TorreBuilder addNivel(int idNivel, int cApto) {
			int cont=100;
			ComponenteAptoPrototype apto =new AptoImpl(1,"I",1,12,13,50,200000,null);
			AptoPrototype.addPrototype(apto.getDescripcion(), apto);
			for(int i=0;i<idNivel;i++) {
				
				List<ComponenteAptoPrototype> aptoList= new ArrayList<>();
				for(int j=0;j<cApto;j++) {
					
					ComponenteAptoPrototype aptoRegistro = (AptoImpl)AptoPrototype.getPrototype("I");
					aptoRegistro.setNumeroApto(cont+j);
					aptoRegistro=new PisoMadera(aptoRegistro);
					aptoList.add(aptoRegistro);
				}
				nivel.add(new Nivel(i, aptoList));
				cont=cont+100;
		    }
			System.out.println("Torre Creada!!!");
			return this;
		}
		
		@Override
		public Torre build() {
			return new Torre(nombre,posicionX,posicionY,nivel);
		}

		public TorreBuilder addNivel(int idNivel, int cApto, String nombreApto, int numeroApto, float largo,
				float ancho, int m2, Double valor, Residente residente) {
			// TODO Auto-generated method stub
			return null;
		}
		
    }
	
	@Override
    public String toString() {
        return "Torre{" + "nombre=" + nombre + ", PosicionX=" + posicionX + ", PosicionY=" 
                + posicionY + ", nivel=" + nivel.get(0).getIdPiso() +'}';
    }
       
	public int getIdTorre() {
		return idTorre;
	}
	public void setIdTorre(int idTorre) {
		this.idTorre = idTorre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public List<Nivel> getNivel() {
		return nivel;
	}
	public void setNivel(List<Nivel> nivel) {
		this.nivel = nivel;
	}
	
    
}