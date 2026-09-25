package tarea01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tarea01 {

	public static void main (String[] args) {
		try {
			File fichero = new File("." + File.separator + "src" + File.separator + "tarea01" + File.separator + "entrada.txt");
			FileReader lector = new FileReader(fichero);
			FileWriter escritor = new FileWriter("." + File.separator + "src" + File.separator + "tarea01" + File.separator + "salida.txt");
			
			int a;
			
			while ((a=lector.read()) !=-1) {
				char caracter = (char) a;
				if(Character.isLetter(caracter)) {    //si es letra se modifica a MAYUSCULA
					caracter = Character.toUpperCase(caracter);
				} else if(Character.isDigit(caracter)) { // si es numero se modifica a #
					caracter = '#';
				}
				
				escritor.write(caracter);
			}
			System.out.println("El fichero salida.txt ha sido creado con exito");
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
