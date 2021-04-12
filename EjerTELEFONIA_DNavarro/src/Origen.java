import java.util.ArrayList;

public class Origen {
	
	private  ArrayList<Integer> origen = new ArrayList<Integer>();
	private ArrayList<Abonados> listaAbonados = new ArrayList<Abonados>();
	
	
	public Origen(ArrayList<Integer> origen, ArrayList<Abonados> listaAbonados) {
		
		this.origen = origen;
		this.listaAbonados = listaAbonados;
	}


	public ArrayList<Integer> getOrigen() {
		return origen;
	}


	public void setOrigen(ArrayList<Integer> origen) {
		this.origen = origen;
	}


	public ArrayList<Abonados> getListaAbonados() {
		return listaAbonados;
	}


	public void setListaAbonados(ArrayList<Abonados> listaAbonados) {
		this.listaAbonados = listaAbonados;
	}


	@Override
	public String toString() {
		return "Origen [origen=" + origen + ", listaAbonados=" + listaAbonados + "]";
	}
	
	
	

}
