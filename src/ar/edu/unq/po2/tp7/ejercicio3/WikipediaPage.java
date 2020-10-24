package ar.edu.unq.po2.tp7.ejercicio3;

import java.util.HashMap;
import java.util.List;

public interface WikipediaPage {

	String getTitle();
	List<WikipediaPage> getLinks();
	HashMap<String, WikipediaPage> getInfobox();
	
}
