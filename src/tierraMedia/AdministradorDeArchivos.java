package tierraMedia;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos  {
	public static void main(String[] args) {		
		
	}
	public static List<Usuario> leerUsuarios() {
		File f = new File("./archivos/usuarios.txt"); //creo el archivo con la ruta
		Scanner sc; //abro el scanner 
		List<Usuario> usuarios = new ArrayList<Usuario>(); //creo el arraylist
		String[] line; //aca guardo linea spliteada
		
		try {
			sc = new Scanner(f); //abrir el archivo con el scanner     
			
			while(sc.hasNext()) {
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
		} catch (NumberFormatException e2) {
			System.err.println(e2.getMessage());
		}
		return usuarios;
}	

//LEER ARCHIVO DE ATRACCIONES

public static List<Atraccion> leerAtracciones() {
	File f = new File("./archivos/atracciones.txt"); //creo el archivo con la ruta
	Scanner sc; //abro el scanner 
	List<Atraccion> atracciones = new ArrayList<Atraccion>();
	String[] line; //aca guardo linea spliteada
	
	try {
		sc = new Scanner(f); //abrir el archivo con el scanner
	   		
		while (sc.hasNext()) {
			line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion, devuelve un array 

			atracciones.add(
					new Atraccion(
							line[0], //primer atraccion ya string
							Integer. parseInt (line[1]), //convierta en entero precio 
							Double.parseDouble(line[2]), //convierta en double las horas
							Integer. parseInt (line[3]), //entero para cupos
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




public static List<Promocion> leerPromociones(List<Atraccion> atracciones) {
	File f = new File("./archivos/promociones.txt"); 
	Scanner sc;  
	List<Promocion> promociones = new ArrayList<Promocion>();
	String[] line; 
	
	try {
		sc = new Scanner(f); 
	   		
		while (sc.hasNext()) {
			line = sc.nextLine().split("-"); // SEPARA LOS ATRIBUTOS - el split cada vez que encuentra un guion, devuelve un array 
       
			List<Atraccion> atraccionesEnPromo = new ArrayList<Atraccion>();
			
			for(int i=3; i<line.length-1; i++){
				for(Atraccion atraccion: atracciones) {
					if(atraccion.getNombre().equals(line[i])) {
						atraccionesEnPromo.add(atraccion);
					}
				}
			}
			Promocion promocion = new Promocion(line[0], Integer.parseInt(line[3]), atraccionesEnPromo, line[1], line[5]);
			promociones.add(promocion);
			;
			
		}
		
		sc.close();
		
		
		
	
	} catch (FileNotFoundException e) {
		System.err.println(e.getMessage());
	} catch (NumberFormatException e) {
		System.err.println(e.getMessage());
	}
	
	return promociones;
}

}




	

