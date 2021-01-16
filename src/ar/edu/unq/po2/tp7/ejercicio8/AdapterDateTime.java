package ar.edu.unq.po2.tp7.ejercicio8;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class AdapterDateTime implements IFecha {

	private LocalDate fecha;
	
	public AdapterDateTime(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public void restarDias(int cantidadDeDias) {
		this.fecha.minusDays(cantidadDeDias);
	}

	@Override
	public boolean antesDeAhora() { 
		return this.fecha.isBefore(LocalDate.now());
	}

	@Override
	public boolean antesDe(IFecha fecha) {
		return this.fecha.isBefore((ChronoLocalDate) fecha); //
	}

	@Override
	public boolean despuesDeAhora() {
		return this.fecha.isAfter(LocalDate.now());
	}

	@Override
	public boolean despuesDeFecha(IFecha fecha) {
		return this.fecha.isAfter((ChronoLocalDate) fecha);
	}

	@Override
	public int dia() {
		return this.fecha.getDayOfMonth();
	}

	@Override
	public int mes() {
		return this.fecha.getMonthValue();
	}

	@Override
	public int anio() {
		return this.fecha.getYear();
	}

}
