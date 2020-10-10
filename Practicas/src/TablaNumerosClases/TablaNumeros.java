package TablaNumerosClases;

import java.util.ArrayList;
import java.util.Collections;

public class TablaNumeros {
	
	private static ArrayList<Integer> Tabla = new ArrayList<Integer>();
	private int posicion;
	private int longitud;
	
	
	public TablaNumeros(ArrayList<Integer> Tabla, int posicion, int longitud) {
		super();
		TablaNumeros.Tabla = Tabla;
		this.posicion = posicion;
		this.longitud = longitud;
	}
	
	public static void borrar(int numero) {
		Tabla.remove(numero);
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public static void imprimir() {
		System.out.println(Tabla);
	}
	
	public static void insertar(int numero) {
		Tabla.add(numero);
	}
	
	public static void menor(int menor) {
		menor = Tabla.get(0);
		for (int i=0; i < Tabla.size(); i++) {
			if (Tabla.get(i) < menor)
				menor = Tabla.get(i);
		}
		System.out.println(menor);
	}
	
	public static void mayor(int mayor) {
		mayor = Tabla.get(0);
		for (int i=0; i < Tabla.size(); i++) {
			if (Tabla.get(i) > mayor)
				mayor = Tabla.get(i);
		}
		System.out.println(mayor);
	}
	
	public static void ordenar() {
		Collections.sort(Tabla);
		for (int i: Tabla)
			System.out.println(i);
	}
}
