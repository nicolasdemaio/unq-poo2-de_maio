package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestorDePartidos {
	
	private Set<Partido> partidos;
	private Map<String, ArrayList<IObserver>> aspectos; //Map de <Aspecto, Observer>
	
	public GestorDePartidos() {
		this.partidos = new HashSet<Partido>();
		this.aspectos = new HashMap<String, ArrayList<IObserver>>();
	}
	
	public void agregarObserver(IObserver observer, Set<String> intereses) {
		for (String aspecto : intereses) {
			this.vincularAspectoYObserver(aspecto, observer);
		}
	}

	private void vincularAspectoYObserver(String aspecto, IObserver observer) {
		if(this.suscriptoresDelAspecto(aspecto) == null) {
			this.aspectos.put(aspecto, new ArrayList<IObserver>());
		}
		this.suscriptoresDelAspecto(aspecto).add(observer);
	}
	
	public void recibirPartido(Partido partido) {
		this.partidos.add(partido);
		for (String aspecto : partido.datosDelPartido()) {
			this.notificar(partido, aspecto);
		}
	}
	

	private void notificar(Partido partido, String aspectoDePartido) {
		if (this.elAspectoEstaEnLosAspectosDeInteres(aspectoDePartido)) {
			this.notificarASuscriptores(this.suscriptoresDelAspecto(aspectoDePartido), partido);
		}
	}
	
	private boolean elAspectoEstaEnLosAspectosDeInteres(String aspectoDePartido) {
		return this.aspectos.containsKey(aspectoDePartido);
	}
	
	private void notificarASuscriptores(ArrayList<IObserver> suscriptores, Partido partido) {
		for (IObserver suscriptor : suscriptores) {
			suscriptor.update(partido);
		}
	}

	public ArrayList<IObserver> suscriptoresDelAspecto(String aspecto) {
		return this.aspectos.get(aspecto);
	}

	public Set<Partido> getPartidos() {
		return this.partidos;
	}
	
	public Map<String, ArrayList<IObserver>> getAspectos() {
		return this.aspectos;
	}

}
