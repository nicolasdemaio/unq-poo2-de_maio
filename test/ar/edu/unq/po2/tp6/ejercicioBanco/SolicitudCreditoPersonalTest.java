package ar.edu.unq.po2.tp6.ejercicioBanco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoPersonalTest {

	private SolicitudCreditoPersonal solicitudCreditoPersonal, solicitudCreditoPersonal2;
	private Cliente cliente, cliente2;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Nicolas", "De Maio", "Bernal", 20, 1000);
		solicitudCreditoPersonal = new SolicitudCreditoPersonal(1000, 2, cliente);
		cliente2 = new Cliente("Juan", "Carlos", "Quilmes", 33, 1500);
		solicitudCreditoPersonal2 = new SolicitudCreditoPersonal(8000, 10, cliente2);
	}

	@Test
	void testConstructor() {
		assertEquals(1000, solicitudCreditoPersonal.getMonto());
		assertEquals(2, solicitudCreditoPersonal.getPlazo());
		assertEquals(cliente, solicitudCreditoPersonal.getCliente());
	}
	
	@Test
	void unaSolicitudDeCreditoPersonalDeClienteQueTieneIngresosAnualesMenorA15000Pesos_NoEsAceptable() {
		assertFalse(solicitudCreditoPersonal.esAceptable());
	}
	
	@Test
	void unClienteConIngresoAnualDe18000PesosYLaCuotaDeSolicitudNoSupera70PorCientoDelIngresoMensual_EsAceptable() {	
		assertTrue(solicitudCreditoPersonal2.esAceptable());
	}

}
