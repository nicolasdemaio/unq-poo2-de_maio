package ar.edu.unq.po2.tp5.ejercicioCaja;

public class Impuesto extends Factura {

	private double tasaDeImpuesto;
	
	public Impuesto (double tasaImpuesto, Agencia agencia) {
		super(agencia);
		this.tasaDeImpuesto = tasaImpuesto;
	}
	
	public double montoAPagar() {
		return tasaDeImpuesto;
	}
	
}
