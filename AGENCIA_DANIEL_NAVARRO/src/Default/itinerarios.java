package Default;

import java.util.ArrayList;

public class itinerarios {

	private String nombre;
	private int n_Destinos;
	private ArrayList<String> destinos = new ArrayList<String>();
	
	
	public itinerarios(String nombre, int n_Destinos, ArrayList<String> destinos) {
		super();
		this.nombre = nombre;
		this.n_Destinos = n_Destinos;
		this.destinos = destinos;
	}
	

	public itinerarios() {
		super();
	}


	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getN_Destinos() {
		return n_Destinos;
	}


	public void setN_Destinos(int n_Destinos) {
		this.n_Destinos = n_Destinos;
	}


	public ArrayList<String> getDestinos() {
		return destinos;
	}


	public void setDestinos(ArrayList<String> destinos) {
		this.destinos = destinos;
	}


	@Override
	public String toString() {
		return ""+ nombre + "\n" + n_Destinos + " \n" + destinos;
	}
	
	
}
