package TablaNumerosClases;

import java.util.Scanner; 
import java.util.InputMismatchException;


public class Main {
	
	static Scanner Leer = new Scanner (System.in);

	public static void main(String[] args) {
		
		
		int opcion=0, numero, mayor = 0, menor = 0;
		// boolean exit = false;
		
	
		boolean exit=false;
		
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
					System.out.println("Dime un numero para el array");
					numero = Leer.nextInt();
					TablaNumeros.insertar(numero);
					break;
				case 2:
					System.out.println("Que numero quieres borrar, dime la posicion");
					numero = Leer.nextInt();
					TablaNumeros.borrar(numero);
					break;
				case 3:
					TablaNumeros.imprimir();
					break;
				case 4:
					TablaNumeros.menor(menor);
					break;
				case 5:
					TablaNumeros.mayor(mayor);
					break;
				case 6:
					TablaNumeros.ordenar();
					break;
				case 7:
					System.out.println("ADios");
					exit = true;
					break;
			}
			
		} while (!exit);
			
		Leer.close();
	}
	
}
