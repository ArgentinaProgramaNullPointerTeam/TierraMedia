package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion{
	private String nombre;
	private int cantAtracciones;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	private int descuento;
	private double tiempoDeVisita;

	public PromocionAbsoluta(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento = Integer.parseInt(descuento);
	}


	public String getNombre() {
		return this.nombre;
	}

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
		return "Promoci�n disponible para adquirir: " + this.nombre + ofertaAtracciones;
	}


	@Override
	public int getCostoDeVisita() {
		return this.descuento;
	}



	@Override
	public boolean esOContiene(Producto otro) {
		for (Atraccion a : this.atracciones) {
			  if(otro.esOContiene(a)) return true;
		}
		return false;
	}
	
}