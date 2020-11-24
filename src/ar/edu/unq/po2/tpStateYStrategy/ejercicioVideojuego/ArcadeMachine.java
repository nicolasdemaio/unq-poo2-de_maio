package ar.edu.unq.po2.tpStateYStrategy.ejercicioVideojuego;

public class ArcadeMachine {

	private EstadoDeJuego estado;
	
	public ArcadeMachine(EstadoDeJuego estado) {
		this.setState(estado);
	}

	public void cambiarEstado(EstadoDeJuego estado) {
		this.setState(estado);
	}
	
	public void setState(EstadoDeJuego estado) {
		this.estado = estado;
	}
	
	public EstadoDeJuego getState() {
		return this.estado;
	}

	public String inicio() {
		return this.getState().inicio(this);
	}

	public String introducirFicha() {
		return this.getState().introducirFicha(this);
	}

}
