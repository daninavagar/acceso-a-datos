package Persona;

import java.io.*;
import java.util.Scanner;

public class datosPersona extends ClasePersona{
	
	
	
	public datosPersona(String nombre, String apellido, String dNI, int edad) {
		super(nombre, apellido, dNI, edad);
		
	}

	public static void crearPersona(File file1, Scanner Leer) {

		
		try {
			// 1. Leer Fichero
			FileWriter fileW = new FileWriter(file1);
			BufferedWriter fileBW = new BufferedWriter(fileW);
			
			// 2. escribir datos Fichero
			
			System.out.println("dime nombre");
			Nombre = Leer.next();
			System.out.println("Dime apellido");
			Apellido = Leer.next();
			System.out.println("Dime DNI");
			DNI = Leer.next();
			System.out.println("Dime edad");
			edad = Leer.nextInt();
			
			
			fileBW.write(Nombre);
			fileBW.newLine();
			fileBW.write(Apellido);
			fileBW.newLine();
			fileBW.write(DNI);
			fileBW.newLine();
			fileBW.write(edad);
			
			
			
			// 3. Cierre fichero
			fileBW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void mostrarPersona(File file1) {
		
		try {
			FileReader fileR = new FileReader(file1);
			BufferedReader fileBR = new BufferedReader(fileR);
			String linea2 = "";
	
			int x = 0;
			linea2 = fileBR.readLine();
			while (x < file1.length()) {
				linea2 = fileBR.readLine();
				System.out.println(linea2);
			}
			
			
			fileBR.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
