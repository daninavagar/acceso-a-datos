package EjercicioTablaNumeros;

public class Numeros {

	private int numero;
	
	public Numeros(int Numero) {
		this.numero = Numero;
	}
	
	public int getValor() {
		return this.numero;
	}
	
	public void setValor(int Num) {
		this.numero = Num;
	}
	
	public String imprimir() {
		
		return Integer.toString(numero);
	}
}
