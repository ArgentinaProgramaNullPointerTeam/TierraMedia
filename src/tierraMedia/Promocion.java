package tierraMedia;

public class Promocion {
	private static String nombre;
	private static int cantAtracciones;
	private static List<Atraccion> atracciones;
	private static String tipoPromocion;
	private static String descuento;
	
	public void Promocion (String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion, String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones= atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento= descuento;	
	}
	
	
	
}
