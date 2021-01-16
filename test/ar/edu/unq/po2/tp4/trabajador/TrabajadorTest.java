package ar.edu.unq.po2.tp4.trabajador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrabajadorTest {

	private Trabajador trabajador;
	private Ingreso ingreso1;
	private IngresoPorHorasExtras ingreso2;
	
	@BeforeEach
	public void setUp() throws Exception {
		trabajador = new Trabajador();
		ingreso1 = new Ingreso("Enero", "Salario", 1000);
		ingreso2 = new IngresoPorHorasExtras("Febrero", "Administracion", 2000, 5);
	}
	
	@Test
	void testConstructor() {
		assertTrue(trabajador.getIngresos().isEmpty());
	}
	
	@Test
	void testAgregarIngreso() {
		
		trabajador.agregarIngreso(ingreso1);
		
		ArrayList<Ingreso> ingresosEsperados = new ArrayList<>();
		ingresosEsperados.add(ingreso1);
		
		assertEquals(ingresosEsperados, trabajador.getIngresos());
	}
	
	@Test
	void testGetTotalPercibido() {
		trabajador.agregarIngreso(ingreso1);
		trabajador.agregarIngreso(ingreso2);
		
		assertEquals(3000, trabajador.getTotalPercibido());
	}
	
	@Test
	void testGetMontoImponible() {
		trabajador.agregarIngreso(ingreso1);
		trabajador.agregarIngreso(ingreso2);
		
		assertEquals(1000, trabajador.getMontoImponible());
	}
	
	@Test
	void testGetImpuestoAPagar() {
		trabajador.agregarIngreso(ingreso1);
		trabajador.agregarIngreso(ingreso2);
		
		assertEquals(20, trabajador.getImpuestoAPagar());
	}

}
