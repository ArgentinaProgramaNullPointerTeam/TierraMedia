package tierraMedia;

import java.util.List;

public class Promocion extends Producto {
	private static String nombre;
	private static int cantAtracciones;
	private static List<Atraccion> atracciones;
	private static String tipoPromocion;
	private static String descuento;
	




	public  Promocion (String nombre, int cantAtracciones, List<Atraccion> atracciones, String tipoPromocion, String descuento) {
		this.nombre = nombre;
		this.cantAtracciones = cantAtracciones;
		this.atracciones= atracciones;
		this.tipoPromocion = tipoPromocion;
		this.descuento= descuento;	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TipoAtraccion getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTiempoDeVisita() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	 
	
	}
		
	
	
