package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

public class EsperandoJugadores implements EstadoDeJuego {

	@Override
	public String inicio(ArcadeMachine maquina) {
		return "Inserte una ficha";
	}

	@Override
	public String introducirFicha(ArcadeMachine maquina) {
		maquina.cambiarEstado(new Singleplayer());
		return "Modo singlePlayer, ingrese otra ficha para jugar Cooperativo.";
	}

}
