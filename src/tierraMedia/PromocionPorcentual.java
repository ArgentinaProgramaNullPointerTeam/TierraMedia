package tierraMedia;

public class PromocionPorcentual extends Promocion {

	public int costoConPorcentajedescontado(List<Atraccion> atracciones, double porcentaje){
	    int costoTotal=0;
		for(Atraccion atraccion: atracciones) {
			costoTotal+= atraccion.getCostoDeVisita();
		}
	}
}
