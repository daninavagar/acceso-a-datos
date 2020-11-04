package Ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

	static Scanner Leer = new Scanner(System.in);

	public static void main(String[] args) {


		int opcion = 0;
		boolean exit = false;
		do {
			try {
				System.out.println("HOLA, ELIGE UNA DE LAS OPCIONES");
				System.out.println("\n\t1. CON ARRAYLIST \n\t2. SIN ARRAYLIST \n\t3. SALIR");
				opcion = Leer.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("¡Vaya!, algo ha pasado, por favor introduce valor numérico");
				Leer.next();
			}
			

			switch (opcion) {
				case 1:
					Array();
					break;
				case 2:
					NotArray();
					break;
				case 3:
					System.out.println("GRACIAS POR VENIR, BYE!!!!");
					exit = true;
			};

		} while (!exit);

		Leer.close();
	}

	public static void Array() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		int entrada;
		System.out.println("Entrada de datos, 5 numeros");
		for (int i = 0; i < 5; i++) {
			System.out.println("Escribe numero " + (i + 1) + ": ");
			entrada = Leer.nextInt();
			list.add(entrada);
		}

		int cont = 0;
		System.out.println("El tamaño del array es: ");
		for (int i = 0; i < list.size(); i++)
			cont++;
		System.out.print(cont);

		System.out.println("\nNumero mas grande");
		int mayor = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > mayor)
				mayor = list.get(i);
		}
		System.out.println(mayor);

		System.out.println("Numero mas pequeño");
		int menor = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < menor)
				menor = list.get(i);
		}
		System.out.println(menor);

		System.out.println("\nQue numero quieres borrar: " + list);
		int borra;
		borra = Leer.nextInt();
		list.remove(borra);
		System.out.println(list);
		System.out.println("El tamaño del array es: ");

		cont = 0;
		for (int i = 0; i < list.size(); i++) {
			cont++;
		}
		System.out.println(cont);

	}

	public static void NotArray() {

		Integer[] numero = new Integer[5];
		int mayor = 0, menor = 0;
		int borrar, cont = 0;

		System.out.println("Entrada de datos, 5 numeros");
		for (int i = 0; i < numero.length; i++) {
			System.out.println("Escribe numero " + (i + 1) + ": ");
			numero[i] = Leer.nextInt();
		}

		System.out.println("Salida de datos");
		for (int i = 0; i < numero.length; i++) {
			System.out.println(numero[i] + "\n");
			cont++;
		}
		System.out.println("El tamaño del array es: " + cont);

		mayor = numero[0];
		menor = numero[0];

		System.out.println("Numero mas grande");

		for (int i = 0; i < numero.length; i++) {
			if (numero[i] > mayor) {
				mayor = numero[i];
			}
		}
		System.out.println(mayor);
		System.out.println("Numero mas pequeño");
		for (int i = 1; i < numero.length; i++) {
			if (numero[i] < menor) {
				menor = numero[i];
			}
		}

		System.out.println(menor);
		int x;
		cont = 0;
		System.out.println("\n Que numero quieres borrar: \n\n");
		borrar = Leer.nextInt();
		for (x = 0; x < numero.length; x++) {
			if (x == borrar) {
				numero[x] = 0;
			}
			if (numero[x] != 0) {
				System.out.println(numero[x]);
				cont++;
			}

		}

		System.out.println("El tamaño del array es: " + cont);

	}
}
