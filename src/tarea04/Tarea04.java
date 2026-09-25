package tarea04;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;

public class Tarea04 {

	public static void main(String[] args) {
		int[] ids = {1, 2, 3, 4, 5, 6, 7, 8};

		String[] codigos = {"EQ0001", "EQ0002", "EQ0003", "EQ0004",
		    "EQ0005", "EQ0006", "EQ0007", "EQ0008"};

		String[] nombres = {
		    "Portatil Lenovo",
		    "Monitor Dell 24",
		    "Teclado Logitech",
		    "Raton Inalambrico",
		    "Webcam Logitech",
		    "Proyector Epson",
		    "Dock USB-C",
		    "Auriculares Jabra"
		};

		String[] categorias = {
		    "portatil",
		    "monitor",
		    "periferico",
		    "periferico",
		    "periferico",
		    "proyector",
		    "accesorio",
		    "audio"
		};

		int[] stocks = {6, 12, 18, 25, 9, 4, 14, 11};

		double[] precios = {899.90, 189.95, 49.90, 24.50, 79.00, 549.99, 129.00, 159.90};

		try {	
			RandomAccessFile fichero = new RandomAccessFile("." + File.separator + "src" + File.separator + "tarea04" + File.separator + "inventario.dat", "rw");
			fichero.setLength(0);
			for (int i = 0; i<ids.length; i++) {
				fichero.writeInt(ids[i]);
				
				StringBuffer buffer = new StringBuffer(codigos[i]);
				buffer.setLength(8); //se podría mejorar con variables estaticas - mejora aportada por IA no aplicada
				fichero.writeChars(buffer.toString());
				
				buffer = new StringBuffer(nombres[i]);
				buffer.setLength(20);
				fichero.writeChars(buffer.toString());
				
				buffer = new StringBuffer(categorias[i]);
				buffer.setLength(12); 
				fichero.writeChars(buffer.toString());
				
				fichero.writeInt(stocks[i]);
				fichero.writeDouble(precios[i]);
			}
			long tamanoFichero = fichero.length();
			int numeroderegistros = ids.length;
			System.out.println("Numero de registros guardados: " + numeroderegistros);
			System.out.println("Tamaño de cada registro: " + tamanoFichero / numeroderegistros + " bytes.");
			fichero.close();

		}catch (IOException e) {
			System.out.println("Error al acceder");
		}
			
	}
}
