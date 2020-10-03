package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoContratado extends Empleado {
	
	private int numeroContrato;
	private String medioDePago;

	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNac, int sueldoBasico, int numeroContrato, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.numeroContrato = numeroContrato;
		this.medioDePago = medioDePago;
	}
	
	@Override
	public int sueldoBruto() {
		
		return getSueldoBasico();
	}

	@Override
	public int retenciones() {
		
		int gastosAdministrativos = 50;
		
		return gastosAdministrativos;
	}

	@Override
	public List<String> conceptos() {

		ArrayList<String> conceptos = new ArrayList<String>();
		
		conceptos.add("SUELDO BRUTO");
		conceptos.add("Sueldo básico = " + sueldoBasico());
		conceptos.add("RETENCIONES");
		conceptos.add("Gastos administrativos = " + retenciones());
		
		return conceptos;
	}

	public int getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}

}
