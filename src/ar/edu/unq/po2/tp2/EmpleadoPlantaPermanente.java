package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoPlantaPermanente extends Empleado {

	private int cantidadHijos;
	private int antiguedad;
	
	public EmpleadoPlantaPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNac,
			int sueldoBasico, int cantidadHijos) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.antiguedad = 0;
	}
	
	public int getCantidadHijos() {
		return cantidadHijos;
	}



	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}



	public int getAntiguedad() {
		return antiguedad;
	}



	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	private int salarioFamiliar() {
		
		return (asignacionPorHijo() + asignacionPorConyuge() + montoPorAntiguedad());
		
	}
	
	private int asignacionPorHijo() {
		return (getCantidadHijos() * 150);
	}
	
	private int asignacionPorConyuge() {
		
		int monto = 0;
		
		if(getEstadoCivil().equals("casado")) {
			monto = 100;
		}
		
		return monto;
		
	}
	
	private int montoPorAntiguedad() {
		return (getAntiguedad() * 50);
	}
	
	private int obraSocial() {
		return ((sueldoBruto()*10)/100) + (getCantidadHijos() * 20);
	}
	
	private int aportesJubilatorios() {
		return (sueldoBruto()*15)/100;
	}

	@Override
	public int sueldoBruto() {
		return (sueldoBasico() + salarioFamiliar());
	}

	@Override
	public int retenciones() {
	
		return obraSocial() + aportesJubilatorios();
	}

	@Override
	public List<String> conceptos() {
		
		ArrayList<String> conceptos = new ArrayList<String>();
		
		conceptos.add("SUELDO BRUTO");
		conceptos.add("Sueldo básico = " + sueldoBasico());
		conceptos.add("Salario familiar = " + salarioFamiliar());
		conceptos.add(" > Asignación por hijo = " + asignacionPorHijo());
		conceptos.add(" > Asignación por conyuge = " + asignacionPorConyuge());
		conceptos.add(" > Monto por antiguedad = " + montoPorAntiguedad());
		conceptos.add("RETENCIONES");
		conceptos.add("Monto por obra social = " + obraSocial());
		conceptos.add("Monto por aportes jubilatorios = " + aportesJubilatorios());
		
		return conceptos;
	}

}
