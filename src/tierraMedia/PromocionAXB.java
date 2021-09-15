
package tierraMedia;

import java.util.List;

public class PromocionAXB extends Promocion{
	private String nombre;
	private int cantAtracciones;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	private String descuento;
	private int costoDeVisita;
	private double tiempoDeVisita;

	public PromocionAXB(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento = descuento;
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public String getTipoPromocion() {
        return this.tipoPromocion;
	}

	@Override
	public String toString() {
		return this.nombre + " con  " + this.cantAtracciones + " atracciones " + this.atracciones;
	}

	@Override
	public boolean hayCupo() {
		boolean cupo = true;
		for (Atraccion cadaAtraccion : atracciones) {
			if (!cadaAtraccion.hayCupo()) {
				cupo = false;
				break;
			}
		}
		return cupo;
	}

	@Override
	public double getTiempoDeVisita() {
		for (Atraccion cadaAtraccion : atracciones) {
			tiempoDeVisita += cadaAtraccion.getTiempoDeVisita();
		}
		return tiempoDeVisita;
	}

	@Override
	public TipoAtraccion getTipoAtracciones() {
		return this.atracciones.get(0).getTipoAtracciones();
	}

	@Override
	public void restarCupo() {
		for (Atraccion cadaAtraccion : atracciones) {
			cadaAtraccion.restarCupo();
		}
	}

	@Override
	public boolean esPromocion() {
		return true;
	}

	@Override
	public String ofertas() {
		String ofertaAtracciones = "";
		for (Atraccion cadaAtraccion : this.atracciones) {
			ofertaAtracciones = ofertaAtracciones + " " + cadaAtraccion.ofertas();
		}
		return "Promoción disponible para adquirir: " + this.nombre + ofertaAtracciones;
	}

	@Override
	public boolean fueComprado(List<Producto> listaCompra) {
		boolean contiene = false;
		for (Atraccion cadaAtraccion : this.atracciones) {
			if (listaCompra.contains(cadaAtraccion)) {
				contiene = true;
				break;
			}
			;
		}
		return contiene;
	}
	
	@Override
	public int getCostoDeVisita() {
	    costoDeVisita=0;
		Atraccion atraccionGratuita=this.atracciones.get(atracciones.size() - 1);
		for(Atraccion cadaAtraccion: this.atracciones) {
			costoDeVisita= costoDeVisita + cadaAtraccion.getCostoDeVisita();
		}
		costoDeVisita=costoDeVisita-atraccionGratuita.getCostoDeVisita();   
		return costoDeVisita;
	}
	
	//Retorna el nombre de la atracción gratuita.
	public String getDescuento() {
		return this.descuento;
	}
	
}
	
