package ar.edu.unq.po2.tp4.trabajador;

import java.util.ArrayList;

public class Trabajador {

	private ArrayList<Ingreso> ingresos;
	
	public Trabajador() {
		ingresos = new ArrayList<>();
	}
	
	public ArrayList<Ingreso> getIngresos() {
		return ingresos;
	}

	public double getTotalPercibido() {
		
		/*double monto = 0;
		for (Ingreso ingreso : ingresos) {
			monto += ingreso.getMonto();
		}
		
		return monto;*/
		
		// Hecho con Lambda Expressions. Bloques como Smalltalk.
		return ingresos.stream().mapToDouble(ingreso -> ingreso.getMonto()).sum();
	}

	public void añadirIngreso(Ingreso ingreso) {
		ingresos.add(ingreso);
	}

	public double getMontoImponible() {
		double montoImponible = 0;
		for (Ingreso ingreso : ingresos) {
			montoImponible += ingreso.montoImponible();
		}
		return montoImponible;
	}

	public double getImpuestoAPagar() {
		
		double montoImpuesto = (this.getMontoImponible() * 0.02);
		
		return montoImpuesto;
	}

}
