package ar.edu.unq.po2.tpObserver.concursoPreguntas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Juego implements ReceptorDeRespuestas {

	private Map<String, String> cuestionario;
	private Map<IJugador, Integer> jugadoresYPuntos;
	private EstadoDeJuego estado;
	
	public Juego(Map<String, String> cuestionario) {
		this.cuestionario = cuestionario;
		this.estado = new EsperandoJugadores(this);
		this.jugadoresYPuntos = new HashMap<IJugador, Integer>();
	}

	@Override
	public void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) throws Exception {
		this.getEstado().recibirRespuesta(pregunta, respuesta, jugador);
	}
	
	public void computarRespuestaCorrecta(String pregunta, IJugador jugador) throws Exception {
		
		this.notificarATodosRespuestaCorrecta(pregunta, jugador.nombreDeJugador());
		this.sumarUnPunto(jugador);
		
		if(this.esGanador(jugador)) {
			this.anunciarFinDeJuego(jugador);
		}
	}
	
	private void sumarUnPunto(IJugador jugador) {
		
		Integer nuevoPuntaje = this.obtenerPuntaje(jugador) + 1;
		
		this.getJugadoresYPuntos().put(jugador, nuevoPuntaje);
		
	}
	
	private Integer obtenerPuntaje(IJugador jugador) {
		return this.getJugadoresYPuntos().get(jugador);
	}

	private void notificarATodosRespuestaCorrecta(String pregunta, String nombreDeJugador) {
		this.getJugadoresYPuntos().keySet().forEach(jugador -> jugador.preguntaRespondida(pregunta, nombreDeJugador));
	}

	private Boolean esGanador(IJugador jugador) {
		
		Integer puntajeDelJugador = this.getJugadoresYPuntos().get(jugador);
		
		return puntajeDelJugador == this.getPreguntas().size();
	}

	public void inscribirJugador(IJugador jugador) throws Exception {
		if(jugadoresYPuntos.size() >= 5) {
			throw new Exception("Juego lleno, 5 participantes.");
		}
		this.getEstado().inscribirJugador(jugador);
	}
	
	public void iniciar() throws Exception {
		this.getEstado().iniciar();
	}

	public void anunciarFinDeJuego(IJugador jugador) throws Exception {
		this.getEstado().anunciarFinDeJuego(jugador);
	}
	
	private EstadoDeJuego getEstado() {
		return this.estado;
	}

	public Map<IJugador, Integer> getJugadoresYPuntos() {
		return this.jugadoresYPuntos;
	}

	public void notificarInicioDePartida() {
		this.getJugadoresYPuntos().keySet().forEach(jugador -> jugador.inicioPartida(this.getPreguntas(), this));
	}
	
	private Set<String> getPreguntas(){
		return this.cuestionario.keySet();
	}

	public Boolean esRespuestaCorrecta(String pregunta, String respuesta) {
		
		String respuestaEsperada = this.cuestionario.get(pregunta);
		
		return respuestaEsperada.equals(respuesta);
	}

	public void changeState(EstadoDeJuego estado) {
		this.estado = estado;
	}

	public void notificarFinDePartida(IJugador jugadorGanador) {
		
		this.getJugadoresYPuntos().keySet().forEach(jugador -> jugador.finDePartida(jugadorGanador.nombreDeJugador()));
	}
	
}
