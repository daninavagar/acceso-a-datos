package Primero;

import java.io.*;

public class Main {

	
	public static void LeerFicheroEnLineasDistintas(String nfichero, Alumnos tabla[]){
		
		// 1. apertura
		
		try {
			File f = new File(nfichero);
			FileReader fr;
			fr = new FileReader(f);
			BufferedReader fbr = new BufferedReader(fr);
			
			String linea = fbr.readLine();
			int pos = 0;
			while (linea != null) {
				String nombre, apellido;
				Alumnos alumno;
				// 2. leer datos del fichero.
				
				nombre = linea;
				apellido = fbr.readLine();
				linea = fbr.readLine();
				alumno = new Alumnos(nombre, apellido);
				
				tabla[pos] = alumno;
				pos++;
				
				
				// 3. cierre
				fbr.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error el leer: " + e.getMessage());
		}

	}
	
	public static void EscribirFicheroLineasDistintas(String nfichero, Alumnos tabla[]) {
		
		// 1. creacion
		
				try {
					File f = new File(nfichero);
					FileWriter fw;
					fw = new FileWriter(f);
					BufferedWriter fbw = new BufferedWriter(fw);
					
					
					for (int i=0; i<tabla.length; i++) {
						// 2. escribir
						fbw.write(tabla[i].getNombre());
						fbw.newLine();
						fbw.write(tabla[i].getApellido());
						fbw.newLine();			}
					
					
					// 3. cerrar
					fbw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error el escribir: " + e.getMessage());
				}
		
	}
	
	public static void EscribirFicheroCadaAlumnoUnaLinea(String nfichero, Alumnos tabla[]){
		
		// 1. creacion
		
		try {
			File f = new File(nfichero);
			FileWriter fw;
			fw = new FileWriter(f);
			BufferedWriter fbw = new BufferedWriter(fw);
			
			
			for (int i=0; i<tabla.length; i++) {
				// 2. escribir
				fbw.write(tabla[i].getNombre());
				fbw.write(";");
				fbw.write(tabla[i].getApellido());
				fbw.newLine();			}
			
			
			// 3. cerrar
			fbw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error el escribir: " + e.getMessage());
		}

	}

	public static void EscribirFicheroMismaUnaLinea(String nfichero, Alumnos tabla[]){
	
	// 1. creacion
	
	try {
		File f = new File(nfichero);
		FileWriter fw;
		fw = new FileWriter(f);
		BufferedWriter fbw = new BufferedWriter(fw);
		
		
		for (int i=0; i<tabla.length; i++) {
			// 2. escribir
			fbw.write(tabla[i].getNombre());
			fbw.write(";");
			fbw.write(tabla[i].getApellido());
					}
		
		
		// 3. cerrar
		fbw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error el escribir: " + e.getMessage());
	}

}
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumnos tabla[] = new Alumnos[3];
		
		tabla[0] = new Alumnos("Pepe", "Martin");
		tabla[1] = new Alumnos("Ana", "Lopez");
		tabla[2] = new Alumnos("Juan", "Gomez");
		
		Alumnos tabla2[] = {
				new Alumnos("Pepe", "Martin"),
				new Alumnos("Ana", "Lopez"),
				new Alumnos("Juan", "Gomez")
		};
		
		EscribirFicheroLineasDistintas("AlumnosLDistintas.txt", tabla);
		EscribirFicheroCadaAlumnoUnaLinea("AlumnosCadaLinea.txt", tabla);
		EscribirFicheroMismaUnaLinea("AlumnosMismaLinea.txt", tabla);
		
		Alumnos tablaLeer[] = new Alumnos[4];
		
		LeerFicheroEnLineasDistintas("AlumnosLDistintas.txt", tablaLeer);
		
		
	}

}
