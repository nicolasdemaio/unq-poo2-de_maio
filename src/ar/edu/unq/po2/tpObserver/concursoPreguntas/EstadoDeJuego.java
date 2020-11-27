package ar.edu.unq.po2.tpObserver.concursoPreguntas;

public abstract class EstadoDeJuego {

	protected Juego juego;
	
	public EstadoDeJuego(Juego juego) {
		this.juego = juego;
	}
	
	public void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) throws Exception {
		throw new Exception("El juego no empezo.");
	}
	
	public void inscribirJugador(IJugador jugador) throws Exception {
		throw new Exception("Juego ya iniciado, no se pueden añadir jugadores.");
	}

	public void iniciar() throws Exception {
		throw new Exception("Juego ya iniciado.");
	}
	
	public void anunciarFinDeJuego(IJugador jugador) throws Exception {
		throw new Exception("El juego todavia no ha comenzado.");
	}
	
	protected Juego getJuego() {
		return this.juego;
	}
	
}
