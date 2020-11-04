package Ficheros;

import java.io.*;

public class PrincipalFicherosFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File carpetaNueva = new File("Datos"),
			fichero1 = new File(carpetaNueva, "prueba"),
			fichero2 = new File(carpetaNueva, "Fichero2.txt"),
			fichero3 = new File(carpetaNueva, "Fichero3.txt");
		
		if (carpetaNueva.mkdir()) { //carpeta Nueva == true
			try {
			System.out.println("La carpeta se ha creado");
			fichero1.mkdir();
			fichero2.createNewFile();
			fichero3.createNewFile();
			} catch (IOException e) {
				System.out.println("ERROR al crear al fichero: " + e.getMessage()); // e.getMessage devuelve el mensaje de error de la clase ExceptionIO
			}
		} else {
			System.out.println("La carpeta no se ha creado");
		}
		
	}

}
