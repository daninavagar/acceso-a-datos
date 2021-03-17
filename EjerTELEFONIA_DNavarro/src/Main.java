import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.*;

public class Main {

	public static void leerPrimero(String ficheroDetalle, String ficheroResumen, Abonados tabla1[]) {
		
		try {
		
			String ubica = "src/primero/";
			File fDetalle = new File(ficheroDetalle);
			File fResumen = new File(ficheroResumen);
			
			FileReader fr_Detalle = new FileReader(fDetalle);
			FileReader fr_Resumen = new FileReader(fResumen);
			
			BufferedReader br_Detalle = new BufferedReader(fr_Detalle);
			BufferedReader br_Resumen = new BufferedReader(fr_Resumen);
			
			// String lineaDetalle;
			String lineaDetalle = br_Detalle.readLine();
			String lineaResumen = br_Resumen.readLine();
			String separador = ";";
			int pos = 0;
			
			while (lineaDetalle != null) {
			//while ( (lineaDetalle = br_Detalle.readLine()) != null) {
				int n_origen;
				int n_destino = 0;
				int duracion = 0;
				double importe = 0;
				
				String[] tablaAbonado = lineaDetalle.split(separador);
				Date fecha = new Date();
				DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
				String date = fechaFormato.format(fecha);
				n_origen = 111111111;
				// n_destino = tablaAbonado[0].indexOf(n_destino);
				String destino = String.valueOf(n_destino);
				destino = tablaAbonado[0];
				int nuevo_destino = Integer.parseInt(destino);
				date = tablaAbonado[1];
				
				DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				fecha.parse(date);
				Date nueva_fecha = new Date();
				// nueva_fecha = formato.parse(date);
				
				String sepa = "/";
				int ini = 0, fin;
				fin = date.indexOf(sepa);
				date.substring(ini, fin);
				ini = fin + 1;
				fin = date.indexOf(sepa, ini);
				
				System.out.println(ini + "\n" + fin + "\n" + date);
				
				fecha.setDate(nuevo_destino);
				// System.out.println(nueva_fecha + "\n" + date);
				
				
				
				String duracionS = String.valueOf(duracion);
				duracionS = tablaAbonado[2];
				int nuevo_duracion = Integer.parseInt(duracionS);
				
				String importeS = String.valueOf(importe);
				importeS = tablaAbonado[3];
				double nuevo_importe = Double.parseDouble(importeS);
				
				Abonados primero = new Abonados(n_origen, nuevo_destino, nueva_fecha, nuevo_duracion, nuevo_importe);
				tabla1[pos] = primero;
				lineaDetalle = br_Detalle.readLine();

				
			}
			
			for (int i=0; i<tabla1.length; i++) {
				System.out.println(tabla1[i].toString());
			}
		} catch (IOException e) {
			System.err.println("Error al leer: " + e.getMessage());
		}/* catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date fecha = new Date();
		DateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(fechaFormato.format(fecha));
		
		
		System.out.println(fecha.getMonth()+1);
		
		Abonados[] tabla1 = new Abonados[1];
		
		leerPrimero("FicheroDetalle1.txt", "FicheroResumen1.txt", tabla1);
		
	}
	
	

}
