package ar.edu.unq.po2.tpObserver.publicaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArticleTestCase {

	private String titulo, afiliacion, tipo, lugarDePublicacion;
	private List<String> autores, palabrasClaves;
	private Article articulo;
	
	@BeforeEach
	void setUp() throws Exception {
		//DOC
		titulo = "Titulo";
		autores = Arrays.asList("Pepita", "Wilkinson");
		afiliacion = "UNQ";
		tipo = "Conferencia";
		lugarDePublicacion = "Bernal";
		palabrasClaves = Arrays.asList("Argentina", "Smalltalk", "POO");
				
		//SUT
		articulo = new Article(titulo, autores, afiliacion, tipo, lugarDePublicacion, palabrasClaves);		
	}

	@Test
	void testConstructor() {
		//Verify
		assertEquals(titulo, articulo.getTitle());
		assertEquals(autores, articulo.getAuthors());
		assertEquals(afiliacion, articulo.getAfiliation());
		assertEquals(tipo, articulo.getType());
		assertEquals(lugarDePublicacion, articulo.getPublishmentPlace());
		assertEquals(palabrasClaves, articulo.getKeyWords());
	}
	
	@Test
	void testCorrespondeConLasPreferencias() {
		//Setup
		//DOC
		List<String> preferencias = Arrays.asList("Smalltalk", "Bernal");
		
		//Verify
		assertTrue(articulo.correspondeConLasPreferencias(preferencias));
	}

}
