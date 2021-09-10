package tierraMedia;

/**
 * Clase que modela  la atraccion. Tiene un constructor con los @param nombre,
 * costoDeVisita, tiempoDeVisita, cupo y tipoAtraccion Tiene los getter
 * para nombre, costoDeVisita, tiempoDeVisita y tipoAtraccion.
 * Tiene un metodo hayCupo que indica si la Atraccion tiene cupo o no
 * y un metodo restarCupo que resta 1 cupo cuando se acepta una compra y
 * hay cupo .
 */

public class Atraccion extends Producto {
	private String nombre;
	private int costoDeVisita;
	private double tiempoDeVisita;
	private int cupo;
	private TipoAtraccion tipoAtraccion;

	public Atraccion(String nombre, int costoDeVisita, double tiempoDeVisita, int cupo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.costoDeVisita = costoDeVisita;
		this.tiempoDeVisita = tiempoDeVisita;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getCostoDeVisita() {
		return costoDeVisita;
	}

	@Override
	public double getTiempoDeVisita() {
		return tiempoDeVisita;
	}

	@Override
	public TipoAtraccion getTipo() {
		return tipoAtraccion;
	}

	@Override
	public boolean hayCupo() {
		return this.cupo > 0;
	}

	public void restarCupo() {
		if (this.cupo > 0) {
			this.cupo -= 1;
		}

	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costoDeVisita=" + costoDeVisita + ", tiempoDeVisita=" + tiempoDeVisita
				+ ", cupo=" + cupo + ", tipoAtraccion=" + tipoAtraccion + "]";
	}

}
