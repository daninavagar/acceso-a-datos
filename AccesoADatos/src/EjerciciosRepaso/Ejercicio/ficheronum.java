package Ejercicio;

import java.util.ArrayList; 
import java.io.*;

public class ficheronum {
	
	private ArrayList<nume> TablaNumeros = new ArrayList<nume>();
	private ArrayList<String> list;
	private File dir, f;
	private FileWriter f_w;
	private BufferedWriter f_bw;
	private FileReader f_r;
	private BufferedReader f_br;
	private String cadena;
	nume num;
	
	
	public void abrir_carpeta() {

		dir = new File("Numeros");
		if (dir.exists()) {
			System.err.println("La carpeta ya se ha creado");
		} else 
			dir.mkdir();
		
	}
	
	public void abrir_fichero() {
		
		try {
			f = new File(dir, "fichero");
			f_w = new FileWriter(f, true);
			f_bw = new BufferedWriter(f_w);
			f_r = new FileReader(f);
			f_br = new BufferedReader(f_r);
			
			
			if (!f.createNewFile()) {
				System.err.println("El archivo ya esta creado");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarNumero() {
		
		
		for (int i=0; i<10; i++) {
			System.out.println("Dime la posicion " + i + "");
			num = new nume(numero.Leer.nextInt());
			TablaNumeros.add(num);
		}
		System.out.println(TablaNumeros);
	}
	
	public void modificarTabla() {
		
		int posicion;
		nume nvalor;
		for (int i=0; i<TablaNumeros.size(); i++) {
			System.out.println("La posicion " + (i) + " es -> " + TablaNumeros.get(i));
		}
		 
			System.out.println("Que posicion quieres modificar y valor: ");
			try {
			posicion = numero.Leer.nextInt();
			numero.Leer.nextLine();
			nvalor = new nume(numero.Leer.nextInt());
			TablaNumeros.set(posicion, nvalor);
			System.out.println(TablaNumeros);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Introduce un valor valido");
		}
	}
	
	public void escribirFichero() {
		
		abrir_fichero();
		String linea = "";
		for (int i=0; i<TablaNumeros.size(); i++) {
			linea += TablaNumeros.get(i).toString();
		}
		try {
			f_w = new FileWriter(f.getAbsoluteFile());
			f_bw = new BufferedWriter(f_w);
			
			
			
			f_bw.write(linea);
			
			f_bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerFichero() {
		
		abrir_fichero();
		cadena = "";
		FileInputStream inputS;
		
		try {
			if (f_br.readLine() == null) {
				System.err.println("El archivo esta vacío");
			} else {
				inputS = new FileInputStream(f.getPath());
				
				f_br = new BufferedReader(new InputStreamReader(inputS));
				
				list = new ArrayList<String>();
				
				cadena = f_br.readLine();
				actualizarTabla();
				System.out.println(list);
				f_br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarTabla() {
		
		list.add(cadena);
	}
	
}
