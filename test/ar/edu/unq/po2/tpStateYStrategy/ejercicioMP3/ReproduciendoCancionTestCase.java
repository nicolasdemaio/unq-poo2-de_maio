package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReproduciendoCancionTestCase {

	private Estado reproduciendoCancion;
	private Reproductor reproductorMP3;
	private Song unaCancion;
	
	@BeforeEach
	void setUp() throws Exception {
		reproductorMP3 = mock(Reproductor.class);
		unaCancion = mock(Song.class);
		
		reproduciendoCancion = new ReproduciendoCancion(reproductorMP3);
		
		when(reproductorMP3.getCancion()).thenReturn(unaCancion);
	}

	@Test
	void testConstructor() {
		assertEquals(reproductorMP3, reproduciendoCancion.getReproductor());
	}
	
	@Test
	void testPlay() {
		assertThrows(RuntimeException.class, () -> reproduciendoCancion.play());
	}
	
	@Test
	void testPause(){
		//Exercise
		reproduciendoCancion.pause();
		
		//Verify
		verify(unaCancion, times(1)).pause();
		verify(reproductorMP3, times(1)).cambiarEstado(any(CancionPausada.class));
	}
	
	@Test
	void testStop() {
		//Exercise
		reproduciendoCancion.stop();
		
		//Verify
		verify(unaCancion, times(1)).stop();
		verify(reproductorMP3, times(1)).cambiarEstado(any(SeleccionDeCanciones.class));
	}

}
