package ar.edu.unq.po2.tpObserver.concursoPreguntas;

public class EnPartida extends EstadoDeJuego {

	public EnPartida(Juego juego) {
		super(juego);
	}
	
	public void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) throws Exception {
		
		if(this.getJuego().esRespuestaCorrecta(pregunta, respuesta)) 
		{
			jugador.respuestaCorrecta();
			this.getJuego().computarRespuestaCorrecta(pregunta, jugador);
		}
		else {
			jugador.respuestaIncorrecta();
		}
		
	}
	
	public void anunciarFinDeJuego(IJugador jugador) {
		this.getJuego().changeState(new EsperandoJugadores(this.getJuego()));
		this.getJuego().notificarFinDePartida(jugador);
	}
	
	protected Juego getJuego() {
		return this.juego;
	}

}
