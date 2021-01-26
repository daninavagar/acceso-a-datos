package EjercicioCarpetas;

import java.io.*;

public class Main {

	
	public static void main(String[] args) {
		
		
		
		File create[] = {
				new File("Proyecto/Estilos/CSS4"),
					new File("Proyecto/Estilos/CSS4", "estilo1.css"),
					new File("Proyecto/Estilos/CSS4", "estilo2.css"),
				new File("Proyecto/Estilos/CSS3"),
				new File("Proyecto/Estilos/CSS3", "estilo3.css"),
				new File("Proyecto/Scripts/js"),
					new File("Proyecto/Scripts/js", "scripts1.js"),
					new File("Proyecto/Scripts/js", "scripts2.js"),
				new File("Proyecto/Scripts/php"),
					new File("Proyecto/Scripts/php", "cabecera.php"),
					new File("Proyecto/Scripts/php", "modelo.php"),
				new File("Proyecto/Imagenes/alta"),
					new File("Proyecto/Imagenes/alta", "paisaje.jpg"),
				new File("Proyecto/Imagenes/media"),
					new File("Proyecto/Imagenes/media", "paisaje.jpg"),
				new File("Proyecto/Imagenes/baja"),
					new File("Proyecto/Imagenes/baja", "paisaje.jpg")
		};
			
			for (int i=0; i<create.length; i++) {
				if(!extension(create[i].getName())) {
					if (!create[i].mkdirs())
						System.err.println("El directorio ya existe");
				} else {
					try {
						create[i].createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		
		
		

	}
	
	public static boolean extension(String algo) {
		
		
		String[] ext = {"css", "js", "php", "jpg"};
		
		for (int i=0; i<ext.length; i++) {
			if (algo.endsWith("." + ext[i]))
				return true;
		}
		
		return false;
	}

}
