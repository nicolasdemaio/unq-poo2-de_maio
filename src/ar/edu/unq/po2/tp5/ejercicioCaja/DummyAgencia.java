package ar.edu.unq.po2.tp5.ejercicioCaja;

public class DummyAgencia implements Agencia {

	private int facturasRegistradas;
	
	@Override
	public void registrarPago(Factura factura) {
		this.facturasRegistradas ++;
	}
	
	public int getFacturasRegistradas() {
		return facturasRegistradas;
	}

}
