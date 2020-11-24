package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

public class Singleplayer implements EstadoDeJuego {

	@Override
	public String inicio(ArcadeMachine maquina) {
		//Aca se jugaria la partida
		maquina.cambiarEstado(new EsperandoJugadores());
		return "Se inicia el juego en 1 Jugador.";
	}

	@Override
	public String introducirFicha(ArcadeMachine maquina) {
		maquina.cambiarEstado(new Cooperativo());
		return "Ingreso a modo Cooperativo, pulse inicio para jugar.";
	}

}
