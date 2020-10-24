package ar.edu.unq.po2.tp7.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadEnComunTest {

	/*retorna aquellas páginas que poseen alguna propiedad del
	infobox en común, por ejemplo si la página de una persona tiene la propiedad
	“birth_place” y otra página posee también la propiedad “birth_place” serian similares
	mutuamente. En este caso, no importa que el valor de la propiedad sea diferente.*/
	
	// Una pagina tiene un HashaMap <String, WikipediaPage>
	// Si dos paginas comparten el mismo String son similares, eso entiendo por el enunciado.
	
	private Filtro propiedadEnComun;
	private PaginaWikipedia paginaCanada, paginaBernal, paginaQuilmes, paginaBera;
	private HashMap<String, WikipediaPage> infoBox1, infoBox2;

	@BeforeEach
	void setUp() throws Exception {
		propiedadEnComun = new PropiedadEnComun(); // Filtro
		paginaCanada = new PaginaWikipedia("Canada"); // Pagina del Infobox
		infoBox1 = new HashMap<>(); // Infobox en paginaBernal y paginaQuilmes
		infoBox1.put("birth_place", paginaCanada);
		infoBox2 = new HashMap<>(); // Infobox en paginaBernal y paginaQuilmes
		infoBox2.put("birth_place", paginaCanada);
		infoBox2.put("location", paginaQuilmes);
		paginaBernal = new PaginaWikipedia("Bernal", infoBox1);
		paginaBera = new PaginaWikipedia("Bera");
		paginaQuilmes = new PaginaWikipedia("Quilmes", infoBox2);
	}

	@Test
	void dosPaginasQueNoCompartenNiUnaPropiedad_NoSonSimilares() {
		assertFalse(propiedadEnComun.areSimilar(paginaBernal, paginaBera));
	}
	
	@Test
	void dosPaginasQueCompartenUnaPropiedad_SonSimilares() {
		assertTrue(propiedadEnComun.areSimilar(paginaBernal, paginaQuilmes));
	}

	
}
