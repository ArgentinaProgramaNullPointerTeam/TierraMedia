package tierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTests {

	Usuario usuario;
	
	@Before
	public void setup() {
		usuario = new Usuario("Sam", TipoAtraccion.AVENTURA, 50, 3);
	}

	@After
	public void tearDown() {
		usuario = null;
	}
	
	@Test
	public void crearUsuarioTest() {
		assertNotNull(usuario);
	}
	
	@Test
	public void guardarSugerenciaTest() {
		Producto sugerenciaAceptada = new Atraccion("Rivendel", 20, 1.5, 2, TipoAtraccion.AVENTURA);
		usuario.guardarSugerencia(sugerenciaAceptada);
		
		double dineroDispObtenido = usuario.getDineroDisponible();
		double dineroDispEsperado = 30;
		double tiempoDispObtenido = usuario.getTiempoDisponible();
		double tiempoDispEsperado = 1.5;
		
		assertEquals(dineroDispEsperado, dineroDispObtenido, 0);
		assertEquals(tiempoDispEsperado, tiempoDispObtenido,0);
	}
	@Test
	public void puedeComprarTest() {
		Producto sugerencia = new Atraccion("Hobbiton", 10, 0.5, 2, TipoAtraccion.AVENTURA);
		assertTrue(usuario.puedeComprar(sugerencia));
	}
	@Test
	public void NoPuedeComprarTest() { //no tiene suficiente dinero
		Producto sugerencia = new Atraccion("Edoras", 60, 0.5, 2, TipoAtraccion.AVENTURA);
		assertFalse(usuario.puedeComprar(sugerencia));
	}
	@Test
	public void NoPuedeComprarTest2() {//no tiene suficiente tiempo
		Producto sugerencia = new Atraccion("Isengard", 5, 4, 2, TipoAtraccion.AVENTURA);
		assertFalse(usuario.puedeComprar(sugerencia));
	}
}
