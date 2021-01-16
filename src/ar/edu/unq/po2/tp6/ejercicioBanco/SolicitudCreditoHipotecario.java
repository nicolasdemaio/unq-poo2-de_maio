package ar.edu.unq.po2.tp6.ejercicioBanco;

public class SolicitudCreditoHipotecario extends SolicitudCredito {

	private Garantia garantia;
	
	public SolicitudCreditoHipotecario(double monto, int plazo, Cliente cliente, Garantia garantia) {
		super(monto, plazo, cliente);
		this.garantia = garantia;
	}

	@Override
	public boolean esAceptable() {
		return cuotaNoSupera50PorCientoDeIngresoMensualDelCliente() && 
				montoEsMenorAl70PorcientoDelValorFiscalDeGarantia() &&
				clienteNoSupera65AniosAntesDeTerminarDePagar();
	}

	private boolean clienteNoSupera65AniosAntesDeTerminarDePagar() {
		return this.cliente.getEdad() + plazoEnAnios() <= 65;
	}

	private Integer plazoEnAnios() {
		return getPlazo()/12;
	}

	private boolean cuotaNoSupera50PorCientoDeIngresoMensualDelCliente() {
		return (this.cuotaMensual() <= (this.cliente.getSueldoNetoMensual() * 0.50));
	}
	
	private boolean montoEsMenorAl70PorcientoDelValorFiscalDeGarantia() {
		return this.getMonto() <= (this.garantia.valorFiscal() * 0.70);
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}

}
