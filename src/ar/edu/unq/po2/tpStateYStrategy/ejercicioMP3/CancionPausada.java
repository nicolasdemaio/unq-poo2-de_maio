package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

public class CancionPausada extends Estado {

	public CancionPausada(Reproductor reproductorMP3) {
		super(reproductorMP3);
	}
	
	@Override
	public void pause() {
		this.getReproductor().getCancion().play();
		this.getReproductor().cambiarEstado(new ReproduciendoCancion(this.getReproductor()));
	}

	@Override
	public void stop() {
		this.getReproductor().getCancion().stop();
		this.getReproductor().cambiarEstado(new SeleccionDeCanciones(this.getReproductor()));
	}
	
}
