package Ficheros;

import java.io.*;
import java.util.*;

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
		
		/* Carpetas */
		
		int opcion=0;
		boolean exit = false;
		Scanner Leer = new Scanner (System.in);
		
		do {
			
			try {
			
				System.out.println("\t+-------------------------------+");
				System.out.println("\t| BIENVENIDO                	|");
				System.out.println("\t| 1. Carpetas Forma Mala    	|");
				System.out.println("\t| 2. Carpetas Forma Buena   	|");
				System.out.println("\t| 3. Hola                       |");
				System.out.println("\t+-------------------------------+");
				opcion = Leer.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Algo ha salido mal, por favor introduce valor numerico");
				Leer.nextLine();
			}
			
			switch (opcion) {
				case 1:
					System.out.println("Hola");
						File dir_Proyecto = new File("Proyecto"),
								dir_Estilos = new File(dir_Proyecto, "Estilos"),
									dir_Estilos_css4 = new File(dir_Estilos, "css4"),
									dir_Estilos_css3 = new File(dir_Estilos, "css3"),
								dir_Scripts = new File(dir_Proyecto, "Script"),
									dir_Scripts_js = new File (dir_Scripts, "js"),
									dir_Scripts_php = new File (dir_Scripts, "php"),
								dir_Imagenes = new File(dir_Proyecto, "Imagenes"),
									dir_Imagenes_alta = new File(dir_Imagenes, "alta"),
									dir_Imagenes_media = new File(dir_Imagenes, "media"),
									dir_Imagenes_baja = new File(dir_Imagenes, "baja");
						
						/* Archivos */ 
						File f_css4_1 = new File (dir_Estilos_css4, "estilo1.css"),
						f_css4_2 = new File (dir_Estilos_css4, "estilo2.css"),
						f_css3_1 = new File (dir_Estilos_css3, "estilo3.css"),
						f_Script_js_1 = new File (dir_Scripts_js, "scripts1.js"),
						f_Script_js_2 = new File (dir_Scripts_js, "scripts2.js"),
						f_Script_php_1 = new File (dir_Scripts_php, "cabecera.php"),
						f_Script_php_2 = new File (dir_Scripts_php, "modelo.php"),
						f_Im_alta = new File (dir_Imagenes_alta, "paisage.jpg"),
						f_Im_media = new File (dir_Imagenes_media, "paisage.jpg"),
						f_Im_baja = new File (dir_Imagenes_baja, "paisage.jpg");
						
						if (dir_Proyecto.mkdir()) {
							dir_Estilos.mkdir();
								dir_Estilos_css4.mkdir();
									f_css4_1.createNewFile();
									f_css4_2.createNewFile();
								dir_Estilos_css3.mkdir();
									f_css3_1.createNewFile();
							dir_Scripts.mkdir();
								dir_Scripts_js.mkdir();
									f_Script_js_1.createNewFile();
									f_Script_js_2.createNewFile();
								dir_Scripts_php.mkdir();
									f_Script_php_1.createNewFile();
									f_Script_php_2.createNewFile();
							dir_Imagenes.mkdir();
								dir_Imagenes_alta.mkdir();
									f_Im_alta.createNewFile();
								dir_Imagenes_media.mkdir();
									f_Im_media.createNewFile();
								dir_Imagenes_baja.mkdir();
									f_Im_baja.createNewFile();
							System.out.println("DONE!");
						} else {
							System.out.println("ERROR");
						}
					break;
				case 2:
					System.out.println("Hello");
					
					File dir[] = new File[21];
					dir[0] = new File("./Proyecto");
					dir[1] = new File (dir[0], "Estilos");
						dir[2] = new File(dir[1], "css4");
							dir[3] = new File(dir[2], "Estilo1.css");
							dir[4] = new File(dir[2], "Estilo2.css");
						dir[5] = new File(dir[1], "css3");
							dir[6]= new File(dir[5], "Estilo3.css");
					dir[7] = new File(dir[0], "Scripts");
						dir[8] = new File (dir[7], "js");
							dir[9] = new File (dir[8], "scripts1.js");
							dir[10] = new File (dir[8], "scripts2.js");
						dir[11] = new File (dir[7], "php");
							dir[12] = new File (dir[11], "cabecera.php");
							dir[13] = new File (dir[11], "modelo.php");
					dir[14] = new File (dir[0], "Imagenes");
						dir[15] = new File (dir[14], "alta");
							dir[16] = new File(dir[15], "paisaje.jpg");
						dir[17] = new File (dir[14], "media");
							dir[18] = new File(dir[17], "paisaje.jpg");
						dir[19] = new File (dir[14], "baja");
							dir[20] = new File(dir[19], "paisaje.jpg");
					
					for (int i=0; i<dir.length; i++) {
						if (!CompruebaFichero(dir[i].getName())) {
							dir[i].mkdir();
						} else {
							dir[i].createNewFile();
						}
					}
					
					
					break;
				case 3:
					System.out.println("ADIOS");
					exit = true;
					break;
			}
			
			
		} while (!exit);
		
		Leer.close();
		
		
	}

}
