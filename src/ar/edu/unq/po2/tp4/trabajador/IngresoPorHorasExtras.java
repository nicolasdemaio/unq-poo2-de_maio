package ar.edu.unq.po2.tp4.trabajador;

public class IngresoPorHorasExtras extends Ingreso {
	
	private int horasExtras;

	public IngresoPorHorasExtras(String mes, String concepto, double monto, int horasExtras) {
		super(mes, concepto, monto);
		setHorasExtras(horasExtras);
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}

	@Override
	public double montoImponible() {
		return 0;
	}
	
}
