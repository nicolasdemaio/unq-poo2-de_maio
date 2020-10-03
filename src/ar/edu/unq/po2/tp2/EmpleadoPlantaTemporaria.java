package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoPlantaTemporaria extends Empleado {
	
	private LocalDate fechaFinDesignacion;
	private int horasExtras;

	public EmpleadoPlantaTemporaria(String nombre, String direccion, String estadoCivil, LocalDate fechaNac,
			int sueldoBasico, LocalDate fechaFinDesignacion) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.fechaFinDesignacion = fechaFinDesignacion;
	}

	@Override
	public int sueldoBruto() {
		
		int monto = getSueldoBasico() + montoPorHorasExtras();
		
		return monto;
	}

	@Override
	public int retenciones() {
		
		int monto = obraSocial() + aportesJubilatorios();
		
		return monto;
	}

	@Override
	public List<String> conceptos() {
		
		ArrayList<String> conceptos = new ArrayList<String>();
		
		conceptos.add("SUELDO BRUTO");
		conceptos.add("Sueldo básico = " + sueldoBasico());
		conceptos.add("Monto por horas extras = " + montoPorHorasExtras());
		conceptos.add("RETENCIONES");
		conceptos.add("Monto por obra social = " + obraSocial());
		conceptos.add("Monto por aportes jubilatorios = " + aportesJubilatorios());
		
		return conceptos;
	}

	public LocalDate getFechaFinDesignacion() {
		return fechaFinDesignacion;
	}

	public void setFechaFinDesignacion(LocalDate fechaFinDesignacion) {
		this.fechaFinDesignacion = fechaFinDesignacion;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	
	private int obraSocial() {
		
		int monto = (sueldoBruto() * 10)/100;
		
		if(this.edad() > 50) {
			monto += 25;
		}
		
		return monto;
	}
	
	private int montoPorHorasExtras() {
		return (40 * getHorasExtras());
	}
	
	private int aportesJubilatorios() {
		
		int monto = ((sueldoBruto() * 10)/100) + (5 * getHorasExtras());
		
		return monto;
		
	}

}
