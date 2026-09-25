package tarea03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Tarea03 {

	public static void main(String[] args) {
		
		//if (args.length != 1) {
			
		//}
		
		try {
			String fichanalizar = "archivo_corto.bin";
			File fichero = new File("." + File.separator + "src" + File.separator + "tarea03" + File.separator + "firmas" + File.separator + fichanalizar);
			FileInputStream fileIn = new FileInputStream(fichero);
			
			
			byte [] contador = new byte [4];
			int bytesLeidos = fileIn.read(contador);
			
			if(bytesLeidos<4) {
				System.out.println("El fichero tiene menos de 4 bytes");
			}
			
			if (contador [0] == 80 &&
				contador [1] == 75 &&
				contador [2] == 3 &&
				contador [3] ==  4) {
				System.out.println("El fichero analizado es un fichero ZIP");
			} else {
				System.out.println("El fichero analizado NO es un fichero ZIP");
			}
			
			fileIn.close();
		}catch (IOException e) {
			System.out.println("Error al acceder");
		}
			
	}
}
