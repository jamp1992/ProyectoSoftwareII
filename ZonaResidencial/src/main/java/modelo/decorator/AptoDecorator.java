package modelo.decorator;

import modelo.prototype.ComponenteAptoPrototype;

public abstract class AptoDecorator extends ComponenteAptoPrototype {

	private ComponenteAptoPrototype componenteAptoPrototype;

	public AptoDecorator(ComponenteAptoPrototype componenteAptoPrototype) {
		setComponenteAptoPrototype(componenteAptoPrototype);
	}

	public ComponenteAptoPrototype getComponenteAptoPrototype() {
		return componenteAptoPrototype;
	}

	public void setComponenteAptoPrototype(ComponenteAptoPrototype componenteAptoPrototype) {
		this.componenteAptoPrototype = componenteAptoPrototype;
	}
	
}
