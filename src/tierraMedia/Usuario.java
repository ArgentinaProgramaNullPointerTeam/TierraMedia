package tierraMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela al usuario Tiene un constructor con los
 * @param nombre, atraccionPreferida, dineroDisponible, tiempoDisponible 
 * Tiene los getter para atraccionPreferida y listaCompra
 * Tiene un metodo guardarSugerencia que recibe un producto 
 * y lo guarda en listaCompra 
 * Tiene un metodo restarTiempo y restarDinero
 * que resta el tiempo y el dinero respectivamente.
 * Tiene un metodo puedeComprar que @return un boolean 
 * si tiene tiempo y dinero disponible
 */
public class Usuario {
	private String nombre;
	private TipoAtraccion atraccionPreferida;
	private double dineroDisponible;
	private double tiempoDisponible;
	private List<Producto> listaCompra = new ArrayList<Producto>();

	public Usuario(String nombre, TipoAtraccion atraccionPreferida, double dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.atraccionPreferida = atraccionPreferida;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public List<Producto> getListaCompra() {
		return listaCompra;
	}

	public void guardarSugerencia(Producto producto) {
		this.restarDinero(producto.getCostoDeVisita());
		this.restarTiempo(producto.getTiempoDeVisita());
		listaCompra.add(producto);
	}

	public void restarDinero(double dinero) {
		this.dineroDisponible -= dinero;
	}

	public void restarTiempo(double tiempo) {
		this.tiempoDisponible -= tiempo;
	}

	public boolean puedeComprar(Producto producto) {
		return this.dineroDisponible >= producto.getCostoDeVisita()
				&& this.tiempoDisponible >= producto.getTiempoDeVisita();
	}

	@Override
	public String toString() {
		return "Nombre de usuario= " + nombre + ", Atraccion preferida= " + atraccionPreferida + ", Dinero disponible= "
				+ dineroDisponible + ", Tiempo disponible= " + tiempoDisponible;
	}

}
