package ar.edu.unq.po2.tp5.ejercicioCaja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.ejercicioCaja.Caja;
import ar.edu.unq.po2.tp5.ejercicioCaja.DummyAgencia;
import ar.edu.unq.po2.tp5.ejercicioCaja.Impuesto;
import ar.edu.unq.po2.tp5.ejercicioCaja.Producto;
import ar.edu.unq.po2.tp5.ejercicioCaja.ProductoDeCooperativa;
import ar.edu.unq.po2.tp5.ejercicioCaja.Servicio;

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
	void alRegistrarLasInstanciasDeArribaElMontoTotalEs49() {
		caja.registrar(producto);
		caja.registrar(productoCooperativa); // Este producto tiene 10 porciento descuento
		caja.registrar(impuesto);
		caja.registrar(servicio);
		assertEquals(49, caja.montoTotal());
	}
	
	@Test
	void cuandoLaCajaRegistraUnaFacturaLaCantidadDeFacturasRegistradasDeLaAgenciaEs1() {
		caja.registrar(impuesto);
		assertEquals(1, agencia.getFacturasRegistradas());
	}

}
