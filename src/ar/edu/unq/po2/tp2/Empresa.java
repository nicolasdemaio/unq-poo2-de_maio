package ar.edu.unq.po2.tp2;

import java.util.List;

public class Empresa {

	private String nombre;
	private String cuit;
	private List<Empleado> empleados;
	private List<ReciboDeHaberes> recibos;
	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	public int montoSueldosNetos() 
	{
		return empleados.stream().mapToInt(Empleado::sueldoNeto).sum();
	}
	
	public int montoSueldosBrutos() 
	{
		return empleados.stream().mapToInt(Empleado::sueldoBruto).sum();
	}
	
	public int montoRetenciones() 
	{
		return empleados.stream().mapToInt(Empleado::retenciones).sum();
	}
	
	public void liquidarSueldos() {
		
		empleados.stream().forEach(this::generarRecibo); // Un stream de empleados, por cada uno, this (Empresa) genera recibo.
	}
	
	public void generarRecibo(Empleado empleado) 
	{
		recibos.add(new ReciboDeHaberes(empleado));
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public String getCuit() {
		return cuit;
	}
	
	public List<Empleado> empleados(){
		return empleados;
	}
	
	public List<ReciboDeHaberes> recibos(){
		return recibos;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
}
