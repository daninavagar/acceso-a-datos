package PersonaCorrecion;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TablaPersona tabla2 = new TablaPersona();
		
		persona p1 = new persona("Pepe", "123123123", 20),
				p2 = new persona("Ana", "123123123", 30);
		
		tabla2.insertarPersona(p1);
		//tabla2.insertarNombre(nombre);
		tabla2.insertarPersona(p2);
		
		tabla2.escribirTabla("Personas.txt");
	}

}
