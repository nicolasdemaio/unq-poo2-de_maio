package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

public class Reproductor {

	private Estado estado;
	private Song cancion;
	
	public Reproductor(Estado unEstado, Song unaCancion) {
		this.estado = unEstado;
		this.cancion = unaCancion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public Song getCancion() {
		return this.cancion;
	}

	public void cambiarCancion(Song otraCancion) {
		this.cancion = otraCancion;
	}

	public void cambiarEstado(Estado otroEstado) {
		this.estado = otroEstado;
	}

	public void play() {
		this.getEstado().play();
	}

	public void pause() {
		this.getEstado().pause();
	}

	public void stop() {
		this.getEstado().stop();
	}

}
