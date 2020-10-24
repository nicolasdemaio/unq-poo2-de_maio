package ar.edu.unq.po2.tp7.ejercicio3;

public class MismaLetraInicial extends Filtro {

	@Override
	public boolean areSimilar(WikipediaPage unaPagina, WikipediaPage otraPagina) {
		// Son similares si la letra inicial de ambas son iguales.
		return unaPagina.getTitle().charAt(0) == otraPagina.getTitle().charAt(0);
	}

}
