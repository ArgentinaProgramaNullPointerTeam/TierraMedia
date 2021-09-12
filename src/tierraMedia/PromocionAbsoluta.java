package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion{
	private static String nombre;
	private static int cantAtracciones;
	private static List<Atraccion> atracciones;
	private static String tipoPromocion;
	private static Double descuento;
	private int costoDeVisita;
	
	public PromocionAbsoluta(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		super(nombre, cantAtracciones, atracciones, tipoPromocion, descuento);
		
	}

	public int getCostoDeVisita(List<Atraccion> atracciones, String descuento) {
	    int costoDeVisita=Integer.parseInt(descuento);
		return costoDeVisita;
	}
}