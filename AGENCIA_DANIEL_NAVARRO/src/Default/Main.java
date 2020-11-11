package Default;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	final static Scanner Teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int opcion = 0;
		boolean exit = false;
		String nombre = null, temp;
		int n_destinos = 0;
		ArrayList<String> destinos2 = new ArrayList<String>();	
		
		ficheroItinerarios ficheroItinerarios  = new ficheroItinerarios();
		TablaItinerarios tablaItinerario = new TablaItinerarios();
		itinerarios itinerarios = new itinerarios();
		// ficheroItinerarios.nombre();
		ficheroItinerarios.abrir();
		do {
			try {
				System.out.println("+-------------------------------------------+");
				System.out.println("| AGENCIAS DE VIAJES                        |");
				System.out.println("+-------------------------------------------+");
				System.out.println("| 1.  Leer Fichero                          |");
				System.out.println("| 2.  Insertar Itinerario                   |");
				System.out.println("| 3.  Borrar Itinerario                     |");
				System.out.println("| 4.  Vaciar                                |");
				System.out.println("| 5.  Modificar Itinerario                  |");
				System.out.println("| 6.  Guardar Fichero                       |");
				System.out.println("| 7.  Separar Fichero                       |");
				System.out.println("| 8.  Mostrar Contenido                     |");
				System.out.println("| 9.  Mostrar Itinerario Menor a Mayor      |");
				System.out.println("| 10. Mostrar Itinerario Mayor a Menor      |");
				System.out.println("| 11. Mostrar Destino Mas Repetido          |");
				System.out.println("| 12. Salir                                 |");
				System.out.println("+-------------------------------------------+");
				opcion = Teclado.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Un valor num�rico por favor :");
				Teclado.nextLine();
			}
			
			
			switch (opcion) {
				case 1:
					ficheroItinerarios.leerItinerario(ficheroItinerarios.archivo, itinerarios, tablaItinerario);
					break;
				case 2:
					System.out.print("Nombre: ");
					nombre = Teclado.next();
					System.out.print("Numero de destinos: ");
					n_destinos = Teclado.nextInt();
					destinos2.clear();
					for (int i=0; i<n_destinos; i++) {
						System.out.print("Introduce Destino:  ");
						temp = Teclado.next();
						destinos2.add(temp);
					}
					tablaItinerario.insertarFichero(new itinerarios(nombre, n_destinos, destinos2));
					break;
				case 3:
					tablaItinerario.ver();
					System.out.println("Cual quieres borrar");
					int opt = Teclado.nextInt();
					tablaItinerario.borrarItinerario(opt);
					break;
				case 4:
					ficheroItinerarios.vaciar();
					System.out.println("Se ha borrado el archivo");
					break;
				case 5:
					System.out.println("Hola");
					break;
				case 6:
					for (int i=0; i<tablaItinerario.listaViajes.size() ; i++) {
						ficheroItinerarios.escribirItinerario(itinerarios, tablaItinerario);
					}
					break;
				case 7:
					System.out.println("Hola");
					break;
				case 8:
					tablaItinerario.ver();
					break;
				case 9:
					System.out.println("Hola");
					break;
				case 10:
					System.out.println("Hola");
					break;
				case 11:
					System.out.println("Hola");
					break;
				case 12:
					System.out.println("Hola");
					exit = true;
					break;
			}
		} while (!exit);
		Teclado.close();
	}

}
