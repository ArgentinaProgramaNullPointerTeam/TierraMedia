package tierraMedia;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos  {


	public static List<Usuario> leerUsuarios() {
		File f = new File("./archivos/usuarios.txt"); //creo el archivo con la ruta
		Scanner sc; //abro el scanner 
		usuarios = new LinkedList<Usuario>();
		String[] line; //aca guardo linea spliteada
		
		try {
			sc = new Scanner(f); //abrir el archivo con el scanner
			int size = sc.nextInt(); //size para la cantidad de arrays y que lea la linea de abajo 
		    usuarios = new Usuario[size];
			
			for(int i=0; i<size; i++);
				line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion, devuelve un array 

				
				usuarios.add(
					new Usuario( 
						line[0], //nombre de usuario nose parsea
						TipoAtraccion.valueOf(line[1]), // parseo el enum tipo de atraccion para q lo pase a string
						Double.parseDouble(line[2]), //presupuesto 
						Double.parseDouble(line[3])) //tiempo
				);
				
				line = null; //no dejar basura en line 
			}
			
			sc.close();//cierro el scaner
			
			//Tiramos este catch cuando no encuentra el archivo 
		} catch (FileNotFoundException e1) {
			System.err.println(e1.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e1.getMessage());
		}
		
		return usuarios;
	}
	
//LEER ARCHIVO DE PROMOCIONES

public static List<Usuario> leerPromociones() {
	File f = new File("./archivos/promociones.txt"); //creo el archivo con la ruta
	Scanner sc; //abro el scanner 
	promociones = new LinkedList<Promociones>();
	String[] line; //aca guardo linea spliteada
	
	try {
		sc = new Scanner(f); //abrir el archivo con el scanner
		int size = sc.nextInt(); //size para la cantidad de arrays y que lea la linea de abajo 
	    promociones = new Promocion[size];
		
		for(int i=0; i<size; i++);
			line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion, devuelve un array 

			promociones.add(
				new Promocion(
					Integer = entrada.nextInt[0], //se lee un entero del archivo
					TipoAtraccion.valueOf(line[1]), // parseo el enum tipo de atraccion para q lo pase a string desde el enum 
					Integer = entrada.nextInt[2], //se lee un entero del archivo en cantidad de atracciones
					line[3], //primer atraccion ya string
					line[4], //segunda atraccion ya string
					line[5], //tercera atraccion ya string para axb
					Promocion.valueOf(line[6]), // me dice si es  descuento, precio o atraccion
					Double.parseDouble(line[7]) //convierta en double precio 
				)
			);
			
			line = null;
		}

		
		sc.close();
		//Tiramos este catch cuando no encuentra el archivo 
	} catch (FileNotFoundException e) {
		System.err.println(e.getMessage());
	} catch (NumberFormatException e) {
		System.err.println(e.getMessage());
	}
	
	return promociones;
}


//LEER ARCHIVO DE ATRACCIONES

public static List<Usuario> leerAtracciones() {
	File f = new File("./archivos/atracciones.txt"); //creo el archivo con la ruta
	Scanner sc; //abro el scanner 
	atracciones = new LinkedList<Atracciones>();
	String[] line; //aca guardo linea spliteada
	
	try {
		sc = new Scanner(f); //abrir el archivo con el scanner
		int size = sc.nextInt(); //size para la cantidad de arrays y que lea la linea de abajo 
	    atracciones = new Atracciones[size];
		
		for(int i=0; i<size; i++);
			line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion, devuelve un array 

			atracciones.add(
					new Atracciones(
							line[0], //primer atraccion ya string
							Double.parseDouble(line[1]), //convierta en double precio 
							Double.parseDouble(line[2]), //convierta en double las horas
							Integer = entrada.nextInt[3], //entero para cupos
							TipoAtraccion.valueOf(line[4]) // parseo el enum tipo de atraccion para q lo pase a string desde el enum 
							
					)
			);
			
			line = null;
		}
		
		sc.close();
		
		
		//Tiramos este catch cuando no encuentra el archivo 
	} catch (FileNotFoundException e) {
		System.err.println(e.getMessage());
	} catch (NumberFormatException e) {
		System.err.println(e.getMessage());
	}
	
	return atracciones;
}
}
	
	
	
}


	
	

