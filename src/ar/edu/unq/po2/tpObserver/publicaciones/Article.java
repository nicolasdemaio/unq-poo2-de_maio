package ar.edu.unq.po2.tpObserver.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Article {

	private String title, afiliation, type, publishmentPlace;
	private List<String> authors, keyWords;
	
	public Article(String title, List<String> authors, String afiliation, String type, String publishmentPlace,
			List<String> keyWords) {
		this.title = title;
		this.afiliation = afiliation;
		this.type = type;
		this.publishmentPlace = publishmentPlace;
		this.authors = authors;
		this.keyWords = keyWords;
	}

	public String getTitle() {
		return title;
	}

	public String getAfiliation() {
		return afiliation;
	}

	public String getType() {
		return type;
	}

	public String getPublishmentPlace() {
		return publishmentPlace;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public List<String> getKeyWords() {
		return keyWords;
	}

	private List<String> datosBibliograficos() {
		List<String> datosDeArticulo = new ArrayList<String>();
		datosDeArticulo.add(this.getAfiliation());
		datosDeArticulo.add(this.getPublishmentPlace());
		datosDeArticulo.add(this.getTitle());
		datosDeArticulo.add(this.getType());
		datosDeArticulo.addAll(this.getAuthors());
		datosDeArticulo.addAll(this.getKeyWords());
		
		return datosDeArticulo;
	}

	public Boolean correspondeConLasPreferencias(List<String> preferencias) {
		return preferencias.stream().anyMatch(preferencia -> this.datosBibliograficos().contains(preferencia));
	}

}
