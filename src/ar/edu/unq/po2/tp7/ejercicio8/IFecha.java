package ar.edu.unq.po2.tp7.ejercicio8;

public interface IFecha {

	void restarDias(int cantidadDeDias);
	boolean antesDeAhora();
	boolean antesDe(IFecha fecha);
	boolean despuesDeAhora();
	boolean despuesDeFecha(IFecha fecha);
	int dia();
	int mes();
	int anio();
	
}
