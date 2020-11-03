package Persona;

public class ClasePersona {
	
	
	protected static String Nombre;
	protected static String Apellido;
	protected static String DNI;
	protected static int edad;
	
	
	public ClasePersona(String nombre, String apellido, String dNI, int edad) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		ClasePersona.edad = edad;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		ClasePersona.edad = edad;
	}


	@Override
	public String toString() {
		return Integer.toString(edad);
		
	}
	
	
	

}
