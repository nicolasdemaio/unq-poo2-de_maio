package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CancionPausadaTestCase {

	private Estado cancionPausada;
	private Reproductor reproductorMP3;
	private Song unaCancion;
	
	@BeforeEach
	void setUp() throws Exception {
		unaCancion = mock(Song.class);
		reproductorMP3 = mock(Reproductor.class);
		
		cancionPausada = new CancionPausada(reproductorMP3);
		
		when(reproductorMP3.getCancion()).thenReturn(unaCancion);
	}

	@Test
	void testConstructor() {
		assertEquals(reproductorMP3, cancionPausada.getReproductor());
	}
	
	@Test
	void testPlay() {
		assertThrows(RuntimeException.class, () -> cancionPausada.play());
	}
	
	@Test
	void testPause() {
		//Exercise
		cancionPausada.pause();
		//Verify
		verify(unaCancion, times(1)).play();
		verify(reproductorMP3, times(1)).cambiarEstado(any(ReproduciendoCancion.class));
	}
	
	@Test
	void testStop() {
		//Exercise
		cancionPausada.stop();
		
		//Verify
		verify(unaCancion).stop();
		verify(reproductorMP3).cambiarEstado(any(SeleccionDeCanciones.class));
	}

}
