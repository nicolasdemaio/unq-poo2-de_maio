package ar.edu.unq.po2.tp5.ultimaConsigna;

import java.time.LocalDate;

public class Persona implements SerVivo {

	private String nombre;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Integer getEdad() {
		
		int añoActual = LocalDate.now().getYear();
		
		int edad = añoActual - this.fechaNacimiento.getYear();
		
		return edad;
	}

	public boolean esMenor(Persona persona) {
		return this.getEdad() < persona.getEdad();
	}

}
