package EjercicioTablaNumeros;

import java.util.ArrayList;

public class TablaNumeros {

	private ArrayList<Numeros> Tabla;
	
	
	public TablaNumeros() {
		Tabla = new ArrayList<Numeros>();
	}
	public void borrar(int posi) {
		
		if (!Tabla.isEmpty() && Tabla.size() >= posi) 
			Tabla.remove(posi);
		 else 
			 System.err.println("La Tabla está vacía o has rebasado el tamaño del array");
		
	}
	
	public void imprimir() {
		if (Tabla.isEmpty())
			System.err.println("La Tabla está vacía");
		else
			for (int i=0; i<Tabla.size(); i++) {
				System.out.println("[" + i + "] -> " + Tabla.get(i).imprimir());
			}
			
	}
	
	public void insertar(int num) {
		
		Numeros n = new Numeros(num);
		Tabla.add(n);
	}
	
	public void mayor() {
		
		
		if (Tabla.isEmpty())
			System.err.println("La Tabla está vacía");
		else {
			Numeros mayor = Tabla.get(0);
			for (int i=0; i<Tabla.size(); i++) {
				if (Tabla.get(i).getValor() > mayor.getValor())
					mayor = Tabla.get(i);
			}
			System.out.println("El numero más grande es :" + mayor.imprimir());
		}
			
	}
	
	public void menor() {
		
		
		if (Tabla.isEmpty())
			System.err.println("La Tabla está vacía");
		else {
			Numeros menor = Tabla.get(0);
			for (int i=0; i<Tabla.size(); i++) {
				if (Tabla.get(i).getValor() < menor.getValor())
					menor = Tabla.get(i);
			}
			System.out.println("El numero más pequeño es :" + menor.imprimir());
		}
			
	}
	
	public void ordenar() {
		
		if (Tabla.isEmpty()) 
			System.err.println("La Tabla está vacía");
		 else {
			for (int i=0; i<Tabla.size(); i++) {
				for (int f = 0; f<Tabla.size(); f++) {
					if (Tabla.get(i).getValor() < Tabla.get(f).getValor()) {
						int temp = Tabla.get(i).getValor();
						Tabla.get(i).setValor(Tabla.get(f).getValor());
						Tabla.get(f).setValor(temp);
					}
				}
			} 
		 }

			for (Numeros g : Tabla)
				System.out.println(" -> " + g.imprimir());
			
	}	
	
}