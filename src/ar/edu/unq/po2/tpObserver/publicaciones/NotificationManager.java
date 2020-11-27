package ar.edu.unq.po2.tpObserver.publicaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class NotificationManager {

	private Map<IInvestigador, List<String>> suscriptores;

	public NotificationManager(){
		suscriptores = new HashMap<IInvestigador, List<String>>();
	}
	
	protected Map<IInvestigador, List<String>> getSuscriptores(){
		return this.suscriptores;
	}

	protected void añadirSuscriptor(IInvestigador investigador, List<String> preferencias) {
		this.suscriptores.put(investigador, preferencias);
	}

	protected List<String> preferenciasDe(IInvestigador investigador){
		return this.getSuscriptores().get(investigador);
	}

	protected void removerSuscriptor(IInvestigador investigador) {
		this.getSuscriptores().remove(investigador);
	}
	
	protected void notify(List<IInvestigador> suscriptores, Article articulo) {
		suscriptores.stream().forEach(suscriptor -> suscriptor.update(articulo));
	}
	
}
