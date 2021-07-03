package EjercicioTablaNumeros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int opcion = 0;
		boolean exit = false;
		Scanner leer = new Scanner(System.in);
		TablaNumeros tablanumeros = new TablaNumeros();
		do {
			
			try {
				System.out.println("Elige una de las opciones. "
						+ "\n\t 1. Insertar Numero"
						+ "\n\t 2. Borrar Numero"
						+ "\n\t 3. Mostrar Tabla"
						+ "\n\t 4. Menor de la Tabla"
						+ "\n\t 5. Mayor de la Tabla"
						+ "\n\t 6. Ordenar Tabla"
						+ "\n\t 7. Salir");
				opcion = leer.nextInt();	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca valor numerico");
				leer.next();
			}
			
			switch (opcion) {
				case 1:
					System.out.println("Introduce numero");
					int num = leer.nextInt();
					tablanumeros.insertar(num);
					break;
				case 2:
					tablanumeros.imprimir();
					System.out.println("Introduce posicion");
					int num2 = leer.nextInt();
					tablanumeros.borrar(num2);
					break;
				case 3:
					tablanumeros.imprimir();
					break;
				case 4:
					tablanumeros.menor();
					break;
				case 5:
					tablanumeros.mayor();
					break;
				case 6:
					tablanumeros.ordenar();
					break;
				case 7:
					System.out.println("Gracias por venir Adios");
					exit = true;
					leer.close();
					break;
			}
			
			
		} while (!exit);
	}

}
