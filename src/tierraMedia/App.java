package tierraMedia;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static List<Producto> productos = new ArrayList<Producto>();
	private static String entradaUsuario="";
	
	private static String saludoBienvenida(String nombreUsuario) {
		return "Hola " + nombreUsuario;
	}
	
	private static String saludoDespedida(String nombreUsuario) {
		return "Que disfrute de su compra " + nombreUsuario;
	}
	public static void main(String[] args) {
		List<Atraccion> atracciones;
		List<Promocion> promociones;

		
		System.out.println("Leer\n");
		usuarios = AdministradorDeArchivos.leerUsuarios(); // Tiene q devolver un array de usuarios

		System.out.println("Leer\n");

		atracciones = AdministradorDeArchivos.leerAtracciones();

		promociones = AdministradorDeArchivos.leerPromociones(atracciones);
		System.out.println(promociones);

		productos.addAll(promociones);
		productos.addAll(atracciones);

		System.out.println(usuarios);

		
		
		Scanner entradaDeUsuario=new Scanner(System.in);
		
		
		for (Usuario cadaUsuario : usuarios) {
			Collections.sort(productos, new ComparadorDeProductos(cadaUsuario.getAtraccionPreferida()));
			System.out.println(saludoBienvenida(cadaUsuario.getNombre()));
			for(Producto cadaProducto: productos) {
				if(cadaUsuario.puedeComprar(cadaProducto)) {  
					System.out.println(cadaProducto.ofertas());
					System.out.println("Si desea adquirir este producto ingrese SI, de lo contrario ingrese NO");
				    entradaUsuario= entradaDeUsuario.nextLine();
				    if(entradaUsuario.contains("SI")){
				    	cadaUsuario.comprar(cadaProducto);
				    	System.out.println(cadaProducto.getNombre() + " fue agregado a su itinerario.");
				    }
				    
				    entradaUsuario="";
				}else if(!cadaUsuario.puedeComprar(cadaProducto)) {
					System.out.println("No puede adquirir: " +cadaProducto.getNombre() +" porque no posee dinero o tiempo suficiente");
				}else if(cadaProducto.fueComprado(cadaUsuario.getListaCompra())){
					System.out.println("No puede adquirir: " + cadaProducto.getNombre() + " porque la/las atracciones ya fueron adquiridas anteriormente");
				}
			}
			
			System.out.println(saludoDespedida(cadaUsuario.getNombre()));
		    
		}
		entradaDeUsuario.close();
		
	     for(Usuario cadaUsuario: usuarios) {
	    	 String listaCompra= cadaUsuario.getListaCompra().toString();
	    	 ArrayList<String> datos = new ArrayList<String>();
	 		datos.add(listaCompra);
	 		AdministradorDeArchivos.guardarArchivo(datos, "prueba");
	     }

		
	}

}
