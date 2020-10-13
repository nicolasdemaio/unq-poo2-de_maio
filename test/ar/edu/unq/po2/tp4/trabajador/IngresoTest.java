package ar.edu.unq.po2.tp4.trabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoTest {

	private Ingreso ingreso;
	
	@BeforeEach
	public void setUp() throws Exception {
		ingreso = new Ingreso("Enero", "Administracion", 1000);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Enero", ingreso.getMes());
		assertEquals("Administracion", ingreso.getConcepto());
		assertEquals(1000, ingreso.getMonto());
	}
	
	@Test
	void testSetConcepto() {
		ingreso.setConcepto("Salario");
		assertEquals("Salario", ingreso.getConcepto());
	}
	
	@Test
	void testSetMes() {
		ingreso.setMes("Febrero");
		assertEquals("Febrero", ingreso.getMes());
	}
	
	@Test
	void testSetMonto() {
		ingreso.setMonto(2000);
		assertEquals(2000, ingreso.getMonto());
	}
	
	@Test
	void testMontoImponible() {
		ingreso.setMonto(2000);
		assertEquals(2000, ingreso.montoImponible());
	}
	
}
