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
	
	public final void extraer(Integer monto) { /* Template Method */
		if (this.cumpleCondicionesParaExtraer(monto)) { /* Operacion primitiva, metodo abstracto */
			this.realizarExtraccionExitosa(monto); /* Operacion concreta */
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

/* Bad Smell:
 * Duplicate Code - Codigo duplicado en varias clases,a pesar de tener la jerarquia de clases.
 * "If the duplicate code is similar but not completely identical, use Form Template Method."
 * Lo solucione con el patron de diseño Template Method.
 * Utilice, ademas, extract method para agrupar comportamiento #realizarExtraccionExitosa.
 */

