package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReproductorTestCase {

	private Reproductor reproductorMP3;
	private Estado unEstado;
	private Estado otroEstado;
	private Song unaCancion;
	private Song otraCancion;
	
	@BeforeEach
	void setUp() throws Exception {
		//DOC
		unaCancion = mock(Song.class);
		otraCancion = mock(Song.class);
		unEstado = mock(Estado.class);
		otroEstado = mock(Estado.class);
		
		//SUT
		reproductorMP3 = new Reproductor(unEstado, unaCancion);
	}

	@Test
	void testConstructor() {
		assertEquals(unEstado, reproductorMP3.getEstado());
		assertEquals(unaCancion, reproductorMP3.getCancion());
	}
	
	@Test
	void testCambiarCancion() {
		//Exercise
		reproductorMP3.cambiarCancion(otraCancion);
		
		//Verify
		assertEquals(otraCancion, reproductorMP3.getCancion());
	}
	
	@Test
	void testCambiarEstado() {
		//Exercise
		reproductorMP3.cambiarEstado(otroEstado);
		
		//Verify
		assertEquals(otroEstado, reproductorMP3.getEstado());
	}
	
	@Test
	void testPlay() {
		//Exercise
		reproductorMP3.play();
		
		//Verify
		verify(unEstado, times(1)).play();
	}
	
	@Test
	void testPause() {
		//Exercise
		reproductorMP3.pause();
				
		//Verify
		verify(unEstado, times(1)).pause();
	}
	
	@Test
	void testStop() {
		//Exercise
		reproductorMP3.stop();
						
		//Verify
		verify(unEstado, times(1)).stop();
	}

}
