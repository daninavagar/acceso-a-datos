package TablaNumerosClases;

import java.util.ArrayList;
import TablaNumerosClases.Main;
import java.util.LinkedList;


@SuppressWarnings("unused")
public class TablaNumeros {
	
	private static ArrayList<Numero> Tabla = new ArrayList<Numero>();
	Numero temp;
	
	
	public void borrar() {
		if (Tabla.size() == 0) {
			System.out.println("NO HAY NADA");
		} else {
			System.out.println("Que prefieres: \n\t1. Borrar un número en concreto  \t2. Borrar el último");
			int op = Main.Leer.nextInt();
			switch (op) {
				case 1:
					int b=0;
					do {	
						try {
							System.out.println("Que numero quieres borrar, dime la posicion");
							b = Main.Leer.nextInt();
							Tabla.remove(b);
						} catch (IndexOutOfBoundsException f) {
							System.out.println("Te llevo al menu para que lo pienses mejor");
						}
					} while ((b < Tabla.size()) && (b > -1));					
					break;
				case 2:
					Tabla.remove(Tabla.size()-1);
					break;
			}
		}		
	}
	
	public void imprimir() {
		if (Tabla.size() == 0) {
			System.out.println("NO HAY NADA");
		} else {
			System.out.println(Tabla.toString());
		}
	}
	
	public void insertarNumero() {
		System.out.println("Introduce un numero: ");
		Numero n = new Numero (Main.Leer.nextFloat());
		Tabla.add(n);
	}
	
	
	public void menor() {
		if (Tabla.size() == 0) {
			System.out.println("NO HAY NADA");
		} else {
			Numero menor;
			menor = Tabla.get(0);
			for (int i=0; i < Tabla.size(); i++) {
				if (Tabla.get(i).getValor() < menor.getValor())
					menor = Tabla.get(i);
			}
			System.out.println("El número mas pequeño es: " +menor.toString());
		}
	}
	
	public void mayor() {
		if (Tabla.size() == 0) {
			System.out.println("NO HAY NADA");
		} else {
			Numero mayor;
			mayor = Tabla.get(0);
			for (int i=0; i < Tabla.size(); i++) {
				if (Tabla.get(i).getValor() > mayor.getValor())
					mayor = Tabla.get(i);
			}
			System.out.println("El número mas grande es : " +mayor.toString());
		}
	}
	
	public void ordenar() {
		if (Tabla.size() == 0) {
			System.out.println("NO HAY NADA");
		} else {
			for (int i=0; i<Tabla.size(); i++) {
				for (int f = 0; f<Tabla.size(); f++) {
					if (Tabla.get(i).getValor() < Tabla.get(f).getValor()) {
						float temp = Tabla.get(i).getValor();
						Tabla.get(i).setValor(Tabla.get(f).getValor());
						Tabla.get(f).setValor(temp);
					}
				}
			} System.out.println(Tabla.toString());
		}
	}
}
