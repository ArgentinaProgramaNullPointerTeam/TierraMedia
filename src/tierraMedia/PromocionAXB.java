
package tierraMedia;

import java.util.List;

public class PromocionAXB extends Promocion{
	
	public PromocionAXB(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		super(nombre, cantAtracciones, atracciones, tipoPromocion, descuento);
	}
	
	private String nombre;
	private int cantAtracciones;
	private  List<Atraccion> atracciones;
	private  String tipoPromocion;
	private  String descuento;
	


	public int costoConAtraccionDescontada(List<Atraccion> atracciones) {
		int costoTotal=0;
		Atraccion atraccionGratuita=atracciones.get(atracciones.size() - 1);
		for(Atraccion cadaAtraccion: atracciones) {
			costoTotal= costoTotal + cadaAtraccion.getCostoDeVisita();
		}
		costoTotal=costoTotal-atraccionGratuita.getCostoDeVisita();   
		return costoTotal;
	}
	
	
}
	
