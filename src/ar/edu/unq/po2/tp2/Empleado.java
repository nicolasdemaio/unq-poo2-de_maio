package ar.edu.unq.po2.tp2;
import java.time.LocalDate;
import java.util.List;

public abstract class Empleado {

	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaNacimiento;
	private int sueldoBasico;
	
	public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaNac, int sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNac;
		this.sueldoBasico = sueldoBasico;
	}
	
	public int edad() {
		int añoActual = LocalDate.now().getYear();
		return (añoActual - fechaNacimiento.getYear());
	}
	
	public int sueldoBasico() {
		return this.sueldoBasico;
	}
	
	public abstract int sueldoBruto();
	public abstract int retenciones();
	
	public int sueldoNeto() {
		
		int monto = this.sueldoBruto() - this.retenciones();
		return monto;
		
	}
	
	public abstract List<String> conceptos();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(int sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
}
