package modelo.prototype;
import java.util.*;


public class AptoPrototype {

	public AptoPrototype() {
    }
    private static Map<String, ComponenteAptoPrototype> prototypes = new  HashMap<String, ComponenteAptoPrototype>();

    public static ComponenteAptoPrototype getPrototype(String prototypeName) {
    	return prototypes.get(prototypeName).deepClone();
    }
    public static void addPrototype(String prototypeName, ComponenteAptoPrototype prototype) {
    	prototypes.put(prototypeName, prototype);
    }

}