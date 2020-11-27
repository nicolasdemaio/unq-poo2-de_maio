package ar.edu.unq.po2.tpObserver.concursoPreguntas;

public class EsperandoJugadores extends EstadoDeJuego {

	public EsperandoJugadores(Juego juego) {
		super(juego);
	}
	
	public void inscribirJugador(IJugador jugador) {
		this.getJuego().getJugadoresYPuntos().put(jugador, 0);
	}
	
	public void iniciar() {
		this.getJuego().notificarInicioDePartida();
		this.getJuego().changeState(new EnPartida(this.getJuego()));
	}

}
