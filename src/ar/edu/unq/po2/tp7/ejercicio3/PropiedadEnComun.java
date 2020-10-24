package ar.edu.unq.po2.tp7.ejercicio3;

import java.util.Set;

public class PropiedadEnComun extends Filtro {

	/*si la p�gina de una persona tiene la propiedad
	�birth_place� y otra p�gina posee tambi�n la propiedad �birth_place� serian similares
	mutuamente.*/
	
	// Una pagina tiene un HashMap <String, WikipediaPage>
	// Si dos paginas comparten el mismo String son similares, eso entiendo por el enunciado.
	
	@Override
	public boolean areSimilar(WikipediaPage unaPagina, WikipediaPage otraPagina) {
		Set<String> clavesPagina1 = unaPagina.getInfobox().keySet();
		Set<String> clavesPagina2 = otraPagina.getInfobox().keySet();
		
		boolean hayPropiedadEnComun = false;
		
		for (String clave : clavesPagina2) {
			if(clavesPagina1.contains(clave)) {
				hayPropiedadEnComun = true;
				break;
			}
		}
		return hayPropiedadEnComun;
	}

}
