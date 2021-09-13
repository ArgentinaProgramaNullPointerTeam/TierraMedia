package tierraMedia;

//Clase abstracta y métodos abstractos
//Hereda a las clases Atraccion y Promocion
public abstract class Producto {
	
	
	//Devuelve si hay cupos
	public abstract boolean hayCupo();
	
	//Devuelve el costo	de la visita
	public abstract int getCostoDeVisita();
	
	//Devuelve el tipo de atraccion
	public abstract TipoAtraccion getTipo();
	
	//Devuelve el tiempo de la visita
	public abstract double getTiempoDeVisita();
	
	//Devuelve el nombre
	public abstract String getNombre();
	
	//Resta cupos
	public abstract void restarCupo();
	
	//Devuelve si es un producto o no lo es
	public abstract boolean esPromocion();
	
	
	
	
	

}