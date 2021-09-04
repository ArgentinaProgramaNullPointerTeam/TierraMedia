package tierraMedia;

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

	public String getNombre() {
		return nombre;
	}

	public int getCostoDeVisita() {
		return costoDeVisita;
	}

	public double getTiempoDeVisita() {
		return tiempoDeVisita;
	}

	public int getCupo() {
		return cupo;
	}

	public TipoAtraccion getTipo() {
		return tipoAtraccion;
	}
	
	public void  restarCupo (int cupo) throws Exception {
		if (this.cupo > cupo) {
			this.cupo -= cupo;
		} else {
			throw new Exception ("No hay más cupo");
		}
	}
	
	@Override
	public boolean hayCupo() {
		if (this.cupo > 0) {
			return true;
		}
		return false;
	}

}
