package tierraMedia;

//Clase abstracta y m�todos abstractos
//Hereda a las clases Atraccion y Promocion
public abstract class Producto {
	
	
	//Devuelve si hay cupos
	public abstract boolean hayCupo();
	
	//Devuelve el costo	de la visita
	public abstract int getCostoDeVisita();
	
	//Devuelve el tipo de atracci�n
	public abstract TipoAtraccion getTipo();
	
	//Devuelve el tiempo de la visita
	public abstract double getTiempoDeVisita();
	
	
	
	
	

}
