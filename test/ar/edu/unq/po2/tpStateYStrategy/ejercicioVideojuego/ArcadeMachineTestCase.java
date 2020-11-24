package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ArcadeMachineTestCase {

	private ArcadeMachine maquina;
	private EstadoDeJuego esperandoJugadores;
	private EstadoDeJuego singlePlayer;

	@BeforeEach
	void setUp() throws Exception {
		
		//DOC
		esperandoJugadores = mock(EsperandoJugadores.class);
		singlePlayer = mock(Singleplayer.class);
		
		//SUT
		maquina = new ArcadeMachine(esperandoJugadores);
	}

	@Test
	void testConstructor() {
		assertEquals(esperandoJugadores, maquina.getState());
	}

	@Test
	void testCambiarEstado(){
		//Exercise
		maquina.cambiarEstado(singlePlayer);
		//Verify
		assertEquals(singlePlayer, maquina.getState());
	}
	
	@Test
	void testInicio() {
		
		String respuesta = "Inicio.";
		
		when(esperandoJugadores.inicio(maquina)).thenReturn(respuesta);
		
		//Exercise
		String textoProducido = maquina.inicio();
		
		//Verify
		assertEquals(respuesta, textoProducido); // Como cada Estado tiene su propio testCase, no considere necesario testear todas las posibilidades
		verify(esperandoJugadores, times(1)).inicio(maquina);
	}
	
	@Test
	void introducirFicha() {
		
		String respuesta = "Introdujo ficha";
		
		when(esperandoJugadores.introducirFicha(maquina)).thenReturn(respuesta);
		
		//Exercise
		String textoProducido = maquina.introducirFicha();
		
		//Verify
		assertEquals(respuesta, textoProducido);
		verify(esperandoJugadores, times(1)).introducirFicha(maquina);
	}

}