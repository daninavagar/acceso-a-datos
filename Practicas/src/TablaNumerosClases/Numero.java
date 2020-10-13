package TablaNumerosClases;

public class Numero {

	private int valor;
	

	public Numero(int valor) {
		super();
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String imprimir() {
		return Integer.toString(valor);
	}

	@Override
	public String toString() {
		return this.imprimir();
	}	
}
