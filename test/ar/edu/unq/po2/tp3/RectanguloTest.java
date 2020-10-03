package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectanguloTest {

	private Point punto;
	private Rectangulo rectangulo;
	
	@BeforeEach
	void setUp() throws Exception {
		punto = new Point(0, 0);
		rectangulo = new Rectangulo(punto, 4, 6);
	}

	@Test
	void unRectanguloCon4DeAlturaY6DeAnchoSuAreaEs24() {
		assertEquals(24, rectangulo.getArea());
	}
	
	@Test
	void unRectanguloCon6DeAnchoY4DeAlturaSuSentidoEsVertical() {
		assertEquals("Sentido Horizontal.", rectangulo.sentido());
	}

}
