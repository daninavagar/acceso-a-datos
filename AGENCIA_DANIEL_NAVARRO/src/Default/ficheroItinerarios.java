package Default;

import java.awt.Desktop;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ficheroItinerarios {

	public File archivo;
	public FileReader archivo_r;
	public BufferedReader archivo_BR;
	public FileWriter archivo_f;
	public BufferedWriter archivo_BW;
	public ArrayList<itinerarios> test = new ArrayList<itinerarios>();
	
	public ficheroItinerarios() {
		// TODO Auto-generated constructor stub
	}

	

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public FileReader getArchivo_r() {
		return archivo_r;
	}

	public void setArchivo_r(FileReader archivo_r) {
		this.archivo_r = archivo_r;
	}

	public BufferedReader getArchivo_BR() {
		return archivo_BR;
	}

	public void setArchivo_BR(BufferedReader archivo_BR) {
		this.archivo_BR = archivo_BR;
	}

	public FileWriter getArchivo_f() {
		return archivo_f;
	}

	public void setArchivo_f(FileWriter archivo_f) {
		this.archivo_f = archivo_f;
	}

	public BufferedWriter getArchivo_BW() {
		return archivo_BW;
	}

	public void setArchivo_BW(BufferedWriter archivo_BW) {
		this.archivo_BW = archivo_BW;
	}


	public void abrir() {
			archivo = new File("Viajes.txt");
			try {
				archivo.createNewFile();
				archivo_BR = new BufferedReader(new FileReader(archivo));
				archivo_BW= new BufferedWriter(new FileWriter(archivo));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
	
	public void leerItinerario(File archivo) {
		
		FileInputStream inputS;
		try {
			if (archivo_BR.readLine() == null) {
				System.err.println("El archivo esta vacio");
			} else {
				
					inputS = new FileInputStream(archivo.getPath());
					archivo_r = new FileReader(archivo);
					
					archivo_BR = new BufferedReader(new InputStreamReader(inputS));
					
					
					String cadena = "";
	
					
					while ((cadena = archivo_BR.readLine()) != null) {
						String[] tablita = cadena.split("-.....-");
						Iti2 leerIti = new Iti2(tablita[0], tablita[1], tablita[2]);
						System.out.println(Arrays.toString(tablita));
					}
					
					
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void escribirItinerario(TablaItinerarios tablaItinerarios) {
		
		FileWriter archivo_f = null;
		String linea = "";
		
		for (int i=0; i<tablaItinerarios.listaViajes.size(); i++) {
			linea += tablaItinerarios.listaViajes.get(i).toString();
		}
		try {
		
			archivo_f = new FileWriter(archivo.getAbsoluteFile(), true);
			
			archivo_BW = new BufferedWriter(archivo_f);
			
			archivo_BW.write(linea);
			archivo_BW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void cerrarFichero() throws IOException {
		
		archivo_BR.close();
		archivo_BW.close();
	}
	
	public boolean final_fichero() {
		
		try {
			if (archivo_BR.readLine() != null) {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void vaciar()  {
		BufferedWriter f_bw;
		try {
			f_bw = new BufferedWriter(new FileWriter(archivo));
			f_bw.write("");
			f_bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
