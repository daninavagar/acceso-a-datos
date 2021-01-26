package Ejercicio;

public class nume {
	
	int numero;

	public nume(int numero) {
		this.numero = numero;
	}
	
	public nume(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String imprimir() {
		return Integer.toString(numero);
	}
	@Override
	public String toString() {
		return this.imprimir();
	}

	
	
	
	
	
}
