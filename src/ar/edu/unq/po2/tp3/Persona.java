package ar.edu.unq.po2.tp3;

import java.time.LocalDate;

public class Persona {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getEdad() {
		int añoActual = 2020;
		return añoActual - getFechaNacimiento().getYear();
	}
	
	public boolean menorQue(Persona persona) {
		return (this.getEdad() < persona.getEdad());
	}
	
}
