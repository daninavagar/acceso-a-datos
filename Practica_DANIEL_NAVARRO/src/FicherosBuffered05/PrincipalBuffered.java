package FicherosBuffered05;

import java.io.*;

public class PrincipalBuffered {
	
	
	public static void leerFichero(String nombre, String[] tabla) {
		
		try {
			// 1. Creacion del fichero para leer
			File fichero = new File(nombre);
			FileReader ficheroR = new FileReader(fichero);
			BufferedReader ficheroBF = new BufferedReader(ficheroR);
			int posicion = 0;
			String linea;
			
			// 2. Lectura del fichero
			linea = ficheroBF.readLine();
			tabla[posicion] = linea;
			
			
			ficheroBF.close();
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void imprimirPantalla(String[] tabla) {
		
		System.out.println("El contenido de la tabla es: ");
		for (int i=0; i<tabla.length; i++) {
			System.out.println(tabla[i] + " - ");
		}
	}
	
	public static void vaciarTabla(String[] tabla) {
		for (int i=0; i<tabla.length; i++) {
			tabla[i] = "";
		}
	}

	public static void main(String[] args) {
		
		// llamada a escibir fichero
		
		String []tablaNombres = {"Juan", "Ana Maria", "Eduardo", "David"};
		
		leerFichero("Prueba1.txt", tablaNombres);
		
		// Vaciar la tabla
		vaciarTabla(tablaNombres);
		imprimirPantalla(tablaNombres);
		leerFichero("Prueba1.txt", tablaNombres);
		imprimirPantalla(tablaNombres);
		
		
		System.out.println("Done");

	}

}
