package ar.edu.unq.po2.tp6.ejercicioBanco;

public class SolicitudCreditoPersonal extends SolicitudCredito {

	public SolicitudCreditoPersonal(double monto, int plazo, Cliente cliente) {
		super(monto, plazo, cliente);
	}

	public boolean esAceptable() {
		return clienteTieneSueldoAnualMayorA15000() && cuotaMensualNoSuperaEl70PorCientoDeIngresoMensualDelCliente();
	}
	
	private boolean clienteTieneSueldoAnualMayorA15000() {
		return this.cliente.sueldoNetoAnual() > 15000;
	}

	private boolean cuotaMensualNoSuperaEl70PorCientoDeIngresoMensualDelCliente() {
		return cuotaMensual() <= (this.cliente.getSueldoNetoMensual() * 0.7);
	}
	
}
