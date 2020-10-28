package FicherosOO;

public class PrincipalOO {

	public static void main(String[] args) {
		
		
		TablaNombres misNombres = new TablaNombres();
		
		misNombres.imprimirPantalla();
		misNombres.leerFichero("victor.txt");
		misNombres.insertarNombre("Raul Delgado");
		misNombres.insertarNombre("Daniel Navarro");
		misNombres.insertarNombre("Diego Martin");
		misNombres.insertarNombre("Alejandro Caldera");
		misNombres.escribirFichero("victor.txt");
		misNombres.imprimirPantalla();
		

	}

}
