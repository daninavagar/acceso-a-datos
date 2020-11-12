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
	
	public void modificarItinerario(int modi) {
		try {
			ArrayList<String> destinos3 = new ArrayList<String>();
			System.out.print("Nombre: ");
			String nombre = Main.Teclado.next();
			System.out.print("Numero de destinos: ");
			int n_destinos = Main.Teclado.nextInt();
			destinos3.clear();
			for (int i=0; i<n_destinos; i++) {
				System.out.print("Introduce Destino:  ");
				String temp_destinos = Main.Teclado.next();
				destinos3.add(temp_destinos);
			}
			itinerarios nuevo_iti = new itinerarios(nombre, n_destinos, destinos3);
			listaViajes.set(modi, nuevo_iti);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Introduce posicion correcta del array");
		}
	}
	
	public void separarFichero() {
		
	}
	
	
	public void mostrarMenorMayor() {
		/* SOLO CAMBIA DEL NUMERO DE DESTINOS FALTA CAMBIAR VALOR DE NOMBRE Y DEL ARRAY DESTINOS*/
		if (listaViajes.size() == 0) {
			System.err.println("No hay nada en la tabla");
		} else {
			for (int i=0; i<listaViajes.size(); i++) {
				for (int f=0; f<listaViajes.size(); f++) {
					if (listaViajes.get(i).getN_Destinos() < listaViajes.get(f).getN_Destinos()) {
						int temp = listaViajes.get(i).getN_Destinos();
						listaViajes.get(i).setN_Destinos(listaViajes.get(f).getN_Destinos());
						listaViajes.get(f).setN_Destinos(temp);
					}
				}
			}
			ver();
		}
		
	}
	
	public void mostrarMayorMenor() {
		/* SOLO CAMBIA DEL NUMERO DE DESTINOS FALTA CAMBIAR VALOR DE NOMBRE Y DEL ARRAY DESTINOS*/
		if (listaViajes.size() == 0) {
			System.err.println("No hay nada en la tabla");
		} else {
			for (int i=0; i<listaViajes.size(); i++) {
				for (int f=0; f<listaViajes.size(); f++) {
					if (listaViajes.get(i).getN_Destinos() > listaViajes.get(f).getN_Destinos()) {
						int temp = listaViajes.get(i).getN_Destinos();
						listaViajes.get(i).setN_Destinos(listaViajes.get(f).getN_Destinos());
						listaViajes.get(f).setN_Destinos(temp);
					}
				}
			}
			ver();
		}
	}
	
	public void destinoRepe() {
		
	}
	public void ver() {
		
		System.out.println(listaViajes);
	}
	@Override
	public String toString() {
		return ""+listaViajes+"\n\n\n";
	}
	
}
