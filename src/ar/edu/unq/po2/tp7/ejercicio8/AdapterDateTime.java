package ar.edu.unq.po2.tp7.ejercicio8;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

public class AdapterDateTime implements IFecha {

	private DateTime fecha;
	
	public AdapterDateTime(DateTime fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public void restarDias(int cantidadDeDias) {
		this.fecha.minusDays(cantidadDeDias);
	}

	@Override
	public boolean antesDeAhora() { 
		return this.fecha.isBeforeNow();
	}

	@Override
	public boolean antesDe(IFecha fecha) {
		return this.fecha.isBefore((ReadableInstant)fecha); //
	}

	@Override
	public boolean despuesDeAhora() {
		return this.fecha.isAfterNow();
	}

	@Override
	public boolean despuesDeFecha(IFecha fecha) {
		return this.fecha.isAfter((ReadableInstant)fecha);
	}

	@Override
	public int dia() {
		return this.fecha.getDayOfMonth();
	}

	@Override
	public int mes() {
		return this.fecha.getMonthOfYear();
	}

	@Override
	public int anio() {
		return this.fecha.getYear();
	}

}
