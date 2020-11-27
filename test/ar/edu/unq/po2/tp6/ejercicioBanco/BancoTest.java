package ar.edu.unq.po2.tp6.ejercicioBanco;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Cliente cliente;
	private Banco banco;
	private SolicitudCredito solicitudCreditoPersonal, solicitudCreditoHipotecario;
	private SectorContable bancoSectorContable;
	private Propiedad propiedad;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Nico", "De Maio", "Bernal", 20, 5000);
		bancoSectorContable = new BancoSectorContable();
		propiedad = new Propiedad("Casa", "Quilmes", 2000);
		solicitudCreditoHipotecario = new SolicitudCreditoHipotecario(1000, 3, cliente, propiedad);
		solicitudCreditoPersonal = new SolicitudCreditoPersonal(1000, 2, cliente);
		banco = new Banco(bancoSectorContable);
	}

	@Test
	void testGetSolicitudes() {
		
		List<SolicitudCredito> solicitudes = new ArrayList<>();
		solicitudes.add(solicitudCreditoHipotecario);
		solicitudes.add(solicitudCreditoPersonal);
		
		banco.registrarSolicitud(solicitudCreditoHipotecario);
		banco.registrarSolicitud(solicitudCreditoPersonal);
		assertEquals(solicitudes, banco.getSolicitudes());
	}
	
	@Test
	void testGetClientes() {
	
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		banco.registrarCliente(cliente);
		
		assertEquals(clientes, banco.getClientes());
	}
	
	@Test
	void unBancoCon2SolicitudesDe1000PesosCada1_MontoADesembolsarEs2000() {
		banco.registrarSolicitud(solicitudCreditoHipotecario);
		banco.registrarSolicitud(solicitudCreditoPersonal);
		
		assertEquals(2000, banco.totalADesembolsar());
	}

}
