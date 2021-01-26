package TablaString;

import java.util.*;

public class principal {

	static Scanner Leer = new Scanner (System.in);
	public static void main(String[] args) {
		
		int opcion = 0;
		boolean exit = false;
		
		TablaNombres tabla = new TablaNombres();
		
		tabla.abrir();
		do {
			
			try {
				System.out.println("+--------------------------------------+");
				System.out.println("| ELIGE UNA OPCION                     |");
				System.out.println("+--------------------------------------+");
				System.out.println("| 1. Escribir fichero                  |");
				System.out.println("| 2. Leer fichero                      |");
				System.out.println("| 3. SALIR                             |");
				System.out.println("+--------------------------------------+");
				opcion = Leer.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Introduzca un valor numerico");
				Leer.nextLine();
			}
			
			
			switch (opcion) {
				case 1:
					tabla.escribir();
					break;
				case 2:
					tabla.leer();
					break;
				case 3:
					System.out.println("ADIOS");
					exit = true;
			}
			
		} while (!false);
	}

}
