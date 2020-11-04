package Persona;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TablaPersona {

	private static persona tabla[];
	private int posicion;
	
	
	public TablaPersona() {
		super();
		this.tabla = tabla;
		this.posicion = posicion;
	}
	
	
	public static void escribirFichero(persona persona, File file1) {
		
		try {
			FileWriter fileFW = new FileWriter(file1);
			BufferedWriter fileBW = new BufferedWriter(fileFW);
			/*
			for (int i=0; i<tabla.length; i++) {
				fileBW.write(null, i, i);
				fileBW.newLine();
			}*/
			/*
			for (persona tabla2 : tabla) {
				fileBW.write(persona.getNombre());
				fileBW.newLine();
			}
			*/
			
			
			
			
			
			fileBW.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
