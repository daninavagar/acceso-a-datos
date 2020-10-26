package FicherosBuffered05;

import java.io.*;

public class PrincipalBuffered {
	
	
	public static void escribirFichero(String nombre, String[] tabla) {
		
		try {
			// 1. Creacion del fichero para leer
			File fichero = new File(nombre);
			FileWriter ficheroFW = new FileWriter(fichero);
			BufferedWriter ficheroBW = new BufferedWriter(ficheroFW);
			
			// 2. Escribir datos en el fichero
			for(int i=0; i<tabla.length; i++) {
				ficheroBW.write(tabla[i]);
				ficheroBW.newLine();
			}
			
			
			// 3. Cerrar el fichero
			ficheroBW.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
	}
	
	public static void leerFichero(String nombre, String[] tabla) {
		
		try {
			// 1. Creacion del fichero
			File fichero = new File(nombre);
			FileReader ficheroR = new FileReader(fichero);
			BufferedReader ficheroBR = new BufferedReader(ficheroR);
			int posicion = 0;
			String linea = "";
			
			// 2. Lectura del fichero
			
			linea = ficheroBR.readLine();
			while(linea != null) {
				posicion++;
				linea = ficheroBR.readLine();
			}
			
			// 3. Cerrar el fichero
			ficheroBR.close();
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
		
		String []tablaNombres = {"Juan", "Ana Maria", "Eduardo", "David"};
		
		
		// Llamada a escribir el fichero
		escribirFichero("PruebaNombres.txt", tablaNombres);
		
		// Vaciar la tabla
		// vaciarTabla(tablaNombres);
		// imprimirPantalla(tablaNombres);
		leerFichero("PruebaNombres.txt", tablaNombres);
		imprimirPantalla(tablaNombres);
		vaciarTabla(tablaNombres);
		leerFichero("PruebaNombres.txt", tablaNombres);
		imprimirPantalla(tablaNombres);
		
		
		System.out.println("Done");

	}

}
