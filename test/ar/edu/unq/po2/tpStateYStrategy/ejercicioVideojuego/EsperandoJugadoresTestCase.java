package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EsperandoJugadoresTestCase {

	private ArcadeMachine maquina;
	private EstadoDeJuego estadoEsperandoJugadores;
	
	@BeforeEach
	void setUp() throws Exception {
		maquina = mock(ArcadeMachine.class);
		estadoEsperandoJugadores = new EsperandoJugadores();
	}

	@Test
	void testInicio() {
		
		String textoEsperado = "Inserte una ficha";
		
		String textoProducido = estadoEsperandoJugadores.inicio(maquina);
		
		//Verify
		assertEquals(textoEsperado, textoProducido);
	}
	
	@Test
	void testIntroducirFicha() {
		String textoEsperado = "Modo singlePlayer, ingrese otra ficha para jugar Cooperativo.";
		String textoProducido = estadoEsperandoJugadores.introducirFicha(maquina);
		
		//Verify
		assertEquals(textoEsperado, textoProducido);
		verify(maquina, times(1)).cambiarEstado(any(Singleplayer.class));
	}

}
