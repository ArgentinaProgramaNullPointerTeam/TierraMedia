package tierraMedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static List<Producto> productos = new ArrayList<Producto>();

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

		// ordenar sugerencia
		for (Usuario cadaUsuario : usuarios) {
			System.out.println("antes de ordenar" + productos);
			System.out.println("clase: "+ productos.get(0).getClass().getName());
			Collections.sort(productos, new ComparadorDeProductos(cadaUsuario.getAtraccionPreferida()));
			System.out.println("despues de ordenar" + productos);
			
			System.out.println(cadaUsuario.getNombre() +"--" + (productos.get(0).getNombre()));
		
		}

		/*
		 * for(Promocion cadaPromo: promociones) {
		 * System.out.println(cadaPromo.getCostoDeVisita()); }
		 */

		ArrayList<String> datos = new ArrayList<String>();
		datos.add("algo");
		AdministradorDeArchivos.guardarArchivo(datos, "prueba");
	}

}
