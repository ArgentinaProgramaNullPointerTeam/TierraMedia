package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private static String nombre;
	private static int cantAtracciones;
	private static List<Atraccion> atracciones;
	private static String tipoPromocion;
	private static Double descuento;
	
	public PromocionPorcentual(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		super(nombre, cantAtracciones, atracciones, tipoPromocion, descuento);
		
	}

	public int costoConPorcentajeDescontado(List<Atraccion> atracciones, String descuento) {
	    int costoTotal=0;
	    PromocionPorcentual.descuento=Double.parseDouble(descuento);
		for(Atraccion atraccion: atracciones) {
			costoTotal+= atraccion.getCostoDeVisita();
		}
		costoTotal=(int) (costoTotal-(costoTotal*PromocionPorcentual.descuento));
		return costoTotal;
	}
}
