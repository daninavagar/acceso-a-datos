package Persona;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		int opc = 0;
		menu(opc, file1);
	}
	
	
	private static int menu(int opc, File file1) {
		
		Scanner Leer = new Scanner(System.in);
		boolean exit = false;
		TablaPersona tabla2 = new TablaPersona();
		String nombre, apellido;
		int edad;
		do {
			try {
				System.out.println("DIME UNA DE LAS OPCIONES");
				System.out.println("+----------------------------------+");
				System.out.println("| 1. Introducir Datos Persona      |");
				System.out.println("| 2. Mostrar Datos                 |");
				System.out.println("| 3. Salir                         |");
				System.out.println("+----------------------------------+");
				opc = Leer.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Valor numero pls");
				Leer.nextLine();
			}
			
			switch (opc) {
				case 1:
					System.out.print("Nombre: ");
					nombre = Leer.next();
					System.out.print("Apellido: ");
					apellido = Leer.next();
					System.out.print("Edad: ");
					edad = Leer.nextInt();
					persona p1;
					// System.out.println(p1);
					TablaPersona.escribirFichero(new persona(nombre, apellido, edad), file1);
					break;
				case 2:
					// datosPersona.mostrarPersona(file1);
					break;
				case 3:
					System.out.println("ADIOS");
					exit = true;
					break;
			}
		}
		while (!exit);
		
		
		Leer.close();
		return opc;
	}
}
