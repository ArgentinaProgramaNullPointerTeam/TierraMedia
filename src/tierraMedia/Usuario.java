package tierraMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela al usuario Tiene un constructor con los parametros nombre,
 * atraccionPreferida, dineroDisponible, tiempoDisponible Tiene los getter para
 * atraccionPreferida y listaCompra Tiene un metodo guardarSugerencia que recibe
 * un producto y lo guarda en listaCompra Tiene un metodo restarTiempo y
 * restarDinero que resta el tiempo y el dinero respectivamente. Tiene un metodo
 * puedeComprar que retorna un boolean si tiene tiempo y dinero disponible.
 * Tiene dos metodos que retorna las monedas gastadas y el tiempo gastado en las
 * compras que realizo el usuario respectivamente.
 */
public class Usuario {
	private String nombre;
	private TipoAtraccion atraccionPreferida;
	private int dineroDisponible;
	private double tiempoDisponible;
	private List<Producto> listaCompra = new ArrayList<Producto>();
	private int monedasGastadas;
	private double tiempoGastado;

	public Usuario(String nombre, TipoAtraccion atraccionPreferida, int dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.atraccionPreferida = atraccionPreferida;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public List<Producto> getListaCompra() {
		return listaCompra;
	}

	public int getMonedasGastadas() {
		for (Producto cadaProducto : listaCompra) {
			this.monedasGastadas += cadaProducto.getCostoDeVisita();
		}
		return this.monedasGastadas;
	}

	public double getTiempoGastado() {
		for (Producto cadaProducto : listaCompra) {
			this.tiempoGastado += cadaProducto.getTiempoDeVisita();
		}
		return this.tiempoGastado;
	}

	public void guardarSugerencia(Producto producto) {
		this.restarDinero(producto.getCostoDeVisita());
		this.restarTiempo(producto.getTiempoDeVisita());
		listaCompra.add(producto);
	}

	public void restarDinero(int dinero) {
		this.dineroDisponible -= dinero;
	}

	public void restarTiempo(double tiempo) {
		this.tiempoDisponible -= tiempo;
	}

	public boolean puedeComprar(Producto producto) {

		return this.dineroDisponible >= producto.getCostoDeVisita()
				&& this.tiempoDisponible >= producto.getTiempoDeVisita() 
				&& !producto.fueComprado(this.listaCompra);
	}

	

	@Override
	public String toString() {
		return "Nombre de usuario= " + nombre + ", Atraccion preferida= " + atraccionPreferida + ", Dinero disponible= "
				+ dineroDisponible + ", Tiempo disponible= " + tiempoDisponible;
	}

}
