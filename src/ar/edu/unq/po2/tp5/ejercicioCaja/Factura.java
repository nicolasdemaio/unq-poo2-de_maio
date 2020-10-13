package ar.edu.unq.po2.tp5.ejercicioCaja;

public abstract class Factura implements Registrable {

	private Agencia agencia;
	
	public Factura(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public abstract double montoAPagar();
	
	public double registrarse() {
		agencia.registrarPago(this);
		return this.montoAPagar();
	}
	
}
