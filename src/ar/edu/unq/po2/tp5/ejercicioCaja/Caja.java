package ar.edu.unq.po2.tp5.ejercicioCaja;

public class Caja {
	
	private double montoAPagar;
	
	public Caja() {
		// Implement
	}

	public void registrar(Registrable registrable) {
		this.montoAPagar += registrable.registrarse();
	}

	public double montoTotal() {
		return montoAPagar;
	}

}
