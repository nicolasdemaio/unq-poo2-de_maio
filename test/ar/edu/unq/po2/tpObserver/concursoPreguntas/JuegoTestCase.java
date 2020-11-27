package ar.edu.unq.po2.tpObserver.concursoPreguntas;

import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTestCase {
	
	private Juego juego;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	//Realice un test de unidad que permita verificar que cuando el servidor recibe una respuesta incorrecta notifica correctamente.
	
	@Test
	void testCuandoSeRecibeRespuestaIncorrecta_ElJugadorEsNotificadoQueRespondioIncorrectamente() throws Exception {
		//SETUP
		//DOC
		IJugador jugador = mock(Jugador.class);
		
		Map<String, String> cuestionario = new HashMap<String, String>();
		
		String pregunta = "¿Cuanto es 2 + 2?";
		
		cuestionario.put(pregunta, "4");
		
		//SUT
		juego = new Juego(cuestionario);
	
		juego.inscribirJugador(jugador);
		juego.iniciar();
		
		//Exercise
		juego.recibirRespuesta(pregunta, "5", jugador);
		
		//Verify
		verify(jugador, times(1)).respuestaIncorrecta();
		
	}

}
