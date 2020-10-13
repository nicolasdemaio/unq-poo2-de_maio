package ar.edu.unq.po2.tp6.ejercicioBanco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente, cliente2;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Nicolas", "De Maio", "Bernal", 20, 10000);
		cliente2 = new Cliente("Ezequiel", "De Maio", "Bernal", 24, 20000);
	}

	@Test
	void testConstructor() {
		assertEquals("Nicolas", cliente.getNombre());
		assertEquals("De Maio", cliente.getApellido());
		assertEquals("Bernal", cliente.getDireccion());
		assertEquals(20, cliente.getEdad());
		assertEquals(10000, cliente.getSueldoNetoMensual());
	}
	
	@Test
	void testSetNombre() {
		cliente.setNombre("Juan");
		assertEquals("Juan", cliente.getNombre());
	}
	
	@Test
	void testSetApellido() {
		cliente.setApellido("Albert");
		assertEquals("Albert", cliente.getApellido());
	}
	
	@Test
	void testSetDireccion() {
		cliente.setDireccion("Avellaneda");
		assertEquals("Avellaneda", cliente.getDireccion());
	}
	
	@Test
	void testSetEdad() {
		cliente.setEdad(19);
		assertEquals(19, cliente.getEdad());
	}
	
	@Test
	void testSetSueldoNetoMensual() {
		cliente.setSueldoNetoMensual(18000);
		assertEquals(18000, cliente.getSueldoNetoMensual());
	}
	
	@Test
	void unClienteConSueldoNetoMensualDe10000Pesos_SuSueldoNetoAnualEs120000Pesos() {
		assertEquals(120000, cliente.sueldoNetoAnual());
	}
	
	@Test
	void unCLienteConSueldoNetoMensualDe20000Pesos_SuSueldoNetoAnualEs240000Pesos() {
		assertEquals(240000, cliente2.sueldoNetoAnual());
	}

}
