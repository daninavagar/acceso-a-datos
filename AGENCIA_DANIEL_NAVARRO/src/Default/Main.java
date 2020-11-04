package Default;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner Teclado = new Scanner(System.in);
		int opcion = 0;
		boolean exit = false;
		
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
					System.out.println("Hola");
					break;
				case 2:
					System.out.println("Hola");
					break;
				case 3:
					System.out.println("Hola");
					break;
				case 4:
					System.out.println("Hola");
					break;
				case 5:
					System.out.println("Hola");
					break;
				case 6:
					System.out.println("Hola");
					break;
				case 7:
					System.out.println("Hola");
					break;
				case 8:
					System.out.println("Hola");
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
