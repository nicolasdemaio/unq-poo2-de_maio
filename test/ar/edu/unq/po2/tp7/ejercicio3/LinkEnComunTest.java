package ar.edu.unq.po2.tp7.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkEnComunTest {

	/* Dos paginas son similares si poseen al menos un link a una pagina en comun.
	 Por ejemplo: Si la pagina de "Bernal" tiene link a Quilmes y la pagina
	 de "Berazategui" tiene link a Quilmes, esas paginas son similares.*/

	private Filtro linkEnComun;
	private PaginaWikipedia paginaBernal;
	private PaginaWikipedia paginaBera;
	private PaginaWikipedia paginaQuilmes;
	private PaginaWikipedia paginaCapital;
	private List<WikipediaPage> links;
	
	@BeforeEach
	void setUp() throws Exception {
		paginaCapital = new PaginaWikipedia("Capital"); // Pagina dentro de lista links
		
		linkEnComun = new LinkEnComun();
		
		links = new ArrayList<>();
		links.add(paginaCapital);
		
		paginaBernal = new PaginaWikipedia("Bernal");
		paginaBera = new PaginaWikipedia("Bera", links);
		paginaQuilmes = new PaginaWikipedia("Quilmes", links);
	}

	@Test
	void cuandoDosPaginasNoTienenUnLinkAOtraPaginaEnComun_NoSonSimilares() {
		assertFalse(linkEnComun.areSimilar(paginaBernal, paginaBera));
	}
	
	@Test
	void cuandoDosPaginasTienenUnLinkEnComun_SonSimilares() {
		assertTrue(linkEnComun.areSimilar(paginaBera, paginaQuilmes));
	}

}
