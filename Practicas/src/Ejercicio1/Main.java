package Ejercicio1;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*
         * Programa, numeros por teclado y menu
         * 1.- Meter numero
         * 2.- Escribir numero por pantalla
         * 3.- Escribir el numero mas alto
         * 4.- Escribir el numero mas bajo
         * 5.- Borrar numero
         * 6.- Salir
         */
		
		Scanner Leer = new Scanner (System.in);
		int[] numero = new int[5];
		int mayor=0, menor=0;
		
		
		System.out.println("Entrada de datos");
		for (int i=0; i<numero.length; i++) {
			System.out.println("Escribe numero: ");
			numero[i] = Leer.nextInt();
		}
		
		System.out.println("Salida de datos");
		for (int i=0; i<numero.length; i++) {
			System.out.println(numero[i]+"\n");
		}
		System.out.println("Numero mas grande");
		
		for (int i=0; i<numero.length;i++) {
			if (numero[i]>mayor) {
				mayor = numero[i];	
			}
		}
		for (int i=0; i>numero.length;i++) {
			if (numero[i]>menor) {
				menor = numero[i];	
			}
		}
		
		

		System.out.println(mayor);
		System.out.println(menor);
		
		
		
		
		
		
		

		Leer.close();
	}

}
