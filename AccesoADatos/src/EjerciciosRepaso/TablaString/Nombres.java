package TablaString;

public class Nombres {
	
	String nombre;

	public Nombres(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return " " + nombre;
	}
	
	
	

}
