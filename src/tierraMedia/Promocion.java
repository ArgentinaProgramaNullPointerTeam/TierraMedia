package tierraMedia;

import java.util.List;

public class Promocion extends Producto {
	private String nombre;
	private int cantAtracciones;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	private String descuento;
	private int costoDeVisita;
	private TipoAtraccion tipoDePromocion;
	private double tiempoDeVisita;

	public Promocion(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento = descuento;
		this.tipoDePromocion = atracciones.get(0).getTipo();
	}


	@Override
	public String toString() {
		return this.nombre + " " + this.cantAtracciones + " " + this.atracciones;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCostoDeVisita() {
		if (tipoPromocion.equals("Porcentual")) {
			PromocionPorcentual promocionPorcentual = new PromocionPorcentual(nombre, cantAtracciones, atracciones,
					tipoPromocion, descuento);
			costoDeVisita = promocionPorcentual.getCostoDeVisita(atracciones, descuento);
		} else if (tipoPromocion.equals("Absoluta")) {
			PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(nombre, cantAtracciones, atracciones,
					tipoPromocion, descuento);
			costoDeVisita = promocionAbsoluta.getCostoDeVisita(atracciones, descuento);
		} else if (tipoPromocion.equals("AXB")) {
			PromocionAXB promocionAXB = new PromocionAXB(nombre, cantAtracciones, atracciones, tipoPromocion,
					descuento);
			costoDeVisita = promocionAXB.getCostoDeVisita(atracciones);
		}

		return costoDeVisita;
	}

	public String getTipoPromocion() {
		return tipoPromocion;
	}

	@Override
	public double getTiempoDeVisita() {
		for(Atraccion cadaAtraccion:atracciones) {
			tiempoDeVisita+= cadaAtraccion.getTiempoDeVisita();
		}
		return tiempoDeVisita;
	}

	@Override
	public TipoAtraccion getTipo() {
		return this.tipoDePromocion;
	}

	@Override
	public String getNombre() {
		return nombre;
	}


	@Override
	public void restarCupo() {
		for(Atraccion cadaAtraccion:atracciones) {
			cadaAtraccion.restarCupo();
		}
		
	}


	@Override
	public boolean esPromocion() {
		return true;
	}

}