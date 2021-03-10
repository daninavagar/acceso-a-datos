package Primero;

import java.io.*;

public class Main {

	
	// ESCRIBIR
	public static void EscribirFicheroMismaLinea(String nfichero, Alumno tabla2[]) {
		
		// 1. Creacion
		
		try {
			File fichero = new File(nfichero);
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String separador = ";";
			// 2. Escribir
			for (int i=0; i<tabla2.length; i++) {
				bw.write(tabla2[i].getNombre());
				bw.write(separador);
				bw.write(tabla2[i].getApellido());
				bw.write(separador);
			}
			
			// 3. Cierre 
			bw.close();
		} catch (IOException e) {
			System.err.println("Error el escribir: " + e.getMessage());
		}
		 
		
	}
	
	
	public static void EscribirAlumnoCadaLinea(String nfichero, Alumno tabla[]) {
		
		// 1. Creacion
		
				try {
					File fichero = new File(nfichero);
					FileWriter fw = new FileWriter(fichero);
					BufferedWriter bw = new BufferedWriter(fw);
					
					// 2. Escribir
					for (int i=0; i<tabla.length; i++) {
						bw.write(tabla[i].getNombre());
						bw.write(";"); // separador manual
						bw.write(tabla[i].getApellido());
						bw.newLine();
					}
					
					// 3. Cierre 
					bw.close();
				} catch (IOException e) {
					System.err.println("Error el escribir: " + e.getMessage());
				}
	}
	public static void EscribirAlumnoLineaDistinta(String nfichero, Alumno tabla[]) {
		
		// 1. Creacion
		
				try {
					File fichero = new File(nfichero);
					FileWriter fw = new FileWriter(fichero);
					BufferedWriter bw = new BufferedWriter(fw);
					
					// 2. Escribir
					for (int i=0; i<tabla.length; i++) {
						bw.write(tabla[i].getNombre());
						bw.newLine();
						bw.write(tabla[i].getApellido());
						bw.newLine();
					}
					
					
					// 3. Cierre 
					bw.close();
				} catch (IOException e) {
					System.err.println("Error el escribir: " + e.getMessage());
				}
	}
	
	
	
	// LECTURA
	
	public static void LeerFicheroMismaLinea(String nfichero, Alumno tablaLeer[]) {
		
		try {
			
			File fichero = new File(nfichero);
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
		// 2. Lectura
			String linea;
			String separador = ";";
			String aux = br.readLine();
			String nombre, apellido;
			int pos = 0;
			while ( (linea = br.readLine() ) != null) {
				String[] leer = aux.split(separador);
				nombre = leer[0];
				apellido = leer[1];
				Alumno alumno = new Alumno(nombre, apellido);
				tablaLeer[pos++] = alumno;
				
			}
			System.out.println("Misma Linea");
			for (int i=0; i<tablaLeer.length; i++)
				System.out.println(tablaLeer[i].toString());
			
		// 3. Cerrar
			
		br.close();
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
		
	}
	public static void LeerFicheroDistintaLinea(String nfichero, Alumno tablaLeer2[]) {
		
		// 1. Apertura
		
		try {
			
			File fichero = new File(nfichero);
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
		// 2. Lectura
			String linea; // = br.readLine();
			int pos = 0;
			String nombre, apellido;
			while ( (linea = br.readLine() ) != null) {
				nombre = linea;
				apellido = br.readLine();
				Alumno alumno = new Alumno(nombre, apellido);
				
				tablaLeer2[pos] = alumno;
				pos++;
			}
			System.out.println("DistintaLinea");
			for (int i=0; i<tablaLeer2.length; i++)
				System.out.println(tablaLeer2[i].toString());
			
		// 3. Cerrar
			
		br.close();
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
	}
	
	public static void LeerFicheroCadaLinea(String nfichero, Alumno tablaLeer3[]) {
		
		// 1. Apertura
		
		try {
			
			File fichero = new File(nfichero);
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
		// 2. Lectura
			String linea;
			String separador = ";";
			String nombre, apellido;
			int pos = 0;
			while ( (linea = br.readLine() ) != null) {
				String[] leer = linea.split(separador);
				nombre = leer[0];
				apellido = leer[1];
				Alumno alumno = new Alumno(nombre, apellido);
				tablaLeer3[pos++] = alumno;
				
				//pos++;
			}
			System.out.println("CadaLinea");
			for (int i=0; i<tablaLeer3.length; i++) {
				System.out.println(tablaLeer3[i]);
			}
			
		// 3. Cerrar
			
		br.close();
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno tabla[] = new Alumno[3];
		
		// Primera forma
		tabla[0] = new Alumno("Pepe", "Martin");
		tabla[1] = new Alumno("Ana", "Lopez");
		tabla[2] = new Alumno("Juan", "Gomez");
		
		// Segundo forma
		Alumno tabla2[] = {
			new Alumno("Pepe", "Martin"),
			new Alumno("Ana", "Lopez"),
			new Alumno("Juan", "Gomez")
		};
		
		EscribirFicheroMismaLinea("MismaLinea.txt", tabla);
		EscribirAlumnoCadaLinea("AlumnosCadaLinea.txt", tabla);
		EscribirAlumnoLineaDistinta("DistintaLinea.txt", tabla);
		
		Alumno tablaLeer[] = new Alumno[3];
		Alumno tablaLeer2[] = new Alumno[3];
		Alumno tablaLeer3[] = new Alumno[3];
		
		// LeerFicheroMismaLinea("MismaLinea.txt", tablaLeer);
		LeerFicheroDistintaLinea("DistintaLinea.txt", tablaLeer2);
		LeerFicheroCadaLinea("AlumnosCadaLinea.txt",tablaLeer3);
	}

}
