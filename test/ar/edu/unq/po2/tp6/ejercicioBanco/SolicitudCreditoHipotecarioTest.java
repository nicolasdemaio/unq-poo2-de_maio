package ar.edu.unq.po2.tp6.ejercicioBanco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudCreditoHipotecarioTest {

	private SolicitudCreditoHipotecario solicitudCreditoHipotecario;
	private Cliente cliente;
	private Propiedad propiedad, propiedad2;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Nico", "De Maio", "Bernal", 20, 10000);
		propiedad = new Propiedad("Casa", "Avellaneda", 50000);
		propiedad2 = new Propiedad("Garage", "Quilmes", 10000);
		solicitudCreditoHipotecario = new SolicitudCreditoHipotecario(1000, 2, cliente, propiedad);
	}

	@Test
	void testConstructor() {
		assertEquals(1000, solicitudCreditoHipotecario.getMonto());
		assertEquals(2, solicitudCreditoHipotecario.getPlazo());
		assertEquals(cliente, solicitudCreditoHipotecario.getCliente());
		assertEquals(propiedad, solicitudCreditoHipotecario.getGarantia());
	}
	
	@Test
	void testSetGarantia() {
		solicitudCreditoHipotecario.setGarantia(propiedad2);
		assertEquals(propiedad2, solicitudCreditoHipotecario.getGarantia());
	}
	
	@Test
	void unCreditoHipotecarioQueSuMontoDeCuotaSuperaEl50PorcientoDelIngresoMensualDelClienteNoEsAceptable() {
		// Setup
		Cliente cliente1 = new Cliente("Juan", "Carlos", "Bernal", 25, 10000); // Cliente que cobra 10000 mensual
		Propiedad propiedad1 = new Propiedad("Casa", "Bernal", 30000); // Propiedad
		SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(15000, 2, cliente1, propiedad1); // Solicitud con pago de 7500 dos meses
		
		// Exercise
		
		//Assert
		assertFalse(solicitud.esAceptable()); // No es aceptable porque la cuota supera (7500) supera el 50 porciento del ingreso mensual del cliente
	}
	
	@Test
	void unCreditoHipotecarioQueSuMontoDeCuotaNoPasaEl50PorcientoDelIngresoMensualDelClienteEsAceptable() {
		// Setup
		Cliente cliente1 = new Cliente("Juan", "Carlos", "Bernal", 25, 10000); // Cliente que cobra 10000 Mensual
		Propiedad propiedad1 = new Propiedad("Casa", "Bernal", 30000); // Propiedad
		SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(10000, 2, cliente1, propiedad1); // Solicitud que se paga 5000 durante dos meses.
				
		// Exercise
				
		//Assert
		assertTrue(solicitud.esAceptable()); // Es aceptable porque cada cuota de la solicitud (5000) no pasa el 50 por ciento del ingreso mensual del cliente (10000)
	}
	
	@Test
	void unCreditoConMontoMayorAl70PorcientoDelValorFiscalDeLaGarantiaNoEsAceptable() {
		Cliente cliente1 = new Cliente("Juan", "Carlos", "Bernal", 25, 5000); // Cliente
		Propiedad propiedad1 = new Propiedad("Casa", "Bernal", 30000); // Propiedad con valor de 30000
		SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(35000, 2, cliente1, propiedad1); // Solicitud
				
		// Exercise
				
		//Assert
		assertFalse(solicitud.esAceptable()); // No es aceptable porque el monto de la solicitud (35000) supera al 70 porciento del valor de la propiedad
	}
	
	@Test
	void unCreditoHipotecarioParaUnClienteQueSupera65AntesDeTerminarDePagarloNoEsAceptable() {
		Cliente cliente1 = new Cliente("Juan", "Carlos", "Bernal", 64, 5000); // Cliente con 64 años de Edad
		Propiedad propiedad1 = new Propiedad("Casa", "Bernal", 30000); // Propiedad
		SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(20000, 36, cliente1, propiedad1); // Solicitud de plazo a 36 Meses (3 años)
				
		// Exercise
				
		//Assert
		assertFalse(solicitud.esAceptable()); // No es aceptable porque la Edad + el plazo en años supera 65.
	}


}
