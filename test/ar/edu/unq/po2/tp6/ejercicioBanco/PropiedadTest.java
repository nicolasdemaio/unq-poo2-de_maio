package ar.edu.unq.po2.tp6.ejercicioBanco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp6.ejercicioBanco.Propiedad;

class PropiedadTest {

	private Propiedad propiedad;
	
	@BeforeEach
	void setUp() throws Exception {
		propiedad = new Propiedad("Casa", "Falso 123", 20000);
	}

	@Test
	void testConstructor() {
		assertEquals("Casa", propiedad.getDescripcion());
		assertEquals("Falso 123", propiedad.getDireccion());
		assertEquals(20000, propiedad.valorFiscal());
	}
	
	@Test
	void setDescripcion() {
		propiedad.setDescripcion("Garage");
		assertEquals("Garage", propiedad.getDescripcion());
	}
	
	@Test
	void setDireccion() {
		propiedad.setDireccion("Alto 2");
		assertEquals("Alto 2", propiedad.getDireccion());
	}
	
	@Test
	void setValorFiscal() {
		propiedad.setValorFiscal(10000);
		assertEquals(10000, propiedad.valorFiscal());
	}

}
