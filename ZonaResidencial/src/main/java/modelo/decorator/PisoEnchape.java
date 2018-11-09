package modelo.decorator;

import modelo.persona.Residente;
import modelo.prototype.ComponenteAptoPrototype;

public class PisoEnchape extends AptoDecorator {
	
	

	public PisoEnchape(ComponenteAptoPrototype componenteAptoPrototype) {
		super(componenteAptoPrototype);
	}

	@Override
	public ComponenteAptoPrototype clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComponenteAptoPrototype deepClone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getDescripcion()+"PisoMadera";
	}

	@Override
	public double getValorAgregado() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getValorAgregado()+200000;
	}
	
	@Override
	public int getIdApto() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getIdApto();
	}

	@Override
	public int getNumApto() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getNumeroApto();
	}

	@Override
	public float getAptoLargo() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getLargo();
	}

	@Override
	public float getAptoAncho() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getAncho();
	}

	@Override
	public int getMetro2() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getM2();
	}

	@Override
	public String getEstate() {
		// TODO Auto-generated method stub
		return getComponenteAptoPrototype().getEstado();
	}

	
	
	

}
