package Ficheros;

import java.io.*;

public class Carpetas_Fichero {

	public static void main(String[] args) throws IOException {
		
		/* Carpetas */
		
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
	}

}
