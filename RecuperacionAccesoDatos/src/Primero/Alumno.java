package Primero;

public class Alumno {

	String Nombre, Apellido;
	
	public Alumno(String Nombre, String Apellido) {
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}
	
	public Alumno(String Nombre) {
		this.Nombre = Nombre;
		
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

	@Override
	public String toString() {
		return "Alumno [Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}
	
	
	
}
