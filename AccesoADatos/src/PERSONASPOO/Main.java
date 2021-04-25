package PERSONASPOO;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

	
	public static void main(String[] args) {
		
	
		Scanner Read = new Scanner(System.in);
		boolean exit = false;
		int opc = 0;
		TablaPersonas people = new TablaPersonas(20);
		/* Crear carpeta y fichero */
		File dir = new File("Personitas"),
		file1 = new File(dir, "Coleccion.txt");
		
		if (dir.mkdir()) {
			
			try {
				System.out.println("La carpeta se ha creado");
				file1.createNewFile();
			} catch (IOException e) {
				System.err.println("Error al crear el fichero " + file1 + e.getMessage());
			}
		} else {
			System.out.println("La carpeta ya esta creada");
		}
		
		
		
		do {
			try {
				System.out.println("DIME UNA DE LAS OPCIONES");
				System.out.println("+----------------------------------+");
				System.out.println("| 1. Crear Persona                 |");
				System.out.println("| 2. Ver Persona                   |");
				System.out.println("| 3. Escribir Fichero              |");
				System.out.println("| 4. Leer Fichero                  |");
				System.out.println("| 5. Salir                         |");
				System.out.println("+----------------------------------+");
				opc = Read.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Valor numero pls");
				Read.nextLine();
			}	
			
			
			
			switch (opc) {
				case 1:
					people.crearPersona(Read);
					break;
				case 2:
					people.mostrarPersona();
					break;
				case 3:
					people.escribirFichero(file1);
					break;
				case 4:
					people.leerFichero(file1);
					break;
				case 5:
					System.out.println("ADIOS");
					exit = true;
					break;
			}
		}
		while (!exit);	
		Read.close();

	}

}
