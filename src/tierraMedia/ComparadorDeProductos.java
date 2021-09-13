package tierraMedia;

import java.util.Comparator;

public class ComparadorDeProductos implements Comparator<Producto> {
	// Atributo para guardar la atraccion preferida del usuario
	private TipoAtraccion atraccionPreferida;

	public ComparadorDeProductos(TipoAtraccion atraccionPreferida) {
		// Constructor que recibe por parametro la atracción preferida del usuario
		this.atraccionPreferida = atraccionPreferida;
	}

	@Override
	public int compare(Producto p1, Producto p2) {
		/*
		 * Metodo que ordena segun prioridades: 
		 * 1 Coincida con la atraccion preferida
		 * del usuario 
		 * 2 Promocion por sobre atraccion 
		 * 3 Mayor costo 
		 * 4 Mayor tiempo
		 */
		if (this.atraccionPreferida == p1.getTipo() && this.atraccionPreferida != p2.getTipo())
			return -1;
		else if (this.atraccionPreferida != p1.getTipo() && this.atraccionPreferida == p2.getTipo())
			return 1;
		else {
			if (p1 instanceof Promocion && p2 instanceof Atraccion)
				return -1;
			else if (p1 instanceof Atraccion && p2 instanceof Promocion)
				return 1;
			else {
				if (p1.getCostoDeVisita() > p2.getCostoDeVisita())
					return -1;
				else if (p1.getCostoDeVisita() < p2.getCostoDeVisita())
					return 1;
				else {
					return -1*Double.compare(p1.getTiempoDeVisita(), p2.getTiempoDeVisita());
				}
			}

		}
	}

}