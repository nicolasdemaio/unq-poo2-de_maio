package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

public abstract class Estado {

	protected Reproductor reproductorMP3;
	
	public Estado(Reproductor reproductorMP3) {
		this.reproductorMP3 = reproductorMP3;
	}

	public void play() {
		throw new RuntimeException();
	}

	public void pause() {
		throw new RuntimeException();
	}

	public void stop() {
		// No hace nada.
	}

	public Reproductor getReproductor() {
		return this.reproductorMP3;
	}

}
