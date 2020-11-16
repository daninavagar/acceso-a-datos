package Default;

import java.util.ArrayList;


public class TablaItinerarios {

	
	public ArrayList<itinerarios> listaViajes = new ArrayList<itinerarios>();
	ficheroItinerarios ficherito = new ficheroItinerarios();

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
		ficherito.abrir();
		ficherito.leerItinerario(ficherito.getArchivo());
		Iti2 temp;
		if (ficherito.getTablita().size() == 0) {
			System.err.println("No hay nada en la tabla");
		} else {
			for (int i=0; i<ficherito.getTablita().size(); i++) {
				for (int f=i+1; f<ficherito.getTablita().size(); f++) {
					if (Integer.parseInt(ficherito.getTablita().get(i).getN_Destinos()) < Integer.parseInt(ficherito.getTablita().get(f).getN_Destinos()) ) {
						temp = ficherito.getTablita().get(i);
						ficherito.getTablita().set(i, ficherito.getTablita().get(f));
						ficherito.getTablita().set(f, temp);
					}
				}
			}
			ver();
		}	
	}
	
	public void mostrarMayorMenor() {
		/* SOLO CAMBIA DEL NUMERO DE DESTINOS FALTA CAMBIAR VALOR DE NOMBRE Y DEL ARRAY DESTINOS*/
		ficherito.abrir();
		ficherito.leerItinerario(ficherito.getArchivo());
		if (ficherito.getTablita().size() == 0) {
			System.err.println("No hay nada en la tabla");
		} else {
			Iti2 temp;
			for (int i=0; i<ficherito.getTablita().size(); i++) {
				for (int f=i+1; f<ficherito.getTablita().size(); f++) {
					if (Integer.parseInt(ficherito.getTablita().get(i).getN_Destinos()) > Integer.parseInt(ficherito.getTablita().get(f).getN_Destinos()) ) {
						temp = ficherito.getTablita().get(i);
						ficherito.getTablita().set(i, ficherito.getTablita().get(f));
						ficherito.getTablita().set(f, temp);
					}
				}
			}
			ver();
		}
	}
	
	public void destinoRepe() {
			
		String Repe = " ";
		int temp = 0;
		
		ficherito.leerItinerario(ficherito.getArchivo());
			for (int i=0; i<ficherito.getTablita().size(); i++) {
				int aux = 0;
				for (int f=0; f<ficherito.getTablita().size(); f++) {
					if (ficherito.getTablita().get(i).getDestinos() == ficherito.getTablita().get(f).getDestinos()) {
						aux++;
					}
					if (aux > temp) {
						temp = aux;
						Repe = ficherito.getTablita().get(f).toString();
					}
				}
			}
			System.out.println("El destino mas repetido es " + Repe);	

				
	}
	public void ver() {
		
		System.out.println(listaViajes);
		
	}
	@Override
	public String toString() {
		return ""+listaViajes+"\n\n\n";
	}
	
}
