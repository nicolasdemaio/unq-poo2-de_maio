package ar.edu.unq.po2.tp8.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadaTest {

	//SUT
	private Jugada jugada;
	
	//DOC
	private Carta carta1, carta2, carta3, carta4, carta5;
	
	@BeforeEach
	void setUp() throws Exception {
		//DOC
		carta1 = mock(Carta.class);
		carta2 = mock(Carta.class);
		carta3 = mock(Carta.class);
		carta4 = mock(Carta.class);
		carta5 = mock(Carta.class);
		
		//SUT
		jugada = new Jugada(carta1, carta2, carta3, carta4, carta5);
	}

	@Test
	void testConstructor() {
		
		List<Carta> cartasEsperadas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		
		assertEquals(cartasEsperadas, jugada.getCartas());
	}

}
