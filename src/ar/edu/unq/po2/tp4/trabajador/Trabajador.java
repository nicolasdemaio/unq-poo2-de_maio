package ar.edu.unq.po2.tp4.trabajador;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {

	private List<Ingreso> ingresos;
	
	public Trabajador() {
		ingresos = new ArrayList<>();
	}
	
	public List<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public double getTotalPercibido() 
	{
		return ingresos.stream().mapToDouble(Ingreso::getMonto).sum();
	}

	public void agregarIngreso(Ingreso ingreso) {
		ingresos.add(ingreso);
	}

	public double getMontoImponible() 
	{
		return ingresos.stream().mapToDouble(Ingreso::montoImponible).sum();
	}

	public double getImpuestoAPagar() {
		
		return this.getMontoImponible() * 0.02;
	}

}
