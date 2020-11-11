package Default;



import java.util.ArrayList;





public class TablaItinerarios {

	
	public ArrayList<itinerarios> listaViajes = new ArrayList<itinerarios>();

	public TablaItinerarios(ArrayList<itinerarios> listaViajes) {
		super();
		this.listaViajes = listaViajes;
	}
	public TablaItinerarios() {
	}
	
	public void insertarFichero(itinerarios itinerarios) {
		
		listaViajes.add(itinerarios);

	}
	
	public void borrarItinerario(int numero) {
		
		try {
			listaViajes.remove(numero);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Introduce posicion correcta del array");
		}
		
	}
	
	public void vaciar()  {
		listaViajes.clear();
	}
	
	public void modificarItinerario() {
		
	}
	
	public void guardarFichero() {
		
	}
	
	public void separarFichero() {
		
	}
	
	public void mostrarContenido() {
		
	}
	
	public void mostrarMenorMayor() {
		
	}
	
	public void mostrarMayorMenor() {
		
	}
	
	public void destinoRepe() {
		
	}
	public void ver() {
		
		for (int i=0; i<listaViajes.size(); i++) {
			System.out.println("["+i+"]" + "\n " + listaViajes);
		}
	}
	@Override
	public String toString() {
		return ""+listaViajes+"\n\n\n";
	}
	
}
