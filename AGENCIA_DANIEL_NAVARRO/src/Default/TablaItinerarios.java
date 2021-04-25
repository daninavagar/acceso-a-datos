package Default;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


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
		
		if (!listaViajes.isEmpty())
			listaViajes.add(itinerarios);
		else 
			System.err.println("La tabla esta vacia, no se puede añadir nada");

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
		ficherito.abrir("Viajes");
		ficherito.leerItinerario(ficherito.archivo);
		
		try {
			ficherito.abrir("primero");
			ficherito.abrir("segundo");
			
			FileWriter primeroW = new FileWriter("primero.txt", true);
			FileWriter segundoW = new FileWriter("segundo.txt", true);
			
			BufferedWriter primeroBW = new BufferedWriter(primeroW);
			BufferedWriter segundoBW = new BufferedWriter(segundoW);
			
			for (int i=0; i<ficherito.tablita.size(); i++) {
				if (Integer.parseInt(ficherito.tablita.get(i).getN_Destinos()) > 1) {
					primeroBW.write(ficherito.tablita.get(i).toString());
				} else {
					segundoBW.write(ficherito.tablita.get(i).toString());
				}
				
			}
			primeroBW.close();
			segundoBW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void mostrarMenorMayor() {
		/* SOLO CAMBIA DEL NUMERO DE DESTINOS FALTA CAMBIAR VALOR DE NOMBRE Y DEL ARRAY DESTINOS */
		ficherito.abrir("Viajes");
		ficherito.leerItinerario(ficherito.archivo);
		ArrayList<Iti2> tablaOrdenar = ficherito.getTablita();
		Iti2 temp = null;
		if (!ficherito.tablita.isEmpty()) {
			System.err.println("No hay nada en la tabla");
		} else {
			
			for (int i=0; i<tablaOrdenar.size(); i++) {
				for (int f=0; f<tablaOrdenar.size(); f++) {
					if (Integer.parseInt(tablaOrdenar.get(i).getN_Destinos()) < Integer.parseInt(tablaOrdenar.get(f).getN_Destinos()) ) {
						temp = tablaOrdenar.get(i);
						tablaOrdenar.set(i, tablaOrdenar.get(f));
						tablaOrdenar.set(f, temp);
					}
				}
			}
			System.out.println(tablaOrdenar);
			
		}
	}
	
	
	public void mostrarMayorMenor() {
		/* SOLO CAMBIA DEL NUMERO DE DESTINOS FALTA CAMBIAR VALOR DE NOMBRE Y DEL ARRAY DESTINOS */
		ficherito.abrir("Viajes");
		ficherito.leerItinerario(ficherito.archivo);
		Iti2 temp = null;
		ArrayList<Iti2> tablaOrdenar = ficherito.getTablita();
		if (!ficherito.tablita.isEmpty()) {
			System.err.println("No hay nada en la tabla");
		} else {
			
			for (int i=0; i<tablaOrdenar.size(); i++) {
				for (int f=i+1; f<tablaOrdenar.size(); f++) {
					if (Integer.parseInt(tablaOrdenar.get(i).getN_Destinos()) > Integer.parseInt(tablaOrdenar.get(f).getN_Destinos()) ) {
						temp = tablaOrdenar.get(i);
						tablaOrdenar.set(i, tablaOrdenar.get(f));
						tablaOrdenar.set(f, temp);
					}
				}
			}
			System.out.println(tablaOrdenar);
			
		}
	}
	
	
	public void destinoRepe() {
			
		Iti2 Repe = null;
		
		
		ficherito.abrir("Viajes");
		ficherito.leerItinerario(ficherito.archivo);
		ArrayList<String> diego = new ArrayList<String>();
		int aux = 0, temp = -1;
		
		for (int i=0; i<ficherito.tablita.size(); i++) {
				diego.add(ficherito.tablita.get(i).getDestinos());
			
		}
		for (int i=0; i<diego.size(); i++) {
			if (Collections.frequency(diego, diego.get(i)) > aux) {
				temp = Collections.frequency(diego, diego.get(i));
				temp = i;
			}	
		}
			Repe = ficherito.tablita.get(temp);
			System.out.println("El destino mas repetido es " + Repe);	

				
	}
	public void ver() {
		if (!listaViajes.isEmpty()) {
			System.out.println(listaViajes);
		} else {
			System.err.println("La tabla está vacía");
		}
		
	}
	@Override
	public String toString() {
		return ""+listaViajes+"\n\n\n";
	}
	
}
