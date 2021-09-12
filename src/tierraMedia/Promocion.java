package tierraMedia;

import java.util.List;

public class Promocion extends Producto {
	private String nombre;
	private int cantAtracciones;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	private String descuento;
	private int costoDeVisita;

	public Promocion(String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion,
			String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento = descuento;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TipoAtraccion getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}