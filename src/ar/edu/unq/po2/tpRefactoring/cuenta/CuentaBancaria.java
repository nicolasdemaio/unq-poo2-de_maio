package ar.edu.unq.po2.tpRefactoring.cuenta;

public abstract class CuentaBancaria {
	
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected int saldo;
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public final void extraer(Integer monto) {
		if (this.cumpleCondicionesParaExtraer(monto)) {
			this.realizarExtraccionExitosa(monto);
		}
	}

	private void realizarExtraccionExitosa(Integer monto) {
		this.descontarSaldo(monto);
		this.historialDeMovimientos.registrarMovimiento("ExtracciÃ³n", monto);
		this.notificador.notificarNuevoSaldoACliente(this);
	}

	private void descontarSaldo(Integer monto) {
		this.saldo = saldo - monto;
	}

	protected abstract Boolean cumpleCondicionesParaExtraer(Integer monto);
}

// BadSmell: Duplicate Code - Codigo duplicado, reparado con un Template Method.
// Refactors aplicados: Patron de diseño - Template Method.
// También: Extract method para agrupar comportamiento #realizarExtraccionExitosa.
