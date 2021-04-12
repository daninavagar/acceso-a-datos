import java.util.Date;

public class FicheroDetalle {

	
	private int numeroDestino;
	private Date fechaLlamada;
	private int duracion;
	private double importe;
	
	
	public FicheroDetalle(int numeroDestino, Date fechaLlamada, int duracion, double importe) {
		super();
		this.numeroDestino = numeroDestino;
		this.fechaLlamada = fechaLlamada;
		this.duracion = duracion;
		this.importe = importe;
	}


	public int getNumeroDestino() {
		return numeroDestino;
	}


	public void setNumeroDestino(int numeroDestino) {
		this.numeroDestino = numeroDestino;
	}


	public Date getFechaLlamada() {
		return fechaLlamada;
	}


	public void setFechaLlamada(Date fechaLlamada) {
		this.fechaLlamada = fechaLlamada;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	@Override
	public String toString() {
		return "FicheroDetalle [numeroDestino=" + numeroDestino + ", fechaLlamada=" + fechaLlamada + ", duracion="
				+ duracion + ", importe=" + importe + "]";
	}
	
	
	
	
}
