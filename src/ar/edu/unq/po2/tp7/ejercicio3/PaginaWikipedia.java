package ar.edu.unq.po2.tp7.ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaginaWikipedia implements WikipediaPage {

	private String title;
	private List<WikipediaPage> links;
	private HashMap <String, WikipediaPage> infoBox;
	
	public PaginaWikipedia(String title, List<WikipediaPage> links, HashMap<String, WikipediaPage> infoBox) {
		this.title = title;
		this.links = links;
		this.infoBox = infoBox;
	}
	
	public PaginaWikipedia(String title, HashMap<String, WikipediaPage> infoBox) {
		this.title = title;
		this.infoBox = infoBox;
		links = new ArrayList<>();
	}
	
	public PaginaWikipedia(String title) {
		this.title = title;
		links = new ArrayList<>();
		infoBox = new HashMap<>();
	}
	
	public PaginaWikipedia(String title, List<WikipediaPage> links) {
		this.title = title;
		this.links = links;
		infoBox = new HashMap<>();
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public List<WikipediaPage> getLinks() {
		return links;
	}

	@Override
	public HashMap<String, WikipediaPage> getInfobox() {
		return infoBox;
	}

}
