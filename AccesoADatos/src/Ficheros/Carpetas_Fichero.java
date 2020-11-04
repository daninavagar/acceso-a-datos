package Ficheros;

import java.io.*;
// import java.util.*;

public class Carpetas_Fichero {
	
	public static boolean CompruebaFichero (String extension) {
		String ext[] = {"css", "js", "jpg", "php"};
		
		for (int i=0; i< ext.length; i++) {
			if (extension.endsWith("." + ext[i]))
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		
		
					
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
						if (!CompruebaFichero(create[i].getName())) {
							if (!create[i].mkdirs())
								System.err.println("El directorio ya existe");
						} else {
							try {
								create[i].createNewFile();
							} catch (IOException e) {
								System.err.println("Error al crear el fichero" + e.getMessage());
							}
							
						}
					}
					
		
	}

}
