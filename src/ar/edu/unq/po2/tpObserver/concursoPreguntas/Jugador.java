package ar.edu.unq.po2.tpObserver.concursoPreguntas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Jugador implements IJugador {

	private String nombre;
	private List<String> preguntas;

	private Integer indiceDePreguntas;
	private ReceptorDeRespuestas juego;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.indiceDePreguntas = 0;
		this.preguntas = new ArrayList<String>();
		
		// No se contempla el caso en el que un jugador quede fuera de la partida.
		// Por eso dejamos null this.juego
	}
	
	@Override
	public void inicioPartida(Set<String> preguntas, ReceptorDeRespuestas juego) {
		this.getPreguntas().addAll(preguntas);
		this.setJuego(juego);
	}

	@Override
	public void preguntaRespondida(String pregunta, String nombreJugador) {
		// No se aclara comportamiento.
		System.out.println("El jugador " + nombreJugador + " respondió correctamente a la pregunta: " + pregunta);
	}

	@Override
	public void finDePartida(String nombreJugadorGanador) {
		this.setJuego(null);
		this.setPreguntas(new ArrayList<String>());
		System.out.println("Finalizo la partida. Gano: " + nombreJugadorGanador);
	}

	@Override
	public void respuestaCorrecta() {
		this.indiceDePreguntas++;
		System.out.println("Respuesta correcta.");
	}

	@Override
	public void respuestaIncorrecta() {
		System.out.println("Respuesta incorrecta.");
	}
	
	public String preguntaActual() {
		return this.getPreguntas().get(this.getIndiceDePreguntas());
	}
	
	public void responder(String pregunta, String respuesta) throws Exception {
		this.getJuego().recibirRespuesta(pregunta, respuesta, this);
	}

	public String nombreDeJugador() {
		return nombre;
	}
	
	public void setNombreDeJugador(String nombre) {
		this.nombre = nombre;
	}

	private ReceptorDeRespuestas getJuego() {
		return this.juego;
	}

	private void setJuego(ReceptorDeRespuestas juego) {
		this.juego = juego;
	}
	
	private List<String> getPreguntas() {
		return preguntas;
	}

	private void setPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
	}

	private Integer getIndiceDePreguntas() {
		return indiceDePreguntas;
	}

}
