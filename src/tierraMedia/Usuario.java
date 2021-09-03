package tierraMedia;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que modela al usuario
 * Tiene un constructor con los
 * @param nombre, atraccionPreferida, dineroDisponible, tiempoDisponible
 * Tiene los getter para tiempoDisponible, dineroDisponible y listaCompra
 * Tiene un metodo guardarSugerencia que recibe un producto y 
 * lo guarda en listaCompra 
 */
public class Usuario {
	private String nombre;
	private TipoAtraccion atraccionPreferida;
	private double dineroDisponible;
	private double tiempoDisponible;
	private List<Producto> listaCompra = new ArrayList<Producto>();
	
	public Usuario(String nombre, TipoAtraccion atraccionPreferida, 
			double dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.atraccionPreferida = atraccionPreferida;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public double getDineroDisponible() {
		return dineroDisponible;
	}

	public List<Producto> getListaCompra() {
		return listaCompra;
	}
	public void guardarSugerencia(Producto producto) {
		listaCompra.add(producto);
	}
}
