package CarpetasFicheros;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Proyecto
		 * 		- Estilos
		 * 			- css4
		 * 				estilo1.css
		 * 				estilo2.css
		 * 			- css3
		 * 				estilo3.css
		 * 		- script
		 * 			- js
		 * 				script1.js
		 * 				script2.js
		 * 			- php
		 * 				cabecera.php
		 * 				modelo.php
		 * 		- imagenes
		 * 			- alta
		 * 				paisaje.jpg
		 * 			- media
		 * 				paisaje.jpg
		 * 			- baja
		 * 				paisaje.jpg
		 * */

		File[] carpetas = {
							new File("Proyecto"),
							new File("Proyecto/Estilos"),
							new File("Proyecto/Estilos/css4"),
							new File("Proyecto/Estilos/css4/estilo1.css"),
							new File("Proyecto/Estilos/css4/estilo2.css"),
							new File("Proyecto/Estilos/css3"),
							new File("Proyecto/Estilos/css3/estilo3.css"),
							new File("Proyecto/script"),
							new File("Proyecto/script/js"),
							new File("Proyecto/script/js/script1.js"),
							new File("Proyecto/script/js/script2.js"),
							new File("Proyecto/script/php"),
							new File("Proyecto/script/php/cabecera.php"),
							new File("Proyecto/script/php/modelo.php"),
							new File("Proyecto/imagenes"),
							new File("Proyecto/imagenes/alta"),
							new File("Proyecto/imagenes/alta/paisaje.jpg"),
							new File("Proyecto/imagenes/media"),
							new File("Proyecto/imagenes/media/paisaje.jpg"),
							new File("Proyecto/imagenes/baja"),
							new File("Proyecto/imagenes/baja/paisaje.jpg")
		};
		
		try {
			for (int i=0; i<carpetas.length; i++) {
				if (carpetas[i].getName().contains("."))
					carpetas[i].createNewFile();
				else
					carpetas[i].mkdir();
		}	
		} catch (IOException e) {
			System.err.println("Error al crear :" + e.getMessage());
		}
		
		
	}

}
