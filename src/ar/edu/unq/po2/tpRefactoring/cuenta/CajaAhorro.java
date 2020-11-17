package ar.edu.unq.po2.tpRefactoring.cuenta;

public class CajaAhorro extends CuentaBancaria{

	public CajaAhorro(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super(historialDeMovimientos, notificador, saldo);
	}
	
	public Boolean cumpleCondicionesParaExtraer(Integer monto) {
		return this.saldo >= monto;
	}
	

}
