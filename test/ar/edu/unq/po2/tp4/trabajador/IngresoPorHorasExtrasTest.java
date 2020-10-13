package ar.edu.unq.po2.tp4.trabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoPorHorasExtrasTest {

	private IngresoPorHorasExtras ingreso;
	
	@BeforeEach
	public void setUp() throws Exception {
		ingreso = new IngresoPorHorasExtras("Enero", "Administracion", 1000, 5);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Enero", ingreso.getMes());
		assertEquals("Administracion", ingreso.getConcepto());
		assertEquals(1000, ingreso.getMonto());
		assertEquals(5, ingreso.getHorasExtras());
	}
	
	@Test
	void testSetHorasExtras() {
		ingreso.setHorasExtras(10);
		assertEquals(10, ingreso.getHorasExtras());
	}
	
	@Test
	void testMontoImponible() {
		assertEquals(0, ingreso.montoImponible());
	}

}
