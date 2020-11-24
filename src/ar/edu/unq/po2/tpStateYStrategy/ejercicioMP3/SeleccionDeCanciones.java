package ar.edu.unq.po2.tpStateYStrategy.ejercicioMP3;

public class SeleccionDeCanciones extends Estado {

	public SeleccionDeCanciones(Reproductor reproductorMP3) {
		super(reproductorMP3);
	}
	
	@Override
	public void play() {
		this.getReproductor().getCancion().play();
		this.getReproductor().cambiarEstado(new ReproduciendoCancion(this.getReproductor()));
	}

}
