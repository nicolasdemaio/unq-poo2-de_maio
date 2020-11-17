package ar.edu.unq.po2.tpRefactoring.automotor;

import java.time.LocalDate;

public class Vehiculo {
	private Boolean esVehiculoPolicial;
	private LocalDate fechaFabricacion;	
	private String ciudadRadicacion; 
	
	public Vehiculo(Boolean esVehiculoPolicial, LocalDate fechaFabricacion, String ciudadRadicacion) {
		this.esVehiculoPolicial = esVehiculoPolicial;
		this.fechaFabricacion = fechaFabricacion;
		this.ciudadRadicacion = ciudadRadicacion;
	}

	public Boolean debeRealizarVtv(LocalDate fecha) {
		return (!this.esVehiculoPolicial && this.noEsVehiculoReciente(fecha) && this.estaRadicadoEnBuenosAires());
	}
	
	public Boolean esVehiculoPolicial() {
		return esVehiculoPolicial;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public String ciudadRadicacion() {
		return ciudadRadicacion;
	}
	
	private boolean noEsVehiculoReciente(LocalDate fecha) {
		return fecha.minusYears(1).isAfter(this.getFechaFabricacion());
	}

	private boolean estaRadicadoEnBuenosAires() {
		return this.ciudadRadicacion().equalsIgnoreCase("Buenos Aires");
	}
}
