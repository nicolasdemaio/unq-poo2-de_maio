package ar.edu.unq.po2.tp7.ejercicio3;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Filtro {

	public Filtro() {
		super();
	}
	
	public List<WikipediaPage> getSimilarPages(WikipediaPage paginaWikipedia, List<WikipediaPage> paginasAComparar)
	{
		return paginasAComparar.stream().
								filter(pagina -> this.areSimilar(pagina, paginaWikipedia)).
								collect(Collectors.toList());
	}
	
	public abstract boolean areSimilar(WikipediaPage unaPagina, WikipediaPage otraPagina);
	
}
