package ar.edu.unq.po2.tpObserver.publicaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublicationSystem extends NotificationManager {

	private List<Article> articulos;
	
	public PublicationSystem(){
		super();
		this.articulos = new ArrayList<>();
	}
	
	public void addArticle(Article articulo) {
		this.articulos.add(articulo);
		
		super.notify(this.suscriptoresQueCorrespondeNotificar(articulo), articulo);
	}

	private List<IInvestigador> suscriptoresQueCorrespondeNotificar(Article articulo) 
	{
		return super.getSuscriptores().keySet().stream()
											   .filter(suscriptor -> articulo.correspondeConLasPreferencias(super.preferenciasDe(suscriptor)))
											   .collect(Collectors.toList());
	}

	public List<Article> getArticulos() {
		return this.articulos;
	}

	public void removeArticle(Article articulo) {
		this.getArticulos().remove(articulo);
	}
}
