package tierraMedia;

public abstract class Promocion extends Producto {
	@Override
	public abstract boolean hayCupo(); 
	
	@Override
	public abstract int getCostoDeVisita();
	
	@Override
	public abstract TipoAtraccion getTipoAtracciones(); 
	
	@Override
	public abstract double getTiempoDeVisita(); 
	
	@Override
	public abstract String getNombre(); 

	@Override
	public abstract void restarCupo();
	
	@Override
	public abstract boolean esPromocion();
	
	@Override
	public abstract String ofertas();
	
	@Override
	public abstract String toString();
	
	
	public abstract String getTipoPromocion(); 

	

	

	

	
	
	
	
}