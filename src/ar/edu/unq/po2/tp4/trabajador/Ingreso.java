package ar.edu.unq.po2.tp4.trabajador;

public class Ingreso {

	private String concepto, mes;
	private double monto;
	
	public Ingreso(String mes, String concepto, double monto) {
		setConcepto(concepto);
		setMes(mes);
		setMonto(monto);
	}

	public String getMes() {
		return mes;
	}

	public String getConcepto() {
		return concepto;
	}

	public double getMonto() {
		return monto;
	}

	public void setConcepto(String concepto) {	
		this.concepto = concepto;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double montoImponible() {
		return this.getMonto();
	}

	
	
}
