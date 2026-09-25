package tarea02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tarea02 {

	public static void main(String[] args) {
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + "tarea02" + File.separator + "accesos.log");
			BufferedReader lector = new BufferedReader (new FileReader (fichero));
			BufferedWriter escritor = new BufferedWriter (new FileWriter ("." + File.separator + "src" + File.separator + "tarea02" + File.separator + "errores.log"));
			
			int contadorerror = 0;
			String linea;
			
			while((linea = lector.readLine()) !=null) 	//lee el fichero hasta la ultima linea
				if(linea.contains("ERROR")) {
					escritor.write(linea); 				//imprime la linea identificada con error
					escritor.newLine(); 				// salta de linea
					contadorerror++; 					//cuenta los errores
				};
			escritor.write("El numero de errores del fichero es de: " + contadorerror);
			System.out.println("El fichero errores.log ha sido creado con exito");
			lector.close();
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
		}
		
		catch (IOException e) {
			System.out.println("Error de lectura o escritura");
		}
			
	}
}
