package ar.edu.unq.po2.tp5.ultimaConsigna;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.ultimaConsigna.Persona;

class PersonaTest {

	private Persona persona1;
	private Persona persona2;
	private LocalDate fechaNacimiento1;
	private LocalDate fechaNacimiento2;
	
	@BeforeEach
	void setUp() {
		fechaNacimiento1 = LocalDate.of(2018, 10, 30);
		fechaNacimiento2 = LocalDate.of(2015, 10, 30);
		persona1 = new Persona("Nicolas", fechaNacimiento1);
		persona2 = new Persona("Nicolas", fechaNacimiento2);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Nicolas", persona1.getNombre());
		assertEquals(fechaNacimiento1, persona1.getFechaNacimiento());
	}
	
	@Test
	void unaPersonaQueNacioEn2018Tiene2AniosDeEdad() {
		assertEquals(2, persona1.getEdad());
	}
	
	@Test
	void unaPersonaQueNacioEn2005Tiene15AniosDeEdad() {
		assertEquals(5, persona2.getEdad());
	}
	
	@Test
	void unaPersonaQueNacioEn2018EsMenorAUnaPersonaQueNacioEnElAnio2015() {
		assertTrue(persona1.esMenor(persona2));
	}
	
	@Test
	void unaPersonaQueNacioEnElAnio2015NoEsMenorQueUnaPersonaQueNacioEnEl2018() {
		assertFalse(persona2.esMenor(persona1));
	}

}
