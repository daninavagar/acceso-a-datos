package TablaNumerosClases;

import java.util.Scanner; 
import java.util.InputMismatchException;


public class Main {
	
	static final Scanner Leer = new Scanner (System.in);

	public static void main(String[] args) {
		
		
		int opcion=0;
		boolean exit=false;
		TablaNumeros TABLA = new TablaNumeros();

		do {
			
			try {
				System.out.println("BIENVENIDO, elige una de las opciones");
				System.out.println("\t1. Introducir Numero \n\t2. Borrar Numero \n\t3. Mostrar Tabla \n\t4. Menor de la Tabla \n\t5. Mayor de la Tabla \n\t6. Ordenar Tabla \n\t7. Salir");
				opcion = Leer.nextInt();
			} catch (InputMismatchException e){
				System.out.println("Algo ha pasado, por favor introduce valor numérico");
				Leer.next();
			}
			
			switch (opcion) {
				case 1:
					TABLA.insertarNumero();
					break;
				case 2:
					TABLA.borrar();
					break;
				case 3:
					TABLA.imprimir();
					break;
				case 4:
					TABLA.menor();
					break;
				case 5:
					TABLA.mayor();
					break;
				case 6:
					TABLA.ordenar();
					break;
				case 7:
					System.out.println("GRACIAS POR VENIR");
					exit = true;
					break;
			}
			
		} while (!exit);	
		Leer.close();
	}
	
}
