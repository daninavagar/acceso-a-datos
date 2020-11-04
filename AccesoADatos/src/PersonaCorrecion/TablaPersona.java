package PersonaCorrecion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TablaPersona {

	private persona tabla[];
	private int posicion;
	
	
	
	public TablaPersona() {
		super();
		this.tabla = tabla;
		this.posicion = posicion;
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



	public void insertarPersona(persona p1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
