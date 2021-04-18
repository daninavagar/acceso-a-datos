import java.util.Date;

public class Abonados {
	
	private int n_origen;
	private int n_destino;
	private Date fecha_llamada;
	private int duracion_llamada; // minutos
	private double importe;
	
	
	public Abonados(int n_origen, int n_destino, Date fecha_llamada, int duracion_llamada,double importe) {
		this.n_origen = n_origen;
		this.n_destino = n_destino;
		this.fecha_llamada = fecha_llamada;
		this.duracion_llamada = duracion_llamada;
		this.importe = importe;
	}
	






	public int getN_origen() {
		return n_origen;
	}
	public void setN_origen(int n_origen) {
		this.n_origen = n_origen;
	}
	public int getN_destino() {
		return n_destino;
	}
	public void setN_destino(int n_destino) {
		this.n_destino = n_destino;
	}
	public Date getFecha_llamada() {
		return fecha_llamada;
	}
	public void setFecha_llamada(Date fecha_llamada) {
		this.fecha_llamada = fecha_llamada;
	}
	public int getDuracion_llamada() {
		return duracion_llamada;
	}
	public void setDuracion_llamada(int duracion_llamada) {
		this.duracion_llamada = duracion_llamada;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}



	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Abonados [n_origen=" + n_origen + ", n_destino=" + n_destino + ", fecha_llamada=" + fecha_llamada.getDate() + "/" + fecha_llamada.getMonth() + "/" + fecha_llamada.getYear() 
				+ ", duracion_llamada=" + duracion_llamada + ", importe=" + importe + "]";
	}
	
	public String toDate() {
		return "En el mes " + fecha_llamada.getMonth()+1 + " --> " + "n_origen=" + n_origen + ", n_destino=" + n_destino + ", fecha_llamada=" + fecha_llamada.getDate() + "/" + fecha_llamada.getMonth() + "/" + fecha_llamada.getYear() 
		+ ", duracion_llamada=" + duracion_llamada + ", importe=" + importe;
	}
	
	
	
	
	
	
	
	

}
