import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Main {

	public static void leerArchivo(String fichero1, ArrayList<Abonados> tabla1) {
		
		try {
		
			File llamadas = new File(fichero1);
			FileReader fr_llamadas = new FileReader(llamadas);
			BufferedReader br_Llamadas = new BufferedReader(fr_llamadas);
		
			String lineaDetalle = br_Llamadas.readLine();
			
			String separador = ";";
			int pos = 0;
			int OrigenLista = 0;
			int n_origen = 0;
			int n_destino = 0;
			int duracion = 0;
			double importe = 0;
			Date fecha = new Date();
			
			
			Abonados primero = null;
			
		
			
			while (lineaDetalle != null) {
			
				
				String[] tablaAbonado = lineaDetalle.split(separador);
				
				String Origen = String.valueOf(n_origen);
				Origen = tablaAbonado[0];
				n_origen = Integer.parseInt(Origen);
				OrigenLista = Integer.parseInt(Origen);
				
				String destino = String.valueOf(n_destino);
				destino = tablaAbonado[1];
				n_destino = Integer.parseInt(destino);
				
				
				DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
				// String date = fechaFormato.format(fecha);
				@SuppressWarnings("deprecation")
				String date = fechaFormato.format(fecha);
				date = tablaAbonado[2];
				fecha = new SimpleDateFormat ("dd/MM/yyyy").parse (date);
				
				
				
				
				String duracionS = String.valueOf(duracion);
				duracionS = tablaAbonado[3];
				duracion = Integer.parseInt(duracionS);
				
				String importeS = String.valueOf(importe);
				importeS = tablaAbonado[4];
				importe = Double.parseDouble(importeS);
				
				primero = new Abonados(n_origen, n_destino, fecha, duracion, importe);
				tabla1.add(primero);
				
				lineaDetalle = br_Llamadas.readLine();
			}
			br_Llamadas.close();
		} catch (IOException e) {
			System.err.println("Error al leer: " + e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		
		
		Abonados temp = null;
		for (int i=0; i<tabla1.size();i++) {
			for (int f=i+1; f<tabla1.size();f++) {
				if (tabla1.get(i).getN_origen() > tabla1.get(f).getN_origen()) {
					temp = tabla1.get(i);
					tabla1.set(i, tabla1.get(f));
					tabla1.set(f, temp);
				}
			}
		}
		
		
		
		
		
	}
	
	
	
	public static void CrearArchivos(ArrayList<Abonados> tabla1, ArrayList<File> nombres, ArrayList<Integer> numeros) {
		
		
		try {
			
			int num = 1;
			
			for (int i=0;i<tabla1.size();i++) {
				if (numeros.indexOf(tabla1.get(i).getN_origen()) == -1)
				numeros.add(tabla1.get(i).getN_origen());
			}
			
			
			
			for (int i=0; i<numeros.size(); i++) {
				File nuevoD = new File("FicheroDetalle" + num  + ".txt");
				nuevoD.createNewFile();
				nombres.add(nuevoD);
				File nuevoR = new File("FicheroResumen" + num  + ".txt");
				nuevoR.createNewFile();
				nombres.add(nuevoR);
				num++;
			}
			
			
			
		
		} catch (IOException e) {
			System.err.println("Error al crear archivos :" + e.getMessage());
		}
	
	}
	
	
	public static void escribirFicheroDetalle(ArrayList<Abonados> tabla1, ArrayList<File> nombres,ArrayList<Integer> numeros) {
		
		
		
		try {


			ArrayList<FileWriter> writer = new ArrayList<FileWriter>();
			ArrayList<BufferedWriter> buffer = new ArrayList<BufferedWriter>();
			
			int pos = 0;
			for (int i=0; i<nombres.size(); i++) {
				FileWriter Detalle = new FileWriter(nombres.get(i++));
				writer.add(Detalle);
				FileWriter Resumen = new FileWriter(nombres.get(i));
				writer.add(Resumen);
				BufferedWriter BDetalle = new BufferedWriter(Detalle);
				buffer.add(BDetalle);
				BufferedWriter BResumen = new BufferedWriter(Resumen);
				buffer.add(BResumen);
				
			}
			


			int cont = 0, x = 0;
			int size = buffer.size() / 2;
			
			String n_destino;
			DateFormat fechaFormato;
			String date;
			String duracion;
			String importe;
			
			
			/*
			for (int i=0; i<size; i++) {
				
				
					
					
				
						
						
						
					
				
				
				
			}*/
			
			for (int i=0; i<tabla1.size();i++) {
				for (int f=i+1;f<tabla1.size();f++) {
					if (tabla1.get(i).getN_origen() == tabla1.get(f).getN_origen()) {
						 n_destino = String.valueOf(tabla1.get(x).getN_destino());
						 fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
						 date = fechaFormato.format(tabla1.get(x).getFecha_llamada());
						 duracion = String.valueOf(tabla1.get(x).getDuracion_llamada());
						 importe = String.valueOf(tabla1.get(x).getImporte());
						
						x++;
						
						buffer.get(cont).write(n_destino);
						buffer.get(cont).write(";");
						buffer.get(cont).write(date);
						buffer.get(cont).write(";");
						buffer.get(cont).write(duracion);
						buffer.get(cont).write(";");
						buffer.get(cont).write(importe);
						buffer.get(cont).newLine();
						
						n_destino = String.valueOf(tabla1.get(x).getN_destino());
						 fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
						 date = fechaFormato.format(tabla1.get(x).getFecha_llamada());
						 duracion = String.valueOf(tabla1.get(x).getDuracion_llamada());
						 importe = String.valueOf(tabla1.get(x).getImporte());
						
						buffer.get(cont).write(n_destino);
						buffer.get(cont).write(";");
						buffer.get(cont).write(date);
						buffer.get(cont).write(";");
						buffer.get(cont).write(duracion);
						buffer.get(cont).write(";");
						buffer.get(cont).write(importe);
						buffer.get(cont).newLine();
						
						cont++;
						cont++;
						x++;
					} else {
						n_destino = String.valueOf(tabla1.get(x).getN_destino());
						 fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
						 date = fechaFormato.format(tabla1.get(x).getFecha_llamada());
						 duracion = String.valueOf(tabla1.get(x).getDuracion_llamada());
						 importe = String.valueOf(tabla1.get(x).getImporte());
						
						x++;
						
						buffer.get(cont).write(n_destino);
						buffer.get(cont).write(";");
						buffer.get(cont).write(date);
						buffer.get(cont).write(";");
						buffer.get(cont).write(duracion);
						buffer.get(cont).write(";");
						buffer.get(cont).write(importe);
						buffer.get(cont).newLine();
						
						i++;
					}
				}
			}
			
			x = 0;
			cont = 1;
			
			/*
			for (int i=0; i<tabla1.size();i++) {
				for (int f=i+1; f<tabla1.size();f++) {
					
				}
			}*/
			
			
			for (int i=0;i<size; i++) {
				
				int aux = 0;
				 String origen = String.valueOf(tabla1.get(x).getN_origen());
				 fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
				 date = fechaFormato.format(tabla1.get(x).getFecha_llamada());
				 duracion = String.valueOf(tabla1.get(x).getDuracion_llamada());
				 importe = String.valueOf(tabla1.get(x).getImporte());
				x++;
				
				buffer.get(cont).write(date);
				buffer.get(cont).write(";");
				if (origen != null) {
					aux++;
					String n = String.valueOf(aux);
					buffer.get(cont).write(n);
					buffer.get(cont).write(";");
				}
				
				buffer.get(cont).write(duracion);
				buffer.get(cont).write(";");
				buffer.get(cont).write(importe);
				cont++;
				cont++;
				
			}
			
			for (int i=0; i<buffer.size();i++)
				buffer.get(i).close();

		} catch (IOException e) {
			System.err.println("Error al escribir :" + e.getMessage());
		}
			
		
	}
	
	@SuppressWarnings("deprecation")
	public static void mostrarLlamadas(ArrayList<Abonados> tabla1, Scanner leer) {
		
		
		System.out.println("Dime el mes: ");
		int mes;
		mes = leer.nextInt();
		System.out.println("+------------------------------+");
		System.out.println("|   LISTADO LLAMADAS POR MES   |");
		System.out.println("+------------------------------+");
		
		
		
		ArrayList<Abonados> listaMes = new ArrayList<Abonados>();
		listaMes = tabla1;
		
		
		
		
		for (int i=0; i<listaMes.size();i++) {
			if (listaMes.get(i).getFecha_llamada().getMonth()+1 == mes ) {
				System.out.println(listaMes.get(i));
			}
		}

		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Abonados> tabla1 = new ArrayList<Abonados>();
		ArrayList<File> nombres = new ArrayList<File>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		leerArchivo("TotalLlamadas.txt", tabla1);
		CrearArchivos(tabla1, nombres, numeros);
		
		
		
		System.out.println(tabla1);
		int opcion;
		boolean exit = false;
		Scanner leer = new Scanner(System.in);
		
		do {
			
			try {
				
				System.out.println("+-----------------------------+");
				System.out.println("|     EJERCICIO TELEFONIA     |");
				System.out.println("+-----------------------------+");
				System.out.println("| 1. Mostrar Llamadas por mes |");
				System.out.println("| 2. Escribir Datos           |");
				System.out.println("| 3. Salir                    |");
				System.out.println("+-----------------------------+");
				System.out.println("Selecciona una de las opciones");
				
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					mostrarLlamadas(tabla1 ,leer);
					break;
				case 2:
					escribirFicheroDetalle(tabla1, nombres, numeros);
					break;
				case 3:
					System.out.println("Adios");
					exit = true;
					break;
					
			}
			} catch (InputMismatchException e) {
				System.err.println("Valor numerico por favor");
				leer.next();
			}
			
			
		} while (!exit);
		
		leer.close();
		
		
	}

	

	
	

}