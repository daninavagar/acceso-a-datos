package Default;


public class Iti2 {

	/* CLASE PARA LEER*/
	private String nombre;
	private String n_Destinos;
	private String destinos;
	
	
	
	public Iti2(String nombre, String n_Destinos, String destinos) {
		super();
		this.nombre = nombre;
		this.n_Destinos = n_Destinos;
		this.destinos = destinos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getN_Destinos() {
		return n_Destinos;
	}

	public void setN_Destinos(String n_Destinos) {
		this.n_Destinos = n_Destinos;
	}

	public String getDestinos() {
		return destinos;
	}

	public void setDestinos(String destinos) {
		this.destinos = destinos;
	}

	@Override
	public String toString() {
		return nombre + " " + n_Destinos + " " + destinos + " ";
	}
	
	
	
	
}
