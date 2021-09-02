package tierraMedia;

import java.util.List;



public class App {
	private static List<Usuario> usuarios;
	
	public static void main(String[] args) {		
		System.out.println("Leer\n");
		usuarios = AdministradorDeArchivos.leerUsuarios(); //Tiene q devolver un array de usuarios

		private static List<Atraccion> atracciones;
		System.out.println("Leer\n");
		atraccion = AdministradorDeArchivos.leerAtracciones(); //Tiene q devolver un array de atracciones
		
		private static List<Promocion> promociones;
		System.out.println("Leer\n");
		promociones = AdministradorDeArchivos.leerPromociones(); //Tiene q devolver un array de promociones
}
	
