package ar.edu.unq.po2.tp5.ejercicioCaja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {

	private Caja caja;
	private Producto producto;
	private ProductoDeCooperativa productoCooperativa;
	private Servicio servicio;
	private Impuesto impuesto;
	private DummyAgencia agencia;
	
	@BeforeEach
	void setUp() throws Exception {
		caja = new Caja();
		producto = new Producto("Crema", 25, 5);
		productoCooperativa = new ProductoDeCooperativa("Cafe", 10, 10);
		agencia = new DummyAgencia();
		servicio = new Servicio(1, 5, agencia);
		impuesto = new Impuesto(10, agencia);
	}

	@Test
	void alRegistrarRegistrables_ElMontoTotalEs49() {
		caja.registrar(producto); // 25$
		caja.registrar(productoCooperativa); // 9$ = Este producto tiene 10 porciento descuento = 
		caja.registrar(impuesto); // 5$
		caja.registrar(servicio); // 10$
		
		assertEquals(49, caja.montoTotal());
	}
	
	@Test
	void cuandoLaCajaRegistraUnaFacturaLaCantidadDeFacturasRegistradasDeLaAgenciaEs1() {
		caja.registrar(impuesto);
		
		assertEquals(1, agencia.getFacturasRegistradas());
	}

}
