package TablaString;

import java.io.*;
import java.util.ArrayList;

public class TablaNombres {
	
	private File f;
	
	private FileReader f_r;
	private BufferedReader f_br;
	
	private FileWriter f_w;
	private BufferedWriter f_bw;
	
	private ArrayList<Nombres> tablita = new ArrayList<Nombres>();
	private ArrayList<String> tablaLeer;
	Nombres name;
	
	
	
	public void abrir() {
		f = new File("Ejercicio2.txt");

			try {
				f.createNewFile();
				f_w = new FileWriter(f, true);
				f_bw = new BufferedWriter(f_w);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public void leer() {
		
		String linea = "";
		try {
			
			f_r = new FileReader(f);
			f_br = new BufferedReader(f_r);
			
			tablaLeer = new ArrayList<String>();
			
			linea = f_br.readLine();
			tablaLeer.add(linea);
			System.out.println(tablaLeer);
			f_br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void escribir() {
		abrir();
		rellenar();
		String cadena = "";
		try {
			
			for (int i=0; i<tablita.size(); i++) {
				cadena += tablita.get(i).toString();
			}
			f_w = new FileWriter(f.getAbsoluteFile());
			f_bw = new BufferedWriter(f_w);
			
			
			
			f_bw.write(cadena);
			f_bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void rellenar() {
		
		int numero = 0;
		System.out.println("Cuantos nombres quieres meter");
		numero = principal.Leer.nextInt();
		
		for (int i=0; i<numero; i++) {
			System.out.println("Dime el nombre : ");
			name = new Nombres(principal.Leer.next());
			tablita.add(name);	
		}
		System.out.println(tablita);
	}

}
