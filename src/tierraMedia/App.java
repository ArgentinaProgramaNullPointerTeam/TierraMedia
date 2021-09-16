package tierraMedia;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static List<Producto> productos = new ArrayList<Producto>();
	private static List<Atraccion> atracciones= new ArrayList<Atraccion>();
	private static List<Promocion> promociones= new ArrayList<Promocion>();
	private static String entradaUsuario="";
	
	private static String saludoBienvenida(String nombreUsuario) {
		return "Hola " + nombreUsuario + "\n";
	}
	
	private static String saludoDespedida(String nombreUsuario) {
		return "Que disfrute de su compra " + nombreUsuario+ "\n";
	}
	public static void main(String[] args) {
		
		usuarios = AdministradorDeArchivos.leerUsuarios(); // Tiene q devolver un array de usuarios
		atracciones = AdministradorDeArchivos.leerAtracciones();
		promociones = AdministradorDeArchivos.leerPromociones(atracciones);

		productos.addAll(promociones);
		productos.addAll(atracciones);


		Scanner entradaDeUsuario=new Scanner(System.in);
		
		for (Usuario cadaUsuario : usuarios) {
			Collections.sort(productos, new ComparadorDeProductos(cadaUsuario.getAtraccionPreferida()));
			System.out.println(saludoBienvenida(cadaUsuario.getNombre()));
			for(Producto cadaProducto: productos) {
				if(cadaUsuario.puedeComprar(cadaProducto)&& cadaProducto.hayCupo()) {  
					System.out.println(cadaProducto.ofertas());
					System.out.println("Si desea adquirir este producto ingrese SI,"
							+ " de lo contrario ingrese NO");
				    entradaUsuario= entradaDeUsuario.nextLine();
				    if((!entradaUsuario.contains("NO"))&&(!entradaUsuario.contains("SI"))){
				    	System.out.println("Si desea adquirir este producto ingrese SI,"
								+ " de lo contrario ingrese NO");
					    entradaUsuario= entradaDeUsuario.nextLine();
				    }
				    if(entradaUsuario.contains("SI")){
				    	cadaUsuario.comprar(cadaProducto);
				    	System.out.println(cadaProducto.getNombre() + " fue agregado a su itinerario.\n");
				    }else if(entradaUsuario.contains("NO")){
				    	System.out.println(cadaProducto.getNombre() + " No fue agregado a su itinerario.\n");	
				    }
				    
				    entradaUsuario="";
				}else if(!cadaUsuario.puedeComprar(cadaProducto)) {
					System.out.println("No puede adquirir: " +cadaProducto.getNombre() +
							"\n porque no posee dinero o tiempo suficiente \n "
							+ "o ya adquirio alguna atraccion anteriormente\n");
				}
			}
			
			
			String listaCompra= "Su itinerario es: \n"  + cadaUsuario.getListaCompra().toString()
					+"\n Dinero total invertido: " + cadaUsuario.getMonedasGastadas()+" monedas.\n "
					+"\n Tiempo total necesario: " + cadaUsuario.getTiempoGastado() + " horas.\n ";
	    	 ArrayList<String> datos = new ArrayList<String>();
	 		datos.add(listaCompra);
	 		AdministradorDeArchivos.guardarArchivo(datos, cadaUsuario.getNombre());
	 		
	 		System.out.println(saludoDespedida(cadaUsuario.getNombre())+
					"\n Su archivo fue generado.------------------\n");
		}
		entradaDeUsuario.close();
		

		
	}

}
