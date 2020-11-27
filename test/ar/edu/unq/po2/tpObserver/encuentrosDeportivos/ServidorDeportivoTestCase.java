package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class ServidorDeportivoTestCase {
	
	private ServidorDeportivo servidor;

	@BeforeEach
	void setUp() throws Exception {
		servidor = new ServidorDeportivo ();
	}

	@Test
	void testConstructor() {
		assertTrue (servidor.getPartidosRecibidos().isEmpty());
	}
	
	@Test
	void testUpdate() {
		Partido partido = mock(Partido.class);
		
		servidor.update(partido);
		
		assertTrue(servidor.getPartidosRecibidos().contains(partido));
		
	}
	

}
