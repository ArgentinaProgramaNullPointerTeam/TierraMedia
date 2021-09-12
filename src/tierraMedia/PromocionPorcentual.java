package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private static String nombre;
	private static int cantAtracciones;
	private static List<Atraccion> atracciones;
	private static String tipoPromocion;
	private static Double descuento;
	private int costoDeVisita;
	
	public PromocionPorcentual(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		super(nombre, cantAtracciones, atracciones, tipoPromocion, descuento);
		
	}

	public int getCostoDeVisita(List<Atraccion> atracciones, String descuento) {
	    costoDeVisita=0;
	    PromocionPorcentual.descuento=Double.parseDouble(descuento);
		for(Atraccion atraccion: atracciones) {
			costoDeVisita+= atraccion.getCostoDeVisita();
		}
		costoDeVisita=(int) (costoDeVisita-(costoDeVisita*PromocionPorcentual.descuento));
		return costoDeVisita;
	}
}