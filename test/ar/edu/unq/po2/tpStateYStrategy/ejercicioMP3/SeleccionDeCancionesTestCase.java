package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeleccionDeCancionesTestCase {

	private Reproductor reproductorMP3;
	private Estado seleccionDeCanciones;
	
	@BeforeEach
	void setUp() throws Exception {
		reproductorMP3 = mock(Reproductor.class);
		seleccionDeCanciones = new SeleccionDeCanciones(reproductorMP3);
	}

	@Test
	void testConstructor() {
		assertEquals(reproductorMP3, seleccionDeCanciones.getReproductor());
	}
	
	@Test
	void testPlay() {
		//Setup
		//DOC
		Song unaCancion = mock(Song.class);
		
		when(reproductorMP3.getCancion()).thenReturn(unaCancion);
		
		//Exercise
		seleccionDeCanciones.play();
		
		//Verify
		verify(unaCancion, times(1)).play();
		verify(reproductorMP3, times(1)).cambiarEstado(any(ReproduciendoCancion.class));
	}
	
	@Test
	void testPause() {
		//Verify
		assertThrows(RuntimeException.class, ()-> seleccionDeCanciones.pause());
	}
	
	@Test
	void testStop() {
		// No hay nada que testear, no hace nada.
	}

}
