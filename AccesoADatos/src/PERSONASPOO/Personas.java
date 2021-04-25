package PERSONASPOO;

public class Personas {

	protected String nombre;
    protected  String DNI;
    protected  int edad;

    public Personas(String nombre, String dNI, int edad) {
        this.nombre = nombre;
        DNI = dNI;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + " , " + DNI + " , " + edad + "\n";
    }

	
}
