package ar.edu.unq.po2.tp7.ejercicio3;

import java.util.Set;
import java.util.stream.Collectors;

public class LinkEnComun extends Filtro {

	@Override
	/*
	 * Dos paginas son similares si ambas comparten al menos un link a otra pagina
	 */
	public boolean areSimilar(WikipediaPage unaPagina, WikipediaPage otraPagina) {

		Set<WikipediaPage> linksEnComun = unaPagina.getLinks().stream()
									.filter(otraPagina.getLinks()::contains)
									.collect(Collectors.toSet());
		
		return !linksEnComun.isEmpty();	
	}
	
}


