package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AplicacionMovilTestCase {
	private AplicacionMovil aplicacion;

	@BeforeEach
	void setUp() throws Exception {
		aplicacion = new AplicacionMovil ();
	}

	@Test
	void testConstructor() {
		assertTrue (aplicacion.getPartidos().isEmpty());
	}
	
	@Test
	void testUpdate() {
		Partido partido = mock (Partido.class);
		
		aplicacion.update(partido);
		
		assertTrue (aplicacion.getPartidos().contains(partido));
	}

}
