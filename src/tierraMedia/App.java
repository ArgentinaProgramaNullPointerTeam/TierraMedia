package tierraMedia;


import java.util.ArrayList;
import java.util.List;

public class App {
	private static List<Usuario> usuarios = new ArrayList <Usuario>();
	private static List<Producto> productos = new ArrayList <Producto>();

	
	public static void main(String[] args) {	
	    List<Atraccion> atracciones;
		List<Promocion> promociones;
		
	
		System.out.println("Leer\n");
		usuarios = AdministradorDeArchivos.leerUsuarios(); //Tiene q devolver un array de usuarios
		
		System.out.println("Leer\n");
	
		atracciones = AdministradorDeArchivos.leerAtracciones();
		
		promociones=AdministradorDeArchivos.leerPromociones(atracciones);
		System.out.println(promociones);
		
		productos.addAll (promociones);
		productos.addAll (atracciones);
		
	
		System.out.println(usuarios);
	}
}