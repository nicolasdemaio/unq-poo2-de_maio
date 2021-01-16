package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CooperativoTestCase {

	private ArcadeMachine maquina;
	private EstadoDeJuego cooperativo;
	
	@BeforeEach
	void setUp() throws Exception {
		maquina = mock(ArcadeMachine.class);
		cooperativo = new Cooperativo();
	}

	@Test
	void testInicio() {
		
		String textoEsperado = "Se inicia el juego en modo Cooperativo.";
		String textoProducido = cooperativo.inicio(maquina);
		
		//Verify
		assertEquals(textoEsperado, textoProducido);
		verify(maquina, times(1)).cambiarEstado(any(EsperandoJugadores.class));
	}
	
	@Test
	void testIntroducirFicha() {
		String textoEsperado = "Ya se alcanzo el limite de jugadores.";
		String textoProducido = cooperativo.introducirFicha(maquina);
		
		//Verify
		assertEquals(textoEsperado, textoProducido);
	}

}