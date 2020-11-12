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
	@Override
	public String toString() {
		return nombre + "\n" + n_Destinos + "\n" + destinos + "\n";
	}
	
	
	
	
}
