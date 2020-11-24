package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

public class Cooperativo implements EstadoDeJuego {

	@Override
	public String inicio(ArcadeMachine maquina) {
		//Aca se jugaria la partida
		maquina.cambiarEstado(new EsperandoJugadores());
		return "Se inicia el juego en modo Cooperativo.";
	}

	@Override
	public String introducirFicha(ArcadeMachine maquina) {
		return "Ya se alcanzo el limite de jugadores.";
	}

}
