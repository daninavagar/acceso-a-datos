package Ejercicio;

import java.util.InputMismatchException;
import java.util.Scanner;
public class numero {

	static Scanner Leer = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		boolean exit = false;
		int opcion = 0;
		ficheronum f_num = new ficheronum();
		f_num.abrir_carpeta();
		
		do {
			
			System.out.println("+-----------------------------------------+");
			System.out.println("| FICHEROS CON NUMEROS                    |");
			System.out.println("+-----------------------------------------+");
			System.out.println("| 1. Escribir fichero                     |");
			System.out.println("| 2. Leer fichero                         |");
			System.out.println("| 3. Escribir datos                       |");
			System.out.println("| 4. Modificar tabla                      |");
			System.out.println("| 5. Actualizar tabla fichero             |");
			System.out.println("| 6. Salir                                |");
			System.out.println("+-----------------------------------------+");
			try {
				System.out.println("Que opcion eliges");
				opcion = Leer.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Por favor introduce valor numérico");
				Leer.nextLine();
			}
			
			switch (opcion) {
				case 1:
					f_num.escribirFichero();
					break;
				case 2:
					f_num.leerFichero();
					break;
				case 3:
					f_num.insertarNumero();
					break;
				case 4:
					f_num.modificarTabla();
					break;
				case 5:
					f_num.actualizarTabla();
					break;
				case 6:
					System.out.println("GRACIAS POR VENIR");
					exit = true;
					break;
			}
		
		} while (!exit);
		Leer.close();
	}
}
