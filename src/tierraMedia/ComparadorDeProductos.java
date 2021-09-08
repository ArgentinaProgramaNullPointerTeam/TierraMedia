package tierraMedia;

public class ComparadorDeProductos implements Comparator<Producto> {
	// Atributo para guardar la atraccion preferida del usuario
	private TipoAtraccion atraccionPreferida;

	public ComparadorDeProductos(TipoAtraccion atraccionPreferida) {
		// Constructor que recibe por parametro la atracción preferida del usuario
		this.atraccionPreferida = atraccionPreferida;
	}

	@Override
		public int compare(Producto p1, Producto p2) {
			/*Metodo que ordena segun prioridades:
			 * 1 Coincida con la atraccion preferida del usuario 
             /////ver costo y tiempo (o en App)
			 * 2 Promocion por sobre atraccion
			 * 3 Mayor costo 
			 * 4 Mayor tiempo
			 */
			if(this.atraccionPreferida== p1.getTipo() 
					&& this.atraccionPreferida !=p2.getTipo())
				return -1;
			else if (this.atraccionPreferida!= p1.getTipo() 
					&& this.atraccionPreferida == p2.getTipo())
				return 1;
			else{ 
				if (p1.getClass().getName() == "Promocion" &&
						&& p2.getClass().getName()!= "Atraccion") 
					return -1;
				else if (p1.getClass().getName() == "Atraccion" &&
						&& = p2.getClass().getName()!= "Promocion")
					return 1;
				else {
					if (p1.getCostoDeVisita()> p2.getCostoDeVisita()) 
						return -1;
					else if (p1.getCostoDeVisita()< p2.getCostoDeVisita())
						return 1;
					else {
						Double.compare(p1.getTiempoDeVisita(), p2.getTiempoDeVisita());
					}
				}
						
			}
	}

}