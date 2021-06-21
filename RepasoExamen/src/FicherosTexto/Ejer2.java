package FicherosTexto;

import java.io.*;
import java.util.ArrayList;

public class Ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 2. Crear un programa en Java que escriba una lista de nombres existentes en una tabla de Strings. Se realizarán los dos métodos.
		 * 			1. escribirFichero. Recibe como parámetro una tabla de Strings rellena con nombres y escribe sobre un fichero de texto 
		 * 								el contenido de la tabla.
		 * 			2. leerFichero. Recibe como parametro una tabla de Strings vacía y lee de un fichero los datos existentes en el mismo y 
		 * 							los almacena en la tabla pasado como parámetro. 
		 * */
		
		ArrayList<String> tablaNombres = new ArrayList<String>();
		tablaNombres.add("Ana");
		tablaNombres.add("Dani");
		tablaNombres.add("Pepe");
		tablaNombres.add("Juan");
		tablaNombres.add("Pedro");
		tablaNombres.add("Diego");
		tablaNombres.add("Sara");
		ArrayList<String> tablaLeer = new ArrayList<String>();
		
		escribirFichero(tablaNombres);
		leerFichero(tablaLeer);
		
		System.out.println(tablaLeer.toString());
		
	}
	
	public static void escribirFichero(ArrayList<String> tablaNombres) {
		
		File fichero = new File("src/FicherosTexto", "Archivo2.txt");
		try {
			FileWriter writer = new FileWriter(fichero);
			BufferedWriter buffer = new BufferedWriter(writer);
			
			for (int i=0; i<tablaNombres.size(); i++) {
				buffer.write(tablaNombres.get(i));
				buffer.newLine();
			}
			
			buffer.close();
		} catch (IOException e) {
			System.err.println("Error el escribir: " + e.getMessage());
		}
	}
	public static void leerFichero(ArrayList<String> tablaLeer) {
		
		File fichero = new File("src/FicherosTexto", "Archivo2.txt");
		
		try {
			FileReader reader = new FileReader(fichero);
			BufferedReader buffer = new BufferedReader(reader);
			
			String linea = buffer.readLine();
			
			while (linea != null) {
				
				String aux = linea;
				tablaLeer.add(linea);
				linea = buffer.readLine();
				
			}
			
			buffer.close();
		} catch (IOException e) {
			System.err.println("Error al leer: " + e.getMessage());
		}

		
	}

}
