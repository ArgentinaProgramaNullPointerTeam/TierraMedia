
package tierraMedia;

import java.util.List;

public class PromocionAXB extends Promocion{
	private String nombre;
	private int cantAtracciones;
	private  List<Atraccion> atracciones;
	private  String tipoPromocion;
	private  String descuento;
	private int costoDeVisita;
	
	public PromocionAXB(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		super(nombre, cantAtracciones, atracciones, tipoPromocion, descuento);
	}
	

	public int costoDeVisita(List<Atraccion> atracciones) {
	    costoDeVisita=0;
		Atraccion atraccionGratuita=atracciones.get(atracciones.size() - 1);
		for(Atraccion cadaAtraccion: atracciones) {
			costoDeVisita= costoDeVisita + cadaAtraccion.getCostoDeVisita();
		}
		costoDeVisita=costoDeVisita-atraccionGratuita.getCostoDeVisita();   
		return costoDeVisita;
	}
	
	
}
	
