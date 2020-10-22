package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuadradoTest {

	private Cuadrado cuadrado;
	private Point punto;
	
	@BeforeEach
	void setUp() throws Exception {
		punto = new Point(0, 0);
		cuadrado = new Cuadrado(punto, 4);
	}

	@Test
	void unCuadradoDeLado4_SuPerimetroEs16() {
		assertEquals(cuadrado.perimetro(), 16);
	}
	
	@Test
	void unCuadradoDeLado4_SuAreaEs16() {
		assertEquals(cuadrado.getArea(), 16);
	}

}
