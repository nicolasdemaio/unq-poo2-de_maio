package ar.edu.unq.po2.tp5.ultimaConsigna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.ultimaConsigna.Mascota;

class MascotaTest {

	private Mascota mascota;
	
	@BeforeEach
	void setUp() {
		mascota = new Mascota("Pepe", "Doberman");
	}
	
	@Test
	void testConstructor() {
		assertEquals("Pepe", mascota.getNombre());
		assertEquals("Doberman", mascota.getRaza());
	}

}
