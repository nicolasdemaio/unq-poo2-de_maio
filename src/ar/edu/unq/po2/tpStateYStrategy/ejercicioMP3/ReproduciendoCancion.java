package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

public class ReproduciendoCancion extends Estado {

	public ReproduciendoCancion(Reproductor reproductorMP3) {
		super(reproductorMP3);
	}
	
	@Override
	public void pause() {
		this.getReproductor().getCancion().pause();
		this.getReproductor().cambiarEstado(new CancionPausada(this.getReproductor()));
	}
	
	@Override
	public void stop() {
		this.getReproductor().getCancion().stop();
		this.getReproductor().cambiarEstado(new SeleccionDeCanciones(this.getReproductor()));
	}

}
