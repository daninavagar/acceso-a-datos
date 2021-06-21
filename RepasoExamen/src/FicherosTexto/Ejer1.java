package FicherosTexto;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejer1 {

	static Scanner leer = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		  	1. Crear un programa que cree un fichero de texto con una lista de 10 números enteros. A continuación,
			   mostrará un menú con:
			1. Escribir fichero: escribir los datos contenidos en una tabla y guardarlos en un fichero.
			2. Leer fichero: abrir un fichero con 10 números y guardarlos en una tabla.
			3. Escribir: escribir por la consola los datos de la tabla.
			4. Modificar tabla: Indicar la posición que se quiere modificar de la tabla y modificar los datos.
			5. Actualizar tabla fichero: Guardar los datos existentes en la tabla sobre el fichero asociado.
			6. Salir. 
		 * */
		
		
		
		boolean exit = false;
		int opcion = 0;
		File fichero = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Integer> numerosEscribir = new ArrayList<Integer>(10);
		ArrayList<Integer> numerosLeer = new ArrayList<Integer>();
		
		do {
			
			try {
				System.out.println("Elige Opcion:"
						+ "\n 1. Escribir Fichero."
						+ "\n 2. Leer Fichero."
						+ "\n 3. Escribir datos por consola."
						+ "\n 4. Modificar Tabla."
						+ "\n 5. Actualizar Fichero"
						+ "\n 6. Salir");
				opcion = leer.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Valor numerico por favor: ");
			}
			
			switch (opcion) {
				case 1:
					EscribirFichero(numerosEscribir, fichero, fw, bw);
					break;
				case 2:
					LeerFichero(numerosEscribir, numerosLeer, fichero, fr, br);
					break;
				case 3:
					EscribeTabla(numerosEscribir);
					break;
				case 4:
					ModificarTabla(numerosEscribir);
					break;
				case 5:
					ActualizarFichero(numerosEscribir, numerosLeer, fichero, fw, bw, fr, br);
					break;
				case 6:
					System.out.println("Gracias por venir");
					exit = true;
					break;
			};
		} while (!exit);
		
		leer.close();
	}
	
	public static void imprimir(ArrayList<Integer> numerosEscribir) {
		
		if (numerosEscribir.isEmpty())
			System.err.println("La Tabla está vacía");
		else
			for (int i=0; i<numerosEscribir.size(); i++)
			System.out.println("[" + i + "] --> " + numerosEscribir.get(i).toString());
	}
	
	public static void imprimirLeer(ArrayList<Integer> numerosLeer) {
		
		if (numerosLeer.isEmpty())
			System.err.println("La Tabla está vacía");
		else
			for (int i=0; i<numerosLeer.size(); i++)
			System.out.println("[" + i + "] --> " + numerosLeer.get(i).toString());
	}

	public static void EscribeTabla(ArrayList<Integer> numerosEscribir) {

		for (int i=0; i<10; i++) {
			System.out.println("Numero [" + i + "] : ");
			int num = leer.nextInt();
			numerosEscribir.add(num);
		}
		imprimir(numerosEscribir);
	}
	
	public static void ModificarTabla(ArrayList<Integer> numerosEscribir) {
		
		
		if (numerosEscribir.isEmpty())
			System.err.println("La Tabla está vacía");
		else {
			imprimir(numerosEscribir);
			System.out.println("Dime la posicion del numero que quieres modificar 0-9");
			int posi = leer.nextInt();
			if (numerosEscribir.size() >= posi) {
				System.out.println("Nuevo número: ");
				int nuevo = leer.nextInt();
				numerosEscribir.set(posi, nuevo);	
			} else
				System.err.println("Número introducido mas grande");
			imprimir(numerosEscribir);
		}
		
	}
	
	public static void EscribirFichero(ArrayList<Integer> numerosEscribir, File fichero,
										FileWriter fw, BufferedWriter bw) {
		
		if (numerosEscribir.isEmpty())
			System.err.println("La Tabla está vacía");
		else {
			fichero = new File("./src/FicherosTexto/", "archivo1.txt");
			try {
				fw = new FileWriter(fichero);
				bw = new BufferedWriter(fw);
				
				for (int i=0; i<numerosEscribir.size(); i++) {
					bw.write("[" + i + "]--> " + numerosEscribir.get(i).toString() + "\n");
				}
				bw.close();
			} catch (IOException e) {
				System.err.println("Error al escribir :" + e.getMessage());
			}
		}
	}
	
	
	public static void ActualizarFichero(ArrayList<Integer> numerosEscribir, ArrayList<Integer> numerosLeer, File fichero,
									FileWriter fw, BufferedWriter bw, FileReader fr, BufferedReader br) {
		
		if (numerosEscribir.isEmpty() || numerosLeer.isEmpty())
			System.err.println("La Tabla está vacía");
		else {
			fichero = new File("./src/FicherosTexto/", "archivo1.txt");
			try {
				
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				String[] posicion = new String[1000000];
				imprimir(numerosEscribir);
				for (int i=0, f = 0; i<numerosEscribir.size(); i++) {
					if (numerosEscribir.get(i).equals(numerosLeer.get(i))) {
						
					} else {
						posicion[f] = String.valueOf(i);
						f++;
					}
				}
				String linea = br.readLine();
				fw = new FileWriter(fichero);
				bw = new BufferedWriter(fw);
				int f = 0;
				int x = 0;
				while (linea != null) {
					String[] tabla = linea.split(" ");
					if (tabla[0].contains(posicion[f])) {
							bw.write("[" + x + "]--> " + numerosEscribir.get(x).toString() + "\n");
							f++;
						}
					x++;
					if (x == numerosEscribir.size())
						break;
					linea = br.readLine();
					
				}
				br.close();
				bw.close();
				
			} catch (IOException e) {
				System.err.println("Error al escribir :" + e.getMessage());
			}
		}
	}
	
	public static void LeerFichero(ArrayList<Integer> numerosEscribir, ArrayList<Integer> numerosLeer, File fichero,
									FileReader fr, BufferedReader br) {
		
		if (numerosEscribir.isEmpty())
			System.err.println("La tabla esta vacia");
		else {
			
			fichero = new File("./src/FicherosTexto/", "archivo1.txt");
			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				String linea = br.readLine();
				String separador = " ";
				
				while (linea != null) {
					String[] tabla = linea.split(separador);
					numerosLeer.add(Integer.parseInt(tabla[1]));
					linea = br.readLine();
				}
				br.close();
				
				imprimirLeer(numerosLeer);
			} catch (IOException e) {
				System.err.println("Error al leer :" + e.getMessage());
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
