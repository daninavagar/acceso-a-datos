package FicherosOO;

import java.io.*;

public class TablaNombres {
	
	
	private String tabla[];
	private int posicion; //, tamaño;
	
	public TablaNombres() {
		tabla = new String[30];
		posicion = 0;
		// tamaño = 0;
	}
	
	
	public void escribirFichero(String nombre) {
		
		
		try {
		// 1. Creacion Fichero
		
		File fichero = new File(nombre);
		FileWriter ficheroFW = new FileWriter(fichero);
		BufferedWriter ficheroBW = new BufferedWriter(ficheroFW);
		
		// 2. Escribir datos en el fichero
		
		for (int i=0; i<posicion; i++) {
			ficheroBW.write(tabla[i]);
			ficheroBW.newLine();
		}
		
		// 3. Cerra el fichero
		ficheroBW.close();
		
		
		} catch (IOException e) {
			System.err.println("Error al crear al fichero" + e.getMessage());
		}
	}
	
	public void leerFichero(String nombre) {
		
		try {
			// 1. Creacion fichero para leer
			File fichero = new File(nombre);
			FileReader ficheroR = new FileReader(fichero);
			BufferedReader ficheroBR = new BufferedReader(ficheroR);
			String linea = "";
			posicion = 0;
			
			// 2. Leer fichero
			linea = ficheroBR.readLine();
			while (linea != null) {
			tabla[posicion] = linea;
			posicion++;
			linea = ficheroBR.readLine();
			}
			
			// 3. Cierre fichero
			ficheroBR.close();
			
		} catch (IOException e) {
			System.err.println("Error al leer al fichero" + e.getMessage());
		}
	}
	
	public void imprimirPantalla() {
		System.out.println("Contenido de la tabla es: ");
		for (int i=0; i<posicion; i++) {
			System.out.println(tabla[i] + " - ");
		}
	}
	
	public void insertarNombre(String nombre) {
		
		tabla[posicion] = nombre;
		posicion++;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
