import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {

	public static void leerArchivo(String fichero1, ArrayList<Abonados> tabla1) {
		
		try {
		
			File llamadas = new File(fichero1);
			FileReader fr_llamadas = new FileReader(llamadas);
			BufferedReader br_Llamadas = new BufferedReader(fr_llamadas);
		
			String lineaDetalle = br_Llamadas.readLine();
			String separador = ";";
			
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
				
				String destino = String.valueOf(n_destino);
				destino = tablaAbonado[1];
				n_destino = Integer.parseInt(destino);
				
				DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
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
				if (tabla1.get(i).getN_origen() > tabla1.get(f).getN_origen() ) {
					temp = tabla1.get(i);
					tabla1.set(i, tabla1.get(f));
					tabla1.set(f, temp);
				}
				else if (tabla1.get(i).getN_origen() == tabla1.get(f).getN_origen()){
					if (tabla1.get(i).getFecha_llamada().compareTo(tabla1.get(f).getFecha_llamada()) > 0)  {
						temp = tabla1.get(i);
						tabla1.set(i, tabla1.get(f));
						tabla1.set(f, temp);
					}
				}
			}
		}

	}
	
	
	
	public static void CrearArchivos(ArrayList<Abonados> tabla1, ArrayList<File> nombresD, ArrayList<File> nombresR, 
			ArrayList<Integer> numeros) {
		
		
		try {
			
			int num = 1;
			
			for (int i=0;i<tabla1.size();i++) {
				if (numeros.indexOf(tabla1.get(i).getN_origen()) == -1)
				numeros.add(tabla1.get(i).getN_origen());
			}
			
			
			
			for (int i=0; i<numeros.size(); i++) {
				File nuevoD = new File("FicheroDetalle" + num  + ".txt");
				nuevoD.createNewFile();
				nombresD.add(nuevoD);
				File nuevoR = new File("FicheroResumen" + num  + ".txt");
				nuevoR.createNewFile();
				nombresR.add(nuevoR);
				num++;
			}
			
			
			
		
		} catch (IOException e) {
			System.err.println("Error al crear archivos :" + e.getMessage());
		}
	
	}
	
	
	public static void escribirFicheroDetalle(ArrayList<Abonados> tabla1, ArrayList<File> nombresD,
			ArrayList<Integer> numeros) {

		try {

				ArrayList<FileWriter> writerD = new ArrayList<FileWriter>();
				ArrayList<BufferedWriter> bufferD = new ArrayList<BufferedWriter>();
						
				for (int i=0; i<nombresD.size();i++) {
					FileWriter Detalle = new FileWriter(nombresD.get(i));
					writerD.add(Detalle);
					BufferedWriter BDetalle = new BufferedWriter(Detalle);
					bufferD.add(BDetalle);
				}
				
				String n_destino;
				DateFormat fechaFormato;
				String date;
				String duracion;
				String importe;
				String separador = ";";

				
				int cont = 0, x = 0, pos = 0;
				
				
				// DETALLE
				for (int i=0;i<tabla1.size();i++) {
						if ( numeros.get(pos).equals(tabla1.get(i).getN_origen()) ) {
							
							n_destino = String.valueOf(tabla1.get(x).getN_destino());
							fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
							date = fechaFormato.format(tabla1.get(x).getFecha_llamada());
							duracion = String.valueOf(tabla1.get(x).getDuracion_llamada());
							importe = String.valueOf(tabla1.get(x).getImporte());
							
							bufferD.get(cont).write(n_destino);
							bufferD.get(cont).write(separador);
							bufferD.get(cont).write(date);
							bufferD.get(cont).write(separador);
							bufferD.get(cont).write(duracion);
							bufferD.get(cont).write(separador);
							bufferD.get(cont).write(importe);
							bufferD.get(cont).newLine();		
							x++;
							
						} else {
							
							cont++;
							pos++;
							n_destino = String.valueOf(tabla1.get(x).getN_destino());
							fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
							date = fechaFormato.format(tabla1.get(x).getFecha_llamada());
							duracion = String.valueOf(tabla1.get(x).getDuracion_llamada());
							importe = String.valueOf(tabla1.get(x).getImporte());
							bufferD.get(cont).write(n_destino);
							bufferD.get(cont).write(separador);
							bufferD.get(cont).write(date);
							bufferD.get(cont).write(separador);
							bufferD.get(cont).write(duracion);
							bufferD.get(cont).write(separador);
							bufferD.get(cont).write(importe);
							bufferD.get(cont).newLine();
							x++;
		
						}			
				}
				
				
				
				for (int i=0; i<bufferD.size();i++) 
					bufferD.get(i).close();

				
			
		} catch (IOException e) {
			System.err.println("Error al escribir :" + e.getMessage());
		}
			
		
	}
	
	public static void escribirFicheroResumen(ArrayList<Abonados> tabla1, ArrayList<File> nombresR,
			ArrayList<Integer> numeros) {
		
		try {

			ArrayList<FileWriter> writerR = new ArrayList<FileWriter>();
			ArrayList<BufferedWriter> bufferR = new ArrayList<BufferedWriter>();
					
			for (int i=0; i<nombresR.size();i++) {
				FileWriter Resumen = new FileWriter(nombresR.get(i));
				writerR.add(Resumen);
				BufferedWriter BResumen = new BufferedWriter(Resumen);
				bufferR.add(BResumen);
			}
			
			ArrayList<Date> fechas = new ArrayList<Date>();
			for (int i=0; i<tabla1.size();i++)
				fechas.add(tabla1.get(i).getFecha_llamada());
			
			DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
			String date = "";
			String duracion = null;
			String importe;
			String separador = ";";
			
			
			String numeroLlamadas = null;
			int numero = 0, totalLlamadas = 0, duraciontotal = 0;
			double  importetotal = 0; 
			int cont = 0, x = 0, pos = 0;
		
	
			for (int i=0, f = i+1; i<fechas.size(); i++, f++) {
				
					if (fechas.get(i).equals(fechas.get(f))) {
						fechas.remove(i);
					}
				
			}
			
			for (int i=0; i<fechas.size();i++)
				System.out.println(fechaFormato.format(fechas.get(i)));
			for (int i=0; i<tabla1.size(); i++) {
				
				if (numeros.get(pos).equals(tabla1.get(i).getN_origen())) {
					
					totalLlamadas = 0;
					duraciontotal = 0;
					importetotal = 0;
					if (fechas.get(numero).equals(tabla1.get(x).getFecha_llamada())) {
						
						date = fechaFormato.format(fechas.get(x));
						
						for (int f=0; f<tabla1.size();f++) {
							if ( (numeros.get(cont).equals(tabla1.get(f).getN_origen()) ) &&  ( date.equals(fechaFormato.format(tabla1.get(f).getFecha_llamada()))) ) {
								totalLlamadas++;
								duraciontotal += tabla1.get(f).getDuracion_llamada();
								importetotal += tabla1.get(f).getImporte();
							}
						}
						bufferR.get(cont).write(date);
						bufferR.get(cont).write(separador);
						numeroLlamadas = String.valueOf(totalLlamadas);
						bufferR.get(cont).write(numeroLlamadas);
						bufferR.get(cont).write(separador);
						
						duracion = String.valueOf(duraciontotal);
						bufferR.get(cont).write(duracion);
						bufferR.get(cont).write(separador);
						
						importe = String.valueOf(importetotal);
						bufferR.get(cont).write(importe);
						bufferR.get(cont).write(separador);
						bufferR.get(cont).newLine();
						x++;
						numero++;
						
					} else {
						date = fechaFormato.format(fechas.get(x));
						totalLlamadas = 0;
						duraciontotal = 0;
						importetotal = 0;
						for (int f=0; f<tabla1.size();f++) {
							if ( (numeros.get(cont).equals(tabla1.get(f).getN_origen()) ) &&  ( date.equals(fechaFormato.format(tabla1.get(f).getFecha_llamada()))) ) {
								totalLlamadas++;
								duraciontotal += tabla1.get(f).getDuracion_llamada();
								importetotal += tabla1.get(f).getImporte();
							}
						}
						bufferR.get(cont).write(date);
						bufferR.get(cont).write(separador);
						numeroLlamadas = String.valueOf(totalLlamadas);
						bufferR.get(cont).write(numeroLlamadas);
						bufferR.get(cont).write(separador);
						
						duracion = String.valueOf(duraciontotal);
						bufferR.get(cont).write(duracion);
						bufferR.get(cont).write(separador);
						
						importe = String.valueOf(importetotal);
						bufferR.get(cont).write(importe);
						bufferR.get(cont).write(separador);
						bufferR.get(cont).newLine();
						x++;
						numero++;
						cont++;
						
						
						
					}
				} // else diferente numero 
				
			}
		
			for (int i=0; i<bufferR.size();i++) 
				bufferR.get(i).close();
			
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero " + e.getMessage());
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

		
		DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
		for (int i=0; i<tabla1.size();i++) {
			if (tabla1.get(i).getFecha_llamada().getMonth()+1 == mes ) {
				System.out.println(fechaFormato.format(tabla1.get(i).getFecha_llamada()));
			}
		}

		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Abonados> tabla1 = new ArrayList<Abonados>();
		ArrayList<File> nombresD = new ArrayList<File>();
		ArrayList<File> nombresR = new ArrayList<File>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		leerArchivo("TotalLlamadas.txt", tabla1);
		CrearArchivos(tabla1, nombresD, nombresR, numeros);
		

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
					escribirFicheroDetalle(tabla1, nombresD, numeros);
					escribirFicheroResumen(tabla1, nombresR, numeros);
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