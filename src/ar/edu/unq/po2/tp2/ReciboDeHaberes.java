package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.List;

public class ReciboDeHaberes {

	// Aca pense en tener una variable de instancia 'empleado' al cual le guardaba el Empleado que me pasaban.
	// El problema es que si yo genero un recibo para ese empleado y le mando el mensaje me responde un sueldo supongamos.
	// Si yo en un futuro le pregunto al mismo recibo el sueldo me va a decir el actual y no el sueldo que tenia a la hora de generar el recibo.
	
	private String nombre, direccion;
	private LocalDate fechaEmision;
	private int sueldoBruto, sueldoNeto;
	private List<String> conceptos;
	
	public ReciboDeHaberes(Empleado empleado) {
		this.nombre = empleado.getNombre();
		this.direccion = empleado.getDireccion();
		this.fechaEmision = LocalDate.now();
		this.sueldoBruto = empleado.sueldoBruto();
		this.sueldoNeto = empleado.sueldoNeto();
		this.conceptos = empleado.conceptos();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public int getSueldoBruto() {
		return sueldoBruto;
	}

	public int getSueldoNeto() {
		return sueldoNeto;
	}

	public List<String> getConceptos() {
		return conceptos;
	}
	
	
	
}
