package PERSONASPOO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class TablaPersonas{
	
	 Personas[] tabla;
	    int maxLong;
	    int posicion;

	    public TablaPersonas(int maxLong) {
	        posicion=0;
	        tabla = new Personas[maxLong];
	    }

	    public void crearPersona(Scanner Read) {

	        String nombre, DNI;
	        int edad;

	        System.out.println("nombre: ");
	        nombre = Read.next();
	        System.out.println("DNI: ");
	        DNI = Read.next();
	        System.out.println("edad: ");
	        edad = Read.nextInt();

	        Personas temp = new Personas(nombre, DNI, edad);
	        this.tabla[this.posicion] = temp;
	        this.posicion++;
	    }
	    public void mostrarPersona() {
	        for(int i=0; i<this.posicion; i++) {
	            System.out.println(this.tabla[i].toString());
	        }
	    }
	    
	    
	    public void escribirFichero(File file1) {
	    	
	    	try {
		    	FileWriter fileW = new FileWriter(file1);
		    	BufferedWriter fileBW = new BufferedWriter(fileW);
		    	
		    	for (int i=0; i<this.posicion; i++) {
		    		fileBW.write(this.tabla[i].toString());
		    	}
		    	
		    	
		    	
		    	fileBW.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}	
	    }
	    
	    public void leerFichero(File file1) {
	    	
	    	try {
		    	FileReader  fileR = new FileReader(file1);
		    	BufferedReader fileBR = new BufferedReader(fileR);
		    	
		    	
		    	String flag = "", linea = "";
		    	
		    	while (flag != null) {
		    		
		    		flag = fileBR.readLine();
		    		linea += flag;
		    		String[] aux = linea.split(" , ");
		    		Personas auxtabla = new Personas(aux[0], aux[1], Integer.parseInt(aux[2]));
		    		this.tabla[this.posicion++] = auxtabla;
		    	}
		    	this.posicion--;

		    	
		    	
		    	for (int i=0; i<this.posicion; i++) {
		    		System.out.println(this.tabla.toString());
		    	}
		    	
		    	
		    	fileBR.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	
	    }

}
