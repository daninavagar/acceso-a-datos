package TablaNumerosClases;

public class Numero {

	private float valor;
	

	public Numero(float valor) {
		super();
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String imprimir() {
		return Float.toString(valor);
				
	}

	@Override
	public String toString() {
		return this.imprimir();
	}	
}
