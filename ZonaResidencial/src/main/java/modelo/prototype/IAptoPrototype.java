package modelo.prototype;

public interface IAptoPrototype<T extends IAptoPrototype> extends Cloneable {
	public T clone();
	public T deepClone();
	public void setNumeroApto(int i);
}
