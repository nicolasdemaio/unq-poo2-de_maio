package ar.edu.unq.po2.tp5.ejercicioCaja;

public class Servicio  extends Factura {

	private double costoUnidad;
	private int cantUnidadesConsumidas;
	
	public Servicio(double costoUnidad, int cantUnidadesConsumidas, Agencia agencia) {
		super(agencia);
		this.costoUnidad = costoUnidad;
		this.cantUnidadesConsumidas = cantUnidadesConsumidas;
	}
	
	public double montoAPagar() {
		return (costoUnidad * cantUnidadesConsumidas);
	}
	
}
