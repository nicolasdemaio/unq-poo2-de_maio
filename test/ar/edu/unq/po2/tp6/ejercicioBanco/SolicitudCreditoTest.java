package ar.edu.unq.po2.tp6.ejercicioBanco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoTest {

	private SolicitudCredito solicitudCredito;
	private Cliente cliente1, cliente2;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente1 = new Cliente("Nicolas", "De Maio", "Bernal", 20, 10000);
		cliente2 = new Cliente("Ezequiel", "De Maio", "Bernal", 24, 5000);
		solicitudCredito = new SolicitudCreditoPersonal(5000, 5, cliente1); // No puede ser tipo SolicitudCredito porque es abstracta
	}

	@Test
	void testConstructor() {
		assertEquals(5000, solicitudCredito.getMonto());
		assertEquals(5, solicitudCredito.getPlazo());
		assertEquals(cliente1, solicitudCredito.getCliente());
	}
	
	@Test
	void testSetMonto() {
		solicitudCredito.setMonto(10000);
		
		assertEquals(10000, solicitudCredito.getMonto());
	}
	
	@Test
	void testSetPlazo() {
		solicitudCredito.setPlazo(10);
		
		assertEquals(10, solicitudCredito.getPlazo());
	}
	
	@Test
	void testSetCliente() {
		solicitudCredito.setCliente(cliente2);
		
		assertEquals(cliente2, solicitudCredito.getCliente());
	}
	
	@Test
	void unaSolicitudConMonto5000PesosYPlazo5Meses_LaCuotaMensualEsDe1000Pesos() {
		assertEquals(1000, solicitudCredito.cuotaMensual());
	}
	
	@Test
	void unaSolicitudConMonto10000PesosYPlazo2Meses_LaCuotaMensualEsDe5000Pesos() {
		//Exercise
		solicitudCredito.setMonto(10000);
		solicitudCredito.setPlazo(2);
		
		//Assert
		assertEquals(5000, solicitudCredito.cuotaMensual());
	}
	
	//Surge la necesidad de crear una jerarquia, esAceptable() depende el tipo de SolicitudCredito.
	
	

}
