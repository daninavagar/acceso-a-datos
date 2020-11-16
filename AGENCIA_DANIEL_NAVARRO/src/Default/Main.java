package Default;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	final static Scanner Teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int opcion = 0;
		boolean exit = false;
		String nombre = null, temp;
		int n_destinos = 0;
		ArrayList<String> destinos2 = new ArrayList<String>();	
		
		ficheroItinerarios ficheroItinerarios  = new ficheroItinerarios();
		TablaItinerarios tablaItinerario = new TablaItinerarios();
		
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
				System.err.println("Un valor numérico por favor :");
				Teclado.nextLine();
			}
			
			
			switch (opcion) {
				case 1:
					ficheroItinerarios.abrir();
					ficheroItinerarios.leerItinerario(ficheroItinerarios.archivo);
					break;
				case 2:
					ficheroItinerarios.abrir();
					System.out.print("Nombre: ");
					nombre = Teclado.next();
					System.out.print("Numero de destinos: ");
					n_destinos = Teclado.nextInt();
					destinos2 = new ArrayList<String>();
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
					System.out.println("Se ha vaciado el archivo");
					break;
				case 5:
					tablaItinerario.ver();
					System.out.println("Que itinerario quieres modificar: ");
					int modificar = Teclado.nextInt();
					tablaItinerario.modificarItinerario(modificar);	
					break;
				case 6:
						ficheroItinerarios.escribirItinerario(tablaItinerario);
					break;
				case 7:
					System.out.println("Separar");
					break;
				case 8:
					tablaItinerario.ver();
					break;
				case 9:
					tablaItinerario.mostrarMenorMayor();
					break;
				case 10:
					tablaItinerario.mostrarMayorMenor();
					break;
				case 11:
					tablaItinerario.destinoRepe();
					break;
				case 12:
					System.out.println("GRACIAS POR VENIR");
					exit = true;
					break;
			}
		} while (!exit);
		Teclado.close();
	}

}
