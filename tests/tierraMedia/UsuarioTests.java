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
	public void comprarTest() {
		//Verifica que al comprar, descuente bien el dinero y el tiempo.
		Producto sugerenciaAceptada = new Atraccion("Rivendel", 20, 1.5, 2, TipoAtraccion.AVENTURA);
		usuario.comprar(sugerenciaAceptada);

		int dineroDispObtenido = usuario.getDineroDisponible();
		int dineroDispEsperado = 30;
		double tiempoDispObtenido = usuario.getTiempoDisponible();
		double tiempoDispEsperado = 1.5;

		assertEquals(dineroDispEsperado, dineroDispObtenido);
		assertEquals(tiempoDispEsperado, tiempoDispObtenido, 0);
	}

	@Test
	public void puedeComprarTest() {
		//Verifica que el usuario pueda comprar una sugerencia.
		Producto sugerencia = new Atraccion("Hobbiton", 10, 0.5, 2, TipoAtraccion.AVENTURA);
		assertTrue(usuario.puedeComprar(sugerencia));
	}

	@Test
	public void NoPuedeComprarTest() { // El usuario no tiene suficiente dinero
		Producto sugerencia = new Atraccion("Edoras", 60, 0.5, 2, TipoAtraccion.AVENTURA);
		assertFalse(usuario.puedeComprar(sugerencia));
	}

	@Test
	public void NoPuedeComprarTest2() {// El usuario no tiene suficiente tiempo
		Producto sugerencia = new Atraccion("Isengard", 5, 4, 2, TipoAtraccion.AVENTURA);
		assertFalse(usuario.puedeComprar(sugerencia));
	}

	@Test
	public void TiempoYMonedas() {
		//Verifica el gasto correcto de tiempo y dinero.
		Producto sugerencia = new Atraccion("Edoras", 5, 0.5, 2, TipoAtraccion.AVENTURA);
		Producto sugerencia2 = new Atraccion("Isengard", 5, 1, 2, TipoAtraccion.AVENTURA);
		Producto sugerencia3 = new Atraccion("Rivendel", 10, 1, 2, TipoAtraccion.AVENTURA);
		usuario.comprar(sugerencia);
		usuario.comprar(sugerencia2);
		usuario.comprar(sugerencia3);
		assertEquals(20, usuario.getMonedasGastadas());
		assertEquals(2.5, usuario.getTiempoGastado(), 0);
	}

	@Test
	public void PromocionesYAtracciones() {
		//Verifica que no pueda comprar atracciones o promociones repetidas.
		Usuario u1 = new Usuario("pepito", TipoAtraccion.AVENTURA, 100, 100);

		Atraccion a1 = new Atraccion("a1", 10, 3, 20, TipoAtraccion.AVENTURA);
		Atraccion a2 = new Atraccion("a2", 4, 2.5, 20, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion("a3", 2, 1, 20, TipoAtraccion.AVENTURA);
		Atraccion a4 = new Atraccion("a4", 8, 4, 20, TipoAtraccion.AVENTURA);

		List<Atraccion> packUno = new ArrayList<Atraccion>();
		packUno.add(a1);
		packUno.add(a2);
		Promocion p1 = new PromocionAbsoluta("Pack uno", 2, packUno, "Absoluta", "10");

		List<Atraccion> packDos = new ArrayList<Atraccion>();
		packDos.add(a1);
		packDos.add(a3);
		Promocion p2 = new PromocionPorcentual("Pack dos", 2, packDos, "Porcentual", "0.3");

		List<Atraccion> packTres = new ArrayList<Atraccion>();
		packTres.add(a1);
		packTres.add(a3);
		packTres.add(a2);
		Promocion p3 = new PromocionAXB("Pack tres", 3, packTres, "AXB", "a3");

		List<Atraccion> packCuatro = new ArrayList<Atraccion>();
		packCuatro.add(a2);
		packCuatro.add(a4);
		Promocion p4 = new PromocionAbsoluta("Pack Cuatro", 2, packCuatro, "Absoluta", "5");
		// Test nro1 - No puede comprar una atraccion que ya este en una promocion
		u1.comprar(p1);
		assertFalse(u1.puedeComprar(a2));
		// Test nro1.5 (opcional si una promocion solo tiene atracciones del mismo tipo)
		u1.comprar(a1);
		assertFalse(u1.puedeComprar(p2));
		// Test nro2 - No puede comprar una promocion que tenga una atraccion que ya
		// haya comprado
		u1.comprar(p1);
		assertFalse(u1.puedeComprar(p2));
		// Test nro3 - No puede comprar una promocion que tenga una atraccion que ya
		// haya comprado
		u1.comprar(p3);
		assertFalse(u1.puedeComprar(p4));
	}
}
