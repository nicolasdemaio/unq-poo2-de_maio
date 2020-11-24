package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleplayerTestCase {

	private ArcadeMachine maquina;
	private EstadoDeJuego estadoSingleplayer;
	
	@BeforeEach
	void setUp() throws Exception {
		maquina = mock(ArcadeMachine.class);
		estadoSingleplayer = new Singleplayer();
	}

	@Test
	void testInicio() {
		
		String textoEsperado = "Se inicia el juego en 1 Jugador.";
		
		String textoProducido = estadoSingleplayer.inicio(maquina);
		
		//Verify
		assertEquals(textoEsperado, textoProducido);
		verify(maquina, times(1)).cambiarEstado(any(EsperandoJugadores.class));
	}
	
	@Test
	void testIntroducirFicha() {
		String textoEsperado = "Ingreso a modo Cooperativo, pulse inicio para jugar.";
		String textoProducido = estadoSingleplayer.introducirFicha(maquina);
		
		//Verify
		assertEquals(textoEsperado, textoProducido);
		verify(maquina, times(1)).cambiarEstado(any(Cooperativo.class));
	}

}
