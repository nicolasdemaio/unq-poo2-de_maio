package ar.edu.unq.po2.tp7.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MismaLetraInicialTest {

	Filtro mismaLetraInicial;
	PaginaWikipedia paginaBernal;
	PaginaWikipedia paginaBerazategui;
	PaginaWikipedia paginaQuilmes;
	
	@BeforeEach
	void setUp() throws Exception {
		mismaLetraInicial = new MismaLetraInicial();
		paginaBernal = new PaginaWikipedia("Bernal");
		paginaBerazategui = new PaginaWikipedia("Berazategui");
		paginaQuilmes = new PaginaWikipedia("Quilmes");
	}

	@Test
	void cuandoDosPaginasTienenLetrasInicialesDistintas_NoSonSimilares() {
		assertFalse(mismaLetraInicial.areSimilar(paginaBerazategui, paginaQuilmes));
	}
	
	@Test
	void cuandoDosPaginasTienenMismaLetraInicial_SonSimilares() {
		assertTrue(mismaLetraInicial.areSimilar(paginaBernal, paginaBerazategui));
	}

}
