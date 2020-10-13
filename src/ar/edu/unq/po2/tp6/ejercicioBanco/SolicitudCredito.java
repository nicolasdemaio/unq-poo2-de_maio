package ar.edu.unq.po2.tp6.ejercicioBanco;

public abstract class SolicitudCredito {

	protected Cliente cliente;
	private double monto;
	private int plazo;
	
	public SolicitudCredito(double monto, int plazo, Cliente cliente) {
		this.cliente = cliente;
		this.monto = monto;
		this.plazo = plazo;
	}

	public double getMonto() {
		return monto;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double cuotaMensual() {
		return monto / plazo;
	}
	
	public abstract boolean esAceptable();

}
